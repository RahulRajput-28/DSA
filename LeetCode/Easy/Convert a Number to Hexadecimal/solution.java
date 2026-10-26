class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        char[] hex = "0123456789abcdef".toCharArray();

        while (num != 0) {
            int digit = num & 15;
            result.append(hex[digit]);
            num >>>= 4;
        }

        return result.reverse().toString();
    }
}