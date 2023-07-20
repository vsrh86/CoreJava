package com.sss.java.java8;

public class StringMatch {

    public static void main(String[] args) {
        String s = "abcd";
      //  String t = "wajbucxd";
        String t = "wbucxda";

        boolean isSeriesMatching = isSeriesMatching(s, t);

        System.out.println(isSeriesMatching);
    }

    private static boolean isSeriesMatching(String s, String t) {
        int sIndex = 0;

        for (int tIndex = 0; tIndex < t.length(); tIndex++) {
            if (t.charAt(tIndex) == s.charAt(sIndex)) {
                sIndex++;

                if (sIndex == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
