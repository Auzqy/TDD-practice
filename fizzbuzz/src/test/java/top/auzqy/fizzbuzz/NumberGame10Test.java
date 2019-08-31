package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * description:  test TCR with WIP
 * createTime: 2019-08-31 14:09
 * @author au
 */
public class NumberGame10Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, Fizz",
            "4, 4",
            "5, Buzz",
            "15, FizzBuzz"
    })
    void should_return_correct_num(String input, String result) {
        NumberGame10 numberGame = new NumberGame10();
        Assertions.assertEquals(result,numberGame.playGame(input));
    }
}
