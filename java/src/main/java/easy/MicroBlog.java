package easy;

public class MicroBlog {

    public String truncate(String input) {
        return input.length() < 5 ? input : input.substring(0, input.offsetByCodePoints(0, 5));
    }

}
