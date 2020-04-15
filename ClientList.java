import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Vector;

public class ClientList {
    // Data
    private static Vector<Account> clientList = new Vector<>();

    // Methods
    public ClientList() {
    }

    public void addClient(Account newAccount) {
        clientList.addElement(newAccount);
    }

    public static void print() throws IOException {
        BufferedWriter oFile = new BufferedWriter(new FileWriter("Final.csv"));

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

        for (Account account : clientList) {
            DecimalFormat df = new DecimalFormat();
            df.setMaximumFractionDigits(2);
            oFile.write(account.getAdviserTD() + ","
                            + account.getAdviserSA() + ","
                            + account.getLastName() + ","
                            + account.getFirstName() + ","
                            + account.getAccountNumber() + ","
                            + account.getRegistration() + ","
                            + account.getTierVal() + ","
                            + account.getValue() + ","
                            + (df.format(account.getFee())) + ","
                            + account.getArrears() + ","
                            + (df.format(account.getTotal()))
                            + "\n");
        }
    }
}
