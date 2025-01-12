package display;

import display.PlainTextStyle;
import display.SlantStyle;
import display.TextStyle;
import java.util.Set;

public class TextStyleFactory {
    public static TextStyle getStyle(String type) {
        switch (type.toLowerCase()) {
            case "block":
                return new BlockStyle();
            case "slant":
                return new SlantStyle();
            default:
                return new PlainTextStyle(); // Fallback-Stil
        }
    }

    public static Set<String> getAvailableStyles() {
        return Set.of("Block", "Slant"); // Verfügbare Schriftstile
    }
}
