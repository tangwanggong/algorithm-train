package day26;

import java.util.Stack;

/**
 * @date 2022/4/25
 */
public class SmallestSubsequenceOfDistinctCharacters {
    public String smallestSubsequence(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = new char[256];
        for (char c : s.toCharArray()) {
            chars[c] ++;
        }
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            chars[c] --;
            if(inStack[c]){
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > c){
                if(chars[stack.peek()] == 0){
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }
}
