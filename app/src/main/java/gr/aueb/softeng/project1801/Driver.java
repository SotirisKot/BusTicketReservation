package gr.aueb.softeng.project1801;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Driver {

    private String DriverName;
    private String DriverID;

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
