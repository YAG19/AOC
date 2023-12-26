package advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/yagne/Documents/adventOfCode.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<String[]> stringList = new ArrayList<>();
            while (line != null) {
                String[] arrayString = line.split(" ");
                stringList.add(arrayString);
                Arrays. stream(arrayString[0].split(""));
                line = br.readLine();
            }
//            for (int i = 0; i < stringList.size(); i++) {
//                Arrays.stream(stringList.get(i)).forEach(x -> System.out.print(x));
//                System.out.println();
//            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}