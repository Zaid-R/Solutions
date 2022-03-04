//Using Prim's algorithm

import java.io.*;
import java.util.*;

public class MST_SPOJ {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tok = new StringTokenizer(reader.readLine());
        int nodes = Integer.parseInt(tok.nextToken());
        int edges = Integer.parseInt(tok.nextToken());
        boolean visited[] = new boolean[nodes];
        ArrayList<Node> []list = new ArrayList[nodes];
        for (int i=0;i<nodes;i++){
            list[i] = new ArrayList<Node>();
        }
        for (int i =0 ; i<edges;i++){
            tok = new StringTokenizer(reader.readLine());
            int node = Integer.parseInt(tok.nextToken())-1;
            int otherNode= Integer.parseInt(tok.nextToken())-1;
            int cost = Integer.parseInt(tok.nextToken());
            list[otherNode].add(new Node(node,cost));
            list[node].add(new Node(otherNode,cost));
        }
        long []costArray = new long[nodes];
        Arrays.fill(costArray,Long.MAX_VALUE);
        costArray[0]=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0,0));
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(visited[temp.node])
                continue;
            visited[temp.node]=true;
            if(temp.cost<costArray[temp.node])  {
                costArray[temp.node]=temp.cost;
            }
            for (Node n:list [temp.node]) {
                if(!visited[n.node]){
                    pq.add(new Node(n.node,n.cost));
                }
            }
        }
        long finalCost = 0;
        for (int i=0;i<costArray.length;i++){
            finalCost+=costArray[i];
        }
        writer.write(finalCost+"");
        writer.newLine();
        writer.flush();
    }
    static class Node implements Comparable<Node>{
        int node;
        long cost;

        public Node(int node, long cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return Long.compare(this.cost,node.cost);
        }
    }
}
