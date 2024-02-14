package com.ushmodin.patterns.strategy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NewCountStrategy implements CountStrategy {
    @Override
    public Map<Integer, Integer> countDuplicates(int[] arr) {
        return Arrays.stream(arr).parallel().collect(
                HashMap<Integer,Integer>::new,
                (r,e)-> r.compute(e, (k,v) -> (v == null)?1:v+1 ),
                (a,b)-> b.forEach((k,v)-> a.merge(k,v, Integer::sum)) );
    }
}
