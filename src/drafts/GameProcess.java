package drafts;

import drafts.board.Board;
import drafts.board.GameElement;
import drafts.board.GameState;
import server.bot.Bot;

/**
 * Created by adobrianskiy on 22.09.15.
 */
public class GameProcess {

    private Board board;
    private Bot white;
    private Bot black;

    private GameState gameState;

    public GameProcess(Bot white, Bot black){
        board = new Board();
        this.white = white;
        this.black = black;
        startGame();
    }

    private void startGame() {
//        while(getState(board) != GameState.PLAYING){
/*        while (!isFinished()){
            Move white_turn = white.getTurn(board);
            board.makeTurn(white_turn);
            if(getState(board) != GameState.PLAYING){
                return;
            }
            Move black_turn = black.getTurn(board);
            board.makeTurn(black_turn);
        }
        */
    }

    private GameState getGameState(Board board) {
        boolean possible_white = false;
        boolean possible_black = false;

        GameState state;
        for(int i = 0; i < 7; i++){
            for(int j = 0; j < 7; j++){
                GameElement e = board.getElement(i, j);
                switch (e){
                    case WHITE:
                        if(checkWhite(i, j)){
                            possible_white = true;
                        }
                        break;
                    case BLACK:
                        if(checkBlack(i, j)){
                            possible_black = true;
                        }
                        break;
                    case WHITE_EXTENDED:
                        if(checkWhiteExtended(i, j)){
                            possible_white = true;
                        }
                        break;
                    case BLACK_EXTENDED:
                        if(checkBlackExtended(i, j)){
                            possible_black = true;
                        }
                        break;
                }
            }
        }
         /*
        * STATE ????
        * */
        return null;
    }


    private boolean checkBlackExtended(int i, int j) {
        if(board.getElement(i,j) != GameElement.BLACK_EXTENDED){
            return false;
        }
        /*
        * Method body here
        * */
        return false;
    }

    private boolean checkWhiteExtended(int i, int j) {
        if(board.getElement(i,j) != GameElement.WHITE_EXTENDED){
            return false;
        }
         /*
        * Method body here
        * */
        return false;
    }

    private boolean checkBlack(int i, int j) {
        if(board.getElement(i,j) != GameElement.BLACK){
            return false;
        }
         /*
        * Method body here
        * */
        return false;
    }

    private boolean checkWhite(int i, int j) {
        if(board.getElement(i,j) != GameElement.WHITE){
            return false;
        }
         /*
        * Method body here
        * */
        return false;
    }
}
