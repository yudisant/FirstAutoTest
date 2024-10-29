package data;

public enum Locators {
    USERNAME("username"),
    ENTER_EMAIL("email"),
    PASSWORD("password"),
    CON_PASSWORD("confirm_password"),
    ENTER_BIRTHDAY("birthdate"),
    LANGUAGE_LVL("language_level"),
    SIGN_UP_BTN("[type='submit']"),
    LANGUAGE_BEGINNER("[value='beginner']"),
    CHECK_ENTER_DATA("output");

    private final String locator;

    Locators(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
