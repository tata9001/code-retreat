package com.retreat

import com.retreat.fp.FizzBuzzWhizz
import spock.lang.Specification

/**
 * Created by yunwang on 9/22/16.
 */
class FizzBuzzWhizzSpec extends Specification {

    def rule = FizzBuzzWhizz.generateRule(3, 5, 7)

    def "return fizz when contains 3"() {

        expect:
        rule.apply(input) == output

        where:
        input || output
        3     || "Fizz"
        35    || "Fizz"

        9     || "Fizz"
        5     || "Buzz"
        25    || "Buzz"
        7     || "Whizz"
        14    || "Whizz"

        15    || "FizzBuzz"
        105   || "FizzBuzzWhizz"
    }
}
