package bot.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.sun.org.apache.xml.internal.utils.LocaleUtility.EMPTY_STRING;
import static bot.config.Const.FILE;
import static bot.config.Const.NAME;
import static bot.config.Const.TOKEN;

public class BotProperties {

    private static BotProperties SingleInstance;
    private String rootPath;
    private String appConfigPath;
    private Properties appProps;

    private BotProperties() {

        this.rootPath = Thread.currentThread().getContextClassLoader().getResource(EMPTY_STRING).getPath();
        this.appConfigPath = rootPath + FILE.getValue();
        this.appProps = new Properties();
    }

    public static BotProperties getBotProperties() {
        if (SingleInstance == null) {
            SingleInstance = new BotProperties();
        }

        return SingleInstance;
    }

    public String getName() {
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return appProps.getProperty(NAME.getValue());
    }

    public String getToken() {
        try {
            appProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return appProps.getProperty(TOKEN.getValue());
    }
}
