package com.good.tyotto.nknock.api.repository.util;

import com.good.tyotto.nknock.api.util.DbUnitUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

/**
 * テスト前処理、後処理を行なうクラス。
 * １．テストクラスがloadする前にDBをテスト用にセットアップする。
 * ２．テストクラスの全ケース終了後にDBをテスト実行前の状態に戻す。
 */
public class DbTestExecutionListener extends AbstractTestExecutionListener {

    public static final String DATA_DIR =
            DbTestExecutionListener.class.getResource("").getFile()
                    + ".." + File.separator + "data" + File.separator;

    private static final File INIT_DATA = new File(DATA_DIR + "db_init.xlsx");

    private static List<File> backupList = new ArrayList<>();

    /**
     * テストで利用するテーブルのバックアップを取得する。 テストで利用するデータをloadする。
     */
    @Override
    public void beforeTestMethod(TestContext testContext) {
        DataSource dataSource = testContext.getApplicationContext().getBean(DataSource.class);
        String filename = "USER";
        File file = new File(DATA_DIR + filename + "_back.xls");
        backupList.add(file);
        DbUnitUtil.backup(dataSource, file, filename);
        DbUnitUtil.loadData(dataSource, INIT_DATA);
    }

    /**
     * 取得したバックアップをリストアし、実行前の状態に復元する。
     */
    @Override
    public void afterTestMethod(TestContext testContext) {
        DataSource dataSource = testContext.getApplicationContext().getBean(DataSource.class);
        backupList.forEach(file -> DbUnitUtil.deleteAll(dataSource, file));
        Arrays.asList("USER").forEach(filename ->
                DbUnitUtil.restoreBackup(dataSource, new File(DATA_DIR + filename + "_back.xls")));
    }
}
