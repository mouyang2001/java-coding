package code.design.conversion;

import java.sql.Array;
import java.util.*;

// m = 3.28 ft -> m,3.28,ft,

/**
 * m:
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("unit conversion");
        List<String> facts = new ArrayList<>();
        facts.add("m,3.28,ft");
        facts.add("ft,12,in");

        System.out.println(conversion(facts, "32,m,in"));
    }

    public static float conversion(List<String> facts, String query) {
        HashMap<String, List<Edge>> adj = convertToAdjacencyList(facts);

        String[] values = query.split(",");
        float magnitude = Float.parseFloat(values[0]);
        String source = values[1];
        String target = values[2];

        // BFS
        Queue<String> queue = new LinkedList<>();
        queue.offer(source);

        HashMap<String, Boolean> visited = new HashMap<>();
        HashMap<String, Float> distance = new HashMap<>();
        for (String node : adj.keySet()) {
            visited.put(node, false);
        }

        distance.put(source, magnitude);

        while (!queue.isEmpty()) {
            String currentUnit = queue.poll();
            visited.put(currentUnit, true);

            List<Edge> neighbours = adj.get(currentUnit);
            for (Edge edge : neighbours) {
                distance.put(edge.target, distance.get(edge.source) * edge.weight);
                if (edge.target.equals(target)) {
                    return distance.get(target);
                }

                if (!visited.get(edge.target)) {
                    queue.offer(edge.target);
                    visited.put(edge.target, true);
                }
            }
        }


        return 0.0f;
    }

    public static HashMap<String, List<Edge>> convertToAdjacencyList(List<String> facts) {
        HashMap<String, List<Edge>> adj = new HashMap<>();
        for (String fact : facts) {
            String[] values = fact.split(",");
            String from = values[0];
            float factor = Float.parseFloat(values[1]);
            String to = values[2];

            List<Edge> edges;

            // from to
            if (adj.containsKey(from)) {
                edges = adj.get(from);
            } else {
                edges = new LinkedList<>();
            }
            edges.add(new Edge(from, to, factor));
            adj.put(from, edges);

            // to from
            if (adj.containsKey(to)) {
                edges = adj.get(to);
            } else {
                edges = new LinkedList<>();
            }
            edges.add(new Edge(to, from, 1/factor));
            adj.put(to, edges);
        }
        return adj;
    }

    static class Edge {
        public float weight;
        public String source;
        public String target;

        public Edge(String source, String target, float weight) {
            this.source = source;
            this.target = target;
            this.weight = weight;
        }
    }
}


