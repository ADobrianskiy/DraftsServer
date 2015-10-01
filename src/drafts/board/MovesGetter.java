package drafts.board;

import drafts.PlayerType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adobrianskiy on 29.09.15.
 */
public class MovesGetter {
    private Pair black_1_vector = new Pair(1, 1);
    private Pair black_2_vector = new Pair(1, -1);
    private Pair white_1_vector = new Pair(-1, -1);
    private Pair white_2_vector = new Pair(-1, 1);

    private PlayerType player;
    private Board board;

    public MovesGetter(PlayerType player, Board board){
        this.player = player;
        this.board = board;
    }

    public List<Move>getAllMoves() {
        List<Move> possibleMoves = new ArrayList<Move>();
        int size = board.getSize();


        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                GameElement currentElement = board.getElement(i,j);
                if(currentElement != GameElement.NONE){
                    //possibleMoves.addAll(getHitsForChecker(player, board, new Pair(i, j)));
                }
            }
        }
        // return moves if there is at least one possible hit
        if(!possibleMoves.isEmpty()) {
            return possibleMoves;
        }

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                GameElement currentElement = board.getElement(i,j);
                if(currentElement != GameElement.NONE){
                    if(isPlayerChecker(currentElement)) {
                        possibleMoves.addAll(getSimpleMovesForChecker(new Pair(i, j)));
                    }
                }
            }
        }
        return possibleMoves;
    }

    private boolean isPlayerChecker(GameElement currentElement) {
        if((currentElement == GameElement.BLACK || currentElement == GameElement.BLACK_EXTENDED) &&
                player == PlayerType.BLACK_PLAYER){
            return true;
        }

        if((currentElement == GameElement.WHITE || currentElement == GameElement.WHITE_EXTENDED) &&
                        player == PlayerType.WHITE_PLAYER){
            return true;
        }

        return false;
    }

    private List<Move> getSimpleMovesForChecker(Pair position) {

        List<Move> possibleMoves = new ArrayList<Move>();

        int i = position.first;
        int j = position.second;
        GameElement currentElement = board.getElement(i,j);
        if(currentElement == GameElement.BLACK){
            addIfNotNull(possibleMoves, getMoveForVector(position, black_1_vector));
            addIfNotNull(possibleMoves, getMoveForVector(position, black_2_vector));
        } else if(currentElement == GameElement.WHITE){
            addIfNotNull(possibleMoves, getMoveForVector(position, white_1_vector));
            addIfNotNull(possibleMoves, getMoveForVector(position, white_2_vector));
        } else if(currentElement != GameElement.NONE){
            possibleMoves.addAll(getMovesForExtendedChecker(new Pair(i, j)));
        }
        return possibleMoves;
    }

    private boolean addIfNotNull(List<Move> list, Move move){
        if(move != null){
            list.add(move);
            return true;
        } else {
            return false;
        }
    }

    private List<Move> getMovesForExtendedChecker(Pair position) {
        List<Move> res = new ArrayList<Move>();

        List<Pair> directions = new ArrayList<Pair>();
        directions.add(black_1_vector);
        directions.add(black_2_vector);
        directions.add(white_1_vector);
        directions.add(white_2_vector);

        for(Pair direction: directions){
            int multiplier = 1;

            Boolean isPossibleMove;
            do{
                Pair from = position;
                Pair currentDirection = new Pair(direction.first * multiplier, direction.second * multiplier);
                isPossibleMove = isPossibleMoveForDirection(from, currentDirection);
                multiplier++;
                if (isPossibleMove) {
                    res.add(getMoveForVector(from, currentDirection));
                }
            } while(isPossibleMove);
        }

        return res;
    }

    private Move getMoveForVector(Pair from, Pair direction) {
        if (isPossibleMoveForDirection(from, direction)) {
            Pair to = getToPositionForDirection(from, direction);
            Move move = new Move(player, from, to);
            return move;
        } else {
            return null;
        }
    }

    private Pair getToPositionForDirection(Pair from, Pair direction) {
        return new Pair(from.first + direction.first , from.second + direction.second);
    }


    private Boolean isPossibleMoveForDirection(Pair from, Pair direction){

        if(from.first + direction.first < 0 || from.first + direction.first >= board.getSize()){
            return false;
        }

        if(from.second + direction.second < 0 || from.second + direction.second >= board.getSize()){
            return false;
        }


        Pair to = getToPositionForDirection(from, direction);

        if(board.getElement(to.first, to.second) != GameElement.NONE){
            return false;
        }

        return true;
    }
}
