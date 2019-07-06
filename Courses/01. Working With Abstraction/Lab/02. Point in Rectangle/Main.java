package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottomLeftX = scanner.nextInt();
        int bottomLeftY = scanner.nextInt();
        int topRightX = scanner.nextInt();
        int topRightY = scanner.nextInt();

        scanner.nextLine();

        int n = Integer.parseInt(scanner.nextLine());

        Point bottomeLeft = new Point(bottomLeftX,bottomLeftY);
        Point topRigth = new Point(topRightX,topRightY);

        Rectangle rectangle = new Rectangle(bottomeLeft,topRigth);

        while (n-- > 0) {
            int[] elements = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int x = elements[0];
            int y = elements[1];

            Point checkPoint = new Point(x,y);

            System.out.println(rectangle.contains(checkPoint));
        }
    }
}
