package code.advent2021.day3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Day3Part2 {
    public enum Rating {
        OXYGEN,
        CO2
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        try {
            // Convert input stream data into ArrayList data structure.
            while((line = reader.readLine()) != null) {
                String[] dataArray = line.split("");
                ArrayList<Integer> list = new ArrayList<>();
                for (String val : dataArray) list.add(Integer.valueOf(val));
                numbers.add(list);
            }

            // Find rating then convert that binary ArrayList to int.
            int oxygenRating = binaryArrayListToInt(findRating(Rating.OXYGEN, numbers));
            int co2Rating = binaryArrayListToInt(findRating(Rating.CO2, numbers));

            // Output answer to console.
            System.out.println("Oxygen rating: " + oxygenRating);
            System.out.println("Oxygen rating: " + co2Rating);
            System.out.println("Product: " + oxygenRating * co2Rating);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int binaryArrayListToInt(ArrayList<Integer> binary) {
        int val = 0;
        Collections.reverse(binary);
        for (int i = 0; i < binary.size(); i++) {
            if (binary.get(i) == 1) {
                val += Math.pow(2, i);
            }
        }

        return val;
    }

    public static ArrayList<Integer> findRating(Rating rating, ArrayList<ArrayList<Integer>> numbersOriginal) {
        // Create copy to prevent mutating original ArrayList.
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<>(numbersOriginal);

        for (int i = 0; i < numbers.get(0).size(); i++) {
            int numberOfOnes = 0;
            for (ArrayList<Integer> number : numbers) {
                if (number.get(i) == 0) numberOfOnes--;
                else numberOfOnes++;
            }

            ArrayList<ArrayList<Integer>> temp = new ArrayList<>();
            switch (rating) {
                case OXYGEN -> {
                    if (numberOfOnes >= 0) {
                        for (ArrayList<Integer> number : numbers) {
                            if (number.get(i) == 1) temp.add(number);
                        }
                    } else {
                        for (ArrayList<Integer> number : numbers) {
                            if (number.get(i) == 0) temp.add(number);
                        }
                    }
                }
                case CO2 -> {
                    if (numberOfOnes < 0) {
                        for (ArrayList<Integer> number : numbers) {
                            if (number.get(i) == 1) temp.add(number);
                        }
                    } else {
                        for (ArrayList<Integer> number : numbers) {
                            if (number.get(i) == 0) temp.add(number);
                        }
                    }
                }
            }

            numbers.clear();
            numbers.addAll(temp);

            // If we are left with 1 inner ArrayList break out.
            if (numbers.size() == 1) break;
        }

        return numbers.get(0);
    }

}
