package com.ushmodin.patterns.strategy;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectorsStrategy implements CountStrategy{
    @Override
    public Map<Integer, Integer> countDuplicates(int[] arr) {
        var res = new HashMap<Integer,Integer>();
        IntStream.of(arr).parallel().boxed().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .forEach((k,v)->res.put(k,Math.toIntExact(v)));
        return res;
    }
}
