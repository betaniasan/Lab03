package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DivisibleByFilterTest {

    DivisibleByFilter filter = new DivisibleByFilter(3);
    List<Integer> divisible = Arrays.asList(0, 3, 6, 9, 333, 666);
    List<Integer> notDivisible = Arrays.asList(1, 2, 4, 5, 100, 1000, 10000);

    @Test
    public void DivisibleByFilterTest(){

        for (int n : divisible)
            Assertions.assertTrue(filter.accept(n));
        for (int n : notDivisible)
            Assertions.assertFalse(filter.accept(n));
    }
}