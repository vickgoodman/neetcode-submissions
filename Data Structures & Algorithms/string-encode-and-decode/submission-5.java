class Solution {

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();

        for (String str : strs) {
            encode.append(str.length()).append("#").append(str);
        }

        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            String len = "";
            while (str.charAt(i) != '#') {
                len += str.charAt(i);
                i++;
            }
            i++;

            int stringLen = Integer.parseInt(len);

            String decoded = "";
            for (int j = i; j < i + stringLen; j++) {
                decoded += str.charAt(j);
            }

            i += stringLen;

            res.add(decoded);
        }

        return res;
    }
}
