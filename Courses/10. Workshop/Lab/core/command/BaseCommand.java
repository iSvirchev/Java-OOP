package core.command;

public abstract class BaseCommand implements Command {
    public BaseCommand(Object... args){
        this.parseArse(args);
    }

    protected abstract void parseArse(Object... args);
}
