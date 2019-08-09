package top.auzqy.fizzbuzz;

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
public class NumberGame02 {
    private int num;

    public NumberGame02(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        if(isRelatedTo(3) && isRelatedTo(5)){
            return "FizzBuzz";
        } else if (isRelatedTo(3)) {
            return "Fizz";
        } else if (isRelatedTo(5)) {
            return "Buzz";
        }

        return String.valueOf(num);
    }

    private boolean isRelatedTo(int i) {
        return num % i == 0 || String.valueOf(num).contains(String.valueOf(i));
    }
}
