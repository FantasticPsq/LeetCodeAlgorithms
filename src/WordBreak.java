import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class WordBreak {
    public List<String> wordBreak(String s, List<String> wordDict) {
        boolean[] can = new boolean[s.length()+1];
        Arrays.fill(can,false);
        can[0]=true;
        LinkedList<String>[] dp = new LinkedList[s.length() + 1];
        LinkedList<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && wordDict.contains(s.substring(j, i))) {
                    can[i] = true;
                }
            }
        }
        if(!can[s.length()]){
            return new ArrayList<>();
        }
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            if(!can[i]){
                continue;
            }

            for (int j = 0; j < i; j++) {
                if(!can[j]){
                    continue;
                }
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l:dp[j]) {
                        list.add(l+(l.equals("")?"":" ")+s.substring(j,i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }
}
