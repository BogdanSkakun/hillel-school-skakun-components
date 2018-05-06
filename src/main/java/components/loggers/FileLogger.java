package components.loggers;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by HillelNew5 on 22.02.2018.
 */
public class FileLogger extends AbstractLogger {
    @Override
    protected void doLogging(String stringToLog) {
        try {
            FileWriter writer = new FileWriter("logger.txt", true);
            writer.write(stringToLog + "\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
