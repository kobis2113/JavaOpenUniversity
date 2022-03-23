package Maman13;

import Maman12.Flight;
import Maman12.Time1;

import java.util.HashMap;
/**
 * This class represents an Airport object.
 * It has many properties of an airport.
 * @author Kobi Shabaton
 * @version 2022a
 */
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

    /**
     * This method removes a flight from the flights array.
     * @param f The flight that will be deleted.
     * @return True if the flight was removed successfully and false if its not.
     */
    public boolean removeFlight(Flight f){
        // Looping over the array
        for (int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++) {
            // Finding that flight we want to remove
            if(f.equals(this._flightSchedule[flightIndex])){
                // Trying to remove it by our private function
                if(removeFlightByIndex(flightIndex)){
                    // Setting the number of flights to be the same but -1.
                    setNumberOfFlights(this._noOfFlights -1);
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    /**
     * This method removes an element from the flights array by a given index,
     * and shifts all the element from that position to prevent a hole in the array.
     * @param index The index of the variable to be removed.
     * @return True if the flight was removed successfully and false if its not.
     */
    private boolean removeFlightByIndex(int index){
        if(index > MIN && index < MAX_FLIGHTS) {
            // Removing the flight in the given index
            this._flightSchedule[index] = null;

            // Going over the array and shifting all the elements from the index one left
            for (int flightIndex = index + 1; flightIndex < this._noOfFlights; flightIndex++) {
                this._flightSchedule[flightIndex - 1] = this._flightSchedule[flightIndex];
            }
            // Setting the last variable to be null instead of the one we removed
            this._flightSchedule[this._noOfFlights - 1] = null;
            return true;
        }
        return false;
    }

    /**
     * This methods gets a place and returns the first flight with the given place.
     * @param place A string representing a name of a place.
     * @return The first flight with the given place as origin and null if there's no such flight.
     */
    public Time1 firstFlightFromOrigin (String place){
        for(int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++){
            if(this._flightSchedule[flightIndex].getOrigin().equals(this._city))
                return this._flightSchedule[flightIndex].getDeparture();
        }
        return null;
    }

    /**
     * This method returns the number of all the full flights from the flights array.
     * @return The number of all the full flights in the flights array.
     */
    public int howManyFullFlights(){
        int fullFlightsCounter = MIN;
        for(int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++){
            if(this._flightSchedule[flightIndex].getIsFull())
                fullFlightsCounter ++;
        }
        return fullFlightsCounter;
    }

    /**
     * This method return the number of all flights that departs or lands in the given city.
     * @param city The city that the flight is departs or lands in.
     * @return The number of af all flights that departs or lands in the given city.
     */
    public int howManyFlightsBetween(String city){
        int flightsCounter = MIN;
        for(int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++){
            if(this._flightSchedule[flightIndex].getOrigin().equals(city) ||
                    this._flightSchedule[flightIndex].getDestination().equals(city))
                flightsCounter ++;
        }
        return flightsCounter;
    }

    /**
     * This method gets the name of the most popular destination.
     * It goes over the fights array and creates a Hash map which each element is the name of
     * the destination and the amount of its occurrences in the flights array.
     * @return The name of the most popular destination.
     */
    public String mostPopularDestination(){
        HashMap<String, Integer> flightAmountPerCity = new HashMap<String, Integer>();
        String mostPopularDestination = null;
        int maxMostPopularDestinationCount = MIN;
        // Iterates over the flights array and sets for all flights its count
        for(int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++){
            // Getting the flight's destination
            String flightDestination = this._flightSchedule[flightIndex].getDestination();
            // Getting the values of the destination in the Hash map
            Integer destinationAmount = flightAmountPerCity.get(flightDestination);
            // Updating the count of occurrences of the flight.
            flightAmountPerCity.put(flightDestination, destinationAmount!=null ? destinationAmount+1 : 1);

            // Checking whether a number of the destination occurrences is the max
            if(flightAmountPerCity.get(flightDestination) > maxMostPopularDestinationCount){
                maxMostPopularDestinationCount = flightAmountPerCity.get(flightDestination);
                mostPopularDestination = flightDestination;
            }
        }
        return mostPopularDestination;
    }

    /**
     * This method goes over the flight schedule and gets the most expensive flight ticket
     * @return The flight with the most expensive ticket or null
     */
    public Flight mostExpensiveTicket(){
        if(this._noOfFlights == MIN)
            return null;
        Flight mostExpensiveFlight = this._flightSchedule[0];
        for(int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++){
            // Checking if the current flight's price is more expensive then the max
            if(this._flightSchedule[flightIndex].getPrice() > mostExpensiveFlight.getPrice())
                mostExpensiveFlight = this._flightSchedule[flightIndex];
        }
        return mostExpensiveFlight;
    }

    /**
     * This method goes over the flight schedule and gets the flight wth the longest flight duration
     * @return The flight with the longest flight duration or null
     */
    public Flight longestFlight(){
        if(this._noOfFlights == MIN)
            return null;
        Flight longestFlight = this._flightSchedule[MIN];
        for(int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++){
            // Checking if the current flight's price is more expensive then the max
            if(this._flightSchedule[flightIndex].getFlightDuration() > longestFlight.getFlightDuration())
                longestFlight = this._flightSchedule[flightIndex];
        }
        return longestFlight;
    }

    /**
     * This method prints all the information of the flight
     * @return A sring repres
     */
    public String toString(){
        if(this._noOfFlights == MIN)
            return null;
        String airportInformation = "The flights for airport " + this._city + " today are: \n";
        for(int flightIndex = MIN; flightIndex < this._noOfFlights; flightIndex++) {
            airportInformation = airportInformation.concat(this._flightSchedule[flightIndex] + "\n");
        }
        return airportInformation;

    }
}