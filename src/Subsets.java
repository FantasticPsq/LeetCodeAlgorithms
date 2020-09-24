import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, list, nums, 0);
        return ans;
    }

    public void dfs(List<List<Integer>> ans, List<Integer> list, int[] nums, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(ans, list, nums, index + 1);
        list.remove(list.size() - 1);
        dfs(ans, list, nums, index + 1);
    }
}
