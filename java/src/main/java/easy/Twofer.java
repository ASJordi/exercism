package easy;

import static java.lang.String.format;

public class Twofer {

    public String twofer(String name) {
//        String msg = "";
//        if (name != null){
//            msg = format("One for %s, one for me.", name);
//        } else {
//            msg = "One for you, one for me.";
//        }
//
//        return msg;
        return (name != null) ? format("One for %s, one for me.", name) : "One for you, one for me.";
    }

}
