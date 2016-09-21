package com.retreat.fp;

import java.util.function.Function;

public interface Action extends Function<Integer, String> {

    static Action to(String str) {
        return (integer) -> str;
    }

    static Action nop() {
        return integer -> integer.toString();
    }
}
