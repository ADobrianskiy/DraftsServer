package server.bot;

import drafts.board.Board;
import drafts.board.Move;

import java.util.List;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public interface Bot {

    public List<Move> getMove(Board board);
}
