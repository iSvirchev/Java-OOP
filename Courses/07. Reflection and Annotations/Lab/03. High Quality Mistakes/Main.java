import reflection.Reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args){

        Reflection reflection = new Reflection();

        Class<? extends Reflection> refClass = reflection.getClass();
        Method[] allDeclaredMethods = refClass.getDeclaredMethods();

        Method[] declaredGetters = getMethodsStartingWith("get",allDeclaredMethods);
        Method[] declaredSetters = getMethodsStartingWith("set",allDeclaredMethods);

        Field[] fields = refClass.getDeclaredFields();

        Arrays.stream(fields)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(field -> System.out.println(field.getName() + " must be private!"));

        Arrays.stream(declaredGetters)
                .filter(f -> !Modifier.isPublic(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be public!",
                        m.getName())));

        Arrays.stream(declaredSetters)
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s have to be private!",
                        m.getName())));

    }

    private static Method[] getMethodsStartingWith (String startingWith, Method[] methods){
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(startingWith))
                .toArray(Method[]::new);

    }
}
