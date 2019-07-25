import loggerTask.appenders.ConsoleAppender;
import loggerTask.appenders.FileAppender;
import loggerTask.appenders.interfaces.Appender;
import loggerTask.enumerations.ReportLevel;
import loggerTask.layouts.SimpleLayout;
import loggerTask.layouts.XmlLayout;
import loggerTask.layouts.interfaces.Layout;
import loggerTask.loggers.MessageLogger;
import loggerTask.loggers.interfaces.Logger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Appender[] appenders = new Appender[n];

        while (n-- > 0) {
            String[] split = scanner.nextLine().split("\\s+");

            Appender appender = null;
            Layout layout = null;

            int index = 0;

            if ("SimpleLayout".equals(split[1])) layout = new SimpleLayout();
            else layout = new XmlLayout();


            if ("ConsoleAppender".equals(split[0])) appender = new ConsoleAppender(layout);
            else appender = new FileAppender(layout);

            if (split.length == 3) appender.setReportLevel(ReportLevel.valueOf(split[2]));

            appenders[index++] = appender;
        }

        Logger logger = new MessageLogger(appenders);

        String inputOrEnd = scanner.nextLine();

        while (!"END".equals(inputOrEnd)) {
            String[] split = inputOrEnd.split("\\|");

            String date = split[1];
            String msg = split[2];

            switch (ReportLevel.valueOf(split[0])) {
                case INFO:
                    logger.logInfo(date, msg);
                    break;
                case ERROR:
                    logger.logError(date, msg);
                    break;
                case FATAL:
                    logger.logFatal(date, msg);
                    break;
                case WARNING:
                    logger.logWarning(date, msg);
                    break;
                case CRITICAL:
                    logger.logCritical(date, msg);
                    break;
            }

            inputOrEnd = scanner.nextLine();
        }

        System.out.println(logger.toString());
    }
}
