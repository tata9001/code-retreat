package com.retreat;

import com.google.common.collect.Maps;
import com.retreat.fp.FizzBuzzWhizz;
import com.retreat.oo.FizzBuzz;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by yunwang on 9/17/16.
 */
public class FizzBuzzTest {

    private HashMap<Integer, String> testCaseMap = Maps.newHashMap();

    @Before
    public void setUp() throws Exception {
        testCaseMap.put(2, "2");
        testCaseMap.put(4, "4");

        testCaseMap.put(3, "Fizz");
        testCaseMap.put(35, "Fizz");

        testCaseMap.put(5, "Buzz");
        testCaseMap.put(15, "FizzBuzz");

        testCaseMap.put(7, "Whizz");
        testCaseMap.put(105, "FizzBuzzWhizz");
    }

    @Test
    public void should_return_right_value_by_oo_way() {
        FizzBuzz fizzBuzz = new FizzBuzz(3, 5, 7);
        testCaseMap
                .entrySet()
                .stream()
                .forEach(item -> {
                    assertThat(fizzBuzz.report(item.getKey()), is(item.getValue()));
                });
    }

    @Test
    public void should_return_right_value_by_fuctional_way() {
        testCaseMap
                .entrySet()
                .stream()
                .forEach(item -> {
                    assertThat(FizzBuzzWhizz.generateRule(3, 5, 7).apply(item.getKey()), is(item.getValue()));
                });
    }

}