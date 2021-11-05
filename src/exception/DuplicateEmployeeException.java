package exception;

public class DuplicateEmployeeException extends Exception{
    public DuplicateEmployeeException() {
    }

    public DuplicateEmployeeException(String message) {
        super(message);
    }
}
