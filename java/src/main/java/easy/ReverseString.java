package easy;

public class ReverseString {

    public String reverse(String inputString) {

//        String reverseString = "";
//        for (int i = 0; i < inputString.length(); i++) {
//            reverseString = inputString.charAt(i) + reverseString;
//        }
//
//        return reverseString;

        StringBuilder s = new StringBuilder(inputString);
        return s.reverse().toString();
    }
}
