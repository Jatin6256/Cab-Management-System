import java.io.Serializable;

public class Customer implements Serializable{ 

    private static final long serialVersionUID = 1L;
    private String customerName;
    private String customerPhoneNumber;
    private int bookedCarNumber;
    private String pickUpPoint;
    private String dropPoint;

    Customer(String customerName,String customerPhoneNumber,int bookedCarNumber,String pickUpPoint,String dropPoint)
    {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.bookedCarNumber = bookedCarNumber;
        this.pickUpPoint = pickUpPoint;
        this.dropPoint = dropPoint;
    }

    public Boolean checkCustomerCredentiol(String name,String phoneNumber,int carNumber)
    {

        if(customerName.equalsIgnoreCase(name) && customerPhoneNumber.equalsIgnoreCase(phoneNumber) && this.bookedCarNumber == carNumber)
            return true;

        return false;
    }

    public int checkCustomerCredentiolandGetCarNumber(String name,String phoneNumber)
    {

        if(customerName.equalsIgnoreCase(name) && customerPhoneNumber.equalsIgnoreCase(phoneNumber) )
            return bookedCarNumber;

        return -1;
    }

    public int getBookedCarNumber()
    {
        return bookedCarNumber;
    }

    @Override
    public String toString() {
        return "Name:" + customerName + "\nphoneNUmber: " + customerPhoneNumber + "\ncarNumber: " + bookedCarNumber + "\npickUpPoint: " + pickUpPoint + "\ndropPoint: " + dropPoint;
    }
    
}
