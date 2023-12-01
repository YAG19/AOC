package advent.of.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        Integer totalCalibrationValue = 0;
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(new File("C:/Users/yagne/Documents/adventOfCode.txt"))))) {
            List<String> stringList = stream.toList();
            for(String line: stringList){
              totalCalibrationValue +=  getCalibrationValue(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(totalCalibrationValue);
    }

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

    }
