package cutter;

import java.util.*;

public class EfficientRodCutterTest extends CutterTest{

    @Override
    protected RodCutter createCutter(Map<Integer, Integer> priceList){
            return new EfficientRodCutter(priceList);
    }
}
