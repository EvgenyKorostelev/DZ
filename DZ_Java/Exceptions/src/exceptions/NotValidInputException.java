package exceptions;

public class NotValidInputException extends RuntimeException{
    private final int length;

    public NotValidInputException(String message, int length) {
        super(message);
        this.length = length;
    }

    public NotValidInputException(int length) {
        super("Invalid data!");
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}
