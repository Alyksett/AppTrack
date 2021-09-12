import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class EditApplicationGUI extends JFrame {

  private JButton saveChangesButton  = new JButton("Save Changes");


  private JTextField companyNameField = new JTextField(" ");

  private JTextField applyDateField = new JTextField(" ");
  private JTextField OAField = new JTextField(" ");
  private JTextField rejectField = new JTextField(" ");
  private JTextArea notesField = new JTextArea(" ");
  private static JComboBox namePicker;
  

  public EditApplicationGUI(){
    setTitle("AppTrack");
    setSize(350,250);
    setLocation(new Point(350,250));
    setLayout(null);    
    setResizable(false);
    super.setVisible(true);
    namePicker = new JComboBox(Driver.getCompanyNames());

    initComponent();    
    initEvent();    
  }

  private void initComponent(){
    saveChangesButton.setBounds(205,180, 125,25);

    
    namePicker.setBounds(170, 5, 150, 25);

    companyNameField.setBounds(20, 5, 145, 20);
    applyDateField.setBounds(20, 30, 145, 20);
    OAField.setBounds(20, 55, 145, 20);
    rejectField.setBounds(20, 80, 145, 20);
    notesField.setBounds(20, 105, 145, 100);


    add(saveChangesButton);
    add(namePicker);

    add(companyNameField);
    companyNameField.setEditable(false);
    add(applyDateField);
    add(OAField);
    add(rejectField);
    add(notesField);

    }

  private void initEvent(){

    // for when the item in the combobox is highlighted
    namePicker.addItemListener(new ItemListener(){
        @Override
        public void itemStateChanged(ItemEvent e){
            if(e.getStateChange() == ItemEvent.SELECTED) {
                companyNameField.setText(Driver.database.get(namePicker.getSelectedItem()).getComanyName());
                applyDateField.setText(Driver.database.get(namePicker.getSelectedItem()).getApplyDate());
                OAField.setText(Driver.database.get(namePicker.getSelectedItem()).getOA());
                rejectField.setText(Driver.database.get(namePicker.getSelectedItem()).getAppState());
                notesField.setText(Driver.database.get(namePicker.getSelectedItem()).getNotes());
            }
        }
    });

    saveChangesButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {    
        String name = companyNameField.getText();
        String date = applyDateField.getText();
        String OA = OAField.getText();
        System.out.println(OA + "This is the OA field from the GUI");        
        String rejected = rejectField.getText();
        String notes = notesField.getText();
        Driver.updateApplication(name, date, OA, rejected, notes);
      }
    });
  }
}
