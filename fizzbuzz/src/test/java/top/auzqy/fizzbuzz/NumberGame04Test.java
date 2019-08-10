package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberGame04Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "4, 4",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            "30, FizzBuzz",
            // 需求该增加了一些内容
            "13, Fizz",
            "35, FizzBuzz",
            "53, FizzBuzz",
            "52, Buzz",
            "32, Fizz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output,new NumberGame04(num).toString());
    }
}
