package loggerTask.appenders;

import loggerTask.enumerations.ReportLevel;
import loggerTask.layouts.interfaces.Layout;

public class ConsoleAppender extends AppenderImpl {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout,ReportLevel reportLevel) {
        super(layout,reportLevel);
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        System.out.println(this.format(date,reportLevel,message));
    }
}
