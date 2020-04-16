import java.io.BufferedWriter;
import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Account is a class to simulate a financial account using TD Ameritrade
 * Used by Citius Adivser Solutions
 */
public class Account {
    // Data
    private String advisorTD;
    private String advisorSA;
    private String lastName;
    private String firstName;
    private int accountNumber;
    private String registration;
    private int tierVal;
    private float value;
    private double fee;
    private float arrears;
    private float total;

    // Methods

    /**
     * Account contructor that initializes all the information for an account
     * @param advisorTD is the TD advisor ID
     * @param advisorSA is the SA advisor ID
     * @param lastName is the last name of the client
     * @param firstName of the client
     * @param accountNumber of the client
     * @param registration description of the client
     * @param tierValue for billing purposes
     * @param accountValue is the value in the account
     */
    public Account(String advisorTD, String advisorSA, String lastName, String firstName, int accountNumber, String registration, int tierValue, float accountValue) {
        this.advisorTD = advisorTD;
        this.advisorSA = advisorSA;
        this.lastName = lastName;
        this.firstName = firstName;
        this.accountNumber = accountNumber;
        this.registration = registration;
        this.tierVal = tierValue;
        this.value = accountValue;
    }

    /**
     * Function to adjust the value in the account based on the nonstandard assets
     */
    public void nonStandardAssets() {

    }

    /**
     * Adjusts the fee based on the quarter that is currently being billed
     * @param quarter is the string version of the quarter number
     */
    public void quarterAdjust(String quarter) {
        switch (quarter) {
            case "1":
                fee = (fee/365)*90;
            case "2":
                fee = (fee/365)*91;
            case "3":
                fee = (fee/365)*92;
            case "4":
                fee = (fee/365)*92;
        }
    }

