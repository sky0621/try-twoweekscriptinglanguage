package stone;

/**
 * Created by SS on 2017/10/15.
 */
public class StoneException extends RuntimeException {
    public StoneException(String m) { super(m); }
//    public StoneException(String m, ASTree t) {
//        super(m + " " + t.location());
//    }
}
