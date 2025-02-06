import java.awt.*;

public class Scania extends Truck {
    private double trailerAngle = 0;


    public Scania(int doors, Color colr, int engPow, String mdlName) {
        super(doors, colr, engPow, mdlName);
    }


    public void incrementTrailer(double amount) {
        if (getCurrentSpeed() == 0 && amount >= 0) {
            if (trailerAngle + amount > 70) {
                trailerAngle = 70;
            } else {
                trailerAngle += amount;
            }
        }
    }


    public void decrementTrailer(double amount) {
            if (getCurrentSpeed() == 0 && amount >= 0) {
                trailerAngle -= amount;
            }
    }


}
