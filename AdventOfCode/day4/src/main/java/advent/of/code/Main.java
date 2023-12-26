package advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/yagne/Documents/adventOfCode.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<String[]> stringList = new ArrayList<>();
            int totalPoint = 0;

            while (line != null) {
                System.out.println(line);
                String[] arrayString = line.split("\\|");
                stringList.add(arrayString);
//                System.out.println(Arrays.stream(arrayString[1].trim().split(" ")).count());
                String[] winingDeck = arrayString[0].split(":");
                List<String> winningNumAr = Arrays.stream(winingDeck[1].trim().split(" ")).map(String::valueOf).toList();
                List<String> chosenNum = Arrays.stream(arrayString[1].trim().split(" ")).map(String::valueOf).toList();
                HashMap<Integer, Integer> winingHashMap = new HashMap<>();
                for(int i=0 ;i < winningNumAr.size() ; i++ ){
                    if(!winningNumAr.get(i).isBlank()) {
                        winingHashMap.put(Integer.parseInt( winningNumAr.get(i) ), i);
                    }
                }
                int countMatch = 1;
                for (String integer : chosenNum) {

                    if( !integer.isBlank() &&  winingHashMap.containsKey(Integer.parseInt(integer)) ) {
                        countMatch *= 2;
                    }
                }
                totalPoint += countMatch/2;
                System.out.println(countMatch/2);
                line = br.readLine();
            }
            System.out.println(totalPoint);
    } catch (
    IOException e) {
        throw new RuntimeException(e);
    }

}
}