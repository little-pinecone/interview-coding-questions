package in.keepgrowing.interviewcodingquestions.algorithms.math.primenumbers;

public class PrimalityValidator {

    public boolean validate(int number) {
        if (number <= 1) {
            return false;
        }
        if (number <= 3) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }
        var dividerLimit = Math.sqrt(number);
        for (int divider = 3; divider <= dividerLimit; divider++) {
            if (number % divider == 0) {
                return false;
            }
        }

        return true;
    }
}
