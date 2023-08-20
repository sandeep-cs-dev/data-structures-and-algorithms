package leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class AllAnagrams {

    public static void main(String[] args) {
        var solution = new Solution();
        List ans =  solution.findAllAnagrams("abcabcabcb","abc");
        ans.stream().forEach(System.out::println);
    }
}

class Solution {
    public List<Integer> findAllAnagrams(String s, String p) {

        // prepare index array for string s
        // prepare index array for string p
        // compare substring using sliding window technique

        if(s.length()<p.length()){
            return List.of();
        }

        int [] countP = new int[26];
        int [] countS = new int[26];
        List<Integer> ansList = new ArrayList<>();
        for( int i=0;i<p.length();i++){
         int ind =  p.charAt(i)-97;
         countP[ind]++;
        }
        for (int i=0;i<p.length();i++){
            int index = s.charAt(i)-97;
            countS[index]++;
        }
        int right = p.length()-1;
        int left =0;
        while(right<s.length()){
             if(compareCount(countP,countS)){
                ansList.add(left);
             }
             int charAtLeft = s.charAt(left)-97;
             countS[charAtLeft]--;
             left++;
             right++;
             if(right<s.length()) {
                 int charIndexAtWindowRight = s.charAt(right) - 97;
                 countS[charIndexAtWindowRight]++;
             }
           }
       return ansList;
    }

    public  Boolean compareCount(int [] countS, int [] countP){
        for (int i =0;i<countS.length;i++){
            if(countP[i]!=countS[i]){
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}