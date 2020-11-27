

public class AvailaibleOptions {
    
     private int numberOfOptions = 4;
     private UserOption [] availOptions = {new UserOption(0,"Book a Cab"),new UserOption(1,"Cancel a cab"),new UserOption(2, "Check Status"),new UserOption(3, "Exit CMS")};

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
