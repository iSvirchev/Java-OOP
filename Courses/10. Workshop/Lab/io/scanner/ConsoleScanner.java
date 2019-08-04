package io.scanner;

public class ConsoleScanner implements Scanner {
    private static final java.util.Scanner SCANNER;

    static {
        SCANNER = new java.util.Scanner(System.in);
    }

    @Override
    public String readLine() {
        return SCANNER.nextLine();
    }
}
