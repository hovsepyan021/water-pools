package org.example;

import junit.framework.TestCase;

import java.util.List;

public class AppTest extends TestCase {

    public List<WaterPoolTestCase> validTestCases = List.of(
            new WaterPoolTestCase(new int[]{5,2,3,4,5,4,0,3,1}, 9),
            new WaterPoolTestCase(new int[]{5,2,3,4,5,4,0,3,0,3}, 12),
            new WaterPoolTestCase(new int[]{5,2,3,4,5,4,0,3,0,3,0,4,0,4}, 24),
            new WaterPoolTestCase(new int[]{5,1,1,1,5}, 12),
            new WaterPoolTestCase(new int[]{3,1,3,1,3}, 4),
            new WaterPoolTestCase(new int[]{0,0,0,0,0}, 0),
            new WaterPoolTestCase(new int[]{5,5,5,5,5}, 0),
            new WaterPoolTestCase(new int[]{4,5,5,5,4}, 0)
    );


    public void testValidCases() {
        validTestCases.forEach(validTestCase -> {
            assertEquals(validTestCase.expectedResult, App.calculateWaterAmount(validTestCase.argument));
        });
    }

    public void testEmptyArray() {
        assertEquals(0, App.calculateWaterAmount(new int[0]));
    }

    public void testArrayOfOneElement() {
        assertEquals(0, App.calculateWaterAmount(new int[] {1}));
    }

    public void testNullCase() {
        try {
            App.calculateWaterAmount(null);
            fail("Illegal argument exception hasn't been thrown.");
        } catch (IllegalArgumentException ignored) {}
    }

    private static class WaterPoolTestCase {
        int[] argument;
        long expectedResult;

        public WaterPoolTestCase(int[] argument, long expectedResult) {
            this.argument = argument;
            this.expectedResult = expectedResult;
        }
    }
}
