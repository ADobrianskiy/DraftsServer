package server.storage;

import server.bot.Bot;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public class PlayerStorage {
    private Map<String, Bot> bots = new HashMap<String, Bot>();
    private static PlayerStorage instance = new PlayerStorage();
    private PlayerStorage(){

    }

    public static PlayerStorage getInstance(){
        return instance;
    }

    public Bot getBot(String name) {
        return bots.get(name);
    }
    public Bot addBot(String name, Bot bot) {
        return bots.put(name, bot);
    }

    public String getPlayerList() {
        String res = "";
        Set<String> names = bots.keySet();
        for(String name: names){
            res += name + " ";
        }
        return res;
    }
}
