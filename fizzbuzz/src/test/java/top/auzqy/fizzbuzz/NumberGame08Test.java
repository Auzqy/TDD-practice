package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * description:  FizzBuzz 08 test
 * createTime: 2019-08-12 21:19
 * @author au
 */
public class NumberGame08Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "4, 4",
            "3, Fizz",
            "5, Buzz",
            "15, FizzBuzz",
            // 老板修改了需求
            "23, Fizz",
            "25, Buzz",
            "32, Fizz",
            "52, Buzz",
            "51, FizzBuzz",
            "53, FizzBuzz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output,new NumberGame08(num).toString());
    }
}
