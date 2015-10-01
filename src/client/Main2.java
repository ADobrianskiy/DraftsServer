package client;

import client.bot.CustomBot;
import server.bot.Bot;
import server.rmi.BotRegistrator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public class Main2 {
    public static void main (String... args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
        BotRegistrator service = (BotRegistrator) registry.lookup("BotRegistrator");
        Bot bot = new CustomBot();
        service.registerBot("Main2", bot);
    }
}
