package gr.aueb.softeng.project1801;

public class Bus {

    private String BusType;
    private String ModelType;
    private String BusID;
    private int BusSeats;
    private BusState state = BusState.AVAILABLE;

    /**
     *
     * Default constructor,which construct a Bus object.
     */
    public Bus() { }

    /**
     *
     * Constructor.
     * @param busType (required) type of the bus.
     * @param modelType (required) model of the bus.
     * @param busID (required) ID of the bus.
     * @param busSeats (required) numbers of seats of the bus.
     */
    public Bus(String busType, String modelType, String busID, int busSeats) {
        BusType = busType;
        ModelType = modelType;
        BusID = busID;
        BusSeats = busSeats;
    }

   /** @return BusType passed to the constructor.  */
    public String getBusType() {
        return BusType;
    }

    /**
     *
     * @param busType bus Type to set
     */
    public void setBusType(String busType) {
        BusType = busType;
    }

    /** @return  ModelType passed to the constructor.  */
    public String getModelType() {
        return ModelType;
    }

    /**
     *
     * @param modelType model Type to set
     */
    public void setModelType(String modelType) {
        ModelType = modelType;
    }

    /** @return BusID passed to the constructor.  */
    public String getBusID() {
        return BusID;
    }

    /**
     *
     * @param busID bus ID to set
     */
    public void setBusID(String busID) {
        BusID = busID;
    }

    /** @return BusSeats passed to the constructor.  */
    public int getBusSeats() {
        return BusSeats;
    }

    /**
     *
     * @param busSeats bus Seats to set
     */
    public void setBusSeats(int busSeats) {
        BusSeats = busSeats;
    }

    /** @return current State of the bus */
    public BusState getState() {
        return state;
    }

    /**
     *
     * @param state state to set
     */
    public void setState(BusState state) {
        this.state = state;
    }

    /** Set the current State of the bus to available*/
    public void available() {
        setState(BusState.AVAILABLE);
    }

    /** Set the current State of the bus to unavailable*/
    public void not_available(){
        setState(BusState.NOT_AVAILABLE);
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

        Bus bus = (Bus) o;

        if (BusSeats != bus.BusSeats) return false;
        if (BusType != null ? !BusType.equals(bus.BusType) : bus.BusType != null) return false;
        if (ModelType != null ? !ModelType.equals(bus.ModelType) : bus.ModelType != null)
            return false;
        return BusID != null ? BusID.equals(bus.BusID) : bus.BusID == null;
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
        int result = BusType != null ? BusType.hashCode() : 0;
        result = 13 * result + (ModelType != null ? ModelType.hashCode() : 0);
        result = 13 * result + (BusID != null ? BusID.hashCode() : 0);
        result = 13 * result + BusSeats;
        return result;
    }
}
