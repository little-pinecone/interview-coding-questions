package in.keepgrowing.interviewcodingquestions.algorithms.math.leastcommonmultiple;

import in.keepgrowing.interviewcodingquestions.algorithms.math.greatestcommondivisor.GreatestCommonDivisorCalculator;

public class LeastCommonMultipleCalculator {

    private final GreatestCommonDivisorCalculator gcdCalculator;

    public LeastCommonMultipleCalculator(GreatestCommonDivisorCalculator gcdCalculator) {
        this.gcdCalculator = gcdCalculator;
    }


    public int calculate(int firstNumber, int secondNumber) {
        if (firstNumber == 0 || secondNumber == 0) {
            return 0;
        }
        return Math.abs(firstNumber * secondNumber) / gcdCalculator.calculate(firstNumber, secondNumber);
    }
}
