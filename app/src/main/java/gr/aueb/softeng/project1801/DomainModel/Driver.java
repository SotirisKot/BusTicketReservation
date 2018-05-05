package gr.aueb.softeng.project1801.DomainModel;


public class Driver {

    private String DriverName;
    private String DriverID;
    private DriverState state = DriverState.AVAILABLE;

    /**
     *
     * Default constructor,which constructs a Driver object.
     */
    public Driver() { }

    /**
     *
     * Constructor.
     * @param driverName (required) driver Name of the driver.
     * @param driverID (required) driver ID of the driver.
     */
    public Driver(String driverName, String driverID) {
        DriverName = driverName;
        DriverID = driverID;
    }

    /** @return DriverName passed to the constructor.  */
    public String getDriverName() {
        return DriverName;
    }

    /**
     *
     * @param driverName driver Name to set
     */
    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    /** @return DriverID passed to the constructor.  */
    public String getDriverID() {
        return DriverID;
    }

    /**
     *
     * @param driverID driver ID to set
     */
    public void setDriverID(String driverID) {
        DriverID = driverID;
    }

    /** @return current State of the bus */
    public DriverState getState() {
        return state;
    }

    /**
     *
     * @param state state to set
     */
    public void setState(DriverState state) {
        this.state = state;
    }

    /** Set the current State of the bus to available*/
    public void available(){
        setState(DriverState.AVAILABLE);
    }

    /** Set the current State of the bus to unavailable*/
    public void not_available(){
        setState(DriverState.NOT_AVAILABLE);
    }

    /**
     * Comparing two objects.
     *
     * This method checks if two object are the same.
     * @param o must be an object.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (DriverName != null ? !DriverName.equals(driver.DriverName) : driver.DriverName != null)
            return false;
        return DriverID != null ? DriverID.equals(driver.DriverID) : driver.DriverID == null;
    }

    /**
     * Getting the hashCode of an object.
     *
     * This method checks if two object has the same hasCode.
     * If the method equals returned "true" the hasCode of the two objects must be the same.
     * If the method equals returned "false" the hasCode of the two objects must not be the same.
     */
    @Override
    public int hashCode() {
        int result = DriverName != null ? DriverName.hashCode() : 0;
        result = 13 * result + (DriverID != null ? DriverID.hashCode() : 0);
        return result;
    }
}
