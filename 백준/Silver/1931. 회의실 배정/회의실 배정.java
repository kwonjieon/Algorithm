import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<meeting> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort(null);

        int count = 1;
        meeting x = list.get(0);
        for (int i=1;i< list.size();i++) {
            if (x.end <= list.get(i).start) {
                count++;
                x = list.get(i);
            }
        }
        System.out.println(count);
    }

    static class meeting implements Comparable<meeting> {
        int start;
        int end;
        meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(meeting o) {
            if(this.end==o.end)
                return this.start-o.start;
            return this.end - o.end;
        }
    }
}