import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class StringSolution {
    /**
     * 二进制字符串相加
     * @param a
     * @param b
     * @return
     */
    public static String addBinary(String a, String b) {
        String[] chars = a.split("");
        String[] chars1 = b.split("");
        Stack<String> aS = new Stack<>();
        Stack<String> bS = new Stack<>();
        String r = "";
        for (String c: chars) {
            aS.push(c);
        }
        for (String c:chars1) {
            bS.push(c);
        }
        int add = 0;
        while (!aS.isEmpty() || !bS.isEmpty()) {
            int result = add;
            if (!aS.isEmpty()){
                result += Integer.valueOf(aS.pop());
            }
            if (!bS.isEmpty()) {
                result += Integer.valueOf(bS.pop());
            }
            if (result >= 2) {
                add = result / 2;
                result = result % 2;
            } else {
                add = 0;
            }
            int i = result % 2;
            r = i + r;
        }
        if (add != 0) r = add + r;
        return r;
    }

    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) return -1;
        return haystack.indexOf(needle);
    }

    /**
     * 最长公共前缀
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        List<String> collect = Arrays.stream(strs).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
        String minStr = collect.get(0);
        int len = minStr.length();
        String result = "";
        while (len > 0) {
            final String substring = minStr.substring(0, len);
            List<String> collect1 = Arrays.stream(strs).filter(x -> x.indexOf(substring) == 0).collect(Collectors.toList());
            if (collect1.size() == strs.length) {
                result = substring;
                break;
            }
            len--;
        }
        return result;
    }
}
