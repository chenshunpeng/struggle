import java.io.*;

public class Main {
    static StreamTokenizer streamTokenizer = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    static PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    static int in() throws IOException {
        streamTokenizer.nextToken();
        return (int) streamTokenizer.nval;
    }

    public static void main(String[] args) throws IOException {
        int n = in();
        int m = in();
        int[] stack = new int[m];
        int cnt = 0;
        //维护栈
        while (m-- > 0) {
            int opt = in();
            int mid = in();
            if (opt == 0) {
                //如果当前操作与之前的最后一次操作相同，取mid大的留下
                if (cnt % 2 != opt) {
                    if (cnt - 1 >= 0 && stack[cnt - 1] < mid) {
                        cnt--;
                    } else {
                        continue;
                    }
                }else{
                    if(cnt - 1 >= 0 && mid <= stack[cnt - 1]){
                        continue;
                    }
                }
                //如果当前操作大于前第2个操作，那么就可以合并成1个
                while (cnt - 2 >= 0 && stack[cnt - 2] <= mid) {
                    cnt -= 2;
                }
            } else {
                //如果当前操作与之前的最后一次操作相同，取mid小的留下
                if (cnt % 2 != opt) {
                    if (cnt - 1 >= 0 && stack[cnt - 1] > mid) {
                        cnt--;
                    } else {
                        continue;
                    }
                }else{
                    if(cnt - 1 >= 0 && mid >= stack[cnt - 1]){
                        continue;
                    }
                }
                //如果当前操作小于前第2个操作，那么就可以合并成1个
                while (cnt - 2 >= 0 && stack[cnt - 2] >= mid) {
                    cnt -= 2;
                }
            }
            stack[cnt++] = mid;
        }

        int l = 1;
        int r = n;
        int[] ans = new int[n + 1];
        //x从大到小，从外到内填数字
        int x = n;
        for (int i = 0; i < cnt; i++) {
            int mid = stack[i];
            if(i % 2 == 0){
                while(r > mid && r >= l){
                    ans[r--] = x--;
                }
            }else{
                while(l < mid && r >= l){
                    ans[l++] = x--;
                }
            }
            if(l > r){
                break;
            }
        }
        if(l <= r){
            if(cnt % 2 == 1){
                while(l <= r){
                    ans[l++] = x--;
                }
            }else{
                while(l <= r){
                    ans[r--] = x--;
                }
            }
        }
        out.print(ans[1]);
        for (int i = 2; i < ans.length; i++) {
            out.print(" " + ans[i]);
        }
        out.flush();
    }
}