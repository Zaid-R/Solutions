//Using Prim's algorithm

import java.io.*;
import java.util.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok;
        int t = Integer.parseInt(reader.readLine());
        point[] node;
        PriorityQueue<edge> q;
        ArrayList<edge>[] graph;
        double[] cost;
        long total = 0;
        while (t-- > 0) {
            tok = new StringTokenizer(reader.readLine());
            int m = Integer.parseInt(tok.nextToken());
            int n = Integer.parseInt(tok.nextToken());
            node = new point[n];
            int i = 0;
            //getting the nodes
            while (i < n) {
                tok = new StringTokenizer(reader.readLine());
                node[i] = new point(Integer.parseInt(tok.nextToken()), Integer.parseInt(tok.nextToken()));
                i++;
            }
            graph = new ArrayList[n];
            i = -1;
            while (i++ < n - 1) {
                graph[i] = new ArrayList<>();
            }
            total += n * (n - 1) / 2;
            //getting the graph
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    double c = Math.sqrt(Math.pow(node[j].x - node[k].x, 2) + Math.pow(node[j].y - node[k].y, 2));
                    graph[j].add(new edge(k, c));
                    graph[k].add(new edge(j, c));
                }
            }

            cost = new double[n];
            Arrays.fill(cost, Long.MAX_VALUE + 0.0);
            cost[0] = 0;
            boolean[] vis = new boolean[n];
            q = new PriorityQueue<>();
            q.add(new edge(0, 0));
            int mst = 0;
            while (mst < n - 1) {
                edge temp = q.poll();
                vis[temp.n] = true;
                if (cost[temp.n] > temp.cost) {
                    cost[temp.n] = temp.cost;
                    mst++;
                }
                for (edge e : graph[temp.n]) {
                    if (!vis[e.n]) {
                        q.add(e);
                    }
                }
            }
            Arrays.sort(cost);
            writer.write(String.format("%.2f", cost[n - m]) + "\n");
        }
        writer.flush();
    }

    static class point {

        int x, y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    static class edge implements Comparable<edge> {

        int n;
        double cost;

        public edge(int n, double cost) {
            this.n = n;
            this.cost = cost;
        }

        @Override
        public int compareTo(edge t) {
            return Double.compare(this.cost, t.cost);
        }
    }
}
