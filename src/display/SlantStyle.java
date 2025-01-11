package display;

import display.TextStyle;

public class SlantStyle implements TextStyle {
    @Override
    public String format(String message) {
        return "\n   ____  _      _      ____   _      \n"
                + "  / ___|| |    | |    / ___| | |     \n"
                + " | |    | |    | |   | |     | |     \n"
                + " | |___ | |___ | |___| |___  | |___  \n"
                + "  \\____||_____||_____|\\____| |_____|\n"
                + " " + message;
    }
}
