package entities;

import entities.interfaces.Fighter;

public class FighterImpl extends BaseMachine implements Fighter {
    private static final double HEALTH_POINTS_DEFAULT = 200;

    private static final double attackPointsModifier = 50;
    private static final double defensePointsModifier = 25;

    private boolean aggressiveMode = true;

    public FighterImpl(String name, double attackPoints, double defensePoints) {
        super(name,
                attackPoints + attackPointsModifier,
                defensePoints - defensePointsModifier,
                HEALTH_POINTS_DEFAULT);
    }

    @Override
    public boolean getAggressiveMode() {
        return this.aggressiveMode;
    }

    @Override
    public void toggleAggressiveMode() {
        if (this.aggressiveMode) { // turns off attk mode - decrease atk, increase def
            this.aggressiveMode = false;
            super.setAttackPoints(super.getAttackPoints() - attackPointsModifier * 2);
            super.setDefensePoints(super.getDefensePoints() + defensePointsModifier * 2);
        } else { // turns on attk mode - increase atk, decrease def
            this.aggressiveMode = true;
            super.setAttackPoints(super.getAttackPoints() + attackPointsModifier * 2);
            super.setDefensePoints(super.getDefensePoints() - defensePointsModifier * 2);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder();
        sb.append(super.toString());
        String mode = "";
        if(getAggressiveMode()) mode="ON";
        else mode = "OFF";
        sb.append(String.format(" *Aggressive Mode(%s)",mode));
        return sb.toString();
    }
}
