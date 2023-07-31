package leetcode.arrays;

import java.util.Arrays;

public class GroupAnagramsTest {

    public static void main(String[] args) {

        String [] input = {"eat","tea","tan","ate","nat","bat"};
        new GroupAnagrams().solution(input);
    }
}

class  GroupAnagrams {


   void solution (String [] input ) {

       int[] chars = new int[26];
       int asciiOfSmallA = 97;
       for (String str : input) {
           int [] temp = Arrays.copyOf(chars,26);
           for (int i = 0; i < str.length(); i++) {
               int ascii = (int) str.charAt(i) - 97;
               temp[ascii] = temp[ascii]+1;
           }
           String key = buildFrequency(temp);
           System.out.println(key);
       }
   }
     static String buildFrequency( int [] inputFrequncy) {
         String frequencyMaPkey = "";
       for (int i=0;i<26;i++){
           if(inputFrequncy[i]>0) {
                String charAt = Character.toString(97 + i);
                String frequencyOfChar = String.valueOf(inputFrequncy[i]);
               frequencyMaPkey = frequencyMaPkey.concat(charAt+frequencyOfChar);
           }
         }
       return frequencyMaPkey;
       }
   }
