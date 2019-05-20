import bot.HelloBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Application {

    public static void main(String[] args) {
        try {
            //Инициализация
            ApiContextInitializer.init();
            //Регистрация бота
            new TelegramBotsApi().registerBot(new HelloBot());
        } catch (TelegramApiException e) {
            e.printStackTrace(); //TODO реализовать throw ... сейчас удобно тестить и смотреть в консоль
        }
    }
}
