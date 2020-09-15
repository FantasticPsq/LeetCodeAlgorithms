public class CanJump {
    public boolean canJump(int[] nums) {

        int longest = 0;
        if(nums[0]==0&&nums.length!=1){
            return false;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]>=nums.length-1){
                return true;
            }
            if(nums[i]==0){
                continue;
            }
            if (i+nums[i] > longest) {
                longest = i+nums[i];
            }
        }
        return longest >= nums.length - 1;
    }
}
