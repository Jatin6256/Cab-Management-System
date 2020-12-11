import java.util.LinkedList;
import java.util.Scanner;


import java.io.*;

// import java.util.*;

public class SystemManger {

    SystemManger()
    {
        createDir();
        createFile();
        readUsersInfoFromFile();
      //  markCarBooked();
    }

    private AvailaibleOptions availaibleOptions = new AvailaibleOptions();
    private AvailaibleCars availaibleCars = new AvailaibleCars();
    private LinkedList<User> users = new LinkedList<User>();
    private File myObj;

    void createDir()
    {
        File d = new File("./cms_data");
        System.out.println(d.mkdirs());
        
    }
     void createFile()
    {
        try {
            myObj = new File("./cms_data/users.txt");
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

    void writeUsersInfoToFile()
    {
        try
        {
            FileOutputStream f = new FileOutputStream(myObj);
            ObjectOutputStream o = new ObjectOutputStream(f);

            for(int i = 0;i < users.size();i++)
            {
                o.writeObject(users.get(i));
            }

            o.close();
            f.close();

        }catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    void readUsersInfoFromFile()
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
                    User customer = (User) oi.readObject();
                    users.add(customer);
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

    // void markCarBooked()
    // {
    //     for(int i = 0;i < customers.size();i++)
    //     {
    //         availaibleCars.markCarBooked(customers.get(i).getBookedCarNumber());
    //     }
    // }

    public void showOptions()
    {
        availaibleOptions.showOptions();
    }

    
    public void showCars()
    {
        availaibleCars.displayAvailaibleCars();
    }

    public Boolean bookCar(int selectedCarNumber,String pickUpPoint,String dropPoint,String time)
    {
        return availaibleCars.bookSelectedCar(selectedCarNumber,pickUpPoint,dropPoint,time);

    }  

    public void cancelCarBooking(int carNumber)
    {
        availaibleCars.cancelBookedCar(carNumber);
    }

    public int getUserIndex(String username)
    {
        for(int i = 0;i < users.size();i++)
        {
            Boolean res1 = users.get(i).checkUserName(username);
            if(res1)
                return i;
        }

        return -1;
    }
    
    public void saveCarsData()
    {
        availaibleCars.writeCarsInfoToFile();
    }

    public void handleUserInput(int selectedOptionNumber)
    {
        Scanner sc = new Scanner(System.in);

        if(selectedOptionNumber == 0)
        {
            System.out.println("Enter your username");
            String name = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter your password");
            String enteredPassword = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter your phoneNumber");
            String phoneNumber = sc.nextLine();
            System.out.println(" ");

            int index = getUserIndex(name);

            if(index != -1)
            {
                System.out.println("Username not availaible");
                System.out.println(" ");
            }
            else if(enteredPassword.length() < 8)
            {
                System.out.println("Invalid password");
                System.out.println(" ");
            }
            else
            {

                users.add(new User(name,phoneNumber,enteredPassword));

                System.out.println("User Succesfully registered");
                System.out.println(" ");
            }


        }
        else if(selectedOptionNumber == 1)
       {
            System.out.println("Enter your username");
            String name = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter your password");
            String enteredPassword = sc.nextLine();
            System.out.println(" ");

            int loggedInUserIndex = getUserIndex(name);

            if(loggedInUserIndex == -1)
            {
                System.out.println("Username not found");
                System.out.println(" ");
            }
            else if(!users.get(loggedInUserIndex).checkPassword(enteredPassword))
            {
                System.out.println("Invalid password");
                System.out.println(" ");
            }
            else
            {
                System.out.println("Enter pick up point");
                String pickUpPoint = sc.nextLine();
                System.out.println(" ");
                System.out.println("Enter dropPoint");
                String dropPoint = sc.nextLine();
                System.out.println(" ");
                System.out.println("Enter time for pick up in 24 hrs format: ");
                System.out.println("Enter hours: ");
                int hour = sc.nextInt();
                System.out.println(" ");
                System.out.println("Enter minutes: ");
                int min = sc.nextInt();
                System.out.println(" ");
                String time;
                if(hour > 24 || hour < 0 || min > 60 || min < 0)
                    System.out.println("Invalid time Format");
                else
                {
                    time = hour + " : " + min;
                    System.out.println(" ");
                    System.out.println("Car Options: ");
                    System.out.println(" ");
                    showCars();
                    System.out.println("Enter your choice: ");
                    int selectedCarNumber = sc.nextInt();
                    System.out.println(" ");
                    
                    Boolean result = bookCar(selectedCarNumber,pickUpPoint,dropPoint,time);
                    if(result)
                        users.get(loggedInUserIndex).addBookedCarNumber(selectedCarNumber);
                }

            }


                 

            
       }
       else if(selectedOptionNumber == 2)
       {
           System.out.println("Enter your name");
           String name = sc.nextLine();
           System.out.println(" ");
           System.out.println("Enter your password");
           String enteredPassword = sc.nextLine();
           System.out.println(" ");
           int loggedInUserIndex = getUserIndex(name);

           if(loggedInUserIndex == -1)
           {
               System.out.println("Username not found");
               System.out.println(" ");
           }
           else if(!users.get(loggedInUserIndex).checkPassword(enteredPassword))
           {
               System.out.println("Invalid password");
               System.out.println(" ");
           }
           else
           {
                System.out.println(" ");
                System.out.println("Enter Booked carNumber: ");
                int carNumber = sc.nextInt();
                System.out.println(" ");
    
                if(users.get(loggedInUserIndex).isSelectedCarNumberBooked(carNumber))
                {
                    cancelCarBooking(carNumber);
                    users.get(loggedInUserIndex).removeBookedCarNumber(carNumber);
                    System.out.println("Booking Successfully cancelled");
                    System.out.println(" ");
                }
                else
                {
                    System.out.println("Invalid Input. Booking cancelation Failed");
                    System.out.println(" ");
                }
           }
       }
       else if(selectedOptionNumber == 3)
       {
            System.out.println("Enter your name");
            String name = sc.nextLine();
            System.out.println(" ");
            System.out.println("Enter your password");
            String enteredPassword= sc.nextLine();
            System.out.println(" ");
            int loggedInUserIndex = getUserIndex(name);

            if(loggedInUserIndex == -1)
            {
                System.out.println("Username not found");
                System.out.println(" ");
            }
            else if(!users.get(loggedInUserIndex).checkPassword(enteredPassword))
            {
                System.out.println("Invalid password");
                System.out.println(" ");
            }
            else
            {
                LinkedList<Integer> bookedCarNumbers = users.get(loggedInUserIndex).getCarNumbers();
                if(bookedCarNumbers.isEmpty())
                {
                    System.out.println("There is no booked car on yours name");
                    System.out.println(" ");
                }
                else
                {
                    System.out.println("There is " +  bookedCarNumbers.size() + " booked car on yours name");
                    System.out.println(" ");
                    for (Integer carNum : bookedCarNumbers) 
                    {
    
                        availaibleCars.displayDriverDetails(carNum);
                        
                    }
                }
            }



            
       }
       else
            System.out.println("Invalid input");  

      // sc.close();
    }
}
