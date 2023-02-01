package lesson2;


        import java.util.Scanner;

public class Main {

    void test1() {
        Scanner lineScanner = new Scanner(System.in);
        int n = -1;
        do {
            System.out.print("Введите натуральное число: ");
            try {
                n = lineScanner.nextInt();
            } catch (Exception e) {
                System.out.println("Ошибка! ");
                e.printStackTrace();
                //log.error("Ошибка: {}", e.getMessage);
            }
        } while (n <= 0);

        System.out.print("Введите первый символ: ");
        String c1String = "";
        try {
            c1String = lineScanner.next();
        } catch (Exception e) {
            System.out.print("Ошибка! ");
        }

        System.out.print("Введите второй символ: ");
        String c2String = "";
        try {
            c2String = lineScanner.next();
        } catch (Exception e) {
            System.out.print("Ошибка! ");
        }
        lineScanner.close();


        char c1 = c1String.charAt(0);
        char c2 = c2String.charAt(0);

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sb.append(c1);
            } else {
                sb.append(c2);
            }
        }

        System.out.println(sb);

//        String line = "";
//        for (int i = 0; i < n; i++) {
//            if(i % 2 == 0) {
//                line += c1;
//            } else {
//                line += c2;
//            }
//

    }

    public static void test1_2(String[] args) {
        // Задаем длину строки
        Scanner read = new Scanner(System.in);
        System.out.print("Введите длину строки: ");
        int length = read.nextInt();

        // Задаем первый символ
        read = new Scanner(System.in);
        System.out.print("Ведите символ C1: ");
        char first = read.next().charAt(0);

        // Задаем второй символ
        System.out.print("Ведите символ C2: ");
        char second = read.next().charAt(0);

        String firstStrSymbol = String.valueOf(first);

        String str = String.valueOf(first).concat(String.valueOf(second)).repeat(length / 2);
/*        String str =
                String.valueOf(first)
                        .concat(String.valueOf(second))
                        .repeat(length / 2)
                        .concat((length % 2 == 1) ? String.valueOf(first) : "");*/

        if (length % 2 == 1) {
//            sb.append(first);
            str += String.valueOf(first);
        }
        System.out.println(str);
    }
}
