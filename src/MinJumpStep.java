public class MinJumpStep {
    public int jump(int[] nums) {
        int rightMost = 0;
        int end = 0;
        int len = nums.length;
        int steps = 0;
        for (int i = 0; i < len-1; i++) {
            rightMost = Math.max(rightMost,i+nums[i]);
            if(i==end){
                end = rightMost;
                steps++;
            }
        }
        return steps;
    }
}
