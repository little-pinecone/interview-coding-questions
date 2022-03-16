package in.keepgrowing.interviewcodingquestions.algorithms.math.factorial;

public class FactorialCalculator {

    public int calculate(int input) {
        return input > 1 ? input * calculate(input - 1) : 1;
    }
}
