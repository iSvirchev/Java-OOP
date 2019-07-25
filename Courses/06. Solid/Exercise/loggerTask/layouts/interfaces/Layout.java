package loggerTask.layouts.interfaces;

import loggerTask.enumerations.ReportLevel;

public interface Layout {
   String format(String date, ReportLevel reportLevel, String message);
}
