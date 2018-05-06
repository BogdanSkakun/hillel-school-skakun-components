package components.loggers;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by HillelNew5 on 22.02.2018.
 */
public abstract class AbstractLogger implements Logger {

    private Date date=new Date();
    private SimpleDateFormat myFormat=new SimpleDateFormat("HH:mm:ss:SSS");
    private static int count=0;

    @Override
    public void log(String action) {
        count++;
        String logInfo = count+") "+ myFormat.format(date) +
                "[ "+Thread.currentThread().getStackTrace()[2]+"]: "+action;
        doLogging(logInfo);

    }
    protected  abstract  void doLogging(String stringToLog);



}
