import java.io.Serializable;
import java.util.*;

public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, ans, list, 0);
        return ans;
    }

    public void dfs(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        if (index == nums.length) {
            if(!ans.contains(list)) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        list.add(nums[index]);
        dfs(nums, ans, list, index + 1);
        list.remove(list.size() - 1);
        dfs(nums, ans, list, index+1);
    }

    public static void main(String[] args) {
        System.out.println(new SubsetsWithDup().subsetsWithDup(new int[]{4,4,4,1,4}));
    }
}
