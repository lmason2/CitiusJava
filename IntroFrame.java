import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

/**
 * IntroFrame to run the billing process using swing
 * Used by Citius Advisor Solutions
 */

public class IntroFrame extends JFrame{
    // Data
    private int quarter;
    private String tdFileName;
    private String personalFileName;
    private boolean bill = false;

    /**
     * Constructor which sets up the layout
     */
    public IntroFrame() {
        JPanel panel = (JPanel) getContentPane();
        setPreferredSize(new Dimension(900, 600));
        setLocation(300, 200);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        setTitle("Citius Advisor Solutions Billing");

        // Panel initialization
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        JPanel chooserLabelPanel = new JPanel();
        chooserLabelPanel.setLayout(new BoxLayout(chooserLabelPanel, BoxLayout.X_AXIS));
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.X_AXIS));
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

        JLabel introTitle = new JLabel("Welcome Citius Advisor Solutions");
        topPanel.add(introTitle);

        JLabel personalFileLabel = new JLabel("Choose your personal file:");
        personalFileLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel tdFileLabel = new JLabel("Choose the TD file:");
        tdFileLabel.setHorizontalAlignment(JLabel.RIGHT);
        chooserLabelPanel.add(personalFileLabel);
        chooserLabelPanel.add(tdFileLabel);

        // Two file choosers in frame for Personal and TD files
        JFileChooser tdFileChooser = new JFileChooser();
        JFileChooser personalFileChooser = new JFileChooser();
        FileNameExtensionFilter csvFilter = new FileNameExtensionFilter(
                "csv files (*.csv)", "csv");
        tdFileChooser.setFileFilter(csvFilter);
        personalFileChooser.setFileFilter(csvFilter);
        secondPanel.add(personalFileChooser);
        secondPanel.add(tdFileChooser);

        // Add listeners
        tdFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button = e.getActionCommand();
                if (button.equals("ApproveSelection")) {
                    tdFileName = tdFileChooser.getSelectedFile().getAbsolutePath();
                    tdFileChooser.setVisible(false);
                }
                else {
                    System.exit(1);
                }
            }
        });
        personalFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button = e.getActionCommand();
                if (button.equals("ApproveSelection")) {
                    personalFileName = personalFileChooser.getSelectedFile().getAbsolutePath();
                    personalFileChooser.setVisible(false);
                }
            }
        });

        // Quarter combo boxes
        JLabel quarterLabel = new JLabel("Which quarter is it?:");
        thirdPanel.add(quarterLabel);
        JComboBox<Integer> quarterComboBox = new JComboBox<Integer>();
        quarterComboBox.addItem(1);
        quarterComboBox.addItem(2);
        quarterComboBox.addItem(3);
        quarterComboBox.addItem(4);
        thirdPanel.add(quarterComboBox);

        JButton billButton = new JButton("Bill");
        bottomPanel.add(billButton);

        // Add panels to root panel
        panel.add(topPanel);
        panel.add(chooserLabelPanel);
        panel.add(secondPanel);
        panel.add(thirdPanel);
        panel.add(bottomPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        // Listener for the bill button
        billButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quarter = (Integer) Objects.requireNonNull(quarterComboBox.getSelectedItem());
                IntroFrame.super.setVisible(false);
                bill = true;
            }
        });
    }

    /**
     * Getter for the value of quarter in a combo box
     * @return the string version of the combo box
     */
    public String getQuarter() {
        return String.valueOf(quarter);
    }

    /**
     * Getter for TD File name path
     * @return the string version of the path of the file
     */
    public String getTdFileName() {
        return tdFileName;
    }

    /**
     * Getter for Personal File name path
     * @return the string version of teh path of the file
     */
    public String getPersonalFileName() {
        return personalFileName;
    }

    /**
     * Getter for bill private member variable
     * @return the status of bill
     */
    public boolean isBill() {
        return bill;
    }
}
