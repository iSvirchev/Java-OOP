package core.engine;

import core.command.Command;
import core.command.factory.CommandFactory;
import core.system.SystemSplit;
import io.scanner.Scanner;

public class Engine {
    public static final String END_COMMAND = "System Split";
    private SystemSplit systemSplit;
    private Scanner reader;

    public Engine(SystemSplit systemSplit, Scanner reader) {
        this.systemSplit = systemSplit;
        this.reader = reader;
    }

    public void run() {
        String line = this.reader.readLine();
        while (!END_COMMAND.equals(line)) {
            String[] split = line.split("[\\(,\\s\\)]+");
            String cmdName = split[0];
            Object[] params = new Object[split.length];
            params[0] = this.systemSplit;
            for (int i = 1; i < split.length; i++) {
                params[i] = split[i];
            }

            Command command = CommandFactory.buildCommand(cmdName,params);
            command.execute();

            line = this.reader.readLine();
        }

        Command command = CommandFactory.buildCommand("SystemSplit",this.systemSplit);
        command.execute();
    }
}
