package movement;

/**
 * @version 1.1
 */

public class AngleCalculator
{
    private double getDistance(Pair A, Pair B)
    {
        return Math.sqrt(Math.pow(A.getX() - B.getX(), 2) + Math.pow(A.getY() - B.getY(), 2));
    }

    public double getAngle(Pair A, Pair B, Pair C)
    {
    	double distAB = this.getDistance(A, B);
    	double distAC = this.getDistance(A, C);
    	double distBC = this.getDistance(B, C);
    	double angle = Math.acos((Math.pow(distAC,2) + Math.pow(distBC,2) - Math.pow(distAB,2))/(2*distAC*distBC));
    	
        return Math.round(Math.toDegrees(angle)*10)/10.0;
    }
  
}
