public class PlainTextStyle implements TextStyle {
    @Override
    public String format(String message) {
        return ">> " + message + " <<"; // Einfacher Stil
    }
}
