package bj1325;

import java.io.*;
import java.util.*;

/**
 * Created by dasom on 2016-12-17.
 */
public class Main {
    public static int N, M;
    public static ArrayList<Integer> connectionMap[];
    public static boolean[] visited;
    public static int tempCounter;
    public static int[] maxValues;
    public static int max = 0;
    public static int index = 0;

    public static void main(String[] args) throws IOException {
        initValues();

        for (int startComputer = 0; startComputer < N; startComputer++) {
            BFS(startComputer);
        }

        for (int i = 0; i < index; i++) {
            System.out.print((maxValues[i] + 1) + " ");
        }
    }

    public static void BFS(int startComputer) {
        Queue<Integer> q = new LinkedList<>();

        tempCounter = 0;
        visited = new boolean[N];

        q.offer(startComputer);
        visited[startComputer] = true;
        tempCounter++;

        while (!q.isEmpty()) {
            int curComputer = q.poll();
            if (connectionMap[curComputer] != null) {
                for (int i = 0; i < connectionMap[curComputer].size(); i++) {
                    int adjComputer = connectionMap[curComputer].get(i);
                    if (!visited[adjComputer]) {
                        q.offer(adjComputer);
                        visited[adjComputer] = true;
                        tempCounter++;
                    }
                }
            }
        }

        if (tempCounter > max) {
            index = 0;
            max = tempCounter;
            maxValues[index++] = startComputer;
        } else if (tempCounter == max) {
            maxValues[index++] = startComputer;
        }
    }

    public static void initValues() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("day11\\src\\bj1325\\input_data.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        if (N > 10000 || M > 100000) return;
        connectionMap = new ArrayList[N];
        visited = new boolean[N];
        maxValues = new int[N];

        for (int numOfN = 0; numOfN < M; numOfN++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            if (connectionMap[end] == null) {
                ArrayList<Integer> computers = new ArrayList<>();
                computers.add(start);
                connectionMap[end] = computers;
            } else {
                connectionMap[end].add(start);
            }
        }

        br.close();
    }
}
