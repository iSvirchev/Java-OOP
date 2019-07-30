import reflection.Reflection;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args){

        Reflection reflection = new Reflection();

        Class<? extends Reflection> refClass = reflection.getClass();
        Method[] allDeclaredMethods = refClass.getDeclaredMethods();

        Method[] declaredGetters = getMethodsStartingWith("get",allDeclaredMethods);
        Method[] declaredSetters = getMethodsStartingWith("set",allDeclaredMethods);

        Arrays.stream(declaredGetters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s will return class %s",
                        m.getName(),
                        m.getReturnType().getName())));

        Arrays.stream(declaredSetters)
                .sorted(Comparator.comparing(Method::getName))
                .forEach(m -> System.out.println(String.format("%s and will set field of class %s",
                        m.getName(),
                        m.getParameterTypes()[0].getName())));

    }

    public static Method[] getMethodsStartingWith (String startingWith, Method[] methods){
        return Arrays.stream(methods)
                .filter(m -> m.getName().startsWith(startingWith))
                .toArray(Method[]::new);

    }
}
