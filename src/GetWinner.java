
public class GetWinner {
    public static int getWinner(int[] arr, int k) {
        int cur_max = Math.max(arr[0], arr[1]);
        if (k == 1) {
            return cur_max;
        }
        int index = 1;
        int max = cur_max;
        for (int i = 2; i < arr.length; i++) {
            int cur = arr[i];
            if (cur < cur_max) {
                index++;
                if (index >= k) {
                    return cur_max;
                }
            } else {
                cur_max = cur;
                index = 1;

            }
            max = Math.max(max, cur_max);
        }
        return max;
    }

    public static void main(String[] args) {
        getWinner(new int[]{2, 1, 3, 5, 4, 6, 7}, 2);
    }
}

