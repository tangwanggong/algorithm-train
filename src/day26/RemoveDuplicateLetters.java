package day26;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * @date 2022/4/25
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        char[] chars = new char[256];
        for (char c : s.toCharArray()) {
            chars[c]++;
        }
        Stack<Character> stack = new Stack<>();
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            chars[c]--;
            if(inStack[c]){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c) {
                if(chars[stack.peek()] == 0){
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.add(c);
            inStack[c] = true;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()){
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
