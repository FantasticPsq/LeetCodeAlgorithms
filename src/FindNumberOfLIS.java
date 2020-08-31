public class FindNumberOfLIS {
    public static int findNumberOfLIS(int[] nums){
        int N = nums.length;
        int[] lengths = new int[N];
        int[] counts = new int[N];

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < j; i++) {
                if(nums[i]<nums[j]){
                    if(lengths[i]>=lengths[j]){
                        lengths[j] = lengths[i]+1;
                        counts[j] = counts[i];
                    }else if(lengths[j]==lengths[i]+1){
                        counts[j] += counts[i];
                    }
                }
            }
        }
        int longest = 0, ans = 0;
        for (int i = 0; i < N; i++) {
            longest = Math.max(longest,lengths[i]);
        }
        for (int i = 0; i < N; i++) {
            if(longest==lengths[i]){
                ans+=counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2};
        System.out.println(findNumberOfLIS(nums));
    }
}
