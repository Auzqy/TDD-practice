package top.auzqy.fizzbuzz;

/**
 * description:  猜数字的游戏 FizzBuzz
 * createTime: 2019-08-09 19:39
 * @author au
 */
public class NumberGame {
    private int num;

    public NumberGame(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        if (isRelatedTo(3) && isRelatedTo(5)) {
            return "FizzBuzz";
        }
        if(isRelatedTo(3)) {
            return "Fizz";
        }
        if (isRelatedTo(5)) {
            return "Buzz";
        }
        return String.valueOf(num);
    }

    private boolean isRelatedTo(int i) {
        return num % i == 0 || String.valueOf(num).contains(String.valueOf(i));
    }
}
