package code.advent2021.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Day3Part1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int gammaRate = 0;
        int epsilonRate = 0;

        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        try {
            while((line = reader.readLine()) != null) {
                String[] dataArray = line.split("");
                ArrayList<Integer> list = new ArrayList<>();
                for (String val : dataArray) {
                    list.add(Integer.valueOf(val));
                }
                numbers.add(list);
            }

            for (int i = 0; i < 12; i++) {
                int numberOfOnes = 0;
                for (ArrayList<Integer> number : numbers) {
                    if (number.get(i) == 0) {
                        numberOfOnes--;
                    } else {
                        numberOfOnes++;
                    }
                }

                if (numberOfOnes > 0) {
                    answer.add(1);
                } else {
                    answer.add(0);
                }
            }

            System.out.println(answer);
            gammaRate = binaryArrayListToInt(answer);
            epsilonRate = binaryArrayListToIntInverted(answer);

            System.out.println("final answer = " + epsilonRate * gammaRate);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int binaryArrayListToInt(ArrayList<Integer> answer) {
        int val = 0;
        int x = 0;
        for (int i = answer.size()-1; i >= 0; i--) {
            if (answer.get(i) == 1) {
                val += Math.pow(2, x);
            }
            x++;
        }

        return val;
    }

    public static int binaryArrayListToIntInverted(ArrayList<Integer> answer) {
        int val = 0;
        int x = 0;
        for (int i = answer.size()-1; i >= 0; i--) {
            if (answer.get(i) == 0) {
                val += Math.pow(2, x);
            }
            x++;
        }

        return val;
    }

}
