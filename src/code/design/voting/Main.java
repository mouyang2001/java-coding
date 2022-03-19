package code.design.voting;

import java.sql.Array;
import java.util.*;
import java.util.spi.CalendarNameProvider;

public class Main {
    public static void main(String[] args) {
        String[] names = new String[]{"Matthew", "Matthew", "John", "Alex"};
        int[] weightedVotes = new int[]{1, 1, 5, 4};

        System.out.println(mostVoted(names, weightedVotes));

        names = new String[]{"Matthew", "Matthew", "John", "John", "Alex"};
        weightedVotes = new int[]{1, 1, 2, 2, 1000};

        System.out.println(mostVoted(names, weightedVotes));
    }

    // count and see if tie in votes
    // count and see if tie in weights
    // if STILL ties then toss a coin.
    public static String mostVoted(String[] names, int[] weights) {
        if (names.length  != weights.length) return "Invalid";

        HashMap<String, Candidate> map = new HashMap<>();
        for (int i = 0; i < names.length; i++) {
            Candidate candidate;
            if (map.containsKey(names[i])) {
                candidate = map.get(names[i]);
                candidate.votes++;
                candidate.weight += weights[i];
            } else {
                candidate = new Candidate(names[i], 1, weights[i]);
            }

            map.put(names[i], candidate);
        }

        double maxRatio = 0.0;
        for (String key : map.keySet()) {
            Candidate candidate = map.get(key);
            double ratio = (double)candidate.weight/candidate.votes;
            maxRatio = Math.max(maxRatio, ratio);
        }

        for (String key : map.keySet()) {
            Candidate candidate = map.get(key);
            double ratio = (double)candidate.weight/candidate.votes;
            if (ratio == maxRatio) return key;
        }

        return "Not found";
    }

    public static class Candidate {
        public String name;
        public int weight;
        public int votes;

        public Candidate(String name, int vote, int weight) {
            this.name = name;
            this.votes = vote;
            this.weight = weight;
        }
    }

}
