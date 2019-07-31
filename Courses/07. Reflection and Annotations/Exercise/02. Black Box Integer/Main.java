import blackBoxInteger.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Scanner;

/*
@SuppressWarnings("All")
*/
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        BlackBoxInt blackBoxInt = null;
        Field innerValue = null;
        try {
            Constructor ctor = BlackBoxInt.class.getDeclaredConstructor();
            ctor.setAccessible(true);
            blackBoxInt = (BlackBoxInt) ctor.newInstance();
            innerValue = BlackBoxInt.class.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchFieldException e) {
            e.printStackTrace();
        }
        Method[] declaredMethods = BlackBoxInt.class.getDeclaredMethods();

        while (!"END".equals(input)) {
            String[] elem = input.split("_");
            String cmd = elem[0];
            int value = Integer.parseInt(elem[1]);

            Method method = Arrays.stream(declaredMethods)
                    .filter(m -> m.getName().equals(cmd))
                    .findFirst()
                    .orElse(null);

            if (method != null) {
                method.setAccessible(true);
                try {
                    method.invoke(blackBoxInt, value);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println(innerValue.getInt(blackBoxInt));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            input = scanner.nextLine();
        }


    }
}
