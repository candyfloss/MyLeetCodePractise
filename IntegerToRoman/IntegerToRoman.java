public class IntegerToRoman {
  public String intToRoman(int num) {
        if ((num < 1) || (num > 3999)) {
            return null;
        }
        String[] digit =  {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] digit10 = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] digit100 = {"C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        StringBuilder sb = new StringBuilder();
        int power = 1;
        int d;
        while (num > 0) {
            d = num%10;
            if (d != 0) {
                if (power == 1) {
                    sb.insert(0, digit[d-1]);
                } else if (power == 10) {
                    sb.insert(0, digit10[d-1]);
                } else if (power == 100) {
                    sb.insert(0, digit100[d-1]);
                } else if (power == 1000) {
                    for (int i = 0; i < d; i++) {
                        sb.insert(0,'M');
                    }
                }
            }
            
            power = power * 10;
            num = num/10;
        }
        return sb.toString();
        
    }
}
