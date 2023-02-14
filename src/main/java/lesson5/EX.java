package lesson5;

import java.util.*;

public class EX {
    public static void main(String[] args) {
//        ex0();
//        System.out.println(ex1());
//        ex2();
//        ex5();
        hw1();
        hw2();

    }

    /**    Создать структуру для хранения Номеров паспортов
 *  и Фамилий сотрудников организации.
123456 Иванов
321456 Васильев
234561 Петрова
234432 Иванов
654321 Петрова
345678 Иванов
 Вывести данные по сотрудникам с фамилией Иванов.
 **/

    private static void ex0() {
        HashMap<Integer, String> people = new HashMap<>();
        people.put(123456, "Иванов");
        people.put(321456, "Васильев");
        people.put(234561, "Петрова");
        people.put(234432, "Иванов");
        people.put(654321, "Петрова");
        people.put(345678, "Иванов");

        for (Integer key : people.keySet()){
            if ("Иванов".equals(people.get(key))){
                System.out.printf("[%d: %s]\n",key, people.get(key));
            }
        }
    }

    /**
     * Даны 2 строки, написать метод, который вернет true,
     * если эти строки являются изоморфными и false, если нет.
     * Строки изоморфны, если одну букву в первом слове можно
     * заменить на некоторую букву во втором слове, при этом
     * повторяющиеся буквы одного слова меняются на одну и
     * ту же букву с сохранением порядка следования.
     * (Например, add - egg изоморфны)
     * буква может не меняться, а остаться такой же.
     * (Например, note - code)
     * Пример 1:
     * Input: s = "foo", t = "bar"
     * Output: false
     * Пример 2:
     * Input: s = "paper", t = "title"
     * Output: true
     */
    private static boolean ex1() {
        String s = "paper";
        String t = "title";
        s = s.replace(" ", "");
        t = t.replace(" ", "");
        if (s.length()!= t.length()){
            return false;
        }
        s = s.toLowerCase();
        t = t.toLowerCase();
        HashMap<Character,Character> map = new HashMap<>();
        for (int i = 0; i<s.length(); i++){
            if (map.containsKey(s.charAt(i))){
                if (!map.get(s.charAt(i)).equals(t.charAt(i))){
                   return false;
                }
            }
            map.putIfAbsent(s.charAt(i), t.charAt(i));
        }
        System.out.println(map);
        return true;
    }

    /**
     * Написать программу, определяющую правильность расстановки
     * скобок в выражении.
     * Пример 1: a+(d*3) - истина
     * Пример 2: [a+(1*3) - ложь
     * Пример 3: [6+(3*3)] - истина
     * Пример 4: {a}[+]{(d*3)} - истина
     * Пример 5: <{a}+{(d*3)}> - истина
     * Пример 6: {a+]}{(d*3)} - ложь
     *
     * @return
     */
    private static void ex2() {
        StringBuilder expr1 = new StringBuilder("a+(d*3) ");
        System.out.println(checkString(expr1));

        StringBuilder expr2 = new StringBuilder("[a+(1*3)");
        System.out.println(checkString(expr2));

        StringBuilder expr3 = new StringBuilder("[6+(3*3)]");
        System.out.println(checkString(expr3));

        StringBuilder expr4 = new StringBuilder("{a}[+]{(d*3)}");
        System.out.println(checkString(expr4));

        StringBuilder expr5 = new StringBuilder("<{a}+{(d*3)}>");
        System.out.println(checkString(expr5));

        StringBuilder expr6 = new StringBuilder("{a+]}{(d*3)}");
        System.out.println(checkString(expr6));
    }

    private static boolean checkString(StringBuilder expr) {
            HashMap <Character, Character> brackets = new HashMap<>();
            brackets.put('[',']');
            brackets.put('(',')');
            brackets.put('{','}');
            brackets.put('<','>');

            int index = 0;
            while (index < expr.length()){
                if (brackets.containsKey(expr.charAt(index))){
                    int index2 = expr.indexOf(String.valueOf(brackets.get(expr.charAt(index))));
                    if (index2 >=0){
                        expr.deleteCharAt(index);
                        expr.deleteCharAt(index2 - 1);
                        index--;
                    } else {
                        return false;
                    }
                } else if ((brackets.containsValue((expr.charAt(index))))) {
                    return false;
                }
                index++;
            }
            return true;
        }

