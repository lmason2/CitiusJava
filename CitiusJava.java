import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * Driver class for Citius Advisor solutions billing
 */
public class CitiusJava {
    // Data
    private static String quarter;
    private static String tdFile;
    private static String personalFile;

    // Methods

    /**
     * Main function for the programs entry point
     * @param args are arguments from the command line
     * @throws IOException is for file IO
     */
    public static void main(String[] args) throws IOException {
        setUpBilling();
        runFileCrossCheck();
        System.exit(1);
    }

    /**
     * Preps the billing process opening a swing frame and initializing
     *      files
     */
    private static void setUpBilling () {
        IntroFrame introFrame = new IntroFrame();
        introFrame.setVisible(true);
        while (introFrame.isVisible()) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        if (!introFrame.isBill()) {
            // Exit if bill button not pressed
            System.exit(0);
        }

        quarter = introFrame.getQuarter();
        tdFile = introFrame.getTdFileName();
        personalFile = introFrame.getPersonalFileName();
    }

    /**
     * Function to cross check the used files for the billing process
     * @throws IOException for file IO
     */
    private static void runFileCrossCheck() throws IOException {
        File            td,			    // td input file
                        personal,		// zach input file
                        NSAFile,		// standard assets file
                        ArrFile;		// Arrears file

        td = new File(tdFile);
        FileReader tIn = new FileReader(td);
        BufferedReader tdFile = new BufferedReader(tIn);

        String trialLine; // String that holds the entire line one at a time
        String[] tdAccount; // Array of strings to hold broken down trial line

        // While loop to run TD file
        while ((trialLine = tdFile.readLine()) != null) {
            int tierVal = 0;
            String registration = "";
            String AdSA = "";
            float value;
            Account newAccount;
            tdAccount = trialLine.split(",", 5);

            // For loop to remove unnecessary characters
            for (int i = 0; i < tdAccount.length; i++) {
                tdAccount[i] = tdAccount[i].replace(",", "")
                        .replace("$", "")
                        .replace("\"", "")
                        .replace(" ", "");
            }

            personal = new File(personalFile);
            FileReader zIn = new FileReader(personal);
            BufferedReader zFile = new BufferedReader(zIn);

            String combinedLine; // String that holds the entire line one at a time
            String[] zAccount; // Array of string to hold broken down combinedLine

            // While loop to cross reference Personal file
            while ((combinedLine = zFile.readLine()) != null) {
                zAccount = combinedLine.split(",", 8);
                if (tdAccount[1].equals(zAccount[5])) {
                    // Match found
                    tierVal = Integer.parseInt(zAccount[7]); // Set tier value
                    registration = zAccount[6]; // Set registration
                    AdSA = zAccount[0]; // Set Advisor SA
                }
            }

            // Initialize value and run appropriate functions on account
            value = Float.parseFloat(tdAccount[4]);
            newAccount = new Account(tdAccount[0], AdSA, tdAccount[2], tdAccount[3], Integer.parseInt(tdAccount[1]), registration, tierVal, value);
            newAccount.nonStandardAssets();
            newAccount.feeSchedule();
            newAccount.calculateArrears();
            newAccount.quarterAdjust(quarter);
            ClientList.addClient(newAccount);
        }
        ClientList.print(); // Print entire portfolio
    }
}
