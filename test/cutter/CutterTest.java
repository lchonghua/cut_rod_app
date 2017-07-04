package cutter;

import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.AbstractMap.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CutterTest {

    private RodCutter rodCutter;

    @Before
    public void setup(){
        Map<Integer, Integer> pricesAndLength;
        pricesAndLength = new HashMap<>();
        pricesAndLength.put(1,1);
        pricesAndLength.put(2,1);
        pricesAndLength.put(3,3);
        pricesAndLength.put(4,3);
        pricesAndLength.put(5,10);
        pricesAndLength.put(6,10);
        pricesAndLength.put(7,10);

        rodCutter = createCutter(pricesAndLength);
    }

    protected RodCutter createCutter(Map<Integer, Integer> pricesList){
        return new RodCutter(pricesList);
    }


    @Test
    public void canary(){ assertTrue(true); }

    @Test
    public void checkCutRodWhenLengthIs0() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(0, Arrays.asList());

        assertEquals(expected, rodCutter.cutRod(0));
    }

    @Test
    public void checkCutRodWhenLengthIs1() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(1, Arrays.asList(1));

        assertEquals(expected, rodCutter.cutRod(1));
    }

    @Test
    public void checkCutRodWhenLengthIs2() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(2, Arrays.asList(1,1));

        assertEquals(expected, rodCutter.cutRod(2));
    }

    @Test
    public void checkCutRodWhenLengthIs3() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(3, Arrays.asList(3));

        assertEquals(expected, rodCutter.cutRod(3));
    }

    @Test
    public void checkCutRodWhenLengthIs4() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(4, Arrays.asList(1,3));

        assertEquals(expected, rodCutter.cutRod(4));
    }

    @Test
    public void checkCutRodWhenLengthIs5() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(10, Arrays.asList(5));

        assertEquals(expected, rodCutter.cutRod(5));
    }

    @Test
    public void checkCutRodWhenLengthIs6() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(11, Arrays.asList(1,5));

        assertEquals(expected, rodCutter.cutRod(6));
    }

    @Test
    public void checkCutRodWhenLengthIs7() {
        SimpleEntry<Integer, List<Integer>> expected = new SimpleEntry<>(12, Arrays.asList(1,1,5));

        assertEquals(expected, rodCutter.cutRod(7));
    }
}