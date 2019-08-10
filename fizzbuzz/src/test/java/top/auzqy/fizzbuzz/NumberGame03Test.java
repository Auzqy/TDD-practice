package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberGame03Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2", // 正常报数
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            "25, Buzz",
            "30, FizzBuzz",
            "65, Buzz",
            // 又增加了新的需求
            "13, Fizz",
            "51, FizzBuzz",
            "52, Buzz",
            "53, FizzBuzz",
            "35, FizzBuzz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output,new NumberGame03(num).toString());
    }
}
