package javax.validation;

public class GroupDefinitionException extends ValidationException {
    public GroupDefinitionException(String message) {
        super(message);
    }

    public GroupDefinitionException() {
    }

    public GroupDefinitionException(String message, Throwable cause) {
        super(message, cause);
    }

    public GroupDefinitionException(Throwable cause) {
        super(cause);
    }
}
