package core;

import core.interfaces.MachineFactory;
import core.interfaces.PilotFactory;
import core.interfaces.MachinesManager;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static common.OutputMessages.*;

public class MachinesManagerImpl implements MachinesManager {
    private PilotFactory pilotFactory;
    private MachineFactory machineFactory;
    private Map<String, Pilot> pilots;
    private Map<String, Machine> machines;

    public MachinesManagerImpl(PilotFactory pilotFactory, MachineFactory machineFactory, Map<String, Pilot> pilots, Map<String, Machine> machines) {
        this.pilotFactory = pilotFactory;
        this.machineFactory = machineFactory;
        this.pilots = pilots;
        this.machines = machines;
    }

    @Override
    public String hirePilot(String name) {
        if (this.pilots.containsKey(name)) {   // check  if pilot hired ?>?>?
            throw new IllegalArgumentException(String.format(pilotExists, name));
        }
        Pilot pilot = this.pilotFactory.createPilot(name);

        this.pilots.put(name, pilot);
        String output = String.format(pilotHired, name);
        return output;
    }

    @Override
    public String manufactureTank(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            throw new IllegalArgumentException(String.format(machineExists, name));
        }
        Tank tank = this.machineFactory.createTank(name, attackPoints, defensePoints);
        this.machines.put(name, tank);
        String output = String.format(tankManufactured, name, attackPoints, defensePoints);
        return output;
    }

    @Override
    public String manufactureFighter(String name, double attackPoints, double defensePoints) {
        if (this.machines.containsKey(name)) {
            throw new IllegalArgumentException(String.format(machineExists, name));
        }
        Fighter fighter = this.machineFactory.createFighter(name, attackPoints, defensePoints);
        this.machines.put(name, fighter);
        String output = String.format(fighterManufactured, name, attackPoints, defensePoints);
        return output;
    }

    @Override
    public String engageMachine(String selectedPilotName, String selectedMachineName) {
        Machine machine = searchManufacturedMachines(selectedMachineName);
        Pilot pilot = searchHiredPilots(selectedPilotName);

        if (machine.getPilot() != null) {
            throw new IllegalArgumentException(String.format(machineHasPilotAlready, machine.getName()));
        }

        machine.setPilot(pilot);
        pilot.addMachine(machine);

        String output = String.format(machineEngaged, selectedPilotName, selectedMachineName);
        return output;
    }

    @Override
    public String attackMachines(String attackingMachineName, String defendingMachineName) {
        Machine attackingMachine = searchManufacturedMachines(attackingMachineName);
        Machine defendingMachine = searchManufacturedMachines(defendingMachineName);

        double firstMachineAttk = attackingMachine.getAttackPoints();
        double secondMachineDef = defendingMachine.getDefensePoints();

        if (firstMachineAttk > secondMachineDef) {
            double healthPoints = defendingMachine.getHealthPoints();

            if(healthPoints-firstMachineAttk < 0){
                healthPoints = 0;
            }else{
                healthPoints-=firstMachineAttk;
            }
            defendingMachine.setHealthPoints(healthPoints);
        }

        attackingMachine.attack(defendingMachineName); // adds to targets
        String output = String.format(attackSuccessful, defendingMachineName, attackingMachineName, defendingMachine.getHealthPoints()); // double check
        return output;
    }

    @Override
    public String pilotReport(String pilotName) {
        Pilot pilot = searchHiredPilots(pilotName);

        return pilot.report();
    }

    @Override
    public String toggleFighterAggressiveMode(String fighterName) {
        Machine machine = searchManufacturedMachines(fighterName);
        if (!machine.getClass().getSimpleName().contains(Fighter.class.getSimpleName())) {
            throw new IllegalArgumentException(String.format(notSupportedOperation, fighterName));
        }

        try {
            Method toggleAggressiveMode = machine.getClass().getDeclaredMethod("toggleAggressiveMode");
            toggleAggressiveMode.setAccessible(true);
            toggleAggressiveMode.invoke(machine);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String output = String.format(fighterOperationSuccessful, fighterName);
        return output;
    }

    @Override
    public String toggleTankDefenseMode(String tankName) {
        Machine machine = searchManufacturedMachines(tankName);
        String type = machine.getClass().getSimpleName();
        if (!machine.getClass().getSimpleName().contains(Tank.class.getSimpleName())) {
            throw new IllegalArgumentException(String.format(notSupportedOperation, tankName));
        }

        try {
            Method toggleDefenseMode = machine.getClass().getDeclaredMethod("toggleDefenseMode");
            toggleDefenseMode.setAccessible(true);
            toggleDefenseMode.invoke(machine);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        String output = String.format(tankOperationSuccessful, tankName);
        return output;
    }

    private Machine searchManufacturedMachines(String selectedMachineName) {
        Machine machine;
        if (!this.machines.containsKey(selectedMachineName)) {
            throw new NullPointerException(String.format(machineNotFound, selectedMachineName));
        }
        machine = this.machines.get(selectedMachineName);
        return machine;
    }

    private Pilot searchHiredPilots(String pilotName) {
        if (!this.pilots.containsKey(pilotName)) {
            throw new NullPointerException(String.format(pilotNotFound, pilotName));
        }

        return this.pilots.get(pilotName);
    }
}
