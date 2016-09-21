package com.retreat.fp;

import java.util.function.Predicate;

public interface Matcher extends Predicate<Integer> {

    static Matcher times(Integer n) {
        return input -> input % n == 0;
    }

    static Matcher contains(Integer n) {
        return input -> input.toString().contains(n.toString());
    }

    static Matcher always(Boolean bool) {
        return input -> bool;
    }
}
