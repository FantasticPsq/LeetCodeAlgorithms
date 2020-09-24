import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class PermuteUnique {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] selected = new boolean[nums.length+1];
        int idx = 0;
        backtrace(idx,nums,ans,list,selected);
        return ans;
    }
    public void backtrace(int idx,int[] nums,List<List<Integer>> ans,List<Integer> list,boolean[] selected){
        if(idx==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(selected[i]||(i>0&&nums[i]==nums[i-1]&&!selected[i-1])){
                continue;
            }
            list.add(nums[i]);
            selected[i] = true;
            backtrace(idx+1,nums,ans,list,selected);
            selected[i] = false;
            list.remove(idx);
        }
        new ConcurrentHashMap<>().put("1",1);
    }

    public static void main(String[] args) {
        System.out.println(new PermuteUnique().permuteUnique(new int[]{1,1,2}));
    }
}

