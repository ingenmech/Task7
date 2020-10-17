package by.epam.evm.pyramid.data.repository.comparator;

public class InputTypeException extends RuntimeException{
    public InputTypeException(String message) {
        super(message);
    }

    public InputTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputTypeException(Throwable cause) {
        super(cause);
    }
}
