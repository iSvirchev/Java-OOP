import reflection.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class someClass = Reflection.class;
        System.out.println("class " + someClass.getSimpleName());
        System.out.println("class " + someClass.getSuperclass().getName());

        Class[] interfaces = someClass.getInterfaces();

        Arrays.stream(interfaces)
                .forEach(i -> System.out.println("interface " + i.getName()));

        Constructor[] declaredConstructors = someClass.getDeclaredConstructors();
        Reflection reflection = (Reflection) someClass.getDeclaredConstructor().newInstance();
        System.out.println(reflection);

        /*for (Constructor declaredConstructor : declaredConstructors) {
            declaredConstructor.newInstance();
        }
        */
    }
}
