package com.daily.algothrim.stack;

import java.util.Stack;

/**
 * 有效的括号(LeetCode 20)
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 使用栈实现，遍历字符串，遇到左括号统统入栈，遇到有括号
 * 1. 判断栈是否为空，为空则无效
 * 2. 从栈中取出一个元素，与当前右括号做匹配，不符合则无效，符合则继续向下操作
 * 3. 字符串遍历结束之后，判断栈是否为空，不为空则无效。
 */
public class ValidParenthesis {

    public static void main(String[] args) {
        System.out.println(new ValidParenthesis().solution("({[[{(([]))}]]})"));
    }

    private boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('(' == c || '[' == c || '{' == c) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((')' == c && '(' != top) || (']' == c && '[' != top) || ('}' == c && '{' != top)) return false;
            }
        }

        return stack.isEmpty();
    }
}
