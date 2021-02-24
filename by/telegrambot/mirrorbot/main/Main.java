package by.telegrambot.mirrorbot.main;

import java.util.Map;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import by.telegrambot.mirrorbot.entity.Bot;

public class Main {
	private static final Map<String, String> getEnv = System.getenv();

	public static void main(String[] args) {

		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(new Bot(getEnv.get("BOT_NAME"), getEnv.get("BOT_TOKEN")));
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}

}
