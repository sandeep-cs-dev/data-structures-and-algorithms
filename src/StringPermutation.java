public class StringPermutation {

    public static void main(String[] args) {

        String a = "ABC";
        printPermutations(a,0,a.length()-1);

    }

    static String swap(int i, int j, String a) {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    static void printPermutations(String str, int l, int r) {

        if (l == r)
            System.out.println(str);
        else {
            for (int i = l; i < str.length(); i++) {
                str = swap(i, l, str);
                System.out.println("swapping "+i+" "+l);
                System.out.println("swapping "+str.charAt(i)+": "+str.charAt(l));
                printPermutations(str, l + 1, r);
                str = swap(i, l, str);   // back track
                System.out.println("swapping "+i+" "+l);
                System.out.println("bk swapping "+str.charAt(i)+": "+str.charAt(l));

            }
        }
    }

}
