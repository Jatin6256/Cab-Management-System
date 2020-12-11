

public class AvailaibleOptions {
    
     private int numberOfOptions = 5;
     private UserOption [] availOptions = {new UserOption(0,"Sign Up"), new UserOption(1,"Book a Cab"),new UserOption(2,"Cancel a cab"),new UserOption(3, "Check Status"),new UserOption(4, "Exit CMS")};

     public void showOptions()
     {
         for(int i = 0;i < numberOfOptions;i++)
         {
            availOptions[i].displayOptionWithOptionNUmber();
         }

     }

     public void showSelectedOption(int selectedOptionNumber)
     {
        if(selectedOptionNumber < availOptions.length)
        {
            System.out.println("You have selected option to : ");
            availOptions[selectedOptionNumber].displayOption();
        }
        else
        {
            System.out.println("Invalid input");
            System.out.println(" ");
        }

     }

}
