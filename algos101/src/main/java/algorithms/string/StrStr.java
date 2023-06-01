package algorithms.string;

public class StrStr {
    
    public static int strStr(String haystack, String needle) {
        int index = -1;
        for(int h = 0; h < haystack.length(); h++) {
            for (int n = 0; n < needle.length(); n++) { 
                System.out.println("h=" + h + " n=" + n);
                if (haystack.charAt(h) == needle.charAt(n)) {
                    index = index > -1 ? index : h;
                    if (n == needle.length() -1) {
                        return index;
                    }
                    h++;
                } else {
                    index = -1;
                    break;
                }
            }
            System.out.println("loop="+ h);
        }
        return index;
    }
    
    
    public static int strStr1(String haystack, String needle) {
    	for(int h = 0; h < haystack.length(); h++) {
            for (int n = 0; n < needle.length(); n++) { 
            	if (haystack.charAt(h) != needle.charAt(n)) break;
            	if (n+1 == needle.length()) return h;
            	//if (h+1 == haystack.length()) return -1;
            }
    	}
    	return -1;
    }
    
	public int strStr2(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j == haystack.length())
					return -1;
				if (needle.charAt(j) != haystack.charAt(i + j))
					break;
			}
		}
	}
    
    
    
    
    public static void main(String[] args) {
        System.out.println("StrStr");
        
        // String haystack = "sadbutsad";
        // String needle = "sad";
        String haystack = "leetcode";
        String needle = "leeto";
        
        int index = strStr(haystack, needle);
        
        System.out.println("Index = " + index);
    }
    

}
