package in.keepgrowing.interviewcodingquestions.algorithms.math.polishnotation;

public enum Parenthesis {

    OPENING("("), CLOSING(")");

    private final String value;

    Parenthesis(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isOpening(String value){
        return OPENING.getValue().equals(value);
    }

    public static boolean isClosing(String value){
        return CLOSING.getValue().equals(value);
    }
}
