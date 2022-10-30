package org.example;

import junit.framework.TestCase;

public class AppTest extends TestCase {

    public void testFirst() {
        int[] landscape = {5,2,3,4,5,4,0,3,1};
        assertEquals(App.calculateWaterAmount(landscape), 9);
    }

    public void testSecond() {
        int[] landscape = {5,2,3,4,5,4,0,3,0,3};
        assertEquals(App.calculateWaterAmount(landscape), 12);
    }

    public void testThird() {
        int[] landscape = {5,2,3,4,5,4,0,3,0,3,0,4,0,4};
        assertEquals(App.calculateWaterAmount(landscape), 24);
    }

    public void testFour() {
        int[] landscape = {5,1,1,1,5};
        assertEquals(App.calculateWaterAmount(landscape), 12);
    }

    public void testSix() {
        int[] landscape = {3,1,3,1,3};
        assertEquals(App.calculateWaterAmount(landscape), 4);
    }
}
