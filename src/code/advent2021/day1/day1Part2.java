package code.advent2021.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class day1Part2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        ArrayList<Integer> depths = new ArrayList<>();

        int count = 0;

        try {
            while ((line = reader.readLine()) != null) {
                depths.add(Integer.valueOf(line));
            }

            for (int i = 0; i < depths.size()-3; i++) {
                int window1 = depths.get(i) + depths.get(i+1) + depths.get(i+2);
                int window2 = depths.get(i+1) + depths.get(i+2) + depths.get(i+3);
                if (window1 < window2) count++;
            }

            System.out.println(count);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
