import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a description  here.
 *
 */
public class GEOCDTPanelSwing extends JPanel {

    private GeoCountDownTimer watch;
   private GeoCountDownTimer tm;
    private Timer javaTimer;


    private JTextField yearsField, monthsField, daysField, addField;
    private JTextField minusField,daysToField,futureField,newField;
    private JButton addButton, continueButton, minusButton, newButton;
    private JButton daysToGoButton,futureButton,loadButton,saveButton;
    private JButton startButton, stopButton, suspendButton;

    private JLabel lblTime,lblDaysToGo,lblFutureDays;

    public GEOCDTPanelSwing() {

        // create the game object as well as the GUI1024 Frame
        watch = new GeoCountDownTimer();
        javaTimer = new Timer(1000, new TimerListener());

        setLayout(new GridLayout(20, 3));
        setBackground(Color.lightGray);

        yearsField = new JTextField("2022", 3);
        add(yearsField);

        add(new JLabel("Years:"));

        monthsField = new JTextField("10", 3);
        add(monthsField);
        add(new JLabel("Months:"));


        daysField = new JTextField("12", 3);
        add(daysField);
        add(new JLabel("Days:"));


        stopButton = new JButton("Stop");
        add(stopButton);

        startButton = new JButton("Start");
        add(startButton);

        //Add TextBox & Field
        addButton = new JButton("Add");
        add(addButton);
        addField = new JTextField("",3);
        add(addField);

        //Minus TextBox & Field
        minusButton = new JButton("Subtract");
        add(minusButton);
        minusField = new JTextField("",3);
        add(minusField);

        //Days in Future TextBox & field
        futureButton = new JButton("Days in Future");
        add(futureButton);
        futureField = new JTextField("",3);
        add(futureField);

        //Days to go TextBox & field
        daysToGoButton = new JButton("Days To Go");
        add(daysToGoButton);

        //Days in Future TextBox & field
        saveButton = new JButton("Save");
        add(saveButton);

        //New TextBox & field
        newButton = new JButton("New");
        add(newButton);
        newField = new JTextField("",4);
        add(newField);


        loadButton = new JButton("Load");
        add(loadButton);


        continueButton = new JButton("Continue");
        add(continueButton);

        add(new JLabel(" "));

        lblTime = new JLabel();
        lblTime.setText(watch.toString());
        add(lblTime);

        lblDaysToGo = new JLabel();
        add(new JLabel("Days to go"));
        lblDaysToGo.setText("0");
        add(lblDaysToGo);

        lblFutureDays = new JLabel();
        add(new JLabel("Future Date:"));
        lblFutureDays.setText("0");
        add(lblFutureDays);


        add(new JLabel("   Date "));

        stopButton.addActionListener(new ButtonListener());
        startButton.addActionListener(new ButtonListener());
        addButton.addActionListener(new ButtonListener());
        continueButton.addActionListener(new ButtonListener());
        loadButton.addActionListener(new ButtonListener());
        newButton.addActionListener(new ButtonListener());
        saveButton.addActionListener(new ButtonListener());
        daysToGoButton.addActionListener(new ButtonListener());
        futureButton.addActionListener(new ButtonListener());
        minusButton.addActionListener(new ButtonListener());

    }

    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {


            int mins, sec, milli, p;

            if (event.getSource() == stopButton) {
                javaTimer.stop();
            }
            if(event.getSource() == newButton)
            {
                watch = new GeoCountDownTimer(newField.getText());
            }


            //Takes use input N applies towards method for quick
            if(event.getSource() == addButton)
            {
                watch.inc(Integer.parseInt(addField.getText()));

            }
            //Takes use input N applies towards method for subtracting days
            if(event.getSource() == minusButton)
            {
                watch.dec(Integer.parseInt(minusField.getText()));
            }

            if(event.getSource() == daysToGoButton)
            {
                GeoCountDownTimer tm = new GeoCountDownTimer (Integer.parseInt(yearsField.getText()),Integer.parseInt(monthsField.getText()),Integer.parseInt(daysField.getText()));
                    lblDaysToGo.setText(String.valueOf(watch.daysToGo(tm.toDateString())));
            }

            if(event.getSource() == futureButton)
            {

                //GeoCountDownTimer date = new GeoCountDownTimer (Integer.parseInt(yearsField.getText()),Integer.parseInt(monthsField.getText()),Integer.parseInt(daysField.getText()));

                lblFutureDays.setText(String.valueOf(watch.daysInFuture((Integer.parseInt(futureField.getText())))));


            }


            if (event.getSource() == startButton) {
                try {
                    mins = Integer.parseInt(yearsField.getText());
                    sec = Integer.parseInt(monthsField.getText());
                    milli = Integer.parseInt(daysField.getText());
                    watch = new GeoCountDownTimer(mins, sec, milli);
                    javaTimer.start();
                } catch (NumberFormatException io) {
                    JOptionPane.showMessageDialog(null, "Enter an integer in all fields");
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, "Error in field");
                }
            }

            // lots more code goes here


//            if (event.getSource() == stringInputButton)
//                watch = new GeoCountDownTimer(newStringField.getText());
//
//            if (event.getSource() == continueButton)
//                javaTimer.start();

            lblTime.setText(watch.toString());
        }

    }

    private class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
              //  watch.dec(1);
                lblTime.setText(watch.toString());
            }
            catch (Exception exception) {

			}
        }
    }
}
