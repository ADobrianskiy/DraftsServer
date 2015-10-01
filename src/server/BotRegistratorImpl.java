package server;

import server.bot.Bot;
import server.storage.PlayerStorage;
import server.rmi.BotRegistrator;

import java.rmi.RemoteException;

public class BotRegistratorImpl implements BotRegistrator {

    @Override
    public Boolean registerBot(String name, Bot bot) throws RemoteException {
        PlayerStorage instance = PlayerStorage.getInstance();
        instance.addBot(name, bot);
        System.out.println(instance.getPlayerList());

        return true;
    }
}