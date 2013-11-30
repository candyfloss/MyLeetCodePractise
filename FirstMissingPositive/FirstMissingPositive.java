public class FirstMissingPositive {
    public int firstMissingPositive(int[] A) {
        int len = A.length;
        int index = 0;
        while (index < len) {
            if (A[index] != (index + 1)) {
                int tmp = A[index];
                while (tmp > 0 && tmp <= len) {
                    if (A[tmp - 1] == tmp) {
                        break;
                    }
                    A[index] = A[tmp - 1];
                    A[tmp - 1] = tmp;
                    tmp = A[index];
                }
            }
            index++;
        }
        index = 0;
        for (index = 0; index < len; index++){
            if (A[index] != (index+1)){
                return index+1;
            }
        }   
        return index+1;
    }
}
