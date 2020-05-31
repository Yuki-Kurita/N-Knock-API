package com.good.tyotto.nknock.api.repository;

import com.good.tyotto.nknock.api.NKnockApiApplication;
import com.good.tyotto.nknock.api.domain.User;
import com.good.tyotto.nknock.api.domain.UserSelector;
import com.good.tyotto.nknock.api.repository.util.DbTestExecutionListener;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * アプリケーションで実装したSQLをテストする。 DBに接続してSQLを実行する。
 */
public class UserRepositoryImplDbUnitTest {

    /**
     * SELECTを検証するテスト
     */
    @SpringBootTest(classes = NKnockApiApplication.class)
    @TestExecutionListeners( {DependencyInjectionTestExecutionListener.class, DbTestExecutionListener.class})
    @Nested public class FindDbTest {

        @Autowired
        private UserRepository target;

        @Test
        public void testFindFilteredByMail() {
            UserSelector input = new UserSelector();
            input.setEmail("test@tyotto.xx.xx");
            User user = target.find(input);
            assertEquals("test@tyotto.xx.xx", user.getEmail());
        }
    }
}
