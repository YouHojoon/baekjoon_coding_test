import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m,n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.valueOf(st.nextToken());
        n = Integer.valueOf(st.nextToken());
        int[][] spaces = new int[m][n];

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            Set<Integer> set = new TreeSet<>();

            for (int j = 0; j < n; j++){
                int s = Integer.valueOf(st.nextToken());
                set.add(s);
                spaces[i][j] = s;
            }

            int[] key = new int[set.size()];
            Iterator<Integer> it = set.iterator();
            int cnt = 0;

            while (it.hasNext()){
                key[cnt++] = it.next();
            }

            for(int j = 0; j < n; j++)
                spaces[i][j] = Arrays.binarySearch(key, spaces[i][j]);
        }


        int ans = 0;
        for (int i = 0 ; i < m; i++){
            for(int j = i+1; j < m; j++){
                if (Arrays.equals(spaces[i], spaces[j]))
                    ans++;
            }
        }

        System.out.print(ans);
    }
}

