import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Random;

/**
 * Class to create a simple GUI for a whack a mole game.
 * @author Ajinkya Nimblkar
 */
public class Game extends JFrame implements ActionListener {
    /**
     * string for up configuration.
     */
    private static final String UPSTRING = ":-)";
    /**
     * string for the hit configuration.
     */
    private static final String HITSTRING = ":-(";
    /**
     * string for the down configuration.
     */
    private static final String DOWNSTRING = "  ";
    /**
     * color for the hit configuration.
     */
    private static final Color HITCOL = Color.RED;
    /**
     * color for the up configuration.
     */
    private static final Color UPCOL = Color.GREEN;
    /**
     * color for the down configuration.
     */
    private static final Color DOWNCOL = Color.DARK_GRAY;
    /**
     * variable to maiatin the score.
     */
    private static int score = 0;
    /**
     * text field to maintain the score.
     */
    private JTextField scoretext;
    /**
     * button array for the moles.
     */
    private JButton[] buttons;
    /**
     * button to start the game.
     */
    private JButton startbtn;
    /**
     * text field to display time.
     */
    private JTextField timelefttext;
    /**
     * this variable keeps track of the state of the game.
     */
    // -1 : game not yet started
    // 0 : game started and not over
    // 1 : game over
    private static int gameover = -1;
    /**
     * constructor for the game class.
     */
    public Game() {
        initialize();
    }
    /**
     * initializes the variables in game class.
     */
    private void initialize() {
        setSize(600, 600);
        setLayout(new BorderLayout());
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Whack-a-Mole");
        JPanel spane = makestartpane();
        this.add(spane, BorderLayout.NORTH);
        JPanel mpane = makemolepane();
        this.add(mpane,  BorderLayout.CENTER);
        this.setVisible(true);
    }
    /**
     * Create the panel for the start button and the timer.
     * @return JPanel pane
     */ 
    private JPanel makestartpane() {
        JPanel startpane = new JPanel();
        startpane.setLayout(new GridLayout(1, 5, 10, 10));
        startbtn = new JButton();
        startbtn.setText("Start");
        startbtn.addActionListener(this);
        JLabel timeleftlabel = new JLabel("Time Left");
        timelefttext = new JTextField();
        timelefttext.setColumns(10);
        timelefttext.setEditable(false);
        //timelefttext.setText("works from here");
        JLabel scorelabel = new JLabel("Score");
        scoretext = new JTextField();
        scoretext.setColumns(10);
        scoretext.setVisible(true);
        scoretext.setEditable(false);
        startpane.add(startbtn);
        startpane.add(timeleftlabel);
        startpane.add(timelefttext);
        startpane.add(scorelabel);
        startpane.add(scoretext);
        return startpane;
    }
    /**
     * Create the pane for the moles.
     * @return JPanel mole pane
     */
    private JPanel makemolepane() {
        //setBounds(100, 100, 666, 390);
        setTitle("Whack-a-Mole     Simple GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(8, 8, 5, 5));
        buttons = new JButton[64];
        for (int i = 0; i < 64; i++) {
            buttons[i] = new JButton("");
            buttons[i].setText(DOWNSTRING);
            buttons[i].setBackground(DOWNCOL);
            buttons[i].addActionListener(this);
            //buttons[i].setForeground(Color.RED);
            //buttons[i].addActionListener(this);
            pane.add(buttons[i]);
        }
        return pane;
    }
    /**
     * create a class for that implements each mole button.
     */
    private static class Moleclass extends Thread {
        /**
         * the mole button.
         */
        private JButton button;
        /**
         * constructor for Moleclass.
         * @param btn button
         */
        Moleclass(JButton btn) {
            button = btn;
        }
        /**
         * implements the run method in the thread class.
         */
        public void run() {
            while (gameover == 0) {
                Random rn = new Random();
                int sleeptime = rn.nextInt(3500);
                sleeptime += 500;
                synchronized (button) {
                    if (button.getText().equals(DOWNSTRING)) {
                        if (gameover != 0) {
                            break;
                        }
                        button.setText(UPSTRING);
                        button.setBackground(UPCOL);
                        try {
                            Thread.sleep(sleeptime);
                        } catch (InterruptedException e) {
                            throw new AssertionError(e);
                        }
                        button.setText(DOWNSTRING);
                        button.setBackground(DOWNCOL);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new AssertionError(e);
                        }
                    } else {
                        button.setText(DOWNSTRING);
                        button.setBackground(DOWNCOL);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            throw new AssertionError(e);
                        }
                    }
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startbtn) {
            startbtn.setEnabled(false);
            // create timer, start timer, create array of mole threads, start
            Thread mytimer = new Thread(new Runnable() {

                @Override
                public void run() {
                    gameover = 0;
                    int count = 20;
                    while (count > -1) {

                        try {

                            timelefttext.setText("" + count);
                            count--;
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    gameover = 1;
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    gameover = -1;
                    count = 20;
                    score = 0;
                    timelefttext.setText("" + count);
                    scoretext.setText("" + score);
                    startbtn.setEnabled(true);
                }
            });
            mytimer.start();
            int totalmoles = buttons.length;
            Thread[] molethreads = new Thread[totalmoles];
            Random rn = new Random();
            for (int i = 0; i < totalmoles; i++) {
                int rnint = rn.nextInt(totalmoles - 1);
                molethreads[i] = new Moleclass(buttons[rnint]);
                molethreads[i].start();
            }
        }
        for (int i = 0; i < buttons.length; i++) {
            if (e.getSource() == buttons[i]) {
                if (gameover == 0) {
                    if (buttons[i].getText().equals(UPSTRING)) {
                        buttons[i].setText(HITSTRING);
                        buttons[i].setBackground(HITCOL);
                        score++;
                        scoretext.setText("" + score);
                    }
                }
            }
        }
    }
    /**
     * main method.
     * @param args input arguments
     */
    public static void main(String[] args) {
        Game game = new Game();
    }
}
