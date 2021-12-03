package code.advent2021.day2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Day2Part2 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;

        int horizontal, depth, aim;
        horizontal = depth = aim = 0;

        try {
            while((line = reader.readLine()) != null) {
                String direction = line.split(" ")[0];

                // Tip: primitive int data type use parsetInt(), for Integer object type use valueOf();
                int magnitude = Integer.parseInt(line.split(" ")[1]);
                switch (direction) {
                    case "forward" -> {
                        horizontal += magnitude;
                        depth += aim * magnitude;
                    }
                    case "down" -> aim += magnitude;
                    case "up" -> aim -= magnitude;
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
