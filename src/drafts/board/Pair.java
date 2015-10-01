package drafts.board;

/**
 * Created by Dima on 23.09.2015.
 */
public class Pair {
    public int first;
    public int second;

    public Pair (int first, int second){
        this.first = first;
        this.second = second;
    }

    public String toString(){
        return "first: " + first + ", second: " + second;
    }
}
