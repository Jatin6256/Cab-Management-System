
public class UserOption {

    private int optionNumber;
    private String option;

    UserOption(int optionNumber,String option)
    {
        this.optionNumber = optionNumber;
        this.option = option;
    }

    public void displayOptionWithOptionNUmber()
    {
        System.out.println(this.optionNumber + " " + this.option);
    }

    public void displayOption()
    {
        System.out.println(this.option);
        System.out.println(" ");
    }
    
}
