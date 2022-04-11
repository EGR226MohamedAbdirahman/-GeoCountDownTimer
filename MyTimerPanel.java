import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MyTimerPanel extends JPanel {

    private GeoCountDownTimer geoCountDownTimer;
    private Timer javaTimer;
    private TimerListener timer;

    public MyTimerPanel() {
        geoCountDownTimer = new GeoCountDownTimer(5,10,2019);
        timer = new TimerListener();

        // This calls timer object 10 times per second

                javaTimer = new Timer(10, timer);

        // There is a problem here, your demonstration of your program could take years. So, you can
        // assume that every time the timer object is called equals one day. So, in about 3 seconds would be
        // a month. That is how you can speed up time.

        javaTimer.start();
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}