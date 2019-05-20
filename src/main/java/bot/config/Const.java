package bot.config;

public enum Const {

    TOKEN("token"),
    NAME("name"),
    FILE("app.properties");

    private String value;

    Const(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
