package je.techtribes.component.log;

import org.apache.commons.logging.LogFactory;

class CommonsLoggingComponent implements LoggingComponent {

    @Override
    public void debug(Object caller, String message) {
        LogFactory.getLog(caller.getClass()).debug(message);
    }

    @Override
    public void info(Object caller, String message) {
        LogFactory.getLog(caller.getClass()).info(message);
    }

    @Override
    public void warn(Object caller, String message) {
        LogFactory.getLog(caller.getClass()).warn(message);
    }

    @Override
    public void warn(Object caller, String message, Throwable throwable) {
        LogFactory.getLog(caller.getClass()).warn(message, throwable);
    }

    @Override
    public void error(Object caller, String message) {
        LogFactory.getLog(caller.getClass()).error(message);
    }

    @Override
    public void error(Object caller, String message, Throwable throwable) {
        LogFactory.getLog(caller.getClass()).error(message, throwable);
    }

}
