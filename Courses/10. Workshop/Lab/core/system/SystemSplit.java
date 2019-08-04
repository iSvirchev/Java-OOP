package core.system;

import core.model.hardware.Hardware;
import core.model.software.Software;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.ToIntFunction;

public class SystemSplit {

    private Map<String, Hardware> hardwareComponents;

    public SystemSplit() {
        this.hardwareComponents = new LinkedHashMap<>();
    }

    private int getSumValue(ToIntFunction<Hardware> function){
        return this.hardwareComponents.values()
                .stream()
                .mapToInt(function)
                .sum();
    }

    public void releaseSoftware(String hardwareComponentName, String softwareComponentName) {
        if(this.hardwareComponents.containsKey(hardwareComponentName)){
            Hardware hardware = this.hardwareComponents.get(hardwareComponentName);
            hardware.removeSoftware(softwareComponentName);
        }
    }

    public void addHardwareComponent(Hardware hardware) {
        this.hardwareComponents.put(hardware.getName(), hardware);
    }

    public void addSoftwareToHardware(String hardwareName, Software software) {
        if (this.hardwareComponents.containsKey(hardwareName)) {
            Hardware hardware = this.hardwareComponents.get(hardwareName);
            hardware.addSoftware(software);
        }
    }

    public int getHardwareComponentSize(){
        return this.hardwareComponents.size();
    }

    public int getSoftwareComponentCount(){
        return this.getSumValue(Hardware::getSoftwareCount);
    }

    public int getTotalMemoryInUse(){
        return this.getSumValue(Hardware::getUsedMemory);
    }

    public int getTotalCapacityInUse(){
        return this.getSumValue(Hardware::getUsedCapacity);
    }

    public int getMaximumMemory() {
        return this.getSumValue(Hardware::getMaximumMemory) + this.getSumValue(Hardware::getUsedMemory);
    }

    public int getMaximumCapacity() {
        return this.getSumValue(Hardware::getMaximumCapacity)+ this.getSumValue(Hardware::getUsedCapacity);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.hardwareComponents.values()
                .stream()
                .sorted((h1,h2) -> {
                    if(h1.getType().equalsIgnoreCase("Power")){
                        return -1;
                    }else{
                        return 1;
                    }
                })
        .forEach(hardware -> {
            sb.append(hardware.toString()).append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
