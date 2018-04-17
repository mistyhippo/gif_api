package gif.exceptions;


public class GeneralException extends Exception {

    public GeneralException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "GeneralException{}";
    }
}
