package entities;

import entities.interfaces.Fighter;
import entities.interfaces.Machine;
import entities.interfaces.Pilot;
import entities.interfaces.Tank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class BaseMachine implements Machine {
    private String name;
    private Pilot pilot;
    private double attackPoints;
    private double defensePoints;
    private double healthPoints;
    private List<String> targets;


    public BaseMachine(String name, double attackPoints, double defensePoints, double healthPoints) {
        this.setName(name);
        this.setAttackPoints(attackPoints);
        this.setDefensePoints(defensePoints);
        this.setHealthPoints(healthPoints);
        this.setTargets();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Machine name cannot be null or empty.");
        }

        this.name = name;
    }

    @Override
    public Pilot getPilot() {
        return this.pilot;
    }

    @Override
    public void setPilot(Pilot pilot) {
        if(pilot == null){
            throw new NullPointerException("Pilot cannot be null.");
        }

        this.pilot = pilot;
    }

    @Override
    public double getHealthPoints() {
        return this.healthPoints;
    }

    @Override
    public void setHealthPoints(double healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setAttackPoints(double attackPoints) {
        this.attackPoints = attackPoints;
    }

    public void setDefensePoints(double defensePoints) {
        this.defensePoints = defensePoints;
    }

    private void setTargets() {
        this.targets = new ArrayList<>();
    }

    @Override
    public double getAttackPoints() {
        return this.attackPoints;
    }

    @Override
    public double getDefensePoints() {
        return this.defensePoints;
    }

    @Override
    public List<String> getTargets() {
        return Collections.unmodifiableList(this.targets);
    }

    @Override
    public void attack(String target) {
        if(target == null || target.trim().isEmpty()){
            throw new IllegalArgumentException("Attack target cannot be null or empty string.");
        }

        this.targets.add(target);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%n- %s%n",this.getName()));
        String type =super.getClass().getSimpleName();
        if(type.contains(Fighter.class.getSimpleName())){
            type = "Fighter";
        }else if(type.contains(Tank.class.getSimpleName())){
            type = "Tank";
        }else{
            type ="ПРОБЛЕМ С TYPE";
        }
        sb.append(String.format(" *Type: %s%n",type));
        sb.append(String.format(" *Health: %.2f%n",this.getHealthPoints()));
        sb.append(String.format(" *Attack: %.2f%n",this.getAttackPoints()));
        sb.append(String.format(" *Defense: %.2f%n",getDefensePoints()));
        String targetString = "";
        if(this.targets.size() == 0) targetString = "None";
        else targetString= String.join(", ",this.targets);
        sb.append(String.format(" *Targets: %s%n", targetString));

        return sb.toString();
    }
}
