import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{10,1,2,7,6,1,5},8));
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        HashSet<List<Integer>> combination = new HashSet<>();

    }

    public static void dfs(int[] candidates, int target, List<List<Integer>> combination, int index, List<Integer> list, boolean[] selected) {
        if (index == candidates.length) {
            return;
        }
        if (target == 0) {
            combination.add(list);
            return;
        }
        dfs(candidates,target,combination,index+1,list,selected);
        if(selected[index]){
            if(target-candidates[index]>=0){
                list.add(candidates[index]);
                selected[index]=true;
                dfs(candidates,target-candidates[index],combination,index,list,selected);
                list.remove(list.size()-1);
                selected[list.size()-1]=false;
            }
        }
    }
}
