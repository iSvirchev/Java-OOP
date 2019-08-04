import core.engine.Engine;
import core.system.SystemSplit;
import io.scanner.ConsoleScanner;
import io.scanner.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new ConsoleScanner();
        SystemSplit systemSplit = new SystemSplit();
        Engine engine = new Engine(systemSplit,scanner);
        engine.run();

    }
}
