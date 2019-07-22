package solidLab.p05_DependencyInversion.p03_Database;

public class Courses {
    private Data database;

    public Courses(Data database) {
        this.database = database;
    }

    public void setDatabase(Data database) {
        this.database = database;
    }

    public void printAll() {
        Iterable<String> courses = database.courseNames();

    }

    public void printIds() {
        Iterable<Integer> coursesIds = database.courseIds();
    }

    public void printById(int id) {
        String course = database.getCourseById(id);
    }

    public void search(String substring) {
        Iterable<String> courses = database.search(substring);
    }
}
