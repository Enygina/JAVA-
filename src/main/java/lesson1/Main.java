package lesson1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        ex1();
//        ex2();
//        hwEx1();
//        hwEx2();
//        hwEx3();



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

    // Задать одномерный массив и найти в нем минимальный и максимальный элементы
    private static void hwEx1() {
        
        int[] oneDimensArray = new int[20];
        Random random = new Random();

        for (int i = 0; i < oneDimensArray.length; i++) {
            oneDimensArray[i] = random.nextInt(1, 20);
        }
        System.out.println(Arrays.toString(oneDimensArray));
        
//        System.out.printf("Максимальное число в массиве - " + (findMinMaxByStats(oneDimensArray)[1]) + " , минимальное - " + (findMinMaxByStats(oneDimensArray)[0]));
        System.out.printf("Максимальное число в массиве - " + (findMinMaxByStream(oneDimensArray)[1]) + " , минимальное - " + (findMinMaxByStream(oneDimensArray)[0]));
    }

    private static int[] findMinMaxByStream(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int max = Arrays.stream(arr).max().getAsInt();
        int[] minMax = new int[]{min, max};
        return minMax;
    }

    private static int[] findMinMaxByStats(int[] arr) {
        IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();

        int max = stats.getMax();
        int min = stats.getMin();
        int[] minMax = new int[]{min, max};
        return minMax;
    }

//        Написать метод, который определяет, является ли год високосным, и возвращает boolean
//        (високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме
//        каждого 100-го, при этом каждый 400-й – високосный.
    private static void hwEx2() {

// Вариант 1:
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        int n = -1;
        do {
            System.out.print("Введите натуральное число: ");

            try {
                n = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка! ");
            }

        } while (n <= 0);


        int year = scanner.nextInt();
        scanner.close();

        leapYearCheck(year);
        IsLeapYearByGregorianCalendar(year);
    }

    private static void leapYearCheck(int year) {
        boolean leapYearCheck = year % 400 == 0 || year %100!=0 & year %4==0;
        System.out.printf((leapYearCheck)? year +" год - високосный": year +" год - не високосный");
    }

    private static void IsLeapYearByGregorianCalendar(int year) {
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
        int right = array.length - 1;
        int left = 0;

        System.out.printf("Заданный массив" + Arrays.toString(array));
        while (left <= right) {
            if (array[left] == val && array[right] != val) {
                array[left] = array[right];
                array[right] = val;
                left++;
                right--;
            } else if (array[left] == val) {
                right--;
            }else if (array[right] == val) {
                right--;
            } else left++;
        }
        System.out.println("Отсортированный массив" + Arrays.toString(array));
    }
}

