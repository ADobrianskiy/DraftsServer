package client;

import client.bot.CustomBot;
import server.rmi.BotRegistrator;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public class Main {
    public static void main (String... args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 2099);
        BotRegistrator service = (BotRegistrator) registry.lookup("BotRegistrator");
        service.registerBot("Main", new CustomBot());
    }
}
