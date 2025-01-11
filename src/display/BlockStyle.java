package display;

import display.TextStyle;

public class BlockStyle implements TextStyle {
    @Override
    public String format(String message) {
        // Beispiel für eine Block-Schrift (vereinfacht hier als Rahmen)
        return "\n  ____    _    _   _    ____   _      \n"
                + " | __ )  / \\  | \\ | |  / ___| | |     \n"
                + " |  _ \\ / _ \\ |  \\| | | |     | |     \n"
                + " | |_) / ___ \\| |\\  | | |___  | |___  \n"
                + " |____/_/   \\_\\_| \\_|  \\____| |_____|\n"
                + " " + message;
    }
}
