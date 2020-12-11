import java.util.LinkedList;
import java.io.*;

public class AvailaibleCars {

    // private Car [] tempCars = {

    //     new Car(0,"Swift",10,800,"Himansh","9899241123",4),
    //     new Car(1,"Dezire",10,800,"Kushagra","9899354212",4),
    //     new Car(2,"Innova",13,1300,"Abhijeet","9899441221",7),
    //     new Car(3,"Fortuner",15,1500,"Siddharth","9899241123",7),
    //     new Car(4,"Bolero",12,1000,"Sonu","9899242218",4),
    //     new Car(5,"Mercedez",40,10000,"Vansh","9899242434",4),
    // };
    AvailaibleCars()
    {
        createFile();
        readCarsInfoFromFile();
        // for (Car car : tempCars) {

        //     availaibleCars.add(car);
            
        // }
    }
    private LinkedList<Car> availaibleCars = new LinkedList<Car>();
    private File myObj;

     void createFile()
    {
        try {
            myObj = new File("./cms_data/cars.txt");
            if (myObj.createNewFile()) {
              System.out.println("File created: " + myObj.getName());
            } else {
              System.out.println("File already exists.");
            }
           // myObj.createNewFile();

          } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
    }

    void writeCarsInfoToFile()
    {
        try
        {
            FileOutputStream f = new FileOutputStream(myObj);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(int i = 0;i < availaibleCars.size();i++)
            {
                o.writeObject(availaibleCars.get(i));
            }

            

            o.close();
            f.close();

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    public int getNumberOfCarsInSystem()
    {
        return availaibleCars.size();
    }
    public void displayAvailaibleCars()
    {
        for(Car car : availaibleCars)
        {
            car.displayCarDetails();
        }
    }

    void readCarsInfoFromFile()
    {
        try 
        {
            FileInputStream fi = new FileInputStream(myObj);
           
            System.out.println(myObj.length());

            if(myObj.length() != 0)
            {
                ObjectInputStream oi = new ObjectInputStream(fi);
                while(fi.available() != 0)
                {
                    Car car = (Car) oi.readObject();
                    availaibleCars.add(car);
                }

                oi.close();
            }
 
            fi.close();
        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        }
    }

    

    public Boolean bookSelectedCar(int selectedCarNumber,String pickUpPoint,String dropPoint,String time)
    {
        if(selectedCarNumber < availaibleCars.size())
        {
           Boolean res =  availaibleCars.get(selectedCarNumber).bookCar(pickUpPoint,dropPoint,time);
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
        if(carNumber < availaibleCars.size())
        {
            availaibleCars.get(carNumber).cancelBooking();   
        }
        else
        {
            System.out.println("Invalid input");
            System.out.println(" ");
        }
    }
    
    void markCarBooked(int carNumber)
    {
        availaibleCars.get(carNumber).markCarBooked();
    }

    void displayDriverDetails(int carNumber)
    {
        availaibleCars.get(carNumber).displayDriverDetails();
    }
}
