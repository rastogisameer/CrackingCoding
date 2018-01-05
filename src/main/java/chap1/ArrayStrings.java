package chap1;

import java.util.*;

public class ArrayStrings {
    public boolean isAllUniqueChars(String str) {

        if (str.length() == 1) {
            return true;
        }
        if (str.length() == 2) {
            return !str.substring(0, 1).equalsIgnoreCase(str.substring(1, 2));
        }
        if (str.substring(1, str.length()).contains(str.substring(0, 1))) {
            return false;
        } else {
            return isAllUniqueChars(str.substring(1, str.length()));
        }
    }

    public String reverse(String str) {

        if (str.length() == 1) {
            return str;
        }
        if (str.length() == 2) {
            return str.substring(1, 2) + str.substring(0, 1);
        }
        return str.substring(str.length() - 1, str.length()) + reverse(str.substring(0, str.length() - 1));
    }

    public String removeDuplicates(String str) {

        if (str.length() == 1) {
            return str;
        }
        if (str.length() == 2) {
            if (str.substring(0, 1).equalsIgnoreCase(str.substring(1, 2))) {
                return str.substring(0, 1);
            } else {
                return str;
            }
        }
        if (str.substring(1, str.length()).contains(str.substring(0, 1))) {
            return removeDuplicates(str.substring(1, str.length()));
        } else {
            return str.substring(0, 1) + removeDuplicates(str.substring(1, str.length()));
        }
    }

    public boolean isAnagram(String str1, String str2) {

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public void rotateBy90(char[][] arr) {

        for (int r = 0; r < arr.length/2; r++) { //0,1
            for (int c = r; c < arr[r].length-1-r; c++) {// 0,1,2,3 .. 1,2

                char t1 = arr[c][arr[r].length-1-r];
                arr[c][arr[r].length-1-r] = arr[r][c];

                char t2 = arr[arr.length-1-r][arr[r].length-1-c];
                arr[arr.length-1-r][arr[r].length-1-c] = t1;

                char t3 = arr[arr.length-1-c][r];
                arr[arr.length-1-c][r] = t2;

                arr[r][c] = t3;

                showArray(arr);
            }
        }
    }

    private void swap(char[][] arr, int r1, int c1, int r2, int c2) {
        char temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;

        showArray(arr);
    }

    public void showArray(char[][] arr) {
        System.out.println("{");
        for (int row = 0; row < arr.length; row++) {
            System.out.print("{");
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col]);
                System.out.print(" ");
            }
            System.out.print("}");
            System.out.println(" ");
        }
        System.out.println("}");
    }
    public String getFirstDuplicate(String str){
        // hgfedcbaha
        char[]arr = str.toCharArray();
        Set<Character> s = new HashSet<Character>();
        for(int i = 0; i < arr.length; i++) {

            boolean isuniq = s.add(arr[i]);
            if(!isuniq){
                return arr[i] + "";
            }
        }
        return "";
    }
    public String[] getWordsSortedByCount(String str){

        String[] words = str.split(" ");

        Map<String, Integer> countmap = new HashMap<String, Integer>();

        for(String w: words){

            if(countmap.containsKey(w)){
                countmap.put(w, countmap.get(w).intValue()+1);
            } else {
                countmap.put(w, 1);
            }
        }
        String[] cntwords = new String[countmap.size()];
        int c = 0;
        for(String k: countmap.keySet()){
            cntwords[c++] = countmap.get(k)+k;
        }
        Arrays.sort(cntwords);
        return cntwords;
    }
    public void showArray(String[]arr){
        for(String s: arr){
            System.out.println(s);
        }
    }
    public void showArray(int[][]arr){

        for (int row = 0; row < arr.length; row++) {
            System.out.print("{");
            for (int col = 0; col < arr[0].length; col++) {
                System.out.print(arr[row][col]);
                System.out.print(" ");
            }
            System.out.print("}");
            System.out.println(" ");
        }
        System.out.println("--");
    }
    public void setRowAndCol(int [][] arr, int n){

        int[] foundrow = new int[arr.length];
        int[] foundcol = new int[arr[0].length];

        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[r].length; c++){

                if(arr[r][c] == n) {
                    foundrow[r] = 1;
                    foundcol[c] = 1;
                }
            }
        }
        for(int r = 0; r < arr.length; r++){
            for(int c = 0; c < arr[r].length; c++){

                if(foundrow[r] == 1){
                    arr[r][c] = n;
                }
                if(foundcol[c] == 1){
                    arr[r][c] = n;
                }
            }
        }
    }
}