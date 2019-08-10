package top.auzqy.fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * description:  FizzBuzz 小游戏
 *      初始需求：
 *          从 1 开始报数，遇到 3 的倍数就报 Fizz，
 *          遇到 5 的倍数就报 Buzz，
 *          遇到即是 3 的倍数，又是 5 的倍数的时候，就报 FizzBuzz。
 *
 *      中途更改需求：
 *          基于上述规则，拟报数字遇到包含 3 这个数字的情况，也报 Fizz，
 *          拟报数字遇到包含 5 这个数字的情况，也报 Buzz，
 *          拟报数字遇到即包含 3 这个数字，又包含 5 这个数字的情况，
 *          也报 FizzBuzz，
 *
 * createTime: 2019-08-09 23:31
 * @author au
 */
public class NumberGame02Test {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "11, 11",       // 输入及输出
            "3, Fizz",
            "9, Fizz",      // 3 的倍数
            "5, Buzz",
            "25, Buzz",     // 5 的倍数
            "15, FizzBuzz",
            "30, FizzBuzz", // 即是 3 的倍数，又是5的倍数
            "13, Fizz",     // 包含数字 3
            "53, FizzBuzz", // 及包含数字 3， 又包含数字 5
            "51, FizzBuzz", // 即是 3 的倍数，又包含数字 5
            "52, Buzz",     // 包含数字 5
            "31, Fizz"      // 包含数字 3
    })
    void shouldReturn(int num, String output) {
        Assertions.assertEquals(output,new NumberGame02(num).toString());
    }
}
