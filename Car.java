

public class Car {

    private int carNumber;
    private String carName;
    private int costPerKM;
    private int initialBookingCost;
    private String driverName;
    private String driverPhoneNumber;
    private Boolean isAvailaible = true;
    private int noOfSeats;
    private String status = "availaible";

    Car(int carNumber,String carName,int costPerKM,int initialBookingCost,String driverName,String driverPhoneNumber,int noOfSeats)
    {
        this.carNumber = carNumber;
        this.carName = carName;
        this.costPerKM = costPerKM;
        this.initialBookingCost = initialBookingCost;
        this.driverName = driverName;
        this.driverPhoneNumber = driverPhoneNumber;
        this.noOfSeats = noOfSeats;
    }

    public void displayCarDetails()
    {
        System.out.println(carNumber + " " + carName);
        System.out.println("initial cost for booking this car: " + initialBookingCost);
        System.out.println("cost per km: " +  costPerKM);
        System.out.println("Number of seats:" + noOfSeats);
        System.out.println("status: " + status);
        System.out.println(" ");
    }

    public Boolean checkAvailaibility()
    {
        return isAvailaible;
    }

    public void displayDriverDetails()
    {
        System.out.println("Driver Name: " + driverName);
        System.out.println("Driver phoneNUmber: " + driverPhoneNumber);
        System.out.println("carNumber: " + carNumber);
        System.out.println(" ");
    }

    public Boolean bookCar()
    {
        if(checkAvailaibility())
        {
            isAvailaible = false;
            status = "booked";
            displayDriverDetails();
            System.out.println("Your car is booked");
            System.out.println(" ");
            return true;

        }
        else
        {
            System.out.println("Selected car is already booked");
            System.out.println(" ");
            return false;
        }
            


        
    }

    public void cancelBooking()
    {
        isAvailaible = true;
        status = "availaible";
    }
    
    public void markCarBooked()
    {
        isAvailaible = false;
        status = "booked";
    }
    
}
