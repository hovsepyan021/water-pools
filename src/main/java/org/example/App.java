package org.example;

import java.util.stream.LongStream;

public class App 
{
    public static long calculateWaterAmount(int[] landscape) {
        checkArgument(landscape);
        if(landscape.length < 3) {
            return 0;
        }
        long[] result = new long[landscape.length];
        for(int i = 0; i < landscape.length; i++) {
            result[i] = calculateWaterAmountForIndex(i, landscape);
        }
        return LongStream.of(result).sum();
    }

    public static void checkArgument(int[] landscape) {
        if(landscape == null) {
            throw new IllegalArgumentException("Argument null is not allowed.");
        }
        for(int height : landscape) {
            if(height > 32000 || height < 0) {
                throw new IllegalArgumentException("Height should be in the following range: 0 <= height <= 32000");
            }
        }
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
