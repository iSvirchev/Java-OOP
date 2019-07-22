package solidLab.p05_DependencyInversion.p02_Worker;

public class Main {
    public static void main(String[] args) {
        Worker worker1 = new Worker();
        Manager manager = new Manager(worker1);
    }
}
