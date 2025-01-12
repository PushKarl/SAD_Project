package display;

import display.PlainTextStyle;
import display.SlantStyle;
import display.TextStyle;

public class TextStyleFactory {
    public static TextStyle getStyle(String type) {
        if (type.equalsIgnoreCase("Block")) {
            return new BlockStyle();
        } else if (type.equalsIgnoreCase("Slant")) {
            return new SlantStyle();
        } else {
            return new PlainTextStyle(); // Fallback
        }
    }
}