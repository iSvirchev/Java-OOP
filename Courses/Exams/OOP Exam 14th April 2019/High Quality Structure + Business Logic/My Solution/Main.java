import core.MachineFactoryImpl;
import core.MachinesManagerImpl;
import core.PilotFactoryImpl;
import core.interfaces.MachineFactory;
import core.interfaces.MachinesManager;
import core.interfaces.PilotFactory;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PilotFactory pilotFactory = new PilotFactoryImpl();
        MachineFactory machineFactory = new MachineFactoryImpl();
        Map<String, Pilot> pilots = new LinkedHashMap<>();
        Map<String, Machine> machines = new LinkedHashMap<>();

        MachinesManager machinesManager = new MachinesManagerImpl(pilotFactory, machineFactory, pilots, machines);
        Scanner scanner = new Scanner(System.in);

        String overOrCmd = scanner.nextLine();

        while (!"Over".equalsIgnoreCase(overOrCmd)) {
            String[] split = overOrCmd.split("\\s+");

            String output = "";
            switch (split[0]) {
                case "Hire":
                    try {
                        output = machinesManager.hirePilot(split[1]);
                    } catch (IllegalArgumentException | NullPointerException ex) {
                        output = ex.getMessage();
                    }
                    break;
                case "Report":
                    try {
                        output = machinesManager.pilotReport(split[1]);
                    } catch (NullPointerException | IllegalArgumentException ex) {
                        output = ex.getMessage();
                    }
                    break;
                case "ManufactureTank":
                    try {
                        output = machinesManager.manufactureTank(split[1], Double.parseDouble(split[2]), Double.parseDouble(split[3]));
                    } catch (IllegalArgumentException | NullPointerException ex) {
                        output = ex.getMessage();
                    }
                    break;
                case "ManufactureFighter":
                    try {
                        output = machinesManager.manufactureFighter(split[1], Double.parseDouble(split[2]), Double.parseDouble(split[3]));
                    } catch (IllegalArgumentException | NullPointerException ex) {
                        output = ex.getMessage();
                    }
                    break;
                case "Engage":
                    try {
                        output = machinesManager.engageMachine(split[1], split[2]);
                    } catch (IllegalArgumentException | NullPointerException ex) {
                        output = ex.getMessage();
                    }
                    break;
                case "Attack":
                    try {
                        output = machinesManager.attackMachines(split[1], split[2]);
                    } catch (IllegalArgumentException | NullPointerException ex) {
                        output = ex.getMessage();
                    }
                    break;
                case "DefenseMode":
                    try {
                        output = machinesManager.toggleTankDefenseMode(split[1]);
                    } catch (IllegalArgumentException | NullPointerException ex) {
                        output = ex.getMessage();
                    }
                    break;
                case "AggressiveMode":
                    try {
                        output = machinesManager.toggleFighterAggressiveMode(split[1]);
                    } catch (IllegalArgumentException | NullPointerException ex) {
                        output = ex.getMessage();
                    }
                    break;
            }

            System.out.println(output);
            overOrCmd = scanner.nextLine();
        }
    }
}
