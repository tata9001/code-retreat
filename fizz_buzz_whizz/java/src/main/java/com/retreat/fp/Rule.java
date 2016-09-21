package com.retreat.fp;

import java.util.Arrays;
import java.util.function.Function;

public interface Rule extends Function<Integer, String> {


    static Rule atom(Matcher matcher, Action action) {
        return t -> matcher.test(t) ? action.apply(t) : "";
    }

    static Rule anyOf(Rule... rules) {

        return t -> Arrays.stream(rules)
                .map(item -> item.apply(t))
                .filter(str -> str.length() > 0)
                .findFirst()
                .orElse("");

    }

    static Rule allOf(Rule... rules) {
        return t -> Arrays.stream(rules)
                .map(rule -> rule.apply(t))
                .reduce((s1, s2) -> s1 + s2)
                .orElse("");
    }
}
