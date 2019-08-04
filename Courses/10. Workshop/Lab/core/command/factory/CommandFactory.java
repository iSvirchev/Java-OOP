package core.command.factory;

import core.command.Command;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class CommandFactory {

    private static final String BASE_COMMAND_PACKAGE = "core.command.";
    public static final String COMMAND_SUFFIX = "Command";

    @SuppressWarnings("unchecked")
    public static Command buildCommand(String name, Object... args) {
        try {
            Class commandClass = Class.forName(BASE_COMMAND_PACKAGE + name + COMMAND_SUFFIX);
            Constructor<Command> ctor = commandClass.getDeclaredConstructors()[0];
            return ctor.newInstance(new Object[]{args});
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return null;
    }
}
