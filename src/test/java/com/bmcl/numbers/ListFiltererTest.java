package com.bmcl.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


public class ListFiltererTest {

    List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    @Test
    public void ListFiltererTest() {

        GenericListFilter filter = Mockito.mock(GenericListFilter.class);

        when(filter.accept(2)).thenReturn(true);
        when(filter.accept(4)).thenReturn(false);
        when(filter.accept(6)).thenReturn(true);
        when(filter.accept(8)).thenReturn(false);
        when(filter.accept(10)).thenReturn(true);


        ListFilterer filterer = new ListFilterer(filter);


        List<Integer> filteredNumbers = filterer.filter(list);


        Mockito.verify(filter).accept(2);
        Mockito.verify(filter).accept(4);
        Mockito.verify(filter).accept(6);
        Mockito.verify(filter).accept(8);
        Mockito.verify(filter).accept(10);

        assertEquals(3, filteredNumbers.size());

    }
}
