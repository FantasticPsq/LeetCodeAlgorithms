import java.util.HashMap;

public class MinWindow {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int left = 0, right = 0;
        int flag = 0;
        String res = s;
        HashMap<Character, Integer> needs = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            needs.put(c, needs.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            window.put(s.charAt(i), window.getOrDefault(s.charAt(i), 0) + 1);
            right++;
            while (windowContainsNeeds(needs, window)) {
                flag =1;
                if (res.length() > right - left) {
                    res = s.substring(left, right);
                }
                window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                left++;
            }
        }
        return flag == 0 ? "" : res;
    }

    private boolean windowContainsNeeds(HashMap<Character, Integer> needs, HashMap<Character, Integer> window) {
        for (char c : needs.keySet()) {
            if (window.get(c) == null || window.get(c) < needs.get(c)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new MinWindow().minWindow("abc", "cba"));
    }
}
