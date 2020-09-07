import sun.management.snmp.jvminstr.JvmRTInputArgsEntryImpl;

import java.util.*;

public class TopKFrequent {
    //    public int[] topKFrequent(int[] nums, int k) {
//        Map<Integer, Integer> occurrence = new HashMap<>();
//        for (int num : nums) {
//            occurrence.put(num, occurrence.getOrDefault(num, 0) + 1);
//        }
//
//        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] m, int[] n) {
//                return m[1]-n[1];
//            }
//        });
//        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
//            int num = entry.getKey(), count = entry.getValue();
//            if (queue.size() == k) {
//                if (queue.peek()[1] < count) {
//                    queue.poll();
//                    queue.offer(new int[]{num, count});
//                }
//            } else {
//                queue.offer(new int[]{num, count});
//            }
//        }
//        int[] ret = new int[k];
//        for (int i = 0; i < k; i++) {
//            ret[i] = queue.poll()[1];
//        }
//        return ret;
//    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrence = new HashMap<>();
        for (int num : nums) {
            occurrence.put(num, occurrence.getOrDefault(num, 0) + 1);
        }
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] m,, int[] nm) {
                return m[1] - nm[1];
            }
        });
        ArrayList<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : occurrence.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }

        int[] ret = new int[k];
        quicksort(values, 0, values.size() - 1, k, 0, ret);
        return ret;
    }

    public void quicksort(List<int[]> values, int start, int end, int k, int retIndex, int[] ret) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, start, picked);
        int index = start;
        int pivot = values.get(start)[1];
        for (int i = start + 1; i < end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);
        if (k <= index - start) {
            quicksort(values, start, end, k, retIndex, ret);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                quicksort(values, index + 1, k - (index - start + 1), k, retIndex, ret);
            }
        }
    }
}


