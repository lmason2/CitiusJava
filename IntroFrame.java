import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

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
        panel.setBackground(Color.BLACK);
        setPreferredSize(new Dimension(900, 600));
        setLocation(300, 200);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel initialization
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setBackground(Color.BLACK);
        JPanel chooserLabelPanel = new JPanel();
        chooserLabelPanel.setLayout(new BoxLayout(chooserLabelPanel, BoxLayout.X_AXIS));
        chooserLabelPanel.setBackground(Color.BLACK);
        JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BoxLayout(secondPanel, BoxLayout.X_AXIS));
        JPanel thirdPanel = new JPanel();
        thirdPanel.setLayout(new BoxLayout(thirdPanel, BoxLayout.X_AXIS));
        thirdPanel.setBackground(Color.BLACK);
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        bottomPanel.setBackground(Color.BLACK);

        JLabel introTitle = new JLabel("Welcome Citius Advisor Solutions");
        introTitle.setForeground(Color.YELLOW);
        topPanel.add(introTitle);

        JLabel personalFileLabel = new JLabel("Choose your personal file:");
        personalFileLabel.setForeground(Color.YELLOW);
        personalFileLabel.setHorizontalAlignment(JLabel.LEFT);
        JLabel tdFileLabel = new JLabel("Choose the TD file:");
        tdFileLabel.setForeground(Color.YELLOW);
        tdFileLabel.setHorizontalAlignment(JLabel.RIGHT);
        chooserLabelPanel.add(personalFileLabel);
        chooserLabelPanel.add(tdFileLabel);

        JFileChooser tdFileChooser = new JFileChooser();
        JFileChooser personalFileChooser = new JFileChooser();
        secondPanel.add(personalFileChooser);
        secondPanel.add(tdFileChooser);
        tdFileChooser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String button = e.getActionCommand();
                if (button.equals("ApproveSelection")) {
                    tdFileName = tdFileChooser.getSelectedFile().getAbsolutePath();
                    tdFileChooser.setVisible(false);
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

        JLabel quarterLabel = new JLabel("Which quarter is it?:");
        thirdPanel.add(quarterLabel);
        quarterLabel.setForeground(Color.yellow);
        JComboBox<Integer> quarterComboBox = new JComboBox<Integer>();
        quarterComboBox.addItem(1);
        quarterComboBox.addItem(2);
        quarterComboBox.addItem(3);
        quarterComboBox.addItem(4);
        thirdPanel.add(quarterComboBox);

        JButton playButton = new JButton("Bill");
        bottomPanel.add(playButton);

        // Add panels to root panel
        panel.add(topPanel);
        panel.add(chooserLabelPanel);
        panel.add(secondPanel);
        panel.add(thirdPanel);
        panel.add(bottomPanel);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        // Listener for the play button
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                quarter = (Integer) Objects.requireNonNull(quarterComboBox.getSelectedItem());
                IntroFrame.super.setVisible(false);
                bill = true;
            }
        });
    }

    public String getQuarter() {
        return String.valueOf(quarter);
    }

    public String getTdFileName() {
        return tdFileName;
    }

    public String getPersonalFileName() {
        return personalFileName;
    }

    public boolean isBill() {
        return bill;
    }
}
