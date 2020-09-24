import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWPI {
    public int longestWPI(int[] hours) {
        int[] new_hours = new int[hours.length];
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] > 8) {
                new_hours[i] = 1;
            } else {
                new_hours[i] = -1;
            }
        }
        // 求出前缀和数组
        List<Integer> preSum = new ArrayList<>();
        preSum.add(0);
        for (int i = 0; i < new_hours.length; i++) {
            preSum.add(preSum.get(i) + new_hours[i]);
        }
        System.out.println(preSum);
        List<Integer> indexArray = new ArrayList<>();
        for (int i = 0; i < preSum.size() - 1; i++) {
            if (indexArray.size() == 0 || preSum.get(indexArray.get(indexArray.size() - 1)) > preSum.get(i)) {
                indexArray.add(i);
            }
        }
        System.out.println(indexArray);
        int j = preSum.size() - 1;
        int i = indexArray.size() - 1;
        int max = 0;
        while (j>max) {
            while (i>=0&&preSum.get(indexArray.get(i)) < preSum.get(j)) {
                max = Math.max(max,j-indexArray.get(i));
                i--;
            }
            j--;
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new LongestWPI().longestWPI(new int[]{13,4,2,5,0,6,0,10,5,12,5}));
    }
}
