package solidLab.p05_DependencyInversion.p03_Database;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        Courses courses = new Courses(data);
    }
}
