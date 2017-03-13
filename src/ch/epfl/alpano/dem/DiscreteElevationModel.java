/**
 * DiscreteElevationModel
 * 
 * @author Andrea Scalisi (259183)
 * @author Gerald Sula (257396)
 */
package ch.epfl.alpano.dem;
import static java.lang.Math.PI;

import ch.epfl.alpano.Interval2D;

public interface DiscreteElevationModel extends AutoCloseable{
    
    static final int SAMPLES_PER_DEGREE = 3600;
    static final double SAMPLES_PER_RADIAN = 648000/PI;
    
    /**
     * Calculates the index of the given angle in radians
     * @param angle, in radians
     * @return the index of the given angle 
     */
    static double sampleIndex(double angle){
        return angle*SAMPLES_PER_RADIAN;
    }

    /**
     * Calculates and returns the area of the MNT
     * @return an interval2D that corresponds to the area of the MNT
     */
    abstract Interval2D extent();
    /**
     *  Calculate the sample of the index
     * @param x first coordinate of the index
     * @param y second coordinate of the index
     * @return the elevation sample in meters
     * @throws IllegalArgumentException if the index is not included in the MNT
     */
    abstract double elevationSample(int x, int y);
    
    /**
     * Creates an MNT, that represents the union of two DiscreteElevationModels
     * @param that the second DiscreteElevationModel used in the union
     * @return an MNT that represents the union of two DiscreteElevationModels
     */
    default DiscreteElevationModel union(DiscreteElevationModel that){
        if(!(this.extent().isUnionableWith(that.extent()))){
            throw new IllegalArgumentException();
        }
        return new CompositeDiscreteElevationModel(this, that);
        //Preconditions
        
    }
}