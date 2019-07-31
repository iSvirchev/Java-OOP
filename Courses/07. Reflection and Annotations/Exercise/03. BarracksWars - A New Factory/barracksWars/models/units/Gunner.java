package barracksWars.models.units;

public class Gunner extends AbstractUnit{
    private static final int ARCHER_HEALTH = 50;
    private static final int ARCHER_DAMAGE = 10;

    public Gunner() {
        super(ARCHER_HEALTH, ARCHER_DAMAGE);
    }
}
