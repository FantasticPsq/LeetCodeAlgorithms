import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class FirstMissingPositive {
    //    public int firstMissingPositive(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] <= 0 || nums[i] > nums.length) {
//                nums[i] = nums.length + 1;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//
//            if (Math.abs(nums[i]) >= 1 && Math.abs(nums[i]) <= nums.length) {
//                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
//            }
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) {
//                return i + 1;
//            }
//        }
//        return nums.length + 1;
//    }
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
//        for (int i = 0; i < n; ++i) {
//            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
//                int temp = nums[nums[i] - 1];
//                nums[nums[i] - 1] = nums[i];
//                nums[i] = temp;
//            }
//        }
        new HashMap<>(10,0.75f).put("1","h");
        new ConcurrentHashMap<>().put("1",1);
        int j = 0;
        while (j < n) {
            if (nums[j] > 0 && nums[j] <= n) {
                if (nums[nums[j] - 1] == nums[j]) {
                    j++;
                    continue;
                }
                int temp = nums[nums[j] - 1];
                nums[nums[j] - 1] = nums[j];
                nums[j] = temp;
            }else {
                j++;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstMissingPositive().firstMissingPositive(new int[]{3, 4, -1, 1}));
    }
}
