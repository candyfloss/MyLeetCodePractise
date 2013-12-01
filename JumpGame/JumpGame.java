public class JumpGame {
    public boolean canJump(int[] A) {
        if ((A == null) || (A.length == 0) || A.length == 1) {
            return true;
        } 
        int index = 0;
        while (index < (A.length - 1)) {
            index = index + A[index];
            if (index < (A.length - 1) && A[index] == 0) {
                return false;
            } 
        }
        return true;
    }
}
