package com.daily.algothrim.stack;

/**
 * 比较含退格的字符串(LeetCode 844)
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class BackSpaceCompare {

    public static void main(String[] args) {
        System.out.println(new BackSpaceCompare().solution("ab#c", "ad#c"));
        System.out.println(new BackSpaceCompare().solution("ab##", "c#d#"));
        System.out.println(new BackSpaceCompare().solution("a##c", "#a#c"));
        System.out.println(new BackSpaceCompare().solution("a#c", "b"));
    }

    private boolean solution(String S, String T) {
        int i = nextValidIndex(S, S.length());
        int j = nextValidIndex(T, T.length());
        while (i >= 0 && j >= 0) {
            if (S.charAt(i) != T.charAt(j)) return false;
            i = nextValidIndex(S, i);
            j = nextValidIndex(T, j);
        }

        return i == j;
    }

    /**
     * 从后往前找到下一个有效位置
     */
    private int nextValidIndex(String s, int index) {
        int backCount = 0;
        while (--index >= 0) {
            if (s.charAt(index) == '#') {
                backCount++;
            } else if (backCount > 0) {
                backCount--;
            } else {
                return index;
            }
        }
        return index;
    }
}
