package solidLab.p02_OpenClosedPrinciple.p01_FileStream;

public class Main {
    public static void main(String[] args) {
        StreamableObject file = new File();
        StreamableObject muisc = new Music();
        System.out.println(Progress.getCurrentPercent(file));
        System.out.println(Progress.getCurrentPercent(muisc));

    }
}

