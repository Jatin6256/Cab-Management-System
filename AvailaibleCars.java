public class AvailaibleCars {

    private Car [] availaibleCars = {

        new Car(0,"Swift",10,800,"Himansh","9899241123",4),
        new Car(1,"Dezire",10,800,"Kushagra","9899354212",4),
        new Car(2,"Innova",13,1300,"Abhijeet","9899441221",7),
        new Car(3,"Fortuner",15,1500,"Siddharth","9899241123",7),
        new Car(4,"Bolero",12,1000,"Sonu","9899242218",4),
        new Car(5,"Mercedez",40,10000,"Vansh","9899242434",4),
    };

    public int getNumberOfCarsInSystem()
    {
        return availaibleCars.length;
    }
    public void displayAvailaibleCars()
    {
        for(Car car : availaibleCars)
        {
            car.displayCarDetails();
        }
    }

    

    public Boolean bookSelectedCar(int selectedCarNumber)
    {
        if(selectedCarNumber < availaibleCars.length)
        {
           Boolean res =  availaibleCars[selectedCarNumber].bookCar();
           return res;

        }
        else
        {
            System.out.println("Invalid input");
            System.out.println(" ");
            return false;
        }

            
    }

    public void cancelBookedCar(int carNumber)
    {
        if(carNumber < availaibleCars.length)
        {
            availaibleCars[carNumber].cancelBooking();   
        }
        else
        {
            System.out.println("Invalid input");
            System.out.println(" ");
        }
    }
    
    void markCarBooked(int carNumber)
    {
        availaibleCars[carNumber].markCarBooked();
    }

    void displayDriverDetails(int carNumber)
    {
        availaibleCars[carNumber].displayDriverDetails();
    }
}
