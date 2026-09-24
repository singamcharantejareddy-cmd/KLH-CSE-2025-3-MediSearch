import java.util.*;

public class EdmondsKarp {

    private int[][] capacity;
    private int[][] flow;
    private int numberOfNodes;

    public EdmondsKarp(int numberOfNodes) {

        this.numberOfNodes = numberOfNodes;

        capacity = new int[numberOfNodes][numberOfNodes];

        flow = new int[numberOfNodes][numberOfNodes];
    }

    // Add an edge to the network
    public void addEdge(int from, int to, int capacityValue) {

        capacity[from][to] = capacityValue;
    }

    // Breadth First Search to find an augmenting path
    private boolean bfs(
            int source,
            int sink,
            int[] parent) {

        boolean[] visited =
                new boolean[numberOfNodes];

        Queue<Integer> queue =
                new LinkedList<>();

        queue.add(source);

        visited[source] = true;

        parent[source] = -1;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int next = 0;
                 next < numberOfNodes;
                 next++) {

                // Remaining capacity
                int residualCapacity =
                        capacity[current][next]
                                - flow[current][next];

                if (!visited[next]
                        && residualCapacity > 0) {

                    parent[next] = current;

                    visited[next] = true;

                    queue.add(next);

                    if (next == sink) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    // Edmonds-Karp Maximum Flow
    public int maxFlow(
            int source,
            int sink) {

        int totalFlow = 0;

        int[] parent =
                new int[numberOfNodes];

        while (bfs(
                source,
                sink,
                parent)) {

            int pathFlow =
                    Integer.MAX_VALUE;

            // Find minimum capacity in path
            int current = sink;

            while (current != source) {

                int previous =
                        parent[current];

                int residualCapacity =
                        capacity[previous][current]
                                - flow[previous][current];

                pathFlow =
                        Math.min(
                                pathFlow,
                                residualCapacity);

                current = previous;
            }

            // Update flow
            current = sink;

            while (current != source) {

                int previous =
                        parent[current];

                flow[previous][current]
                        += pathFlow;

                flow[current][previous]
                        -= pathFlow;

                current = previous;
            }

            totalFlow += pathFlow;
        }

        return totalFlow;
    }
}