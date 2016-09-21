package com.retreat.oo;

import com.google.common.collect.Maps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import static java.util.Map.*;

public class FizzBuzz {
    private LinkedHashMap<Integer, String> keyNumberMap = Maps.newLinkedHashMap();

    public FizzBuzz(int first, int second, int third) {
        keyNumberMap.put(first, "Fizz");
        keyNumberMap.put(second, "Buzz");
        keyNumberMap.put(third, "Whizz");
    }


    public String report(int number) {
        Set<Entry<Integer, String>> entries = keyNumberMap.entrySet();

        return entries.stream()
                .findFirst()
                .filter(isContains(number))
                .map(Entry::getValue)
                .orElse(entries
                        .stream()
                        .filter(isTimes(number))
                        .map(Entry::getValue)
                        .reduce((s, s2) -> s + s2)
                        .orElse(String.valueOf(number)));
    }

    private static Predicate<Entry<Integer, String>> isContains(int number) {
        return item -> String.valueOf(number).contains(item.getKey().toString());
    }

    private static Predicate<Map.Entry<Integer, String>> isTimes(int number) {
        return item -> number % item.getKey() == 0;
    }
}
