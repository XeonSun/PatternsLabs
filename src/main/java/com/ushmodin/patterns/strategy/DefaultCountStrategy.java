package com.ushmodin.patterns.strategy;

import java.util.HashMap;
import java.util.Map;

public class DefaultCountStrategy implements CountStrategy {
    @Override
    public Map<Integer, Integer> countDuplicates(int[] arr) {
        var res = new HashMap<Integer,Integer>();
        for (int i:arr) {
            res.compute(i, (k,v) -> (v == null)?1:v+1 );
        }

        return res;
    }
}
