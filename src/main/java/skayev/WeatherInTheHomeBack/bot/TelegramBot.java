package skayev.WeatherInTheHomeBack.bot;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import skayev.WeatherInTheHomeBack.config.SecretConstants;

@Component
public class TelegramBot extends DefaultAbsSender {

    public TelegramBot() {
        super(new DefaultBotOptions());
    }


    @Override
    public String getBotToken() {
        return SecretConstants.TELEGRAM_TOKEN;
    }
}
