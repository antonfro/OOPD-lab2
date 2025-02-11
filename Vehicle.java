import java.awt.*;

public abstract class Vehicle implements Movable{
    private int nrDoors;
    private Color color;
    private int enginePower;
    private String modelName;
    protected double currentSpeed;
    private double x;
    private double y;

    private int currentDir;
    final private Direction[] directions = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

    public Vehicle(int nrDoors, Color color, int engPow, String mdlName) {
        this.nrDoors = nrDoors;
        this.enginePower = engPow;
        this.color = color;
        this.modelName = mdlName;
        stopEngine();
        this.currentDir = 0; // 0 is north
    }

    public double getX(){return x;}

    public double getY(){return y;}

    public enum Direction{SOUTH, WEST, NORTH, EAST}

    public Direction getTowards() {return directions[currentDir];}

    public double getSpeedFactor(){return speedFactor();}

    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower(){
        return enginePower;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    public void startEngine(){
        currentSpeed = 0.1;
    }

    public void stopEngine(){ currentSpeed = 0;}

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - getSpeedFactor() * amount, 0);
    }

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + getSpeedFactor() * amount, getEnginePower());
    }

    protected double speedFactor(){
        return getEnginePower() * 0.01;
    }

    public void gas(double amount){
        if (amount >= 0 && amount <= 1) // Är det en OK ökning.
            incrementSpeed(amount);
        else {
            throw new IllegalArgumentException("Värdet ligger inte mellan 0-1");
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        else {
            throw new IllegalArgumentException("Värdet ligger inte mellan 0-1");
        }
    }

    @Override
    public void move() {
        switch (getTowards()) {
            case SOUTH:
                this.y -= getCurrentSpeed();
                break;
            case WEST:
                this.x -= getCurrentSpeed();
                break;
            case NORTH:
                this.y += getCurrentSpeed();
                break;
            case EAST:
                this.x += getCurrentSpeed();
                break;
        }
    }

    @Override
    public void turnLeft(){
        currentDir = (currentDir - 1) % 4;
    }

    @Override
    public void turnRight(){
        currentDir = (1 + currentDir) % 4;
    }

}
