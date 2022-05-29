package Maman15;

/**
 * This class represents a group of natural and positive odd numbers.
 * It has many properties of an airport.
 * @author Kobi Shabaton
 * @version 2022a
 */
public class Set {
    // Class variables
    private IntNode value;

    /**
     * This method checks if the group is empty or not.
     * @return True if the group is empty and false if its not.
     */
    public boolean isEmpty (){
        return this.value.getValue() == 0 && this.value.getNext().getValue() == 0;
    }


}
