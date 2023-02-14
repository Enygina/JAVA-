package lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex5 {
    public static void main(String[] args) {
        ex5("C:\\Users\\Paul\\IdeaProjects\\java-praltic190123\\.idea");

    }


    private static void ex5(String path) {
        StringBuilder sb = new StringBuilder();
        for (String fileName : convertPathToNamesArr(path)) {
            sb.append(fileName).append(System.lineSeparator());
        }

        try(PrintWriter pw = new PrintWriter("src/main/resources/lib/2ex5.txt")) {
            pw.print(sb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String[] convertPathToNamesArr(String path) {
        File dir = new File(path);
//        try{
//            new Scanner(dir);
//            } catch (FileNotFoundException e){
//            throw new RuntimeException(e);
//        }
        return dir.list();
    }
}