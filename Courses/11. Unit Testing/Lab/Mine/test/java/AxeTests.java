import org.junit.Assert;
import org.junit.Test;
import rpgLab.Axe;
import rpgLab.Dummy;

public class AxeTests {

    @Test
    public void weaponAttackLosesDurability() {
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(20, 10);

        int durability = axe.getDurabilityPoints();
        axe.attack(dummy);
        Assert.assertTrue(durability > axe.getDurabilityPoints());
    }

    @Test(expected =IllegalStateException.class)
    public void brokenWeaponCantAttack(){
        Axe axe = new Axe(10, 1);
        Dummy dummy = new Dummy(20, 10);

        axe.attack(dummy);
        axe.attack(dummy);
        axe.attack(dummy);
    }
}
