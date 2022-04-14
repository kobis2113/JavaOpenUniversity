/**
 * This class represents a Flight object.
 * It has many properties of a basic flight and some consts.
 * @author Kobi Shabaton
 * @version 2022a
 */
public class Flight {
    private String _origin;
    private String _destination;
    private Time1 _departure;
    private int _flightDuration;
    private int _noOfPassengers;
    private boolean _isFull;
    private int _price;
    private final int MAX_CAPACITY = 250;
    private final int MIN = 0;

    /**
     * A constructor that creates a Flight object.
     * @param origin The place where the flight departs.
     * @param destination The place that the flight lands.
     * @param hour The hour of the fight.
     * @param minute The minute of the flight.
     * @param flightDuration The length of the flight in minutes.
     * @param noOfPassengers The number of passengers on the flight.
     * @param price The price of a flight ticket.
     */
    public Flight(String origin, String destination, int hour, int minute, int flightDuration, int noOfPassengers, int price) {
        this._origin = origin;
        this._destination = destination;
        this._departure = new Time1(hour, minute);
        this._flightDuration = flightDuration < MIN ? MIN : flightDuration;
        if(noOfPassengers < MIN) this._noOfPassengers = MIN;
        else this._noOfPassengers = noOfPassengers > MAX_CAPACITY ? MAX_CAPACITY : noOfPassengers;
        this._isFull = this._noOfPassengers == MAX_CAPACITY;
        this._price = price < MIN ? MIN : price;
    }

    /**
     * A copy constructor that gets an other flight it copies it.
     * @param other The new copied Flight object.
     */
    public Flight(Flight other) {
        this._origin = other._origin;
        this._destination = other._destination;
        this._departure = other._departure;
        this._flightDuration = other._flightDuration;
        this._noOfPassengers = other._noOfPassengers;
        this._isFull = other._isFull;
        this._price = other._price;
    }

    /**
     * @return The origin of the flight.
     */
    public String getOrigin() { return this._origin; }

    /**
     * Sets a new origin to the object.
     * @param origin The name of the new origin to be set.
     */
    public void setOrigin(String origin) { this._origin = origin; }

    /**
     * @return The destination of the flight.
     */
    public String getDestination() { return this._destination; }

    /**
     * Sets a new destination to the object.
     * @param destination The name of the new destination to be set.
     */
    public void setDestination(String destination) { this._destination = destination; }

    /**
     * @return The departure of the flight in Time1 object.
     */
    public Time1 getDeparture() { return this._departure; }

    /**
     * Sets a new departure to the object.
     * @param departure A Time1 object representing the new time of the departure.
     */
    public void setDeparture(Time1 departure) { this._departure = departure; }

    /**
     * @return The flight duration of the flight.
     */
    public int getFlightDuration() { return this._flightDuration; }

    /**
     * Sets a new flight duration to the object.
     * @param flightDuration An int representing the new length of the flight in minutes.
     */
    public void setFlightDuration(int flightDuration) {
        this._flightDuration = flightDuration >= MIN ? flightDuration : this._flightDuration;
    }

    /**
     * @return The number of passengers in the flight.
     */
    public int getNoOfPassengers() { return this._noOfPassengers; }

    /**
     * Sets a new number of passengers in the flight.
     * @param noOfPassengers An int representing the new number of passengers in the flight.
     */
    public void setNoOfPassengers(int noOfPassengers) {
        if(noOfPassengers < MIN) this._noOfPassengers = MIN;
        else if(noOfPassengers >= MAX_CAPACITY){
            this._noOfPassengers = MAX_CAPACITY;
            setIsFull(true);
        }
        else{
            this._noOfPassengers = noOfPassengers;
            setIsFull(false);
        }
    }

    /**
     * @return Boolean representing if the flight is full or not.
     */
    public boolean getIsFull() { return this._isFull; }

    /**
     * Sets a boolean representing if the flight is full or not.
     * @param isFull Boolean representing if the flight is full or not.
     */
    public void setIsFull(boolean isFull) { this._isFull = isFull; }

    /**
     * @return The price of a flight ticket.
     */
    public int getPrice() { return this._price; }

    /**
     * Sets a new price of a flight ticket.
     * @param price An int representing the new flight ticket.
     */
    public void setPrice(int price) { this._price = price < MIN ? MIN : price; }

    /**
     * @return The max capacity of a flight.
     */
    public int getMaxCapacity() { return MAX_CAPACITY; }

    /**
     * This methods checks whether two Flight objects are equal.
     * @param other The other Flight object to be compared.
     * @return True if they are equal and false if they are not.
     */
    public boolean equals(Flight other){
        return this._origin.equals(other._origin)
                && this._destination.equals(other._destination)
                && this._departure.equals(other._departure);
    }

    /**
     * This method calculates the landing time of the flight.
     * @return A Time1 object represeting the flights landing time.
     */
    public Time1 getArrivalTime(){
        return _departure.addMinutes(this._flightDuration);
    }

    /**
     * This method adds passengers to the flight if there's space left.
     * If the flight is getting full after the addition it sets the isFull field
     * to true, and updates the noOfPassengers field.
     * @param num The number of passengers to add.
     * @return If there's no space left it returns false.
     */
    public boolean addPassengers(int num){
        // Calculating the total number of passengers after the addition.
        int newCount = this._noOfPassengers + num;
        if(newCount > MAX_CAPACITY) return false;
        else if(newCount == MAX_CAPACITY){
            setIsFull(true);
        }
        setNoOfPassengers(newCount);
        return true;
    }

    /**
     * Checks whether a flight is cheaper then an other.
     * @param other The other Flight object to be compared.
     * @return True if the flight is cheaper then the other and false if it doesn't.
     */
    public boolean isCheaper(Flight other){
        return this._price < other._price;
    }

    /**
     * Calculates the total price of all the tickets in the flights.
     * @return The total price of a flight.
     */
    public int totalPrice(){
        return this._noOfPassengers * this._price;
    }

    /**
     * Checks whether a flight is earlier then an other.
     * @param other The other Flight object to be compared.
     * @return True if the flight is earlier then the other and false if it doesn't.
     */
    public boolean landsEarlier(Flight other){
        return this.getArrivalTime().before(other.getArrivalTime());
    }

    /**
     * Creates a string of the flights data from the flight object.
     * @return A string rep
     */
    public String toString(){
        return "Flight from " + this._origin + " to " + this._destination + " departs at " + this._departure.toString()+
                (this._isFull ? ". Flight is full." : ". Flight is not full.");
    }
}
