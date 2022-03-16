public class Airport {
    private final int MAX_FLIGHTS = 200;
    private final int MIN = 0;
    private Flight[] _flightSchedule;
    private int _noOfFlights;
    private String _city;

    /**
     * This method creates a new Airport object.
     * Sets the number of flights to zero and initializes the flights array to 200(MAX_FLIGHTS).
     * @param city The city of the airport.
     */
    public Airport(String city){
        this._city = city;
        this._flightSchedule = new Flight[MAX_FLIGHTS];
        this._noOfFlights = MIN;
    }

    /**
     * @return The number of flights.
     */
    public int getNumberOfFlights() { return this._noOfFlights; }

    /**
     * Sets a new number of flights to the object.
     * @param noOfFlights An int representing the new number of flights.
     */
    public void setNumberOfFlights(int noOfFlights) {
        this._noOfFlights = noOfFlights >= MIN && noOfFlights < MAX_FLIGHTS ? noOfFlights : this._noOfFlights;
    }

    /**
     * This method adds a flight to the flight scheduale array, only if there is space left.
     * If there is space left, It updates the number of flights, and sets it into the array.
     * @param f A flight object.
     * @return True if the flight has been added successfuly and False if it didin't.
     */
    public boolean addFlight(Flight f){
        // If the flights origin or destination equals to the airport city.
        if((this._city.equals(f.getOrigin()) || this._city.equals(f.getDestination()) && this._noOfFlights < MAX_FLIGHTS)){
            this._flightSchedule[this._noOfFlights] = f;
            setNumberOfFlights(this._noOfFlights + 1);
            return true;
        }
        return false;
    }


}