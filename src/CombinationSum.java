import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combination = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(combination,list,0,target,candidates);
        return combination;
    }
    public void dfs(List<List<Integer>> combination,List<Integer> list,int start,int target,int[] candidates){
        if(start==candidates.length){
            return;
        }
        if(target==0){
            combination.add(list);
            return;
        }
        if(target-candidates[start]>=0){
            target -= candidates[start];
            //选择当前
            list.add(candidates[start]);
            dfs(combination,list,start+1,target,candidates);
            list.remove(list.size()-1);
        }
        //不选择当前
        dfs(combination,list,start+1,target,candidates);

    }
}
