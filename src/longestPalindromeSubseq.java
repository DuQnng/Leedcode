
public class longestPalindromeSubseq {
    public static String longestPalindromeSubseq(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;
        // dp[i][j] 表示 s[i..j] 是否是回文串
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++)
        {
            dp[i][i]=true;
        }
        char[] cA=s.toCharArray();
        for(int L=2;L<=n;L++)
        {
            for(int i=0;i<n;i++){
                int j=i+L-1;
                if(j>=n)
                {
                    break;
                }
                if(cA[i]!=cA[j])
                {
                    dp[i][j]=false;
                }else {
                    if(j-i<=2)
                    {
                        dp[i][j]=true;
                    }else
                    {
                        dp[i][j]=dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen)
                {
                    maxLen=j-i+1;
                    begin=i;
                }
            }
        }

        return s.substring(begin, begin + maxLen);
    }

    public static void main(String[] args) {
        String s = "DABBADF";
        String result = longestPalindromeSubseq(s);
        System.out.println("最长回文子序列为: " + result);
    }
}