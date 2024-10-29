package data;

public enum Mode {
    FULLSCREEN("--start-fullscreen"),
    KIOSK("--kiosk"),
    HEADLESS("--headless");

    private final String argument;

    Mode(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }
}