    /**
     * Fee schedule applies the fee based on the tier value attached to the account
     */
    public void feeSchedule()
    {
        if (tierVal == 1)
        {
            fee = 0.00;
        }
        else if (tierVal == 2)
        {
            fee = 0.002*value;
        }
        else if (tierVal == 3)
        {
            fee = 0.0025*value;
        }
        else if (tierVal == 4)
        {
            fee = 0.0035*value;
        }
        else if (tierVal == 5)
        {
            fee = 0.004*value;
        }
        else if (tierVal == 6)
        {
            fee = 0.0042*value;
        }
        else if (tierVal == 7)
        {
            fee = 0.0045*value;
        }
        else if (tierVal == 8)
        {
            fee = 0.005*value;
        }
        else if (tierVal == 9)
        {
            fee = 0.006*value;
        }
        else if (tierVal == 10)
        {
            fee = 0.0065*value;
        }
        else if (tierVal == 11)
        {
            fee = 0.0075*value;
        }
        else if (tierVal == 12)
        {
            fee = 0.008*value;
        }
        else if (tierVal == 13)
        {
            fee = 0.0085*value;
        }
        else if (tierVal == 14)
        {
            fee = 0.009*value;
        }
        else if (tierVal == 15)
        {
            fee = 0.01*value;
        }
        else if (tierVal == 16)
        {
            fee = 0.011*value;
        }
        else if (tierVal == 17)
        {
            fee = 0.012*value;
        }
        else if (tierVal == 18)
        {
            fee = 0.0125*value;
        }
        else if (tierVal == 19)
        {
            fee = 0.013*value;
        }
        else if (tierVal == 20)
        {
            fee = 0.0135*value;
        }
        else if (tierVal == 21)
        {
            fee = 0.014*value;
        }
        else if (tierVal == 22)
        {
            fee = 0.015*value;
        }
        else if (tierVal == 23)
        {
            fee = 0.016*value;
        }
        else if (tierVal == 24)
        {
            fee = 0.0175*value;
        }
        else if (tierVal == 25)
        {
            fee = 0.0195*value;
        }
        else if (tierVal == 26)
        {
            fee = 0.02*value;
        }
        else if (tierVal == 27)
        {
            fee = 0.0225*value;
        }
        else if (tierVal == 28)
        {
            fee = 0.025*value;
        }
        else if (tierVal == 29)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0075*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0075*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0065*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0065*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 30)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0075*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0075*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.006*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 31)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.008*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0075*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 32)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.008*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.008*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 33)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.008*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.008*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.008*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 34)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0085*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0075*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 35)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0085*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.008*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 36)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.009*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0085*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.008*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 37)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0075*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.006*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.006*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 38)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0075*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.005*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 39)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.008*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 40)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.008*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.008*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 41)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.009*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.006*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 42)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.009*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0065*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 43)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.009*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.008*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.007*value;
            }
            else if (value > 1000000)
            {
                fee = 0.006*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 44)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0095*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.009*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0085*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 45)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.005*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0025*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 46)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.005*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 47)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0065*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 48)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 49)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 50)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 51)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.02*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.02*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.02*value;
            }
            else if (value > 1000000)
            {
                fee = 0.02*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 52)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.011*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.009*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.008*value;
            }
            else if (value > 1000000)
            {
                fee = 0.007*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 53)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0115*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0095*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0095*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0095*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0095*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 54)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.012*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.011*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.009*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.009*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 55)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.012*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.011*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.009*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 56)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.005*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 57)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 58)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 59)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.011*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 60)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0115*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0105*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 61)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0115*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0105*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 62)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0125*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 63)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0125*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 64)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.013*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0115*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0085*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 65)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.013*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.013*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.013*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.013*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 66)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.014*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.013*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.013*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.013*value;
            }
            else if (value > 1000000)
            {
                fee = 0.013*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 67)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.025*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.02*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.02*value;
            }
            else if (value > 1000000)
            {
                fee = 0.02*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 68)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0075*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 69)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.008*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.008*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 70)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 71)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 72)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.009*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 73)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.013*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.011*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 74)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0135*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.012*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0115*value;
            }
            else if (value > 1000000)
            {
                fee = 0.009*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 75)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0135*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.012*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0115*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 76)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0135*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0115*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 77)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0135*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0135*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0135*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0135*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 78)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0115*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 79)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0125*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 80)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0125*value;
            }
            else if (value > 1000000)
            {
                fee = 0.011*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 81)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.015*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.015*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 82)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.015*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.015*value;
            }
            else if (value > 1000000)
            {
                fee = 0.011*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 83)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.015*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.015*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0125*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 84)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.015*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.015*value;
            }
            else if (value > 1000000)
            {
                fee = 0.02*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 85)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.016*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.016*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.016*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.015*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0125*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 86)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0175*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0135*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0125*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 87)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0175*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0175*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0175*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0175*value;
            }
            else if (value > 1000000)
            {
                fee = 0.015*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 88)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.02*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0175*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.015*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0125*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 89)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.02*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.02*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.02*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.02*value;
            }
            else if (value > 1000000)
            {
                fee = 0.015*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 90)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0225*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.02*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0175*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.015*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0125*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 91)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.025*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.02*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0175*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.015*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0125*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 92)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.025*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0225*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.02*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0175*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0175*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 93)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.025*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.025*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.02*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.02*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 94)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 95)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.025*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.025*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.02*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.02*value;
            }
            else if (value > 1000000)
            {
                fee = 0.02*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 96)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.009*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.005*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.005*value;
            }
            else if (value > 1000000)
            {
                fee = 0.005*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 97)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.009*value;
            }
            else if (value > 1000000)
            {
                fee = 0.008*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 98)
        {
            fee = 0.0115*value;
        }
        else if (tierVal == 99)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.015*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.013*value;
            }
            else if (value > 1000000)
            {
                fee = 0.011*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 100)
        {
            fee = 0.007*value;
        }
        else if (tierVal == 101)
        {
            fee = 0.019*value;
        }
        else if (tierVal == 102)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.013*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.012*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.011*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 103)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0075*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.005*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0025*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0025*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0025*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 104)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0085*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0085*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.008*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0075*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 105)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.01*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.008*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.008*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 106)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.01*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.01*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 107)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.015*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.0125*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.0125*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0125*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 108)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0125*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.01*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0075*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.005*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0025*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else if (tierVal == 109)
        {
            if (value > 0 && value <= 250000)
            {
                fee = 0.0175*value;
            }
            else if (value > 250000 && value <= 500000)
            {
                fee = 0.015*value;
            }
            else if (value > 500000 && value <= 750000)
            {
                fee = 0.0125*value;
            }
            else if (value > 750000 && value <=1000000)
            {
                fee = 0.01*value;
            }
            else if (value > 1000000)
            {
                fee = 0.0075*value;
            }
            else
            {
                System.out.println("Error at tier val: " + tierVal);
            }
        }
        else
        {
            fee = 0;
        }
    }

    /**
     * Calculate arrears calculates the arrears for the account
     */
    public void calculateArrears() {

    }

    /**
     * Print account that allows the account to print itself based on its data
     * @param oFile is the file being printed to
     * @throws IOException for the possibility of a file IO exception
     */
    public void printAccount(BufferedWriter oFile) throws IOException {
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        oFile.write(advisorTD + ","
                + advisorSA + ","
                + lastName + ","
                + firstName + ","
                + accountNumber + ","
                + registration + ","
                + tierVal + ","
                + value + ","
                + df.format(fee) + ","
                + arrears + ","
                + df.format(total)
                + "\n");
    }
}
