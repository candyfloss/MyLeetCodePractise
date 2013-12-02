public class GrayCode {
 public ArrayList<Integer> grayCode(int n) {
        if (n < 0) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(0);
        if (n == 0) {
            return list;
        }
        list.add(1);
        for (int i = 1; i < n; i++) {
            ArrayList<Integer> tmpList = new ArrayList<Integer>();
            for (int j = list.size() - 1; j >= 0; j--) {
                Integer tmp = (Integer)list.get(j);
                tmpList.add(flipOne((int)tmp, i));
            }
            list.addAll(tmpList);
        }
        return list;
    }
    
    private int flipOne(int num, int index) {
        return num | (1<<index) ;

    }
}
