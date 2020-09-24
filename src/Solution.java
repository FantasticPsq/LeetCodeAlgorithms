import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    public int longestValidParentheses(String s) {
        int maxValidLength = 0;
        // need表示需要多少个左括号
        int validLength = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                stack.push(i);
            }else {
                stack.pop();
                if(stack.size()==0){
                    stack.push(i);
                }else {
                    validLength = Math.max(validLength,i-stack.peek());
                }
            }
        }
        return validLength;
    }

    public void dfs(int index, String s, Queue<Character> queue) {
        if (s.charAt(index) == ')') {
            queue.offer(')');
        }
        if (s.charAt(index) == '(') {
            if (queue.size() == 0) {

            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestValidParentheses(")()())()()("));
    }
}