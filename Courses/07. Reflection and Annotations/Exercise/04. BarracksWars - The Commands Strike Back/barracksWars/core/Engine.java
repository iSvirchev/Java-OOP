package barracksWars.core;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.UnitFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;
    private static final String COMMANDS_PACKAGE_PATH = "barracksWars.core.commands.";

    public Engine(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                String[] data = input.split("\\s+");
                String commandName = data[0];
                String result = interpretCommand(data, commandName);
                if (result.equals("fight")) {
                    break;
                }
                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private String interpretCommand(String[] data, String commandName) {
        String result = "Invalid Command!";

        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        try {
            Class<? extends Executable> clazz =
                    (Class<? extends Executable>) Class.forName(COMMANDS_PACKAGE_PATH + commandName);
            Constructor<? extends Executable> ctor =
                    clazz.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
            ctor.setAccessible(true);
            Executable executable = ctor.newInstance(data, this.repository, this.unitFactory);
            result = executable.execute();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String fightCommand(String[] data) {
        return "fight";
    }
}
