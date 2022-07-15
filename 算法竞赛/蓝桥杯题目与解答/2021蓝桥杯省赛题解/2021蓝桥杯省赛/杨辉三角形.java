import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static String[] s;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        s = in.readLine().split(" ");
        N = Integer.valueOf(s[0]);

        for (int i = 16; i >=0; i--) {
            if(check(i))
                break;
        }
    }
    static long C(int a,int b) {
        long res = 1;
        for (int i = 1,j=b; i<=a; i++,j--) {
            res=res*j/i;
            if(res>N)
                return res;
        }
        return res;
    }
    static boolean check(int k) {
        long l = 2*k,r=N;
        while(l<r) {
            long mid = (l+r)>>1;
            if(C(k,(int) mid)>=N)
                r = mid;
            else
                l = mid+1;
        }
        if(C(k,(int) r)!=N||N<2*k)
            return false;
        else {
            System.out.println(r*(r+1)/2+k+1);
            return true;
        }
    }
}