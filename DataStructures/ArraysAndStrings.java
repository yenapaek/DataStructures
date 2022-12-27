package DataStructures;

import java.util.Arrays;
import java.util.HashSet;

public class ArraysAndStrings {
    /*
     * 1.1 Is Unique
     * Determine if a string has all unique characters
     * 
     * Solution - hash table?
     */
    public static boolean isUnique(String s){
        HashSet<Character> hash = new HashSet<>();

        for (int i = 0; i < s.length(); i++){
            if (hash.contains(s.charAt(i))){
                return false;
            } else {
                hash.add(s.charAt(i));
            }
        }

        return true;

    }     

    /*
     * 1.2 Check Permutation
     * Given two strings, decide if one is a permutation of the other
     * 
     * permutation = arrangement number
     */
    public static boolean permutationExists(String s1, String s2){
        /*
         * Solution 1: Sort & Compare
         * Time Complexity: O(n^2)
         */
        // char[] s1arr = s1.toCharArray();
        // char[] s2arr = s2.toCharArray();

        // Arrays.sort(s1arr); //  quickSort
        // Arrays.sort(s2arr);

        // return s1arr.equals(s2arr);

        /* 
         * Solution 2: Hash Table - Check char counts
         * Time Complexity O(n)
        */
        // Make a hash table of ASCII characters, keep count of # of each char
        if (s1.length() != s2.length()) return false;

        int[] ascii = new int[128];
        
        // add s1 letters onto hash table
        for (int i = 0; i < s1.length(); i++){
            ascii[s1.charAt(i)]++;
        }

        // remove s2 letters from hash table
        for (int i = 0; i < s2.length(); i++){
            ascii[s2.charAt(i)]--;
            if (ascii[s2.charAt(i)] < 0){
                return false;
            }
        }

        return true;
    }

    /*
     * 1.3 URLify
     * Replace all spaces in a string with '%20'
     * 
     * Assume that there is sufficient space at the end to hold additional chars 
     * and that the true length of the String is given 
     * 
     * Input: "Mr John Smith", 13
     * Output: "Mr%20John%20Smith"
     * 
     * Time Complexity: O(n)
     * 
     */
    public static String replaceSpace(String s, int len){
        char[] arr = s.toCharArray();
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < len; i++){
            if (arr[i] == ' '){
                sb.append("%20");
            } else {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }

    /*
     * 1.4 Palindrome Permutation
     * Given a string, check if it is a palindrome
     * 
     * Input: Tact Coa
     * Output: taco cat, atco cta - true
     * 
     * Time Complexity: O(n)
     * 
     */
    public static boolean isPalindrome(String s){
        /*
         * Two Runners
         */
        int left = 0, right = s.length()-1;

        while (left <= right){
            // if left char is not a letter, increment left pointer
            if (!(s.charAt(left) >= 'a' && s.charAt(left) <= 'z')){
                left++;
            } 
            // if right char is not a letter, increment right pointer
            else if (!(s.charAt(right) >= 'a' && s.charAt(right) <= 'z')){
                right--;
            }
            // if left char and right char match, increment pointers
            else if (s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }
            else { return false; }
        }
        return true;
    }    
    
    /*
    * 1.5 One Away
    * Given two strings, check if they are one or zero edits away
    * insert, remove, replace a char
    *
    * pale, ple --> true
    * pales, pale --> true
    * pale, bale --> true
    * pale, bake --> false
    * 
    * Time Complexity: O(n)
    * 
    */
   public static boolean oneEdit(String s, String t){
        /*
         * Hash Table - check letters
         */
        if (Math.abs(s.length() - t.length()) > 1) return false;

        int[] letters = new int[128]; // assuming ascii
        int changes = 0;
        // add chars for s to hash table
        for (int i = 0; i < s.length(); i++){
            letters[s.charAt(i)]++;
        }

        // compare iteratively to t and add missing char
        for (int i = 0; i < t.length(); i++){
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0){
                changes++;
            }
        }
        
        // if by end of length, t doesn't match return false;
        return changes <= 1;
   }

    /*
    * 1.6 String Compression
    * Compress string by adding count of letters after letter
    * Assume the string will only have upper and lower case letters
    *
    * aabcccaa -> a2b2c3a2
    * 
    * Time Complexity: O(n) 
    */
    public static String stringCompress(String s){
        StringBuilder sb = new StringBuilder();
        int j = 1;
        for (int i = 0; i < s.length()-1; i++){
            sb.append(s.charAt(i)+j);
            if (s.charAt(i+1) != s.charAt(i)){
                j = 1;
            }
        }
        return sb.toString();
   }

    public static void main (String args[]){
        /*
         * 1.1 is Unique
         */
        String s1 = "hi", s2 = "hello";
        System.out.println(s1 + ": " + isUnique(s1));
        System.out.println(s2 + ": " + isUnique(s2));
        System.out.println("----------------------------");
        /*
         * 1.2 permutation exists
         */
        String pExists1 = "ollhiell", pExists2 = "ihellllo";
        String pExists3 = "god", pExists4 = "dog ";
        System.out.println(pExists1 + "\n" + pExists2 + "\n" + permutationExists(pExists1, pExists2) + "\n");
        System.out.println(pExists3 + "\n" + pExists4 + "\n" + permutationExists(pExists3, pExists4) + "\n");
        System.out.println("----------------------------");
        /*
         * 1.3 URLify
         */
        String url1 = "Mr John Smith";
        System.out.println(replaceSpace(url1, 13));
        System.out.println("----------------------------");
        /*
         * 1.4 Palindrome
         */
        String pal1 = "taco cat";
        System.out.println(pal1 + ": " + isPalindrome(pal1));
        String pal2 = "race car";
        System.out.println(pal2 + ": " + isPalindrome(pal2));
        String pal3 = "blue";
        System.out.println(pal3 + ": " + isPalindrome(pal3));
        String pal4 = "too ot";
        System.out.println(pal4 + ": " + isPalindrome(pal4));
        System.out.println("----------------------------");        
        /*
        * 1.5 One Away
        */
       System.out.println("pale, ple : " + oneEdit("pale", "ple"));
       System.out.println("pale, bale : " + oneEdit("pale", "bale"));
       System.out.println("pale, palee : " + oneEdit("pale", "palee"));
       System.out.println("pale, bake : " + oneEdit("pale", "bake"));
       System.out.println("----------------------------");
        /*
        * 1.6 String Compression
        */
        System.out.println("aacccbaaa" + stringCompress("aacccbaa"));
        System.out.println("----------------------------");
    }
}
