public class StringToInteger {
    public int atoi(String str) {
        if ((str == null) || str.length() == 0) {
            return 0;
        }
        char[] arr = str.toCharArray();
        long result = 0;
        long power = 1;
        int start = 0;
        int end = arr.length - 1;
        boolean negative = false;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != ' ') {
                start = i;
                break;
            }
        }

        if (arr[start] == '-') {
            negative = true;
            start = start + 1;
        } else if (arr[start] == '+'){
            start = start + 1;
        }
        for (int i = arr.length - 1; i >=start; i-- ){
            if (arr[i] < '0' || arr[i] >'9') {
                end = i - 1;
                result = 0;
                continue;
            } else {
                int digit = arr[i] - '0';
                power = (int)Math.pow(10, (end - i));
                result += digit*power;
            }
        }
        
        if (negative) {
            if (-result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else {
                return (int)(-result);
            }
        } else {
            if (result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return (int)result;
            }
        }
    }
}
