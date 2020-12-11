import java.io.Serializable;
import java.util.LinkedList;

public class User implements Serializable{ 

    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;
    private String userPhoneNumber;
    private LinkedList<Integer> bookedCarNumbers = new LinkedList<Integer>();
    // private String pickUpPoint;
    // private String dropPoint;

    User(String userName,String userPhoneNumber,String password)
    {
        this.userName = userName;
        this.userPhoneNumber = userPhoneNumber;
        this.password = password;
    }

    public Boolean checkUserName(String name)
    {

        if(userName.equals(name))
            return true;

        return false;
    }

    public Boolean checkPassword(String enteredPassword)
    {

        if(password.equals(enteredPassword) )
            return true;

        return false;
    }

    public void addBookedCarNumber(int carNumber)
    {
        bookedCarNumbers.add(carNumber);
    }

    public void removeBookedCarNumber(int carNumber)
    {
        bookedCarNumbers.remove(bookedCarNumbers.indexOf(carNumber));
    }

    public Boolean isSelectedCarNumberBooked(int carNumber)
    {
        return bookedCarNumbers.contains(carNumber);
    }

    public LinkedList<Integer> getCarNumbers()
    {
        return bookedCarNumbers;
    }
    // public int checkCustomerCredentiolandGetCarNumber(String name,String phoneNumber)
    // {

    //     if(customerName.equalsIgnoreCase(name) && customerPhoneNumber.equalsIgnoreCase(phoneNumber) )
    //         return bookedCarNumber;

    //     return -1;
    // }

    // public int getBookedCarNumber()
    // {
    //     return bookedCarNumber;
    // }

    @Override
    public String toString() {
        return "Name:" + userName + "\nphoneNUmber: " + userPhoneNumber;
    }
    
}
