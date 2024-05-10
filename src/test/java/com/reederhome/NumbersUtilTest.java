package com.reederhome;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NumbersUtilTest {
    @Test
    void testCalculateAverage() {
        assertEquals(4.0, NumbersUtil.calculateAverage(new int[] { 4 }));
    }

    @Test
    void testCalculateAverage_null_list() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumbersUtil.calculateAverage(null);
        });
    }

    @Test
    void testCalculateAverage_empty_list() {
        assertThrows(IllegalArgumentException.class, () -> {
            NumbersUtil.calculateAverage(new int[0]);
        });
    }
}
