public class MinimumWindowSubstring {
    
    public String minWindow(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = -1; 
        int minStart = -1;
        int end = -1;
        char tmp;
        int count = 0;
        int minWindow = Integer.MAX_VALUE;
        for (int i = 0; i < T.length(); i++) {
            if (map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i))+1);
            } else {
                map.put(T.charAt(i), 1);
            }            
        }
        int size = T.length();
        for (int i = 0; i < S.length(); i++) {
            tmp = S.charAt(i);
            if (map.containsKey(tmp)) {
                if (start == -1) {
                    start = i;
                }
                int key = (int)((Integer)map.get(tmp));
                if (key > 0) {
                    count++;
                }
                map.put(tmp, key - 1);
                if (count == size) {                                      
                    while ((int)((Integer)map.get(S.charAt(start))) < 0){
                        map.put(S.charAt(start), map.get(S.charAt(start)) + 1);
                        start++;
                        while (!map.containsKey(S.charAt(start))) {
                            start++;
                        }
                    }
                    int tmplen = i - start;
                    
                    if (tmplen < minWindow) {
                        
                        minStart = start;
                        end = i;
                        minWindow = tmplen;
                    }
                }
                
            
            }
        }
        
        if (end == -1) {
            return "";
        } else {
            return S.substring(minStart, end+1);
        }
    }
}
