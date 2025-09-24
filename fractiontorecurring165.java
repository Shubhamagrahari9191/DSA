class Solution {
    public String fractionToDecimal(int a, int b) {
        if (a == 0) return "0";

        StringBuilder sb = new StringBuilder();

        if ((a < 0) ^ (b < 0)) {
            sb.append("-");
        }
        long num = Math.abs((long) a);
        long den = Math.abs((long) b);

        sb.append(num / den);
        num %= den;

        if (num == 0) return sb.toString(); 

        sb.append(".");
       
        java.util.Map<Long, Integer> map = new java.util.HashMap<>();

        while (num != 0) {
            if (map.containsKey(num)) {
                int index = map.get(num);
                sb.insert(index, "(");
                sb.append(")");
                break;
            }

            map.put(num, sb.length());
            num *= 10;
            sb.append(num / den);
            num %= den;
        }

        return sb.toString();
    }
}
