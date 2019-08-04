package core.command;

import core.system.SystemSplit;

public class AnalyzeCommand extends BaseCommand {
    private SystemSplit systemSplit;

    public AnalyzeCommand(Object... args) {
        super(args);
    }

    @Override
    protected void parseArse(Object... args) {
        this.systemSplit = (SystemSplit) args[0];
    }

    @Override
    public void execute() {
        StringBuilder sb = new StringBuilder();

        int nHardwareComponents = this.systemSplit.getHardwareComponentSize();
        int nSoftwareComponents = this.systemSplit.getSoftwareComponentCount();
        int totalMemoryInUse = this.systemSplit.getTotalMemoryInUse();
        int totalCapacityInUse = this.systemSplit.getTotalCapacityInUse();

        int maximumMemory = this.systemSplit.getMaximumMemory();
        int maximumCapacity = this.systemSplit.getMaximumCapacity();

        sb.append("System Analysis");
        sb.append(System.lineSeparator());
        sb.append("Hardware Components: ").append(nHardwareComponents);
        sb.append(System.lineSeparator());
        sb.append("Software Components: ").append(nSoftwareComponents);
        sb.append(System.lineSeparator());
        sb.append("Total Operational Memory: ").append(totalMemoryInUse).append(" / ").append(maximumMemory);
        sb.append(System.lineSeparator());
        sb.append("Total Capacity Taken: ").append(totalCapacityInUse).append(" / ").append(maximumCapacity);

        System.out.println(sb.toString());

    }
    /*
    "System Analysis
    Hardware Components: {countOfHardwareComponents}
    Software Components: {countOfSoftwareComponents}
    Total Operational Memory: {totalOperationalMemoryInUse} / {maximumMemory}
    Total Capacity Taken: {totalCapacityTaken} / {maximumCapacity}"
    */

}
