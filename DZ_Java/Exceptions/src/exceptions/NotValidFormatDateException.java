package exceptions;

public class NotValidFormatDateException extends RuntimeException{

    public NotValidFormatDateException() {
        super("Invalid date format!");
    }

    public NotValidFormatDateException(String message) {
        super(message);
    }
}
