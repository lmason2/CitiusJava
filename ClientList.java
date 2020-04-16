import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

/**
 * ClientList.java implements a client list object that holds
 *      accounts for a financial adviser.
 * Citius Adviser solutions uses this class to run their billing
 */

public class ClientList {
    // Data
    private static Vector<Account> clientList;

    // Methods

    /**
     * Constructor for a client list which initializes the vector
     *      holding the accounts
     */
    public ClientList() {
        clientList = new Vector<>();
    }

    /**
     * addClient allows an account to be added to the client list
     * @param newAccount is the account being added
     */
    public static void addClient(Account newAccount) {
        clientList.addElement(newAccount);
    }

    /**
     * print function to print the entire vector of clients
     * @throws IOException if output file has a problem
     */
    public static void print() throws IOException {
        BufferedWriter oFile = new BufferedWriter(new FileWriter("Final.csv"));
        oFile.flush();
        //output headers
        oFile.write("Advisor TD");
        oFile.write("," + "Advisor SA");
        oFile.write("," + "Last Name");
        oFile.write("," + "First Name");
        oFile.write("," + "Acc. #");
        oFile.write(", " + "Registration");
        oFile.write(", " + "Fee Schedule");
        oFile.write(", " + "Acc. Value");
        oFile.write(", " + "Fee In Advance");
        oFile.write(", " + "Fee in Arrears");
        oFile.write(", " + "Total Fee\n");

        // Enhanced for loop that tells each account to print itself
        for (Account account : clientList) {
            account.printAccount(oFile);
        }
        oFile.close(); // Close the output file
    }
}
