package components.loggers;

/**
 * Created by HillelNew5 on 22.02.2018.
 */
public class ConsoleLogger extends  AbstractLogger {
    @Override
    protected void doLogging(String stringToLog) {
        System.out.println(stringToLog);
    }
}
