import java.util.*;

class Solution {
    public static int solution(String s) {
        int result = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder zipStr = new StringBuilder();
            String str = "", prevStr = "";
            int strCount = 1;

            for (int j = 0; j < s.length(); j += i) {
                str = s.substring(j, Math.min(j + i, s.length()));

                if (prevStr.equals(str)) {
                    strCount++;
                    continue;
                }

                zipStr.append(strCount > 1 ? strCount + prevStr : prevStr);
                prevStr = str;
                strCount = 1;
            }

            zipStr.append(strCount > 1 ? strCount + str : str);
            result = Math.min(result, zipStr.length());
        }

        return result;
    }
}