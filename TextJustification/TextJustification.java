public class TextJustification {
   public ArrayList<String> fullJustify(String[] words, int L) {
        ArrayList<String> list = new ArrayList<String>();
        int index = 0;
        String tmp = null;
        while (index < words.length) {
            String content;
            if (tmp == null) {
                content = words[index];
            } else {
                content = tmp + " " + words[index];
            }
            
            if (content.length() == L) {
                list.add(content);
                tmp = null;
            } else if (content.length() > L){
                String justifiedStr = justifyString(tmp, L);
                list.add(justifiedStr);
                tmp = words[index];
            } else {
                tmp = content;
            }
            index++;
        }
        if (tmp != null) {
            list.add(leftJustify(tmp, L));
        }
        return list;
    }
    
    
    private String justifyString(String word, int L){
        
        if (word.length() == L) {
            return word;
        } else {
            StringBuilder sb = new StringBuilder();
            String[] words = word.split(" ");
            int addlen = L - word.length() + words.length - 1;
            int numOfwords = words.length;
            
            if (numOfwords == 1) {
                sb.append(words[0]);
                for (int i = 0; i < addlen; i++){
                    sb.append(" ");
                }
            } else {
                int numOfblank = addlen/(numOfwords - 1);
                
                int numOfEblank = addlen%(numOfwords - 1);
                int i ;
                for (i = 0; i < words.length - 1; i++){
                    sb.append(words[i]);
                    for (int j = 0; j < numOfblank; j++){
                        sb.append(" ");
                    }
                    if (numOfEblank > 0) {
                        sb.append(" ");
                        numOfEblank--;
                    }
                }
                sb.append(words[i]);
            }
            return sb.toString();
        }
        
    }
    
    private String leftJustify(String word, int L){
        int addlen = L - word.length();
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        for (int i = 0; i < addlen; i++){
            sb.append(" ");
        }
        return sb.toString();
    }
}
