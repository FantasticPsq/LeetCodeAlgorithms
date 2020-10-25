import java.util.ArrayList;
import java.util.List;

public class CanPartition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        if (sum % 2 != 0 || sum / 2 < max) {
            return false;
        }
        return dfs(0, sum, 0, nums);
    }

    public boolean dfs(int sum1, double sum, int index, int[] nums) {
        if (sum1 == sum / 2) {
            return true;
        }
        if (index == nums.length) {
            return false;
        }
        sum1 += nums[index];
        if (dfs(sum1, sum, index + 1, nums)) {
            return true;
        } else {
            sum1 -= nums[index];
            return dfs(sum1, sum, index + 1, nums);
        }

    }

    public static void main(String[] args) {
        System.out.println(new CanPartition().canPartition(new int[]{1, 2, 3, 5}));
    }
}
