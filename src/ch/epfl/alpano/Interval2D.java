package ch.epfl.alpano;

import java.util.Objects;

public final class Interval2D 
{
    private Interval1D iX,iY;
    
    /**
     * Creates the cartesian product of two uni-dimensional intervals
     * @param iX the first interval
     * @param iY the second interval
     * @throws throws NullPointerException id either iX or iY are null
     */
    Interval2D(Interval1D iX, Interval1D iY)
    {
        if(iX==null||iY==null)throw new NullPointerException();
        this.iX=iX;
        this.iY=iY;        
    }
    
    /**
     *  Returns the first uni-dimensional interval
     * @return the first interval
     */
    public Interval1D iX()
    {
        return iX;
    }
    
    /**
     Returns the second uni-dimensional interval
     * @return the second interval

     */
    public Interval1D iY()
    {
        return iY;
    }
    
    /**
     * Checks if the bi-dimensional interval contains the pair (x,y)
     * @param x the first element to be checked
     * @param y the second element to be checked
     * @return true if the pair is contained in the bi-dimensional interval contains the pair (x,y)
     */
    public boolean contains(int x, int y)
    {
        return (iX().contains(x)&&iY().contains(y));
    }
    /**
     * Returns the size of the bi-dimensional interval
     * @return the size of the bi-dimensional interval
     */
    public int size()//ok?
    {
        return iX().size()+iY().size();
    }
    
    /**
     *  Checks if two bi-dimenional intervals are unionable
     * @param that the second bi-dimensional interval
     * @return true if the two bi-dimenional intervals are unionable
     */
    public boolean isUnionableWith(Interval2D that)
    {
        return (this.iX.isUnionableWith(that.iX())&&this.iY().isUnionableWith(that.iY()));
    }
    
    /**
     * Calculates the size of a intersection between two bi-dimensional intervals
     * @param that the second  bi-dimensional interval
     * @return the size of a intersection between two bi-dimensional intervals
     */
    public int sizeOfIntersectionWith(Interval2D that)
    {
        return this.iX().sizeOfIntersectionWith(that.iX())+this.iY().sizeOfIntersectionWith(that.iY());
    }
    
    /**
     * Unites inclusively (englobante) two bi-dimensional intervals into one
     * @param that that the second bi-dimensional interval
     * @return a new bi-dimensional interval that unites two bi-dimensional intervals into one
     */
    public Interval2D boundingUnion(Interval2D that)
    {
        return new Interval2D(this.iX().boundingUnion(that.iX()), this.iY().boundingUnion(that.iY()));
    }
    
    /**
     * Unites two bi-dimensional intervals into one
     * @param that that that the second bi-dimensional interval
     * @return a new bi-dimensional interval that unites two bi-dimensional intervals into one
     * @throws throws IllegalArgumentException if either of the two pairs of uni-dimensional intervals 
     *         that compose the two bi-dimensional intervals are not unionizable
     */
    public Interval2D union(Interval2D that)
    {
        return new Interval2D(this.iX().union(that.iX()), this.iY().union(that.iY()));
    }
    
    ///comments\/
    @Override
    public boolean equals(Object thatO)
    {
        if(thatO==null)return false;
        if(thatO.getClass()!=this.getClass())return false;
        
        Interval2D that= (Interval2D)thatO;
        if(this.hashCode()!=that.hashCode()) return false;
        
        return (this.iX().equals(that.iX())&&this.iY().equals(that.iY()));
    }
    
    @Override
    public String toString()
    {
        return this.iX().toString()+"x"+this.iY().toString();
    }
    
    @Override//OK?
    public int hashCode() {
      return Objects.hash(this.iX(), this.iY());
    }

}