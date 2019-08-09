package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberGameTest02Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "11, 11",
            "3, Fizz",
            "9, Fizz",
            "5, Buzz",
            "25, Buzz",
            "15, FizzBuzz",
            "30, FizzBuzz",
            "13, Fizz",
            "53, FizzBuzz",
            "51, FizzBuzz",
            "52, Buzz",
            "31, Fizz"
    })
    void shouldReturn(int num, String output) {
        Assertions.assertEquals(output,new NumberGame02(num).toString());
    }
}
