package je.techtribes.component.log;

public final class LoggingComponentFactory {

    public static LoggingComponent create() {
        return new CommonsLoggingComponent();
    }

}
