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
        long[] highestLeftPeaks = calculateHighestLeftPeaks(landscape);
        long[] highestRightPeaks = calculateHighestRightPeaks(landscape);
        for(int i = 0; i < landscape.length; i++) {
            result[i] = calculateWaterAmountForIndex(i, landscape, highestLeftPeaks, highestRightPeaks);
        }
        return LongStream.of(result).sum();
    }

    public static long[] calculateHighestRightPeaks(int[] landscape) {
        long[] result = new long[landscape.length];
        long currentHighestPeak = 0;
        for(int i = landscape.length - 2; i >= 0; i--) {
            if(landscape[i + 1] > currentHighestPeak) {
                currentHighestPeak = landscape[i + 1];
            }
            result[i] = currentHighestPeak;
        }
        return result;
    }

    public static long[] calculateHighestLeftPeaks(int[] landscape) {
        long[] result = new long[landscape.length];
        long currentHighestPeak = 0;
        for(int i = 1; i < landscape.length; i++) {
            if(landscape[i - 1] > currentHighestPeak) {
                currentHighestPeak = landscape[i - 1];
            }
            result[i] = currentHighestPeak;
        }
        return result;
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

    public static long calculateWaterAmountForIndex(int index, int[] landscape, long[] highestLeftPeaks, long[] highestRightPeaks) {
        if(index == 0 || index == landscape.length - 1) {
            return 0;
        } else {
            long currentHeight = landscape[index];
            long highestLeftPeak = highestLeftPeaks[index];
            long highestRightPeak = highestRightPeaks[index];
            if(highestLeftPeak > currentHeight && highestRightPeak > currentHeight) {
                long smallestPeak = Math.min(highestLeftPeak, highestRightPeak);
                return smallestPeak - currentHeight;
            } else {
                return 0;
            }
        }
    }
}
