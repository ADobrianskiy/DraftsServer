package client.bot;

import drafts.board.Board;
import drafts.board.Move;
import server.bot.Bot;

import java.io.Serializable;
import java.util.List;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public class CustomBot implements Bot, Serializable {

    @Override
    public List<Move> getMove(Board board) {
        return null;
    }
}
