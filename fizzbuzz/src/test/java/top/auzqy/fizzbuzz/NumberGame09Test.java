package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * description:  FizzBuzz 09 test
 * createTime: 2019-08-12 21:29
 * @author au
 */
public class NumberGame09Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "4, 4",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            // 老板修改了需求
            "31, Fizz",
            "35, FizzBuzz",
            "13, Fizz",
            "10, Buzz",
            "51, FizzBuzz",
            "52, Buzz",
            "53, FizzBuzz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output,new NumberGame09(num).toString());
    }
}
