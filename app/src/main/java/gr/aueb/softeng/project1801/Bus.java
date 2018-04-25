package gr.aueb.softeng.project1801;

/**
 * Created by George Chatzopoulos on 04/22/2018.
 */

public class Bus {

    private String BusType;
    private String ModelType;
    private String BusID;
    private int BusSeats;
    private BusState state = BusState.AVAILABLE;

    public Bus() { }

    public Bus(String bysType, String modelType, String busID, int busSeats) {
        BusType = bysType;
        ModelType = modelType;
        BusID = busID;
        BusSeats = busSeats;
    }

    public String getBusType() {
        return BusType;
    }

    public void setBusType(String busType) {
        BusType = busType;
    }

    public String getModelType() {
        return ModelType;
    }

    public void setModelType(String modelType) {
        ModelType = modelType;
    }

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String busID) {
        BusID = busID;
    }

    public int getBusSeats() {
        return BusSeats;
    }

    public void setBusSeats(int busSeats) {
        BusSeats = busSeats;
    }

    public BusState getState() {
        return state;
    }

    public void setState(BusState state) {
        this.state = state;
    }

    public void available() {
        setState(BusState.AVAILABLE);
    }

    public void not_available(){
        setState(BusState.NOT_AVAILABLE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bus bus = (Bus) o;

        if (BusSeats != bus.BusSeats) return false;
        if (BusType != null ? !BusType.equals(bus.BusType) : bus.BusType != null) return false;
        if (ModelType != null ? !ModelType.equals(bus.ModelType) : bus.ModelType != null)
            return false;
        return BusID != null ? BusID.equals(bus.BusID) : bus.BusID == null;
    }

    @Override
    public int hashCode() {
        int result = BusType != null ? BusType.hashCode() : 0;
        result = 13 * result + (ModelType != null ? ModelType.hashCode() : 0);
        result = 13 * result + (BusID != null ? BusID.hashCode() : 0);
        result = 13 * result + BusSeats;
        return result;
    }
}
