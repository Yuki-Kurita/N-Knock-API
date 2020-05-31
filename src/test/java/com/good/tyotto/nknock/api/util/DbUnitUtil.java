package com.good.tyotto.nknock.api.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.dbunit.Assertion;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.ext.h2.H2Connection;
import org.dbunit.operation.DatabaseOperation;

public class DbUnitUtil {
    /**
     * dataFileで指定したExcelファイルを該当のテーブル(Excelのシート名に定義したテーブル)にloadする。
     */
    public static void loadData(DataSource source, File dataFile) {
        IDatabaseConnection connection = null;
        try {
            connection = dbUnitConnection(source);
            DatabaseConfig config = connection.getConfig();
            config.setProperty(DatabaseConfig.FEATURE_ALLOW_EMPTY_FIELDS, true);
            FileInputStream inFile = new FileInputStream(dataFile);
            XlsDataSet dataSet = new XlsDataSet(inFile);
            DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    /**
     * dataFileの全データ削除
     * @param source dataSource
     * @param dataFile dataFile
     */
    public static void deleteAll(DataSource source, File dataFile) {
        IDatabaseConnection connection = null;
        try {
            connection = dbUnitConnection(source);
            FileInputStream inFile = new FileInputStream(dataFile);
            XlsDataSet dataSet = new XlsDataSet(inFile);
            DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    /**
     * dataFileと主キーが一致するデータを削除
     * @param source dataSource
     * @param dataFile dataFile
     */
    public static void delete(DataSource source, File dataFile) {
        IDatabaseConnection connection = null;
        try {
            connection = dbUnitConnection(source);
            FileInputStream inFile = new FileInputStream(dataFile);
            XlsDataSet dataSet = new XlsDataSet(inFile);
            DatabaseOperation.DELETE.execute(connection, dataSet);
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    /**
     * tableNamesで指定したテーブルのデータをbackupファイル(Excel)にバックアップする。 tableNames分、ワークシートが作成される。
     */
    public static void backup(DataSource source, File backup, String... tableNames) {
        IDatabaseConnection connection = null;
        try {
            connection = dbUnitConnection(source);
            IDataSet partialDataSet = connection.createDataSet(tableNames);
            XlsDataSet.write(partialDataSet, new FileOutputStream(backup));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    /**
     * ExcelのbackupファイルにあるデータをDBに戻す backupファイルはデータ戻し後に削除する。
     */
    public static void restoreBackup(DataSource source, File backup) {
        restoreBackup(source, backup, false);
    }

    /**
     * ExcelのbackupファイルにあるデータをDBに戻す
     *
     * @param deleteOnExit (trueの場合は、全テストケース終了後にbackupを削除する)
     */
    public static void restoreBackup(DataSource source, File backup, boolean deleteOnExit) {
        loadData(source, backup);
        if (deleteOnExit) {
            backup.deleteOnExit();
        } else {
            backup.delete();
        }
    }

    /**
     * Excelで定義した想定更新結果(INSERT/UPDATE/DELETEの結果）と実際のテーブル更新結果をassertする。
     *
     * @param tableName 対象テーブル名
     * @param expected  想定結果(Excelファイル)
     * @param skipCols  テーブルで検証除外するカラムの列(ID、UPDATE_TIMESTAMPなど自動発番するもの)
     */
    public static void assertMutateResult(DataSource source, String tableName, File expected, List<String> skipCols) {
        IDatabaseConnection connection = null;
        try {
            connection = dbUnitConnection(source);
            ITable expectedTable = getExcelITable(expected.getPath(), tableName);
            ITable actualTable = getCurrentITable(connection, tableName);
            Assertion.assertEqualsIgnoreCols(expectedTable, actualTable, skipCols.toArray(new String[0]));
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exception) {
                    throw new RuntimeException(exception);
                }
            }
        }
    }

    static ITable getExcelITable(String path, String tableName) throws Exception {
        XlsDataSet dataSet = new XlsDataSet(new FileInputStream(path));
        return dataSet.getTable(tableName);
    }

    static ITable getCurrentITable(IDatabaseConnection connection, String tableName) throws Exception {
        try {
            IDataSet dbDataSet = connection.createDataSet();
            return dbDataSet.getTable(tableName);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    static IDatabaseConnection dbUnitConnection(DataSource dataSource) throws Exception {
        return new H2Connection(dataSource.getConnection(), "KNOWLEDGE");
    }

}
