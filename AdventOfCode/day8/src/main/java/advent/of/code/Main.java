package advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/yagne/Documents/adventOfCode.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<String> stringList = new ArrayList<>();
            while (line != null) {
//                String[] arrayString = line.split(" ");
                stringList.add(line);
//                Arrays. stream(arrayString[0].split(""));
                line = br.readLine();
            }
            String instruction = stringList.get(0);
            HashMap<String, String> stringHashMap = new HashMap<>();
            for (int i = 2; i < stringList.size(); i++) {
                String[] arrayString = stringList.get(i).split("=");
                 stringHashMap.put(arrayString[0].trim(), arrayString[1].substring(2,10) );
//                System.out.println(stringList.get(i).split("="));
            }
//
//            int count = 0;
            for (Map.Entry<String, String> entry : stringHashMap.entrySet()) {
//                System.out.println(entry.getKey() + "=" + entry.getValue());
//                String[] nodes = entry.getValue().split(",");
//                String toCheckLR = checkForInstruction(instruction, count);
//                if(toCheckLR.charAt(0) == 'R'){
//                    String node = nodes[1];
//                    System.out.println(node);
//                    String nodeValue =  stringHashMap.get(node.substring(1,3));
//                    stringHashMap.get(nodeValue);
//                }
            }
            String destination = "";
            int countIns = 0;
            int countSteps = 1;
            String firstValue = stringHashMap.get("AAA");
            String[] tripleAValue = firstValue.split(",");
            System.out.println("First Step: "+ tripleAValue[0] + " " + tripleAValue[1]);
            while (true){
                String toCheckLR = checkForInstruction(instruction, countIns);
                countIns = Integer.parseInt(toCheckLR.substring(1, toCheckLR.length()));
                if(toCheckLR.charAt(0) == 'R'){
                    destination = tripleAValue[1].trim();
                    System.out.println("Destination Right" + destination);
                    String value = stringHashMap.get(destination.trim());
                    tripleAValue = value.split(",");
                    if(destination.trim().equals("ZZZ") ) {
                        break;
                    };
                    System.out.println("New Value for "+ destination +" =  "+ tripleAValue[0] + " " + tripleAValue[1]);
                }
                else{
                    System.out.println("Destination left " + tripleAValue[0]);
                    destination = tripleAValue[0].trim();
                    tripleAValue =   stringHashMap.get(destination.trim()).split(",");
                    if(destination.trim().equals("ZZZ") ) break;
                    System.out.println("New Value for "+ destination +" =  "+ tripleAValue[0] + " " + tripleAValue[1]);
                }
                countSteps++;
                countIns++;
//                tripleAValue = stringHashMap.get(destination).split(",");
                System.out.println(destination + " " + countSteps);
            }
            System.out.println(countSteps);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static String checkForInstruction(String instruction, Integer count) {
        if(count == instruction.length()) count =0;
        System.out.println(instruction.charAt(count) + count.toString());
        return instruction.charAt(count) + count.toString();
    }
}