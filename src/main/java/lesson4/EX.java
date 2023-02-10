package lesson4;

import java.util.*;


public class EX {
    public static void main(String[] args) {
//        ex0();
//        ex1();
    }

    private static void ex0() {

        String text = inputText();
        LinkedList<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list);
        parseText(list, text);
        System.out.println(list);
        startEndlessСycle(list);
    }

    private static void startEndlessСycle(LinkedList<String> list) {
        String text = "";
        while (true){
            text = inputText();
            if (text.equals("exit")|| !text.contains("~")){
                return;
            }
            parseText(list,text);
            System.out.println(list);
        }
    }

    private static LinkedList parseText(LinkedList<String> list, String text) {
        String action = "";
        String index = "";
        if (!text.contains("~")) {
            return list;
        } else {
            action = text.split("~")[0];
            index = text.split("~")[1];
            int ind = 0;
            try {
                ind = Integer.parseInt(index);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            if (ind >= list.size() && ind < 0) {
                throw new RuntimeException("Выход за пределы листа");
            }
            if (action.equals("print")) {
                System.out.println(list.get(ind));
                list.remove(ind);
            } else {
                list.set(ind, action);
            }
        }
        return list;
    }

    private static String inputText() {
        String text = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите запрос: ");
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
    }

    private static void ex1() {
        Scanner in = new Scanner(System.in);
        List<String> wordsList = new ArrayList<>();
        Collections.addAll(wordsList, "apple", "orange", "banana", "tomato", "strawberry", "melon");
        int num = 0;

        while (true) {
            System.out.println();
            System.out.print("Введите строку: ");
            String inputString = in.nextLine();

            if (inputString.length() == 0) {
                System.out.println("Строка не должна быть пустой");
                continue;
            }

            if (inputString.equals("print~all")) {
                for (int i = 0; i < wordsList.size(); i++) {
                    System.out.printf("%d) %s%n", i + 1, wordsList.get(i));
                }
            } else if (inputString.equals("stop")) {
                System.exit(0);
            }

            if (!inputString.contains("~")) {
                System.out.println("Строка не содержит тильду или чило");
                continue;
            }

            String[] parts = inputString.split("~");
            String word = parts[0];
            try {
                num = Integer.parseInt(parts[1]);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Выражение не содержит числа");
                continue;
            }

            if (num <= 0 || num > wordsList.size() + 1) {
                System.out.println("Число должно быть в пределах списка от 1 до " + (wordsList.size() - 1));
                continue;
            }

            if (word.equals("print")) {
                System.out.printf("Под номером %d находится слово: %s%n", num, wordsList.get(num - 1));
            } else if (num == wordsList.size()) {
                wordsList.add(word);
                System.out.printf("Слово %s добавлено на позицию %d%n", word, num);
            } else {
                String oldWord = wordsList.get(num - 1);
                wordsList.set(num - 1, word);
                System.out.printf("Слово %s заменило на позиции %d слово %s%n", word, num, oldWord);
            }

        }
    }
}


