import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;

class LFUCache {
    HashMap<Integer, Integer> keyToVal;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    int cap;
    int minFreq;

    // 构造容量为 capacity 的缓存
    public LFUCache(int capacity) {
        this.cap = capacity;
        keyToFreq = new HashMap<>();
        keyToVal = new HashMap<>();
        freqToKeys = new HashMap<>();
        this.minFreq = 0;
    }

    // 在缓存中查询 key
    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    // 将 key 和 val 存入缓存
    public void put(int key, int val) {
        if (this.cap <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, val);
            increaseFreq(key);
            return;
        }
        if (this.cap <= keyToVal.size()) {
            removeMinFreq();
        }
        keyToVal.put(key, val);
        keyToFreq.put(key,1);
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        this.minFreq = 1;
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        // 删除freq对应的key
        freqToKeys.get(freq).remove(key);
        freqToKeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKeys.get(freq+1).add(key);
        if (freqToKeys.get(freq).isEmpty()) {
            freqToKeys.remove(freq);
            if(freq==this.minFreq){
                this.minFreq++;
            }
        }
    }

    private void removeMinFreq() {
        LinkedHashSet<Integer> keyList = freqToKeys.get(this.minFreq);
        int deletedKey = keyList.iterator().next();
        keyToFreq.remove(deletedKey);
        keyToVal.remove(deletedKey);
        keyList.remove(deletedKey);
        if (keyList.isEmpty()) {
            freqToKeys.remove(this.minFreq);
            // 不需要更新minFreq
        }
    }
}
