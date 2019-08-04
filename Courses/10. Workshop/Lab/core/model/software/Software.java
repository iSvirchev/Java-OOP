package core.model.software;

public  abstract class Software {
    private String name;
    private Type type;
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, Type type, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.type = type;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }

    public String getName() {
        return this.name;
    }

    protected enum Type{
        EXPRESS,
        LIGHT
    }

}
