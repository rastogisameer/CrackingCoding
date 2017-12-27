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
}
