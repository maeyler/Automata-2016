package animate;

public class AkifEyler implements Animator {
    public String process(String input) {
        return input.toLowerCase();
    }
    public String description(String source) {
        return source+" converted to lower case";
    }
    public String author() {
        return "M Akif Eyler";
    }
}
