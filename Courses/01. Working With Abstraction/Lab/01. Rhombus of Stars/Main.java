package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        for (int i = 1; i <= n; i++) {
            printRow(n,i);
        }

        for (int i = n-1; i >= 1; i--) {
            printRow(n,i);

        }

    }

    public static void printRow(int size, int stars) {
        for (int i = 0; i < size-stars; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i < stars; i++) {
            System.out.print("* ");
        }

        System.out.println("*");
    }
}