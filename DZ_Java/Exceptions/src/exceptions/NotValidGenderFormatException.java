package exceptions;

public class NotValidGenderFormatException extends RuntimeException{

    public NotValidGenderFormatException() {
        super("Invalid gender format!");
    }

    public NotValidGenderFormatException(String message) {
        super(message);
    }

}
