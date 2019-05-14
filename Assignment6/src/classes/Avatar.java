package classes;
/**
 * Abstract superclass for Avatar hierarchy
 * @author Tunde Forrest
 */

public abstract class Avatar {
    protected String name;


    /**
     * Null constructor for Avatar class
     */
    public Avatar() {
        this("");
    }
    /**
     * Initializes Avatar data
     */
    public Avatar(String aName) {
        this.name = aName;
    }

    /**
     * Returns name of Avatar
     *
     */
    public final String getName() {
        return name;
    }

    /**
     * Returns strength of Avatar
     */
    public abstract int getStrength();

    /**
     * Returns points of Avatar
     */
    public abstract int getPoints();

    /**
     * Reduces the Avatar strength
     */
    public abstract void losesStrength(int pts);

    /**
     * Increases the Avatar strength
     */
    public abstract void gainsStrength(int pts) ;


}
