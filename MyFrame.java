import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class MyFrame extends JFrame{
  private JButton saveButton  = new JButton("Save");
  private JButton getButton = new JButton("Get");

  private JTextField companyNameField = new JTextField("Company name");
  private JTextField applyDateField = new JTextField("Date");
  private JTextField OAField = new JTextField("OA?");
  private JTextField rejectField = new JTextField("rejected/accepted");
  private JTextArea notesField = new JTextArea("Notes");

  private static JLabel appCounter = new JLabel();


  //constructor
  public MyFrame(){
    setTitle("AppTrack");
    setSize(350,250);
    setLocation(new Point(300,200));
    setLayout(null);    
    setResizable(false);

    initComponent();    
    initEvent();
  }

  private void initComponent(){
    //save and get buttons
    saveButton.setBounds(210,5, 80,25);
    getButton.setBounds(210,35, 80,25);

    //first 2 is the location in the frame, second two are the dimensions of the text area/field
    companyNameField.setBounds(20, 5, 145, 20);
    applyDateField.setBounds(20, 30, 145, 20);
    OAField.setBounds(20, 55, 145, 20);
    rejectField.setBounds(20, 80, 145, 20);
    notesField.setBounds(20, 105, 145, 100);

    appCounter.setBounds(175, 100, 150, 20);

    add(appCounter);
    updateAppCounter();

    add(saveButton);
    add(getButton);

    add(companyNameField);
    add(applyDateField);
    add(OAField);
    add(rejectField);
    add(notesField);
  }

  //handling events
  private void initEvent(){
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
        try {
            Driver.saveFile();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        System.exit(1);
      }
    });

    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = companyNameField.getText();
        String date = applyDateField.getText();
        String OA = OAField.getText();
        String rejected = rejectField.getText();
        String notes = notesField.getText();
        
         if(Driver.addApplication(name, date, OA, rejected, notes) != (true)){
             JOptionPane.showMessageDialog(null, 
             "There was an error while adding to the database.",
             "Error", 
             JOptionPane.ERROR_MESSAGE);
         }  
         updateAppCounter(); 
    }
    });

    getButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        new EditApplicationGUI();             
      }
    });
  }
  public static void updateAppCounter(){
    appCounter.setText("Total Applications: " + Driver.getTotalApplications());
  }
}
