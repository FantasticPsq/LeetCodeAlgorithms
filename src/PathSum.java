import java.util.ArrayList;
import java.util.List;

public class PathSum {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int curSum = 0;
        dfs(root, sum, ans, list, curSum);
        return ans;
    }

    public void dfs(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list, int curSum) {
        if (root == null) {
            if (curSum == sum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(root.val);
        curSum += root.val;
        if (root.left == null && root.right == null) {
            if (curSum == sum) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        dfs(root.left, sum, ans, list, curSum);
        dfs(root.right, sum, ans, list, curSum);
        list.remove(list.size() - 1);
    }
}
