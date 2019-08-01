package validPerson;

public class InvalidPersonNameException extends RuntimeException{
    public InvalidPersonNameException(String msg) {
        super(msg);
    }

    public InvalidPersonNameException() {
    }
}
