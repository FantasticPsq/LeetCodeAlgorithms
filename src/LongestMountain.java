class LongestMountain {
    public int longestMountain(int[] A) {
        int ans = 0;
        int N = A.length;
        // left[i]表示A[i]能向左拓展多少个
        int[] left = new int[N];
        left[0] = 0;
        // right[i] 表示 A[i]能向右拓展多少个
        int[] right = new int[N];
        right[N - 1] = 0;

        for (int i = 1; i <= N - 1; i++) {
            left[i] = (A[i] > A[i - 1] ? left[i - 1] + 1 : 0);
        }
        for (int i = N - 2; i >= 0; i--) {
            right[i] = (A[i] > A[i + 1] ? right[i + 1] + 1 : 0);
        }
        for (int i = 0; i < N; i++) {
            ans = Math.max(ans, left[i] + right[i] +1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestMountain().longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}