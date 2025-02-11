import java.awt.*;

public class Cartransport extends Truck {

    //final private Direction[] directions = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
    final private trailerpositions[] tpos = {trailerpositions.UP, trailerpositions.DOWN};

    public Cartransport(int doors, Color colr, int engPow, String mdlName) {
        super(doors, colr, engPow, mdlName);
    }

    public enum trailerpositions {UP, DOWN};

    public trailerpositions[] getTrailerpos(){return tpos;}

    public void pickupcar() {
        if (getTrailerpos().equals(trailerpositions.DOWN)) {
            
        }
    }
}
