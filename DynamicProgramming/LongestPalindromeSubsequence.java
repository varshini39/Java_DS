package DynamicProgramming;

public class LongestPalindromeSubsequence {

    //DP solution
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //Recursive solution
    public static String longestPalindromeRecursive(String s) {
        if(isPalindrome(s)) {
            return s;
        } else {
            String s1 = longestPalindrome(s.substring(1));
            String s2 = longestPalindrome(s.substring(0, s.length()-1));
            if(s1.length() > s2.length()) {
                return s1;
            }
            else {
                return s2;
            }
        }
    }

    public static boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder(s);
        if (s.equals(str.reverse().toString())) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "babad";
        String s2 = "abbcccbbbcaaccbababcbcabca";

        System.out.println(longestPalindromeRecursive(s1));
        System.out.println(longestPalindrome(s2));        
    }
}