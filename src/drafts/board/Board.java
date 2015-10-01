package drafts.board;

import java.util.List;

/**
 * Created by adobrianskiy on 22.09.15.
 */

public class Board {
    private GameElement[][] elements;
    private int size = 8;
    public Board(){
        elements = new GameElement[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                elements[i][j] = GameElement.NONE;
            }
        }
        initBlack();
        initWhite();
    }

    public Board(Board board) {
        elements = new GameElement[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                elements[i][j] = board.getElement(i, j);
            }
        }
    }

    private void initBlack(){
        for(int i = 0; i < size; i++){
            if(i%2 == 0){
                elements[1][i] = GameElement.BLACK;
            } else {
                elements[0][i] = GameElement.BLACK;
                elements[2][i] = GameElement.BLACK;
            }
        }
    }

    private void initWhite(){
        for(int i = 0; i < size; i++){
            if(i%2 != 0){
                elements[size - 2][i] = GameElement.WHITE;
            } else {
                elements[size - 1][i] = GameElement.WHITE;
                elements[size - 3][i] = GameElement.WHITE_EXTENDED;
            }
        }
    }

    public Board move(Move move){
        // !IMPORTANT ADD POSSIBILITY TO HIT
        // !IMPORTANT ADD POSSIBILITY TO HIT
        // !IMPORTANT ADD POSSIBILITY TO HIT
        // !IMPORTANT ADD POSSIBILITY TO HIT

        List<Pair> list = move.getSubmoves();
        Pair[] submoves = list.toArray(new Pair[list.size()]);

        for(int i = 1; i < submoves.length; i++){
            Pair from = submoves[i - 1];
            Pair to = submoves[i];

            if (elements[from.first][from.second] == GameElement.NONE ||
                    elements[to.first][to.second] != GameElement.NONE) {
                throw new RuntimeException ("BAD MOVE:" + move + "\nfor board\n" + toString());
            }

            GameElement e = elements[from.first][from.second];
            elements[from.first][from.second] = GameElement.NONE;
            elements[to.first][to.second] = e;
        }
        return this;
    }

    public GameElement getElement(int i, int j) {
        if(i < 0 || i > 7 || j < 0 || j > 7){
            return null;
        }
        return elements[i][j];
    }

    public String toString() {
        String res = "";
        for(int i = 0; i < size; i++){
            for(int j = size - 1; j >= 0; j--){
                GameElement e = getElement(i, j);
                switch (e){
                    case WHITE:
                        res += "w";
                        break;
                    case BLACK:
                        res += "b";
                        break;
                    case WHITE_EXTENDED:
                        res += "W";
                        break;
                    case BLACK_EXTENDED:
                        res += "B";
                        break;
                    case NONE:
                        res += "_";
                        break;
                }
                res += " ";
            }
            res += "\n";
        }
        return res;
    }

    public int getSize(){
        return size;
    }
}