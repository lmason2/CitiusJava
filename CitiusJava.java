import java.io.*;
import java.util.concurrent.TimeUnit;

public class CitiusJava {
    private static String quarter;
    private static String tdFile;
    private static String personalFile;

    //Changed File

    public static void main(String[] args) throws IOException {
        setUpBilling();
        runFileCrossCheck();
        System.exit(1);
    }

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
            System.exit(0);
        }
        quarter = introFrame.getQuarter();
        tdFile = introFrame.getTdFileName();
        personalFile = introFrame.getPersonalFileName();
    }

    private static void runFileCrossCheck() throws IOException {
        File            td,			    // td input file
                        personal,		// zach input file
                        NSAFile,		// standard assets file
                        ArrFile;		// Arrears file

        td = new File(tdFile);
        FileReader tIn = new FileReader(td);
        BufferedReader tdFile = new BufferedReader(tIn);
        String[] tdAccount;
        String trialLine;
        int j = 0;
        while ((trialLine = tdFile.readLine()) != null) {
            int tierVal = 0;
            String registration = "";
            String AdSA = "";
            float value;
            Account newAccount;
            tdAccount = trialLine.split(",", 5);
            for (int i = 0; i < tdAccount.length; i++) {
                tdAccount[i] = tdAccount[i].replace(",", "")
                        .replace("$", "")
                        .replace("\"", "")
                        .replace(" ", "");
            }

            personal = new File(personalFile);
            FileReader zIn = new FileReader(personal);
            BufferedReader zFile = new BufferedReader(zIn);
            String[] zAccount;
            String combinedLine;
            while ((combinedLine = zFile.readLine()) != null) {
                zAccount = combinedLine.split(",", 8);
                if (tdAccount[1].equals(zAccount[5])) {
                    tierVal = Integer.parseInt(zAccount[7]);
                    registration = zAccount[6];
                    AdSA = zAccount[0];
                }
            }
            value = Float.parseFloat(tdAccount[4]);
            newAccount = new Account(tdAccount[0], AdSA, tdAccount[2], tdAccount[3], Integer.parseInt(tdAccount[1]), registration, tierVal, value);
            newAccount.nonStandardAssets();
            newAccount.feeSchedule();
            newAccount.arrears();
            newAccount.quarterAdjust(quarter);
            ClientList.addClient(newAccount);
        }
        ClientList.print();
    }
}
