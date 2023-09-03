import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinExtraCharsInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leetscode";
		String[] dictionary = {"leet","code","leetcode"};
		System.out.println(minExtraChar(s, dictionary));
	}
	public static int minExtraChar(String s, String[] dictionary) {
        int maxVal = s.length() + 1;
        int[] dp = new int[s.length() + 1];
//        Arrays.fill(dp, maxVal);
        dp[0] = 0;

        Set<String> dictionarySet = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 1; i <= s.length(); ++i) {
            dp[i] = dp[i - 1] + 1;
            for (int l = 1; l <= i; ++l) {
                if (dictionarySet.contains(s.substring(i - l, i))) {
                    dp[i] = Math.min(dp[i], dp[i - l]);
                }
            }
        }
        return dp[s.length()];
    }
}
