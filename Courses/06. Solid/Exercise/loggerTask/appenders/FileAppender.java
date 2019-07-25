package loggerTask.appenders;

import loggerTask.customFiles.LogFile;
import loggerTask.customFiles.interfaces.File;
import loggerTask.enumerations.ReportLevel;
import loggerTask.layouts.interfaces.Layout;

import java.io.IOException;

public class FileAppender extends AppenderImpl {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String date, ReportLevel reportLevel, String message) {
        if (this.file == null) {
            /*throw  new NullPointerException("file reference not set to an instance of an object");*/
            try{
                this.setFile(new LogFile());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        this.file.appendBuffer(this.format(date, reportLevel, message));
        this.file.write();
    }

    @Override
    public String toString() {
        return super.toString() + ", File size: " + this.file.getSize();
    }
}
