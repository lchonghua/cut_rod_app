package cutter;

import java.util.*;
import java.util.AbstractMap.*;
import java.util.Map;

public class EfficientRodCutter extends RodCutter{

    private Map<Integer, List<Integer>> cutPatterns;
    private Map<Integer, Integer> maxPriceForLength;

    public EfficientRodCutter(Map<Integer, Integer> lengthAndPrice) {

        super(lengthAndPrice);
        this.cutPatterns = new HashMap<>();
        this.maxPriceForLength = new HashMap<>();
    }

    public SimpleEntry<Integer, List<Integer>> cutRod(int length){

        SimpleEntry<Integer, List<Integer>> maxPriceAndCut;

        if(maxPriceForLength.containsKey(length)){
            maxPriceAndCut = new SimpleEntry<>(maxPriceForLength.get(length), cutPatterns.get(length));
        }
        else{
            maxPriceAndCut = super.cutRod(length);
            cutPatterns.put(length,maxPriceAndCut.getValue());
            maxPriceForLength.put(length, maxPriceAndCut.getKey());
        }

        return maxPriceAndCut;
    }
}
