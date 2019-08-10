package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberGame05Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "4, 4",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            "30, FizzBuzz",
            // 老板提出了新的需求
            "13, Fizz",
            "52, Buzz",
            "51, FizzBuzz",
            "53, FizzBuzz",
            "32, Fizz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output, new NumberGame05(num).toString());
    }
}
