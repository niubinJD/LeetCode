package algorithm;

/**
 * 算法面试汇总-字符串问题
 */
public class StringProblemSolution {
    /**
     * 验证回文串
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        StringBuilder str = new StringBuilder();
        for (char aChar : chars) {
            if ((aChar >= 'a' && aChar <= 'z') || (aChar >= 'A' && aChar <= 'Z') || (aChar >= '0' && aChar <= '9')) {
                str.append(aChar);
            }
        }
        s = str.toString().toLowerCase();
        if (s.length() < 2) {
            return true;
        }
        return isSame(s, 0);
    }

    private boolean isSame(String str, int time){
        if (time > str.length() / 2) {
            return true;
        }
        if (str.charAt(time) == str.charAt(str.length() - 1 - time)) {
            return isSame(str, time + 1);
        }
        return false;
    }
}
