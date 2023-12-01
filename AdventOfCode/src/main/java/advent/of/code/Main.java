package advent.of.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;


public class Main {
    private static int totalProduces = 0;
    private static int totalCalibrationValue = 0;
    public static void main(String[] args) {
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(new File("C:/Users/yagne/Documents/adventOfCode.txt"))))) {
            List<String> stringList = stream.toList();
            for(String line: stringList){
              totalCalibrationValue +=  getCalibrationValue(line);
              totalProduces += getCalibrationValueForStringDigits(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(totalCalibrationValue);
        System.out.println(totalProduces);
    }

    //Part 2
    private static int getCalibrationValueForStringDigits(String line) {
        Integer stringLeftDigit = -1;
        Integer stringRightDigit = -1;
        int lastIndex = line.length() - 1;
        String  digit = "";
        for(int i =0 ; i< line.length(); i++){
            stringLeftDigit = findDigit(stringLeftDigit, line, i, line.substring(0, i + 1));
            stringRightDigit = findDigit(stringRightDigit, line, lastIndex, line.substring(lastIndex));
            lastIndex--;

        }
//        System.out.println(stringLeftDigit + " " + stringRightDigit);
        digit = String.valueOf(stringLeftDigit ) + String.valueOf(stringRightDigit);
        return Integer.parseInt(digit);

    }

    private static Integer findDigit(Integer stringDigit, String line, int index, String subString) {
        if(stringDigit == -1 && Character.isDigit(line.charAt(index))){
                stringDigit = Integer.parseInt(String.valueOf(line.charAt(index)));
        }
        else if(stringDigit == -1)
        {
            stringDigit = checkForStringDigits(subString);
        }
        return stringDigit;
    }

    private static Integer checkForStringDigits(String line) {
        for (Map.Entry<String, Integer> entry : mapOfDigit().entrySet()) {
              if(line.contains(entry.getKey())){
                  return entry.getValue();
              };
        }
        return -1;
    }


    //Part 1
    private static Integer getCalibrationValue(String line) {
        int lastIndex = line.length() - 1;
        char leftDigit = 'l';
        char rightDigit = 'r';
        String digit = "";
        for(int i=0 ; i < line.length(); i++) {
            char leftIndex = line.charAt(i);
            char rightIndex = line.charAt(lastIndex);
            if (Character.isDigit(leftIndex) && leftDigit == 'l'){
                leftDigit = line.charAt(i);
            }

            if(Character.isDigit(rightIndex) && rightDigit == 'r' ){
                rightDigit = line.charAt(lastIndex);
            }
            lastIndex--;

            digit = String.valueOf(leftDigit ) + String.valueOf(rightDigit);
        }
        return Integer.parseInt(digit);
    }

    private static Map<String, Integer> mapOfDigit(){
        Map<String,Integer> mapOfString = new HashMap<>();
        mapOfString.put("zero", 0);
        mapOfString.put("one", 1);
        mapOfString.put("two", 2);
        mapOfString.put("three", 3);
        mapOfString.put("four", 4);
        mapOfString.put("five", 5);
        mapOfString.put("six", 6);
        mapOfString.put("seven", 7);
        mapOfString.put("eight", 8);
        mapOfString.put("nine", 9);

        return mapOfString;
    }

}
