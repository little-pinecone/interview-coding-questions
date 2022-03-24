package in.keepgrowing.interviewcodingquestions.algorithms.math.greatestcommondivisor;

public class GreatestCommonDivisorCalculator {

    public int calculateRecursively(int firstNumber, int secondNumber) {
        if (firstNumber == 0 && secondNumber == 0) {
            return 0;
        }

        int first = Math.abs(firstNumber);
        int second = Math.abs(secondNumber);

        if (first == second) {
            return first;
        }

        if (first == 0) {
            return second;
        }
        if (second == 0) {
            return first;
        }

        return calculateRecursively(secondNumber, firstNumber % second);
    }

    public int calculate(int... numbers) {
        int result = numbers[0];
        for (int number : numbers) {
            result = calculateRecursively(result, number);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }

}
