package entities;

import entities.interfaces.Tank;

public class TankImpl extends BaseMachine implements Tank {
    private static final double HEALTH_POINTS_DEFAULT = 100;

    private static final double attackPointsModifier = 40;
    private static final double defensePointsModifier = 30;

    private boolean defenseMode = true;

    public TankImpl(String name, double attackPoints, double defensePoints) {
        super(name,
                attackPoints - attackPointsModifier,
                defensePoints + defensePointsModifier,
                HEALTH_POINTS_DEFAULT);
    }

    @Override
    public boolean getDefenseMode() {
        return this.defenseMode;
    }

    @Override
    public void toggleDefenseMode() {
        if (this.defenseMode) { // turns off def mode - increase atk, decrease def
            this.defenseMode = false;
            super.setAttackPoints(super.getAttackPoints() + attackPointsModifier * 2);
            super.setDefensePoints(super.getDefensePoints() - defensePointsModifier * 2);
        } else { // turns on def mode - decrease atk, increase def
            this.defenseMode = true;
            super.setAttackPoints(super.getAttackPoints() - attackPointsModifier * 2);
            super.setDefensePoints(super.getDefensePoints() + defensePointsModifier * 2);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString());
        String mode = "";
        if(getDefenseMode()) mode="ON";
        else mode = "OFF";
        sb.append(String.format(" *Defense Mode(%s)",mode));
        return sb.toString();
    }
}
