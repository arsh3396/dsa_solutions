package Arrays;

import java.util.*;
import java.io.*;

public class Pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int h = n/2;

        for (int i = 0; i < n; i++) {
            if (i != h) {
                for (int j = 0; j < h; j++) {
                    System.out.print("  ");
                }

                if (i < h) {
                    for (int j = 0; j < i; j++) {
                        System.out.print("* ");
                    }
                }
                else if (i < h) {
                    for (int j = h-i; j >= 0; j--) {
                        System.out.print("* ");
                    }
                }
            }
            else {
                for (int j = 0; j < n; j++) {
                    System.out.print("* ");
                }
            }
        }
        sc.close();
    }
}
