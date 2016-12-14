package bj9372;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by dasom on 2016-12-14.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("day11\\src\\bj9372\\input_data.txt")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int test_case = Integer.parseInt(st.nextToken());

        // 직사각형이 그려진 영역은 1로 표시한다.
        for (int i = 0; i < test_case; i++) {
            st = new StringTokenizer(br.readLine());
            int nara = Integer.parseInt(st.nextToken());
            int airplain = Integer.parseInt(st.nextToken());

            for(int j=0; j<airplain; j++){
                st = new StringTokenizer(br.readLine());
            }
            System.out.println(nara-1);
        }
    }
}
