package advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int red = Integer.MAX_VALUE;
    static int green = Integer.MAX_VALUE;
    static int blue = Integer.MAX_VALUE;
    static int countId  = 0;
    static int possible = 1;
    private static int gameId = 0;
    static int maxRedCubes = 0;
    static int maxBlueCubes = 0;
    static int maxGreenCubes = 0;
    private static long totalPower = 0;

    public static void main(String[] args) {

        Map<Integer, String> mapOfSet = new HashMap<>();

        try(BufferedReader br = new BufferedReader(new FileReader("C:/Users/yagne/Documents/adventOfCode.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                String[] lineArray = line.split(";");
                for(int i=0; i<lineArray.length ; i++){
                    System.out.println("Splitting by ; " + lineArray[i]);
                    mapOfSet.put(i, lineArray[i]);
                }
                possible = 1;

                for (Map.Entry<Integer, String> entry : mapOfSet.entrySet()) {
                    if (entry.getValue().contains("Game")) {
//                        System.out.print(entry.getValue());
                        String[] firstSet = entry.getValue().split(" ");

                        gameId = Integer.parseInt(firstSet[1].substring(0, firstSet[1].length() - 1 ));
                        System.out.println("GAME ID:" + gameId);

                        for (int i = 0; i < firstSet.length - 1; i++) {
                            char[] s = firstSet[i].toCharArray();
                            if(Character.isDigit(s[0]) && !firstSet[i].contains(":")){
                                if(checkForValidCubes(firstSet[i+1], Integer.parseInt(firstSet[i]))){
//                                    System.out.println(firstSet[i] + "-" + firstSet[i+1]);
                                    possible = -1;
                                    break;
                                }
                            }
                        }
                    } else {
//                        System.out.println(entry.getValue().trim());
                        String[] otherSet = entry.getValue().split(" ");
                        for (int i = 0; i < otherSet.length - 1 ; i++) {
                            char[] s = otherSet[i].trim().toCharArray();
                            if(s.length != 0 && Character.isDigit(s[0])){
//                                System.out.println(otherSet[i] + "-" + otherSet[i+1]);
                                if(checkForValidCubes(otherSet[i+1], Integer.parseInt(otherSet[i]))){
                                    possible = -1;
                                    break;
                                }
                            }
                        }
                    }
                }
                mapOfSet.clear();
//                System.out.println(possible);
                if(possible == 1){
//                    System.out.println(countId +"=="+ gameId);
                    countId += gameId;
                }

                long powerOfEachSet = (long) maxRedCubes * maxBlueCubes * maxGreenCubes;
                System.out.println(maxRedCubes +" " + maxGreenCubes +" " + maxBlueCubes);
                totalPower += powerOfEachSet;
                System.out.println(powerOfEachSet);
                System.out.println(totalPower);
                maxRedCubes = maxGreenCubes = maxBlueCubes = 0;
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();

            }
//             System.out.println(countId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkForValidCubes(String color, int numberOfCubes) {
        if(color.contains(",")){
           color = color.substring(0,color.length() - 1 );
        }
        System.out.println("NUmber of cubes " + numberOfCubes +" " + color);
        if(color.equals("red")){
            if(numberOfCubes > maxRedCubes) maxRedCubes = numberOfCubes;
            return numberOfCubes > red;
        }
        if(color.equals("green")){
            if(numberOfCubes > maxGreenCubes) maxGreenCubes = numberOfCubes;
            return  numberOfCubes > green;
        }
        if(color.equals("blue")){
            if(numberOfCubes > maxBlueCubes) maxBlueCubes = numberOfCubes;
            return numberOfCubes > blue;
        }
         return false;
    }
}