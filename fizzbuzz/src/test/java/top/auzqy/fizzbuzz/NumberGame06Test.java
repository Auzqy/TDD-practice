package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberGame06Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "4, 4",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            // 需求改变了
            "23, Fizz",
            "52, Buzz",
            "51, FizzBuzz",
            "53, FizzBuzz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output,new NumberGame06(num).toString());
    }
}
