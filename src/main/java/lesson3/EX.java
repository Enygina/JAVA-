package lesson3;

import java.util.*;
import java.util.stream.Collectors;

public class EX {
    static String[] solarSystemPlanets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
    public static void main(String[] args) {
//        getRandomTo10();
//        getCountDublePlanet(getRandomListArray(solarSystemPlanets));
//        deletDubleInArrHashSet(getRandomListArray(solarSystemPlanets));
//        deleteDoubleInArrStream(getRandomListArray(solarSystemPlanets));
        // Задача 1 домашней работы
        oddNums(rendomList());
        oddNumsInterator(rendomList());
    }


    static void getRandomTo10() {
        ArrayList<Integer> randomNums = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i < 100; i++) {
            randomNums.add(random.nextInt(3, 11));
        }
       randomNums.sort(Comparator.naturalOrder());
       System.out.println(randomNums);
    }
    static List<String> getRandomListArray(String[] arr ){
        ArrayList<String> resultArr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++){
            resultArr.add(arr[random.nextInt(8)]);
        }
        System.out.println("Исходный массив:\n"+resultArr);
        return resultArr;
    }
    static void  getCountDublePlanet(List<String> planets){
        Map<String, Integer> frequencyPlanets = new HashMap<>();

        for (String planet : planets){
            if (frequencyPlanets.containsKey(planet)){
                frequencyPlanets.put(planet,frequencyPlanets.get(planet)+1);
            } else {
                frequencyPlanets.put(planet,1);
            }
        }
        for (String planet : frequencyPlanets.keySet()) {
            System.out.printf("%s\t%s\n", planet, frequencyPlanets.get(planet));
        }
    }
    static void deletDubleInArrHashSet(List<String> arr){
        Set<String> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        System.out.println("Массив без дубликатов:\n"+arr);
    }

    static void deleteDoubleInArrStream(List<String> arr){
        List<String> listWithoutDuplicates = arr.stream()
                    .distinct()
                    .toList();
            System.out.println("Массив без дубликатов:"+listWithoutDuplicates);
        }



    private static ArrayList<Integer> rendomList(){
        ArrayList<Integer> rendNums = new ArrayList<Integer>();
        Random random = new Random();

        for (int i = 0; i < 20; i++) {
            int val = random.nextInt(0,10);
            rendNums.add(val);
        }
        System.out.println(rendNums);
        return rendNums;
    }
    static void oddNumsInterator(ArrayList<Integer> rendNums){
        for (Iterator<Integer> iterator = rendNums.iterator(); iterator.hasNext();) {
            Integer number = iterator.next();
            if (number % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(rendNums);
    }
    static void oddNums(ArrayList<Integer> rendNums){
                int i = 0;
        while (i < rendNums.size()) {
            if (rendNums.get(i) % 2 == 0) {
                rendNums.remove(i);
            }
            else {
                i++;
            }
        }
        System.out.println(Arrays.toString(rendNums.toArray()));

    }
}


