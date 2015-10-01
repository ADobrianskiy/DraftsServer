import drafts.PlayerType;
import drafts.board.Board;
import drafts.board.Move;
import drafts.board.MovesGetter;

import java.util.List;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public class Main {
    public static void main(String... args){
        Board board = new Board();
        System.out.println(board);

        MovesGetter mg = new MovesGetter(PlayerType.WHITE_PLAYER, board);
        List<Move> moves = mg.getAllMoves();

        for(Move m: moves){
            Board b = new Board(board);
            System.out.println(b.move(m));
        }
    }
}
