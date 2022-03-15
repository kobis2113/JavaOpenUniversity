/**
 * This class represents a time object.
 * It has many methods which helps working with times.
 * @author Kobi Shabaton
 * @version 2022a
 */

public class Time1 {
    private int _hour;
    private int _minute;
    private final int MIN_TIME = 0;
    private final int MAX_MINUTES = 60;
    private final int MAX_HOURS = 24;
    private final int SINGLE_DIGIT = 10;

    /**
     * Creates a new Time1 object.
     * @param h An int representing the amount of hours. Should be between 0 to 24.
     * @param m An int representing the amount of minutes. Should be between 0 to 60.
     */
    public Time1(int h, int m){
        if(h >= MIN_TIME && h < MAX_HOURS)
            this._hour = h;
        else
            this._hour = MIN_TIME;
        if(m >= MIN_TIME && m < MAX_MINUTES)
            this._minute = m;
        else
            this._minute = MIN_TIME;
    }

    /**
     * A copy constructor.
     * @param other A Time1 object.
     */
    public Time1(Time1 other){
        this._hour = other._hour;
        this._minute = other._minute;
    }

    /**
     * @return Returns the hour of the time.
     */
    public int getHour() { return this._hour;}

    /**
     * @return Returns the minutes of the time.
     */
    public int getMinute() { return this._minute; }

    /**
     * Sets a new hour.
     * @param num A new amount of hours. Should be between 0 to 23.
     */
    public void setHour(int num){ this._hour = num >= MIN_TIME && num < MAX_HOURS ? num : this._hour; }

    /**
     * Sets a new minutes.
     * @param num A new amount of minutes. Should be between 0 to 59.
     */
    public void setMinute(int num){ this._minute = num >= MIN_TIME && num < MAX_MINUTES ? num : this._minute; }

    /**
     * This methods takes the minutes and hours of the object and creates a string time.
     * @return The time in this pattern: hh:mm
     */
    public String toString(){
        String hourPreFix = (this._hour < SINGLE_DIGIT) ? "0" : "";
        String minutePreFix = (this._minute < SINGLE_DIGIT) ? "0" : "";
        return hourPreFix + this._hour+":"+ minutePreFix + this._minute;
    }

    /**
     * This method calculates the amount of minutes passed from midnight.
     * @return An int representing the amount of minutes passed from midnight.
     */
    public int minFromMidnight(){ return this._hour * MAX_MINUTES + this._minute; }

    /**
     * This methods checks whether two Time1 objects are equal.
     * @param other The other Time1 object to be compared.
     * @return True if they are equal and false if they are not.
     */
    public boolean equals (Time1 other){
        return this._hour == other._hour && this._minute == other._minute;
    }

    /**
     * This method checks whether a time if before an other time.
     * @param other The other Time1 object to be compared to.
     * @return True if the time is before the other one, and false if doesn't.
     */
    public boolean before (Time1 other){
        if(this._hour < other._hour)
            return true;
        else return this._minute < other._minute;
    }

    /**
     * This method checks whether a time if after an other time.
     * @param other The other Time1 object to be compared to.
     * @return True if the time is after the other one, and false if doesn't.
     */
    public boolean after (Time1 other){
        return !this.before(other);
    }

    /**
     * This method calculates the difference between two Time1 objects.
     * @param other The other Time1 object to be compared to.
     * @return An int representing the difference between the objects.
     */
    public int difference(Time1 other){
        return (this._hour - other._hour)*MAX_MINUTES + (this._minute-other._minute);
    }

    /**
     * This method creates a new Time1 object, adds/subs minutes from it, and returns it.
     * @param num The amount of minutes to add/subs.
     * @return A new Time1 object.
     */
    public Time1 addMinutes(int num){
        Time1 newTime = new Time1(this);

        // Calculating the new time from midnight.
        int newTimeFromMidnight = newTime.minFromMidnight() + num;
        newTimeFromMidnight = (newTimeFromMidnight < MIN_TIME) ? newTimeFromMidnight : 1440 + newTimeFromMidnight;

        // Sets the new hour and minutes to the new Time2 object.
        newTime.setHour((newTimeFromMidnight/MAX_MINUTES % MAX_HOURS));
        newTime.setMinute(newTimeFromMidnight %MAX_MINUTES);
        return newTime;
    }
}