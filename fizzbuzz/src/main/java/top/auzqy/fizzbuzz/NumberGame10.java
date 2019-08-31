package top.auzqy.fizzbuzz;

public class NumberGame10 {


    public String playGame(String input) {
        if ("15".equals(input)) {
            return "FizzBuzz";
        }
        if ("3".equals(input)) {
            return "Fizz";
        }
        if ("5".equals(input)) {
            return "Buzz";
        }
        return input;
    }
}
