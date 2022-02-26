import java.io.*;
import java.util.*;

public class Highways_UVa {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer tok;
        int t = Integer.parseInt(reader.readLine());
        while (t > 0) {
            reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            unionFind set = new unionFind(n);
            point[] town = new point[n];
            int i = 0;
            //getting the towns
            while (i < n) {
                tok = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tok.nextToken()), y = Integer.parseInt(tok.nextToken());
                town[i] = new point(x, y, i);
                i++;
            }
            PriorityQueue<edge> q = new PriorityQueue<>();
            //getting connected graph
            for (i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    point x = town[i], y = town[j];
                    q.add(new edge(x, y));
                }
            }
            int m = Integer.parseInt(reader.readLine());
            //connect the town which he ask to connect
            while (m > 0) {
                tok = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tok.nextToken()) - 1, y = Integer.parseInt(tok.nextToken()) - 1;
                set.union(x, y);
                m--;
            }
            Queue<edge> mst = new ArrayDeque<>();
            while (set.sets > 1) {
                edge e = q.poll();
                if (set.isSame(e.a.ind, e.b.ind)) {
                    continue;
                }
                set.union(e.a.ind, e.b.ind);
                mst.add(e);
            }
            if (mst.size() == 0) {
                writer.write("No new highways need");
                writer.newLine();
            } else {
                i = 0;
                while (!mst.isEmpty()) {
                    edge e = mst.poll();
                    writer.write((e.a.ind + 1) + " " + (e.b.ind + 1));
                    writer.newLine();
                }
            }
            if (t > 1) {
                writer.newLine();
            }
            t--;
        }
        writer.flush();
    }

    static class edge implements Comparable<edge> {

        double cost;
        point a, b;

        public edge(point a, point b) {
            this.a = a;
            this.b = b;

            cost = Math.sqrt(Math.pow(a.i - b.i, 2) + Math.pow(a.j - b.j, 2));
        }

        @Override
        public int compareTo(edge edge) {
            return Double.compare(this.cost, edge.cost);
        }
    }

    static class point {

        int i, j, ind;

        public point(int i, int j, int ind) {
            this.i = i;
            this.j = j;
            this.ind = ind;
        }
    }

    static class unionFind {

        int[] rank, p;
        int sets;

        public unionFind(int n) {
            this.sets = n;
            rank = new int[n];
            p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = i;
                rank[i] = 1;
            }
        }

        int find(int x) {
            if (p[x] == x) {
                return x;
            }
            return p[x] = find(p[x]);
        }

        void union(int x, int y) {
            int xp = find(x), yp = find(y);
            if (xp == yp) {
                return;
            }
            if (rank[yp] > rank[xp]) {
                p[xp] = p[yp];
            } else {
                p[yp] = p[xp];
            }
            if (rank[xp] == rank[yp]) {
                rank[xp]++;
            }
            sets--;
        }

        boolean isSame(int x, int y) {
            return find(x) == find(y);
        }
    }
}
