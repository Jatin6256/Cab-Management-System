import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;

// import java.util.*;

public class SystemManger {

    SystemManger()
    {
        createDir();
        createFile();
        readCustomerInfoFromFile();
        markCarBooked();
    }

    private AvailaibleOptions availaibleOptions = new AvailaibleOptions();
    private AvailaibleCars availaibleCars = new AvailaibleCars();
    private LinkedList<Customer> customers = new LinkedList<Customer>();
    private File myObj;

    void createDir()
    {
        File d = new File("./cms_data");
        System.out.println(d.mkdirs());
        
    }
     void createFile()
    {
        try {
            myObj = new File("./cms_data/customers.txt");
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

    void writeCustomersInfoToFile()
    {
        try
        {
            FileOutputStream f = new FileOutputStream(myObj);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(int i = 0;i < customers.size();i++)
            {
                o.writeObject(customers.get(i));
            }

            o.close();
            f.close();

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    void readCustomerInfoFromFile()
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
                    Customer customer = (Customer) oi.readObject();
                    customers.add(customer);
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

    void markCarBooked()
    {
        for(int i = 0;i < customers.size();i++)
        {
            availaibleCars.markCarBooked(customers.get(i).getBookedCarNumber());
        }
    }

    public void showOptions()
    {
        availaibleOptions.showOptions();
    }

    
    public void showCars()
    {
        availaibleCars.displayAvailaibleCars();
    }

    public Boolean bookCar(int selectedCarNumber)
    {
        return availaibleCars.bookSelectedCar(selectedCarNumber);

    }  

    public void cancelCarBooking(int carNumber)
    {
        availaibleCars.cancelBookedCar(carNumber);
    }
    
    public void handleUserInput(int selectedOptionNumber)
    {
        Scanner sc = new Scanner(System.in);
       if(selectedOptionNumber == 0)
       {
            System.out.println("Enter your name");
            String name = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter your phoneNumber");
            String phoneNumber = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter pick up point");
            String pickUpPoint = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter dropPoint");
            String dropPoint = sc.nextLine();
            System.out.println(" ");
            System.out.println("Car Options: ");
            System.out.println(" ");
            showCars();
            System.out.println("Enter your choice: ");
            int selectedCarNumber = sc.nextInt();
            System.out.println(" ");
            
            Boolean result = bookCar(selectedCarNumber);
            if(result)
                 customers.add(new Customer(name,phoneNumber,selectedCarNumber,pickUpPoint,dropPoint));

            
       }
       else if(selectedOptionNumber == 1)
       {
           System.out.println("Enter your name");
           String name = sc.nextLine();
           System.out.println(" ");
           System.out.println("Enter your phoneNumber");
           String phoneNumber = sc.nextLine();
           System.out.println(" ");
           System.out.println("Enter Booked carNumber: ");
           int carNumber = sc.nextInt();
           System.out.println(" ");

           Boolean res = false;
           for(int i = 0;i < customers.size();i++)
           {
               res = customers.get(i).checkCustomerCredentiol(name, phoneNumber, carNumber);
               if(res)
               {
                    cancelCarBooking(carNumber);
                    customers.remove(i);
                    System.out.println("Booking Successfully cancelled");
                    System.out.println(" ");
                    break;
               }
           }

           if(!res)
                System.out.println("Invalid Input. Booking cancelation Failed");


       }
       else if(selectedOptionNumber == 2)
       {
            System.out.println("Enter your name");
            String name = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter your phoneNumber");
            String phoneNumber = sc.nextLine();
            System.out.println(" ");
            int carNumber = -1;

            for(int i = 0;i < customers.size();i++)
            {
                carNumber = customers.get(i).checkCustomerCredentiolandGetCarNumber(name, phoneNumber);
                if(carNumber != -1)
                    break;
            }

            if(carNumber == -1)
                System.out.println("There is no booked car on yours name");
            else
            {
                System.out.println("status: Booked\n"); 
                availaibleCars.displayDriverDetails(carNumber);
            }

            
       }
       else
            System.out.println("Invalid input");  

      // sc.close();
    }
}
