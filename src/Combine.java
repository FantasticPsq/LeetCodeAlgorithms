import java.util.ArrayList;
import java.util.List;

public class Combine {
    List<List<Integer>> combination = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, n, k);
        return combination;
    }

    public void dfs(int cur, int n, int k) {
        if (k-(n-cur+1)>temp.size()) {
            return;
        }
        if (temp.size() == k) {
            combination.add(new ArrayList<>(temp));
            return;
        }
        temp.add(cur);
        dfs(cur + 1, n, k);
        temp.remove(temp.size() - 1);
        dfs(cur + 1, n, k);
    }
}
