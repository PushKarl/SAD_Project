package display;

import display.TextStyle;

public class SlantStyle implements TextStyle {
    @Override
    public String format(String message) {
        switch (message) {
            case "GAME OVER":
                return """
                            _________    __  _________   ____ _    ____________\s
                           / ____/   |  /  |/  / ____/  / __ \\ |  / / ____/ __ \\
                          / / __/ /| | / /|_/ / __/    / / / / | / / __/ / /_/ /
                         / /_/ / ___ |/ /  / / /___   / /_/ /| |/ / /___/ _, _/\s
                         \\____/_/  |_/_/  /_/_____/   \\____/ |___/_____/_/ |_| \s
                                                                               \s
                        """;
            case "BALL 1":
                return """
                             ____  ___    __    __       ___
                            / __ )/   |  / /   / /      <  /
                           / __  / /| | / /   / /       / /\s
                          / /_/ / ___ |/ /___/ /___    / / \s
                         /_____/_/  |_/_____/_____/   /_/  \s
                                                           \s
                        """;
            case "BALL 2":
                return """
                             ____  ___    __    __       ___\s
                            / __ )/   |  / /   / /      |__ \\
                           / __  / /| | / /   / /       __/ /
                          / /_/ / ___ |/ /___/ /___    / __/\s
                         /_____/_/  |_/_____/_____/   /____/\s
                                                            \s
                        """;
            case "BALL 3":
                return """
                             ____  ___    __    __       _____
                            / __ )/   |  / /   / /      |__  /
                           / __  / /| | / /   / /        /_ <\s
                          / /_/ / ___ |/ /___/ /___    ___/ /\s
                         /_____/_/  |_/_____/_____/   /____/ \s
                                                             \s
                        """;
            case "Press Start":
                return """
                            ____  ____  ________________    ______________    ____  ______
                           / __ \\/ __ \\/ ____/ ___/ ___/   / ___/_  __/   |  / __ \\/_  __/
                          / /_/ / /_/ / __/  \\__ \\\\__ \\    \\__ \\ / / / /| | / /_/ / / /  \s
                         / ____/ _, _/ /___ ___/ /__/ /   ___/ // / / ___ |/ _, _/ / /   \s
                        /_/   /_/ |_/_____//____/____/   /____//_/ /_/  |_/_/ |_| /_/    \s
                                                                                         \s                                                          \s
                        """;
            default:
                return message;
        }
    }
}