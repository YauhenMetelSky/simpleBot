package by.telegrambot.mirrorbot.entity;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
	private final String BOT_NAME;
	private final String BOT_TOKEN;
	
	public Bot(String BOT_NAME, String BOT_TOKEN) {
		super();
		this.BOT_NAME=BOT_NAME;
		this.BOT_TOKEN=BOT_TOKEN;
	}

	@Override
	public void onUpdateReceived(Update update) {
		 if (update.hasMessage() && update.getMessage().hasText()) {
		        SendMessage message = new SendMessage();
		        message.setChatId(String.valueOf(update.getMessage().getChatId()));
		        message.setText(update.getMessage().getText());
		              
		        try {
		            execute(message); // Call method to send the message
		        } catch (TelegramApiException e) {
		            e.printStackTrace();
		        }
		    }
		
	}

	@Override
	public String getBotUsername() {
		
		return BOT_NAME;
	}

	@Override
	public String getBotToken() {
		
		return BOT_TOKEN;
	}

}
