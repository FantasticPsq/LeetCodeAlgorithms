import java.util.Stack;

public class LongestValidParentheses {
    public int minAddToMakeValid(String S) {
        if (S.length() == 0) {
            return 0;
        }
        int need = 0;
        int ans = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                need++;
            } else {
                need--;
                if (need == -1) {
                    need = 0;
                    ans++;
                }
            }
        }
        return ans+need;
    }
}
