package by.kliosov.backend.bot;

import by.kliosov.backend.model.City;
import by.kliosov.backend.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Component
@PropertySource("classpath:telegram.properties")
public class ChatBot extends TelegramLongPollingBot {

    @Autowired
    private CityServiceImpl cityService;

    @Value("${bot.username}")
    private String botName;

    @Value("${bot.token}")
    private String botToken;

    @Override
    public String getBotToken(){
        return botToken;
    }

    @Override
    public String getBotUsername(){
        return botName;
    }

    @Override
    public void onUpdateReceived(Update update){
        if(!update.hasMessage() || !update.getMessage().hasText()) {
            return;
        }
        if("/start".equals(update.getMessage().getText())){
            sendMessage(update.getMessage().getChatId(),
                    "Welcome to this tourist bot. Enter the name of the city to get a little information about the city. To see a list of all cities, enter /cities.");
            return;
        }
        if("/cities".equals(update.getMessage().getText())){
            sendAllCity(update.getMessage().getChatId());
            return;
        }
        String text = update.getMessage().getText();
        City city = cityService.findByName(text);
        if (city == null){
            sendMessage(update.getMessage().getChatId(), "Incorrect city. Please try again");
        }
        sendMessage(update.getMessage().getChatId(), city.getDescription());
    }

    public void sendMessage(Long chatId, String text){
        SendMessage message = new SendMessage().setChatId(chatId).setText(text);
        try {
            execute(message);
        } catch (TelegramApiException e){
            e.printStackTrace();
        }

    }

    public void sendAllCity(Long chatId){
        StringBuilder sb = new StringBuilder("All cities list:\n");
        List<City> cities = cityService.findAll();
        cities.forEach(city -> sb.append(city.getName())
                                    .append("\n"));
        sendMessage(chatId, sb.toString());
    }
}
