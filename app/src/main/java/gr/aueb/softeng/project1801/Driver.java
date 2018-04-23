package gr.aueb.softeng.project1801;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Driver {

    private String DriverName;
    private String DriverID;
    private DriverState state = DriverState.AVAILABLE;

    public Driver(String driverName, String driverID) {
        DriverName = driverName;
        DriverID = driverID;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String driverName) {
        DriverName = driverName;
    }

    public String getDriverID() {
        return DriverID;
    }

    public void setDriverID(String driverID) {
        DriverID = driverID;
    }

    public DriverState getState() {
        return state;
    }

    public void setState(DriverState state) {
        this.state = state;
    }

    public void available(){
        setState(DriverState.AVAILABLE);
    }

    public void not_available(){
        setState(DriverState.NOT_AVAILABLE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Driver driver = (Driver) o;

        if (DriverName != null ? !DriverName.equals(driver.DriverName) : driver.DriverName != null)
            return false;
        return DriverID != null ? DriverID.equals(driver.DriverID) : driver.DriverID == null;
    }

    @Override
    public int hashCode() {
        int result = DriverName != null ? DriverName.hashCode() : 0;
        result = 13 * result + (DriverID != null ? DriverID.hashCode() : 0);
        return result;
    }
}
