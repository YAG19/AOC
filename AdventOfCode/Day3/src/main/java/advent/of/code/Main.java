package advent.of.code;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("C:/Users/yagne/Documents/adventOfCode.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            List<String[]> stringList = new ArrayList<>();
            while (line != null) {
//                System.out.println(line);
                String[] arrayString = line.split("");
                stringList.add(arrayString);
                line = br.readLine();

            }

            for (int x = 0; x < stringList.size(); x++) {
                for (int y = 0; y < stringList.get(x).length - 1; y++) {
                    String digit = stringList.get(x)[y];
                    boolean checkToAdd = true;
                    if (Character.isDigit(digit.charAt(0))) {
                        StringBuilder stringNum = new StringBuilder(digit);
                        y = y + 1;
                        while (Character.isDigit(stringList.get(x)[y].charAt(0))) {
                            stringNum.append(stringList.get(x)[y]);
                            if (checkToAdd && !checkForAdjacentSymbols(stringList, x, y)) {
                                checkToAdd = false;
                            }
                            y = y + 1;
                            if (!checkToAdd) {
                                System.out.println("Value to Add " + stringNum);
                            }
                        }
                        System.out.println("Digits: " + stringNum);

                    }
                }

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private static boolean checkForNextDigit(List<String[]> stringList, String nextDigit, int x, int y) {
        boolean check = false;
        if (x == 0) {
            String nextValue = stringList.get(x + 1)[y];
            check = nextValue.equals(".");
        } else {
            String bottomUpValue = stringList.get(x + 1)[y + 1];
            check = bottomUpValue.equals(".");
        }
        return check;
    }

    private static boolean checkForAdjacentSymbols(List<String[]> stringList, int x, int y) {
        boolean check = true;

        if (x == 0 && y == 0) {
            check = checkRight(x, y, stringList) || checkBottom(x, y, stringList) || checkBottomDiagnoly(x, y, stringList);
        }
        if (x > 0 && x < stringList.size() - 1 && y < stringList.get(x).length - 1) {
            check = checkUp(x, y, stringList) || checkBottom(x, y, stringList) || checkUpDiagonal(x, y, stringList) || checkBottomDiagnoly(x, y, stringList);
        }
        if (x == stringList.size() - 1 && y < stringList.get(x).length - 1) {
            check = checkUp(x, y - 1, stringList) || checkUpDiagonal(x + 1, y - 1, stringList);
        }
        return check;
    }

    private static boolean checkBottomDiagnoly(int x, int y, List<String[]> stringList) {
        if (Character.isDigit(stringList.get(x + 1)[y + 1].charAt(0))) {
            return true;
        }
        String value = stringList.get(x + 1)[y + 1];
        return value.equals(".");
    }

    private static boolean checkRight(int x, int y, List<String[]> stringList) {
        if (Character.isDigit(stringList.get(x)[y + 1].charAt(0))) {
            return true;
        }
        String value = stringList.get(x)[y + 1];
        return value.equals(".");
    }

    private static boolean checkUpDiagonal(int x, int y, List<String[]> stringList) {
        if (Character.isDigit(stringList.get(x - 1)[y + 1].charAt(0))) {
            return true;
        }
        String value = stringList.get(x - 1)[y + 1];
        return value.equals(".");
    }

    private static boolean checkUp(int x, int y, List<String[]> stringList) {
        if (Character.isDigit(stringList.get(x - 1)[y].charAt(0))) {
            return true;
        }
         String value = stringList.get(x - 1)[y];
        return value.equals(".");
    }

    private static boolean checkBottom(int x, int y, List<String[]> stringList) {
        if (Character.isDigit(stringList.get(x + 1)[y].charAt(0))) {
            return true;
        }
        String value = stringList.get(x + 1)[y];
        return value.equals(".");
    }
}