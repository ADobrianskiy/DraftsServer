package drafts.board;


import drafts.PlayerType;
import drafts.board.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adobrianskiy on 22.09.15.
 */
public class Move {
    private PlayerType player;
    private List<Pair> submoves = new ArrayList<Pair>();

    public Move(PlayerType player, Pair from, Pair to) {
        this.player = player;
        submoves.add(from);
        submoves.add(to);
    }

    public PlayerType getPlayer() {
        return player;
    }

    public void clearPath(){
        submoves.clear();
    }

    public void addSubmove(Pair to){
        submoves.add(to);
    }

    public List<Pair> getSubmoves(){
        return submoves;
    }

}
