package com.good.tyotto.nknock.api.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.util.Assert;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * UnitTestのユーティリティ
 */
public class UnitTestUtil {

    /**
     * LocalDateTimeを年月日時分秒でassertする。
     */
    public static void assertDateTimeUntilSeconds(LocalDateTime actual, LocalDateTime expected) {
        Assert.notNull(actual, "actual is null");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        assertThat(actual.format(formatter), is(expected.format(formatter)));
    }

    /**
     * entityをJSON形式の文字列を変換する。
     */
    public static String entity2JsonText(Object entity) throws Exception {
        return new ObjectMapper().writeValueAsString(entity);
    }
}
