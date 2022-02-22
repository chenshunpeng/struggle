import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        n /= 1000;
        n %= 24 * 60 * 60;
        long h = n / 3600, s = n % 60, m;
        m = (n - h * 3600 - s) / 60;
        if (h >= 10) System.out.print(h);
        else System.out.print("0" + h);
        System.out.print(":");
        if (m >= 10) System.out.print(m);
        else System.out.print("0" + m);
        System.out.print(":");
        if (s >= 10) System.out.print(s);
        else System.out.print("0" + s);
    }
}