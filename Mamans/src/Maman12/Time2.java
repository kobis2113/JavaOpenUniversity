package Maman12;
/**
 * This class represents a time object.
 * It has many methods which helps working with times.
 * @author Kobi Shabaton
 * @version 2MIN_TIME22a
 */
public class Time2 {
    private int _minFromMid;
    private final int MIN_TIME = 0;
    private final int MAX_MINUTES = 60;
    private final int MAX_HOURS = 24;
    private final int SINGLE_DIGIT = 10;
    private final int MINUTES_IN_DAY = 1440;

    /**
     * Creates a new Maman13.Time2 object.
     * @param h An int representing the amount of hours. Should be between 0 to 23.
     * @param m An int representing the amount of minutes. Should be between 0 to 59.
     */
    public Time2 (int h, int m){
        this._minFromMid = (h >= MIN_TIME && h< MAX_HOURS ? h* MAX_MINUTES : MIN_TIME) + (m>=MIN_TIME && m< MAX_MINUTES ? m : MIN_TIME);
    }

    /**
     * A copy constructor.
     * @param other An other Maman13.Time2 object to be copied.
     */
    public Time2(Time2 other){
        this._minFromMid = other._minFromMid;
    }

    /**
     * @return Returns the hour of the time.
     */
    public int getHour(){ return this._minFromMid / MAX_MINUTES; }

    /**
     * @return Returns the minutes of the time.
     */
    public int getMinute(){ return this._minFromMid % MAX_MINUTES; }

    /**
     * Sets a new hour to the time. Should be between 0 to 23
     * @param num The new hour.
     */
    public void setHour(int num){
        if(num >= MIN_TIME && num < MAX_HOURS)
            this._minFromMid = num * MAX_MINUTES + this._minFromMid % MAX_MINUTES;
    }

    /**
     * Sets a new minutes to the time. Should be between 0 to 59
     * @param num The new minute.
     */
    public void setMinute(int num){
        if(num >= MIN_TIME && num < MAX_MINUTES)
            this._minFromMid = (this._minFromMid / MAX_MINUTES)*MAX_MINUTES + num;
    }

    /**
     * @return An int representing the amount of minutes passed from midnight.
     */
    public int minFromMidnight(){
        return _minFromMid;
    }

    /**
     * This methods checks whether two Maman13.Time2 objects are equal.
     * @param other The other Maman13.Time2 object to be compared.
     * @return True if they are equal and false if they are not.
     */
    public boolean equals(Time2 other){
        return this._minFromMid == other._minFromMid;
    }

    /**
     * This method checks whether a time if before an other time.
     * @param other The other Maman13.Time2 object to be compared to.
     * @return True if the time is before the other one, and false if doesn't.
     */
    public boolean before(Time2 other){
        return this._minFromMid < other._minFromMid;
    }

    /**
     * This method checks whether a time if after an other time.
     * @param other The other Maman13.Time2 object to be compared to.
     * @return True if the time is after the other one, and false if doesn't.
     */
    public boolean after(Time2 other){
        return !this.before(other);
    }

    /**
     * This method calculates the difference between two Maman13.Time2 objects.
     * @param other The other Maman13.Time2 object to be compared to.
     * @return An int representing the difference between the objects.
     */
    public int difference(Time2 other){
        return this._minFromMid - other._minFromMid;
    }

    /**
     * This methods takes the Maman13.Time2 object and creates a string of time.
     * @return The time in this pattern: hh:mm
     */
    public String toString(){
        String hourPreFix = (this.getHour() < SINGLE_DIGIT) ? "0" : "";
        String minutePreFix = (this.getMinute() < SINGLE_DIGIT) ? "0" : "";
        return hourPreFix + this.getHour()+":"+ minutePreFix + this.getMinute();
    }

    /**
     * This method creates a new Maman13.Time2 object, adds/subs minutes from it, and returns it.
     * @param num The amount of minutes to add/subs.
     * @return A new Maman13.Time2 object.
     */
    public Time2 addMinutes(int num){
        Time2 newTime = new Time2(this);

        // Calculating the new time from midnight.
        int newTimeFromMidnight = newTime._minFromMid + num;
        newTimeFromMidnight = (newTimeFromMidnight < MIN_TIME) ? newTimeFromMidnight : MINUTES_IN_DAY + newTimeFromMidnight;

        // Sets the new hour and minutes to the new Maman13.Time2 object.
        newTime.setHour((newTimeFromMidnight/MAX_MINUTES % MAX_HOURS));
        newTime.setMinute(newTimeFromMidnight % MAX_MINUTES);
        return newTime;
    }
}