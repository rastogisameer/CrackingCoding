package chap1;

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
    public String reverse(String str){

        if(str.length() == 1){
            return str;
        }
        if (str.length() == 2) {
            return str.substring(1, 2) + str.substring(0, 1);
        }
        return str.substring(str.length() - 1, str.length()) + reverse(str.substring(0, str.length() - 1));
    }
    public String removeDuplicates(String str){

        if(str.length() == 1){
            return str;
        }
        if (str.length() == 2) {
            if(str.substring(0, 1).equalsIgnoreCase(str.substring(1, 2))){
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
    public boolean isAnagram(String str1, String str2){

        if(str1.length() == 1 && str2.length() == 1){
            if(str1.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        if (str1.length() == 2 && str2.length() == 2) {
            if(str1.equalsIgnoreCase(str2) || str1.equalsIgnoreCase(str2.substring(1, 2) + str2.substring(0, 1))){
                return true;
            }
        }
        return false;
    }
}
