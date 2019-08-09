package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * description:  猜数字 游戏的测试类
 *          1。 也是需要消除冗余，必要是需要重构
 *          2。 也是需要维护的
 * createTime: 2019-08-09 19:31
 * @author au
 */
public class NumberGameTest {


    /**
     * description:  总的测试
     * createTime: 2019-08-09 20:42
     * @author au
     * @param num
     * @param output
     */
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 'Fizz'",
            "6, 'Fizz'",
            "5, Buzz",
            "20, Buzz",
            "15, FizzBuzz",
            "30, FizzBuzz"
    })
    void shouldReturnCorrectOutput(int num, String output) {
        Assertions.assertEquals(output, new NumberGame(num).toString());
    }

    /**
     * description:  如果既不是3的倍数，也不是5的倍数，那么输出 该值
     * createTime: 2019-08-09 20:42
     * @author au
     * @param num
     * @param output
     */
    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "2, 2",
            "3, 'Fizz'",
            "6, 'Fizz'",
            "5, Buzz",
            "20, Buzz",
            "15, FizzBuzz",
            "30, FizzBuzz"
    })
    void shouldReturnInputNum(int num, String output) {
        Assertions.assertEquals(output, new NumberGame(num).toString());
    }

    /**
     * description:  如果只是3的倍数，那么输出 Fizz
     * createTime: 2019-08-09 20:42
     * @author au
     * @param num
     * @param output
     */
    @ParameterizedTest
    @CsvSource({
            "3, 'Fizz'",
            "6, 'Fizz'"
    })
    void shouldReturnFizz(int num, String output) {
        Assertions.assertEquals(output,new NumberGame(num).toString());
    }

    /**
     * description:  如果只是5的倍数，那么输出 Buzz
     * createTime: 2019-08-09 20:41
     * @author au
     * @param num
     * @param output
     */
    @ParameterizedTest
    @CsvSource({
            "5, Buzz",
            "20, Buzz"
    })
    void shouldReturnBuzz(int num, String output) {
        Assertions.assertEquals(output, new NumberGame(num).toString());
    }

    /**
     * description:  如果即是3的倍数，又是5的倍数，那么输出 FizzBuzz
     * createTime: 2019-08-09 20:41
     * @author au
     * @param num
     * @param output
     */
    @ParameterizedTest
    @CsvSource({
            "15, FizzBuzz",
            "30, FizzBuzz"
    })
    void shouldReturnFizzBuzz(int num, String output) {
        Assertions.assertEquals(output,new NumberGame(num).toString());
    }

    /**
     * description:  老板将需求变更了，
     *          如果包含3，或者是3的倍数，那么输出 Fizz
     *          如果包含5，或者是5的倍数，那么输出 Buzz
     *          如果既包含3又包含5，那么输出 FizzBuzz
     *
     * createTime: 2019-08-09 20:39
     * @author au
     * @param num
     * @param output
     */
    @ParameterizedTest
    @CsvSource({
            "13, Fizz",
            "30, FizzBuzz",
            "50, Buzz",
            "53, FizzBuzz"
    })
    void shouldReturnRelative(int num, String output) {
        Assertions.assertEquals(output,new NumberGame(num).toString());
    }
}
