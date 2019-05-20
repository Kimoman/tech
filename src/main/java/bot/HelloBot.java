package bot;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;

import static bot.util.Utils.pardon;
import static bot.config.BotProperties.getBotProperties;
import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

public class HelloBot extends AbilityBot {

    public HelloBot() {
        super(getBotProperties().getToken(), getBotProperties().getName());
    }

    @Override
    public int creatorId() {
        return 5678321;
    }

    //Ответ на сообщения (DEFAULT) - не команды
    public Ability answer() {
        return Ability
                .builder()
                .name(DEFAULT)
                .locality(ALL)
                .privacy(PUBLIC)
                .input(0)
                .action(ctx -> pardon(ctx).ifPresent(str -> silent.send(str, ctx.update().getMessage().getChatId())))
                .build();
    }
}
