package data;

public enum Mode {
    FULLSCREEN("--start-fullscreen"),
    KIOSK("--kiosk"),
    HEADLESS("--headless");

    private String argument;

    Mode(String argument) {
        this.argument = argument;
    }

    public String getArgument() {
        return argument;
    }
}