    /**
     * Взять набор строк, например,
     * Мороз и солнце день чудесный
     * Еще ты дремлешь друг прелестный
     * Пора красавица проснись.
     * Написать метод, который отсортирует эти строки
     * по длине с помощью TreeMap. Строки с одинаковой
     * длиной не должны “потеряться”.
     */
    private static void ex5() {
        String[] s = {"Мороз и солнце день чудесный Еще ты дремлешь друг прелестный Пора красавица проснись."};
//        TreeMap<Double, String> map = new TreeMap<>();
//        for(int i = 0; i < s.length; i++){
//            if (map.containsKey((double) s[i].length())){
//                map.put(((double)s[i].length()) + i * Math.pow(10,-((int)Math.log10(s.length))-1), s[i]);
//            }else {
//                map.put((double) s[i].length(), s[i]);
//            }
        TreeMap<Integer, List<String>> map = new TreeMap<>();
        for (int i = 0; i< s.length; i++)
            if (map.containsKey(s[i].length())) {
                map.get(s[i].length()).add(s[i]);
            } else {
                ArrayList<String> list = new ArrayList<>();
                list.add(s[i]);
                map.put(s[i].length(), list);
            }
        System.out.println(map);

        System.out.println(s.length);
        System.out.println(map.size());
    }

    private static void hw1() {
        Map<Integer, ArrayList<String>> phoneBook = new HashMap<Integer, ArrayList<String>>();
        Map<Integer, String> nameBook = new HashMap<Integer, String>();
        nameBook.put(0, "Иванов");
        nameBook.put(1, "Петров");
        nameBook.put(2, "Иванов A");
        nameBook.put(3, "Сидоров");
        for (int i=0;i< nameBook.size();i++){
        if (phoneBook.get(i)==null){
            phoneBook.put(i, new ArrayList<String>());
            phoneBook.get(i).add("1111111111"+i+";"+"2222222222"+i);
        }
        System.out.println("Телефонные номера абонента"+" "+nameBook.get(i)+" :"+phoneBook.get(i));


    }
    }

    /**
     * Пусть дан список сотрудников:Иван Иванов
     * Светлана Петрова
     * Кристина Белова
     * Анна Мусина
     * Анна Крутова
     * Иван Юрин
     * Петр Лыков
     * Павел Чернов
     * Петр Чернышов
     * Мария Федорова
     * Марина Светлова
     * Мария Савина
     * Мария Рыкова
     * Марина Лугова
     * Анна Владимирова
     * Иван Мечников
     * Петр Петин
     * Иван Ежов
     * Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений. Отсортировать по убыванию популярности.
     */
    private static void hw2() {
        HashMap<String, Integer> freqMap = new HashMap<String, Integer>();
        HashMap<String, String> dataMap = new HashMap<>();
        int bubblesBufferForValues;
        String bubblesBufferForKeys;
        dataMap.put("Петрова", "Светлана");
        dataMap.put("Белова", "Кристина");
        dataMap.put("Мусина", "Анна");
        dataMap.put("Крутова", "Анна");
        dataMap.put("Юрин", "Иван");
        dataMap.put("Лыков", "Петр");
        dataMap.put("Чернов", "Павел");
        dataMap.put("Чернышов", "Петр");
        dataMap.put("Федорова", "Мария");
        dataMap.put("Светлова", "Марина");
        dataMap.put("Савина", "Мария");
        dataMap.put("Рыкова", "Мария");
        dataMap.put("Лугова", "Марина");
        dataMap.put("Владимирова", "Анна");
        dataMap.put("Мечников", "Иван");
        dataMap.put("Петин", "Петр");
        dataMap.put("Ежов", "Иван");
        for (String name : dataMap.values()) {
            if (!freqMap.containsKey(name)) {
                if (Collections.frequency(dataMap.values(), name) >= 1) {
                    freqMap.put(name, Collections.frequency(dataMap.values(), name));
                }
            }
        }
        System.out.println(freqMap);
        ArrayList<Integer> sortedListValues = new ArrayList<Integer>(freqMap.values());
        ArrayList<String> sortedListKeys = new ArrayList<String>(freqMap.keySet());
        for (int i = 0; i < sortedListValues.size(); i++) {
            for (int j = 1; j < sortedListValues.size(); j++) {
                if (sortedListValues.get(j) > sortedListValues.get(j - 1)) {
                    bubblesBufferForValues = sortedListValues.get(j - 1);
                    sortedListValues.set((j - 1), sortedListValues.get(j));
                    sortedListValues.set((j), bubblesBufferForValues);
                    bubblesBufferForKeys = sortedListKeys.get(j - 1);
                    sortedListKeys.set((j - 1), sortedListKeys.get(j));
                    sortedListKeys.set((j), bubblesBufferForKeys);
                }
            }
        }
        System.out.println("Популярность имен по убыванию имеет вид:");
        for (int i = 0; i < sortedListValues.size(); i++) {
            System.out.println("Имя " + sortedListKeys.get(i) + " повторяется " +sortedListValues.get(i)+( sortedListValues.get(i)>1?" раза":" раз"));
        }
    }
}
