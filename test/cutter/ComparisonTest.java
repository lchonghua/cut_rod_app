package cutter;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class ComparisonTest {

    @Test
    public void speedImprovementIsGreaterThan10FoldWhenLengthIs7(){

        Map<Integer, Integer> pricesAndLength;
        pricesAndLength = new HashMap<>();
        pricesAndLength.put(1,1);
        pricesAndLength.put(2,1);
        pricesAndLength.put(3,3);
        pricesAndLength.put(4,3);
        pricesAndLength.put(5,10);
        pricesAndLength.put(6,10);
        pricesAndLength.put(7,10);

        RodCutter naiveCutter = new RodCutter(pricesAndLength);
        RodCutter efficientCutter = new EfficientRodCutter(pricesAndLength);

        long enhance = calculateTimeDifferenceInFold(naiveCutter, efficientCutter, 7);

        assertTrue(enhance > 10);
    }

    private long calculateTime(RodCutter cutter, int length){
        long start = System.nanoTime ();
        cutter.cutRod(length);
        long end = System.nanoTime();

        return end - start;
    }

    private long calculateTimeDifferenceInFold(RodCutter naiveCutter, RodCutter efficientCutter, int length){
        return calculateTime(naiveCutter, length)/calculateTime(efficientCutter, length);
    }

}
