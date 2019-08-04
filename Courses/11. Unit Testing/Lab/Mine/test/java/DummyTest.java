import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpgLab.Axe;
import rpgLab.Dummy;

public class DummyTest {

    private static final int DEFAULT_AXE_ATTACK = 10;
    private static final int DEFAULT_AXE_DURABILITY = 10;
    private static final int DEFAULT_DUMMY_HEALTH = 20;
    private static final int DEFAULT_DUMMY_EXPERIENCE = 10;

    private Dummy target;
    private Axe axe;

    @Before
    public void initValues() {
        axe = new Axe(DEFAULT_AXE_ATTACK, DEFAULT_AXE_DURABILITY);
        target = new Dummy(DEFAULT_DUMMY_HEALTH, DEFAULT_DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthWhenAttacked() {
        int baseHealth = target.getHealth();
        axe.attack(target);
        Assert.assertTrue(baseHealth > target.getHealth());
        /*Assert.assertEquals(10,dummy.getHealth());*/
    }

    @Test(expected = IllegalStateException.class)
    public void dummyThrowsExceptionIfDeadWhenAttacked() {
        axe.attack(target);
        axe.attack(target);
        axe.attack(target);
    }

    @Test
    public void deadDummyGivesXP() {
        axe.attack(target);
        axe.attack(target);

        int actual = target.giveExperience();
        Assert.assertEquals(10, actual);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyShouldNotGiveXP() {
        axe.attack(target);

        target.giveExperience();
    }


}
