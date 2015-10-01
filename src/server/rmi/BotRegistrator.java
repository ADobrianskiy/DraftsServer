package server.rmi;

import server.bot.Bot;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public interface BotRegistrator extends Remote {
    Boolean registerBot(String name, Bot bot) throws RemoteException;
}

