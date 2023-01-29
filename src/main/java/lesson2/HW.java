package lesson2;

import java.io.*;
import java.util.Scanner;

public class HW {

    public static void main(String[] args) {

//        System.out.println((istPalindrom(getString()))?"Палиндром":"Не палиндром");
        wordsToFile(WordRepeat());

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

    public static String WordRepeat() {
        Scanner lineScanner = new Scanner(System.in);
        String test = "TEST";
        int n = -1;
        do {
            System.out.print("Введите числом, сколько раз напичатать слово TEST: ");
            try {
                n = lineScanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка! ");
                e.printStackTrace();
                //log.error("Ошибка: {}", e.getMessage);
            }
        } while (n <= 0);
        lineScanner.close();

        String word =(test).repeat(n);
        return word;
    }

    private static void wordsToFile (String word) {

        try(FileWriter writer = new FileWriter("src/main/resources/lib/sem2hw3.txt", false))
        {
            writer.write(word);
            System.out.println("Данные занесены в файл");
            writer.flush();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}


