package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberGame07Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            // 需求变更了
            "31, Fizz",
            "52, Buzz",
            "53, FizzBuzz",
            "51, FizzBuzz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output, new NumberGame07(num).toString());
    }
}
