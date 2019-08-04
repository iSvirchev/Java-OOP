import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import rpgLab.Hero;
import rpgLab.interfaces.Target;
import rpgLab.interfaces.Weapon;

public class HeroTests  {

    private static final int DEFAULT_XP = 10;
    private static final int DEFAULT_TARGET_HEALTH = 0;
    private static final boolean DEFAULT_IS_TARGET_DEAD = Boolean.TRUE;

    private static final int DEFAULT_WEAPON_ATTACK = 10;
    private static final int DEFAULT_WEAPON_DURABILITY = 0;

    public static final String HERO_NAME = "Pesho";

    @Test
    public void attackGainsExperienceIfTargetIsDead(){
        Target mockTarget = Mockito.mock(Target.class);
        Mockito.when(mockTarget.giveExperience()).thenReturn(DEFAULT_XP);
        Mockito.when(mockTarget.isDead()).thenReturn(DEFAULT_IS_TARGET_DEAD);
    /*    Target fakeTarget = new Target() {
            @Override
            public int getHealth() {
                return DEFAULT_TARGET_HEALTH;
            }

            @Override
            public void takeAttack(int attackPoints) {}

            @Override
            public int giveExperience() {
                return DEFAULT_XP;
            }

            @Override
            public boolean isDead() {
                return DEFAULT_IS_TARGET_DEAD;
            }
        };*/

        Weapon mockWeapon = Mockito.mock(Weapon.class);
        Mockito.when(mockWeapon.getAttackPoints()).thenReturn(DEFAULT_WEAPON_ATTACK);
        Mockito.when(mockWeapon.getDurabilityPoints()).thenReturn(DEFAULT_WEAPON_DURABILITY);
/*
        Weapon fakeWeapon = new Weapon() {
            @Override
            public int getAttackPoints() {
                return DEFAULT_WEAPON_ATTACK;
            }

            @Override
            public int getDurabilityPoints() {
                return DEFAULT_WEAPON_DURABILITY;
            }

            @Override
            public void attack(Target target) {
            }
        };*/

        /*Hero hero = new Hero(HERO_NAME,fakeWeapon);
        hero.attack(fakeTarget);
        Assert.assertEquals(DEFAULT_XP,hero.getExperience());*/

        Hero hero = new Hero(HERO_NAME,mockWeapon);
        hero.attack(mockTarget);
        Assert.assertEquals(DEFAULT_XP,hero.getExperience());
    }
}
