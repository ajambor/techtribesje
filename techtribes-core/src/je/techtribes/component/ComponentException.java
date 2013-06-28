package je.techtribes.component;

public abstract class ComponentException extends RuntimeException {

    public ComponentException(String message, Throwable cause) {
        super(message, cause);
    }

}
