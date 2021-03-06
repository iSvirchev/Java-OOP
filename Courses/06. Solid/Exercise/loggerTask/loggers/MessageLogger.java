package loggerTask.loggers;

import loggerTask.appenders.interfaces.Appender;
import loggerTask.enumerations.ReportLevel;
import loggerTask.loggers.interfaces.Logger;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... args) {
        this.appenders = args;
    }

    private void logMessage(String date, ReportLevel reportLevel, String message) {
        for (Appender appender : this.appenders) {
            if(appender.getReportLevel().compareTo(reportLevel) <= 0) {
                appender.append(date, reportLevel, message);
            }
        }
    }

    @Override
    public void logInfo(String date, String message) {
        this.logMessage(date, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String date, String message) {
        this.logMessage(date, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String date, String message) {
        this.logMessage(date, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String date, String message) {
        this.logMessage(date, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String date, String message) {
        this.logMessage(date, ReportLevel.FATAL, message);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Logger info \r\n");

        for (Appender appender : this.appenders) {
            sb.append(appender.toString());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
