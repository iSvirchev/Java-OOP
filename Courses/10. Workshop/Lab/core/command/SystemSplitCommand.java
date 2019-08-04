package core.command;

import core.system.SystemSplit;

public class SystemSplitCommand extends BaseCommand {
    private SystemSplit systemSplit;

    public SystemSplitCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArse(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
    }

    @Override
    public void execute() {
        System.out.println(this.systemSplit);
    }
}
