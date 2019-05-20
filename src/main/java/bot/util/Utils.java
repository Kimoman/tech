package bot.util;

import org.telegram.abilitybots.api.objects.MessageContext;

import java.util.Optional;

public class Utils {

    public static boolean hasHello(String s) {
        return s.matches(".*([П|п][Р|р][И|и][В|в][Е|е][Т|т]).*");
    }

    public static boolean hasGoodbye(String s) {
        return s.matches(".*([П|п][О|о][К|к][А|а]).*");
    }

    public static Optional<String> getHello(MessageContext context) {
        return Optional.ofNullable(context)
                .filter(c -> hasHello(c.update().getMessage().getText()))
                .map(cxt -> cxt.user().getFirstName() + ", Привет!");
    }

    public static Optional<String> getGoodbye(MessageContext context) {
        return Optional.ofNullable(context)
                .filter(c -> hasGoodbye(c.update().getMessage().getText()))
                .map(cxt -> cxt.user().getFirstName() + ", Пока!");
    }

    public static Optional<String> pardon(MessageContext context) {
        return getHello(context).isPresent() ? getHello(context) : getGoodbye(context);
    }
}
