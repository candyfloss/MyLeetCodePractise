public class NextPermutation {
  public void nextPermutation(int[] num) {
        if ((num == null) || (num.length <= 1)) {
            return;
        } 
        int len = num.length;
        int last = num[len - 1];
        int index;
        int tmp;
        for (index = len - 2; index >=0 ; index--) {
            if (num[index] < last) {
                int backTrack = index + 1;
                while (backTrack < len) {
                    if (num[backTrack] <= num[index]) {
                        break;
                    }
                    backTrack++;
                }
                tmp = num[index];
                num[index] = num[backTrack - 1];
                num[backTrack - 1] = tmp;
                int exchange = len-index - 1;
                for (int j = index + 1; j < index + 1+ exchange/2; j++) {
                    tmp = num[j];
                    num[j] = num[len - j + index];
                    num[len - j + index] = tmp;
                }
                return;
            } else {
                last = num[index];
            }
        }

        for (int i = 0; i < len/2; i++) {
            tmp = num[i];
            num[i] = num[len - i - 1];
            num[len - i - 1] = tmp;
        }
    }
}
