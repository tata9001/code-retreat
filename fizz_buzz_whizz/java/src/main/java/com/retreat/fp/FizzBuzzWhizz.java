package com.retreat.fp;

import static com.retreat.fp.Action.*;
import static com.retreat.fp.Matcher.*;
import static com.retreat.fp.Rule.*;

public class FizzBuzzWhizz {
    public static Rule generateRule(int n1, int n2, int n3) {

        Rule fizzRule = atom(times(n1), to("Fizz"));
        Rule buzzRule = atom(times(n2), to("Buzz"));
        Rule whizzRule = atom(times(n3), to("Whizz"));
        Rule timesRule = allOf(fizzRule, buzzRule, whizzRule);

        Rule containsRule = atom(contains(n1),  to("Fizz"));
        Rule alwaysRule = atom(always(true), nop());

        return anyOf(containsRule, timesRule, alwaysRule);
    }
}
