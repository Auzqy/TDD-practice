package top.auzqy.fizzbuzz;

public class NumberGame10 {


    public String playGame(String input) {
        int num = Integer.parseInt(input);
        if (num % 3 == 0 && num % 5 == 0) {
            return "FizzBuzz";
        }
        if (num % 3 == 0) {
            return "Fizz";
        }
        if (num % 5 == 0) {
            return "Buzz";
        }
        return input;
    }
}
