package lesson2;

import java.util.Scanner;

public class HW {

    public static void main(String[] args) {

        System.out.println((istPalindrom(getString()))?"Палиндром":"Не палиндром");

    }
    public static String[] getString () {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите значение для проверки на палиндром: ");
        String getString = in.nextLine();
        if (getString.isBlank()) {
            return new String[]{""};
        }
        return new String[]{getString};
    }


    public static boolean istPalindrom(String[] n){
        int first = 0;
        int last = n.length - 1;
        while (last > first) {
            if (n[first] != n[last]) {
                return false;
            }
            ++first;
            --last;
        }
        return true;
    }

}


