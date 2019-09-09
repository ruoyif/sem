import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

class Node {
    int start;
    int end;
    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
class NodeComparetor implements Comparator<Object> {
    public int compare(Object o1, Object o2) {
        Node n1 = (Node) o1;
        Node n2 = (Node) o2;
        if (n1.start != n2.start)
            return n1.start - n2.start;
        return n1.end - n2.end;
    }
}

public class LifeGuards {

    public static List<Node> guards;
    public static int n;
    public static int cal(int upper, int index) {
        int end = guards.get(index).end;
        int start = guards.get(index).start;
        if (end <= upper)
            return 0;
        if (start > upper)
            return end-start;
        return end-upper;
    }
    public static int maxcoverage() {
        int[][] dp = new int[n+1][2];
        int[] upper = new int[n+1];
        Collections.sort(guards, new NodeComparetor());
        int n = guards.size();
        for (int i = 0; i < n; i++) {
            if (i < n-1) {
                dp[i+1][0] = dp[i][0] + cal(upper[i],i);
                upper[i+1] = Math.max(upper[i], guards.get(i).end);
            }
            if (i > 0) {
                dp[i+1][1] = Math.max(dp[i][1] + cal(upper[i], i), dp[i-1][0] + cal(upper[i-1],i));

            }
        }

        return dp[guards.size()][1];


    }

    public static void main(String[] args) throws Exception {

        BufferedReader stdin = new BufferedReader(new FileReader("/Users/fan/Desktop/leet/src/10.in"));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        n = Integer.parseInt(tok.nextToken());
        guards = new ArrayList<>();
        for (int i=0; i<n; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int s = Integer.parseInt(tok.nextToken());
            int e = Integer.parseInt(tok.nextToken());
            guards.add(new Node(s,e));
        }
        int res = maxcoverage();
        PrintWriter out = new PrintWriter(new FileWriter("10.out"));
        out.println(res);
        out.close();
        stdin.close();

    }

}
