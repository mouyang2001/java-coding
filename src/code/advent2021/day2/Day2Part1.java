package code.advent2021.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Day2Part1 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int horizontal = 0;
        int depth = 0;

        try {
            while((line = reader.readLine()) != null) {
                String direction = line.split(" ")[0];

                // Tip: primitive int data type use parsetInt(), for Integer object type use valueOf();
                int magnitude = Integer.parseInt(line.split(" ")[1]);
                switch (direction) {
                    case "forward" -> horizontal += magnitude;
                    case "down" -> depth += magnitude;
                    case "up" -> depth -= magnitude;
                }
            }

            System.out.println("Horizontal: " + horizontal);
            System.out.println("Depth: " + depth);
            System.out.println("Answer " + horizontal * depth);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
