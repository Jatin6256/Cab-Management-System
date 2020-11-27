import java.util.Scanner;

public class InitializeCms {


    
    public static void main(String[] args) {

        Boolean flag = true;
        Scanner sc = new Scanner(System.in);
        SystemManger manager = new SystemManger();

        while(flag)
        {

            System.out.println("Welcome To CMS");
            System.out.println(" ");
            manager.showOptions();
            System.out.println("Enter Your Choice: ");
            int selectedChoice = sc.nextInt();
            System.out.println(" ");

            if(selectedChoice == 3)
                flag = false;
            else
                manager.handleUserInput(selectedChoice);
                
               
        }

        manager.writeCustomersInfoToFile();

        System.out.println(" ");
        System.out.println("Thank You");
       sc.close();




        
    }
    
}
