package skayev.WeatherInTheHomeBack.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import skayev.WeatherInTheHomeBack.bot.TelegramBot;

@Slf4j
@Configuration
@EnableScheduling
@AllArgsConstructor
public class Schedule {
    private TelegramBot telegramBot;

//    @Scheduled(fixedRate = 10000)
//    public void scheduleFixedRateTask() throws TelegramApiException {
//
//        SendMessage sendMessage = new SendMessage();
//        sendMessage.setChatId(SecretConstants.CHAT_ID);
//        sendMessage.setText("Вот это попка");
//        telegramBot.execute(sendMessage);
//
//        log.info(
//                "Fixed rate task - " + System.currentTimeMillis() / 10000);
//    }
}
