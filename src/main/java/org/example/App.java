package org.example;

import java.util.stream.LongStream;

public class App 
{
    public static long calculateWaterAmount(int[] landscape) {
        long[] result = new long[landscape.length];
        for(int i = 0; i < landscape.length; i++) {
            result[i] = calculateWaterAmountForIndex(i, landscape);
        }
        return LongStream.of(result).sum();
    }

    public static long calculateWaterAmountForIndex(int index, int[] landscape) {
        if(index == 0 || index == landscape.length - 1) {
            return 0;
        } else {
            long currentHeight = landscape[index];
            long highestLeftPeak = findHighestLeftPeak(index, landscape);
            long highestRightPeak = findHighestRightPeak(index, landscape);
            if(highestLeftPeak > currentHeight && highestRightPeak > currentHeight) {
                long smallestPeak = Math.min(highestLeftPeak, highestRightPeak);
                return smallestPeak - currentHeight;
            } else {
                return 0;
            }
        }
    }

    public static long findHighestLeftPeak(int index, int[] landscape) {
        int highest = -1;
        for(int i = index - 1; i >= 0; i--) {
            if(landscape[i] > highest) {
                highest = landscape[i];
            }
        }
        return highest;
    }

    public static long findHighestRightPeak(int index, int[] landscape) {
        int highest = -1;
        for(int i = index + 1; i < landscape.length; i++) {
            if(landscape[i] > highest) {
                highest = landscape[i];
            }
        }
        return highest;
    }
}
