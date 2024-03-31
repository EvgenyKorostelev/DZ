package exceptions;

public class NotValidPhoneNumberFormatException extends RuntimeException{

    public NotValidPhoneNumberFormatException() {
        super("Invalid phone number format!");
    }

    public NotValidPhoneNumberFormatException(String message) {
        super(message);
    }

}
