package com.daily.algothrim.stack;

import java.util.Stack;

/**
 * 实现一个基本的计算器来计算一个简单的字符串表达式的值。(LeetCode 224)
 * 字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格.
 *
 * 示例 1:
 *
 * 输入: "1 + 1"
 * 输出: 2
 * 示例 2:
 *
 * 输入: " 2-1 + 2 "
 * 输出: 3
 * 示例 3:
 *
 * 输入: "(1+(4+5+2)-3)+(6+8)"
 * 输出: 23
 *
 * 说明：
 * 你可以假设所给定的表达式都是有效的。
 *
 * 1. 通过设定一个符号位将所有的运算转化成加法
 * 2. 遇到数字都带上之前的符号位，再与之前的结果做加法运算
 * 3. 遇到'('将之前的符号位与结果保留到栈中，然后再重复1 2 步骤计算括号里面的值
 * 4. 遇到')'取出之前保留的符号位与结果，与当前结果做加法运算
 */
public class Calculate {

    public static void main(String[] args) {
        System.out.println(new Calculate().solution("(1+(4+5+2)-3)+(6+8)"));
    }

    private int solution(String s) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            switch (current) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case '(':
                    stack.push(result);
                    stack.push(sign);
                    // 复原
                    result = 0;
                    sign = 1;
                    break;
                case ')':
                    // 取出之前暂存的数据与符号位，并做运算
                    result = stack.pop() * result + stack.pop();
                    break;
                default:
                    int num = current - '0';
                    // 多为数字
                    while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                        num = num * 10 + (s.charAt(++i) - '0');
                    }
                    result += num * sign;
            }
        }

        return result;
    }
}
