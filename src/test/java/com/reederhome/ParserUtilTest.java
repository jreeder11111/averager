package com.reederhome;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ParserUtilTest {
    @Test
    void testParseInts_null_input() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts(null);
        });
    }

    @Test
    void testParseInts_empty_input() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts("");
        });
    }

    @Test
    void testParseInts_count_0() {
        //assertEquals(0, Arrays.compare(new int[0], ParserUtil.parseInts("0")));
        assertArrayEquals(new int[0], ParserUtil.parseInts("0"));
    }

    @Test
    void testParseInts_good() {
        assertArrayEquals(new int[] { 1, 2, 3 }, ParserUtil.parseInts("3 1 2 3"));
    }

    @Test
    void testParseInts_count_too_few() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts("3 1 2");
        });
    }

    @Test
    void testParseInts_count_too_many() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts("3 1 2 3 4");
        });
    }

    @Test
    void testParseInts_count_not_a_number() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts("a 1 2");
        });
    }

    @Test
    void testParseInts_other_inputs_not_a_number() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts("1 a");
        });
    }

    @Test
    void testParseInts_count_not_integer() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts("1.0 1");
        });
    }

    @Test
    void testParseInts_varying_whitespace() {
        assertArrayEquals(new int[] { 1, 2, 3 }, ParserUtil.parseInts("3  1 \t2    3"));
    }

    @Test
    void testParseInts_count_negative() {
        assertThrows(IllegalArgumentException.class, () -> {
            ParserUtil.parseInts("-1");
        });
    }
}
