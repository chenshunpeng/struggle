import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N=scan.nextInt();
        int []nums = new int[N];
        int sum = 0;
        for(int i =0;i<N;i++){
            nums[i] = scan.nextInt();
            sum +=nums[i];
        }
        boolean [][]dp = new boolean[N][sum+1];
        dp[0][nums[0]] = true;
        for(int i = 1;i<N;i++){
            dp[i][nums[i]]=true;
            for(int j=1;j<=sum;j++) {
                dp[i][j]=dp[i-1][j]|dp[i][j];
                if(dp[i-1][j]){
                    dp[i][j+nums[i]] = true;
                    if(j-nums[i]!=0) {
                        dp[i][Math.abs(j - nums[i])] = true;
                    }
                }
            }
        }
        int count=0;
        for(int i=0;i<=sum;i++){
            if(dp[N-1][i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
