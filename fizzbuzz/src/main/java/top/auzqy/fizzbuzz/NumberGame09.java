package top.auzqy.fizzbuzz;

/**
 * description:  NumberGame09
 * createTime: 2019-08-12 21:30
 * @author au
 */
public class NumberGame09 {
    private int num;

    public NumberGame09(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        if (isRelatedTo(3) && isRelatedTo(5)) {
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
