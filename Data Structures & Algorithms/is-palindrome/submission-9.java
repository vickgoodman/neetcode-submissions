class Solution {
    private boolean isDigitOrLetter(char c) {
        return (c >= 'a' && c <= 'z')
                || (c >= 'A' && c <= 'Z')
                || (c >= '0' && c <= '9');
    }

    private char toLower(char c) {
        if (c >= 'A' && c <= 'Z') {
            return (char)(c + 32);
        }

        return c;
    }

    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (!isDigitOrLetter(s.charAt(l)) && l < r) {
                l++;
            }

            while (!isDigitOrLetter(s.charAt(r)) && l < r) {
                r--;
            }

            if (toLower(s.charAt(l)) != toLower(s.charAt(r))) {
                return false;
            }

            l++;
            r--;
        }

        return true;
    }
}
