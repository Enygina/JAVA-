package lesson1;

import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
//        ex1();
//        ex2();
//        hwEx1();
//        hwEx2();
        hwEx3();

    }

    public static void ex1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String name = scanner.next();
        System.out.printf("Привет, " + name + "!");
    }


    private static void ex2() {
        int[] binArray = new int[1000];
        int count = 0;
        int maxCount = 0;
        Random random = new Random();
//        double randomFromMath = Math.random();
//        System.out.println(randomFromMath);

        for (int i = 0; i < binArray.length; i++) {
            binArray[i] = random.nextInt(2);
        }

//        System.out.println(Arrays.toString(binArray));
        for (int num : binArray) {
            if (num == 1) {
                count++;
            } else {
                /* if (count > maxCount){
                        maxCount = count;
                        count = 0;
                }*/

//                maxCount = (count > maxCount)?  count : maxCount;

                maxCount = Math.max(count, maxCount);
                count = 0;
            }
        }
        System.out.println("Максимальная серия единиц: " + Math.max(count, maxCount));
    }


    private static void hwEx1() {

// Задать одномерный массив и найти в нем минимальный и максимальный элементы

        int[] oneDimensArray = new int[20];
        Random random = new Random();

        for (int i = 0; i < oneDimensArray.length; i++) {
            oneDimensArray[i] = random.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(oneDimensArray));
//
//  Вариант 1:
//        Arrays.sort(oneDimensArray);
//        int min = oneDimensArray[0];
//        int max = oneDimensArray[oneDimensArray.length-1];
//
//  Вариант 2:
        int min = Arrays.stream(oneDimensArray).min().getAsInt();
        int max = Arrays.stream(oneDimensArray).max().getAsInt();

        System.out.printf("Максимальное число в массиве - " + max + " , минимальное - " + min);

    }

    private static void hwEx2() {

//        Написать метод, который определяет, является ли год високосным, и возвращает boolean
//        (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме
//        каждого 100-го, при этом каждый 400-й – високосный.

// Вариант 1:
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = scanner.nextInt();
//        boolean leapYearChec = year % 400 == 0 | year%100!=0 &year%4==0;
//        System.out.printf((leapYearChec)? year+" год - високосный":year+" год - не високосный";
// Вариант 2:
        GregorianCalendar checYear = new GregorianCalendar();
        System.out.println((checYear.isLeapYear(year)) ? year + " год - високосный" : year + " год - не високосный");


    }
    private static void hwEx3() {

// Дан массив nums = [3,2,2,3] и число val = 3.
//Если в массиве есть числа, равные заданному, нужно перенести эти элементы в
// конец массива. Таким образом, первые несколько (или все) элементов массива
// должны быть отличны от заданного, а остальные - равны ему.
        int[] array = new int[20];
        Random random = new Random();
        int val = 3;

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(1, 5);
        }
        int right = array.length-1;
        int left = 0;

        System.out.printf("Заданный массив"+Arrays.toString(array));
        while (left <=right){
        if (array[left] == val & array[right] != val) {
            array[left] = array[right];
            array[right] = val;
            left++;
            right--;
        }if (array[left] == val) {
            right++;
        }if (array[right] == val){
            right--;
        }else {left++;}
        }
        System.out.printf("Отсортированный массив"+Arrays.toString(array));
    }
}

