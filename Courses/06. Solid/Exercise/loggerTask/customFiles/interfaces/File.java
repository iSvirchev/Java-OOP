package loggerTask.customFiles.interfaces;

public interface File {
    void write();
    int getSize();
    void appendBuffer(String text);

}
