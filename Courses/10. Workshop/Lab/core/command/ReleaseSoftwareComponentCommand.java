package core.command;

import core.system.SystemSplit;

public class ReleaseSoftwareComponentCommand extends BaseCommand {
    private SystemSplit systemSplit;
    private String hardwareComponentName;
    private String softwareComponentName;

    public ReleaseSoftwareComponentCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArse(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
        this.hardwareComponentName = args[1].toString();
        this.softwareComponentName = args[2].toString();
    }

    @Override
    public void execute() {
        this.systemSplit.releaseSoftware(hardwareComponentName,softwareComponentName);
    }
}
