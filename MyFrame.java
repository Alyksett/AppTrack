import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class MyFrame extends JFrame {
  private JButton saveButton  = new JButton("Save");
  private JButton getButton = new JButton("Get");

  private JTextField companyNameField = new JTextField("Company name");
  private JTextField applyDateField = new JTextField("Date");
  private JTextField OAField = new JTextField("OA?");
  private JTextField rejectField = new JTextField("rejected/accepted");
  private JTextArea notesField = new JTextArea("Notes");


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


    JFrame frame1 = new JFrame();

    //frame1.add(saveButton);

    add(saveButton);
    add(getButton);

    //add(lblA);
    //add(lblB);
    //add(lblC);

    add(companyNameField);
    add(applyDateField);
    add(OAField);
    add(rejectField);
    add(notesField);
  }

  private void initEvent(){

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e){
       System.exit(1);
      }
    });

    saveButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTutupClick(e);
      }
    });

    getButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        btnTambahClick(e);
      }
    });
  }
  
  private void btnTutupClick(ActionEvent evt){
    System.exit(0);
  }
  
  private void btnTambahClick(ActionEvent evt){
    Integer x,y,z;
    try{
      x = Integer.parseInt(companyNameField.getText());
      y = Integer.parseInt(applyDateField.getText());
      z = x + y;
      OAField.setText(z.toString());

    }catch(Exception e){
      System.out.println(e);
      JOptionPane.showMessageDialog(null, 
          e.toString(),
          "Error", 
          JOptionPane.ERROR_MESSAGE);
    }

  /*    
                        Focus Listeners. 
       For when the user selects the box and the text will dissapear.
  */

    companyNameField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
         companyNameField.setText(null); // Empty the text field when it receives focus
        }

        @Override
        public void focusLost(FocusEvent e) {
         // You could do something here when the field loses focus, if you like
        }

    });

    applyDateField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            companyNameField.setText(null); // Empty the text field when it receives focus
        }

        @Override
        public void focusLost(FocusEvent e) {
            // You could do something here when the field loses focus, if you like
        }

    });

    
    OAField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            companyNameField.setText(null); // Empty the text field when it receives focus
        }

        @Override
        public void focusLost(FocusEvent e) {
            // You could do something here when the field loses focus, if you like
        }

    });

    
    rejectField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            companyNameField.setText(null); // Empty the text field when it receives focus
        }

        @Override
        public void focusLost(FocusEvent e) {
            // You could do something here when the field loses focus, if you like
        }

    });

    
    notesField.addFocusListener(new FocusListener() {
        @Override
        public void focusGained(FocusEvent e) {
            companyNameField.setText(null); // Empty the text field when it receives focus
        }

        @Override
        public void focusLost(FocusEvent e) {
            // You could do something here when the field loses focus, if you like
        }

    });
}
}
    

