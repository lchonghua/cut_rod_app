package cutter;

import java.util.*;
import java.util.List;
import java.util.AbstractMap.*;
import java.util.Map;
import java.util.stream.IntStream;

public class RodCutter {

    private Map<Integer, Integer> theLengthAndPrice;

    public RodCutter(Map<Integer, Integer> lengthAndPrice) { this.theLengthAndPrice = lengthAndPrice; }

    public SimpleEntry<Integer, List<Integer>> cutRod(int length){

        if(length == 0) return new SimpleEntry<>(0, Arrays.asList());
        if(length == 1) return new SimpleEntry<>(theLengthAndPrice.get(1), Arrays.asList(1));

        SimpleEntry<Integer, List<Integer>> maxPriceAndCuts = new SimpleEntry<>(theLengthAndPrice.get(length), Arrays.asList(length));

        SimpleEntry<Integer, List<Integer>> currPriceAndCuts = 
          IntStream.range(1,length)
                   .mapToObj(split -> getMaxForSplit(split, length))
                   .max(Comparator.comparing(SimpleEntry::getKey))
                   .orElse(new SimpleEntry<>(0, Arrays.asList()));

        return maxPriceAndCuts.getKey() < currPriceAndCuts.getKey()? currPriceAndCuts : maxPriceAndCuts ;
    }

    private SimpleEntry<Integer, List<Integer>> getMaxForSplit(int split, int length){
        SimpleEntry<Integer, List<Integer>> maxForLeftSplit = cutRod(split);
        SimpleEntry<Integer, List<Integer>> maxForRightSplit = cutRod(length - split);

        int maxPrice = maxForLeftSplit.getKey() + maxForRightSplit.getKey();
        List<Integer> combinedLengths = new ArrayList<>();
        combinedLengths.addAll(maxForLeftSplit.getValue());
        combinedLengths.addAll(maxForRightSplit.getValue());

        return new SimpleEntry<>(maxPrice, combinedLengths);
    }
}