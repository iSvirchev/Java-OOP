public class Main {

    public static void main(String[] args) {

        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(5);
        randomArrayList.add(5.2);
        randomArrayList.add("fuck");

        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        randomArrayList.removeElement();
        randomArrayList.removeElement();
        System.out.println(randomArrayList.getRandomElement());
        System.out.println(randomArrayList.getRandomElement());
        randomArrayList.removeElement();
        System.out.println(randomArrayList.getRandomElement());
    }
}
