package com.ushmodin.patterns.strategy;

import java.util.Map;

public class Context {
    private CountStrategy countStrategy;

    public void setCountStrategy(CountStrategy countStrategy) {
        this.countStrategy = countStrategy;
    }

    public Context(CountStrategy countStrategy) {
        this.countStrategy = countStrategy;
    }

    public Map<Integer,Integer> countDuplicates(int[] arr){
        return countStrategy.countDuplicates(arr);
    }
}
