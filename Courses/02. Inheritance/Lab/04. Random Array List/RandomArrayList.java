import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList {

    private static final Random RANDOM;

    static {
        RANDOM = new Random();
    }

    public Object getRandomElement() {
        int index = RANDOM.nextInt(super.size());

        return super.get(index);
    }

    public void removeElement(){
        int index = RANDOM.nextInt(super.size());

        super.remove(index);
    }
}
