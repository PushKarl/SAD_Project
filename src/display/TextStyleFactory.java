package display;

import java.util.Set;

public class TextStyleFactory {

    // Statische Instanz der Factory (Singleton-Instanz)
    private static TextStyleFactory instance;

    // Privater Konstruktor verhindert die Instanziierung
    private TextStyleFactory() {
    }

    // Öffentliche Methode, um die einzige Instanz zu erhalten
    public static TextStyleFactory getInstance() {
        if (instance == null) {
            synchronized (TextStyleFactory.class) {
                if (instance == null) {
                    instance = new TextStyleFactory();
                }
            }
        }
        return instance;
    }

    // Methode, um den passenden Textstil zurückzugeben
    public TextStyle getStyle(String type) {
        switch (type.toLowerCase()) {
            case "block":
                return new BlockStyle();
            case "slant":
                return new SlantStyle();
            default:
                return new PlainTextStyle(); // Fallback-Stil
        }
    }

    // Methode, um verfügbare Stile anzuzeigen
    public Set<String> getAvailableStyles() {
        return Set.of("Block", "Slant", "Plain");
    }
}
