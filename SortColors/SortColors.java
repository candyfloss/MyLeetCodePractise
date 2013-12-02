public class SortColors {
    public void sortColors(int[] A) {
        int redend = 0;
        int bluestart = A.length - 1;
        
        while (bluestart >= 0 && A[bluestart] == 2) {
            bluestart--;
        }
        int whitestart = bluestart;
        while (whitestart >= 0 && A[whitestart] == 1) {
            whitestart --;
        }
        
        int tmp;
        while (redend < whitestart) {
            if (A[redend] == 0) {
                redend++;
                continue;
            } else if (A[redend] == 1) {
                tmp = A[whitestart];
                A[whitestart] = 1;
                A[redend] = tmp;
                while (whitestart >= 0 && A[whitestart] == 1) {
                    whitestart --;
                }
                continue;
            } else if (A[redend] == 2) {
                if (whitestart == bluestart) {
                    tmp = A[bluestart];
                    A[bluestart] = 2;
                    while (bluestart>=0 && A[bluestart] == 2) {
                        bluestart --;
                    }
                    whitestart = bluestart;
                    while (whitestart>=0 && A[whitestart] == 1) {
                        whitestart --;
                    }
                    A[redend] = tmp;
                    
                } else {
                    tmp = A[whitestart];
                    A[bluestart] = 2;
                    bluestart--;
                    A[whitestart] = 1;

                    A[redend] = tmp;
                    while (whitestart >= 0 && A[whitestart] == 1) {
                        whitestart --;
                    }
                }


            }
        }
        if ((redend == whitestart) && (A[redend] == 2)) {
            tmp = A[bluestart];
            A[bluestart] = 2;
            A[redend] = tmp;
        }
        
    }
}
