import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Color;

public class GameGUI {

    private JFrame frame;
    private JTextField timelefttext;
    private JTextField scoretext;
    //this variable keeps track of the state of the game
    // -1 : game not yet started
    // 0 : game started and not over
    // 1 : game over
    private int gameover = -1;
    // counts the elapsed time
    private long elapsedtime;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    GameGUI window = new GameGUI();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    
    Timer mytimer = new Timer();
    TimerTask task = new TimerTask(){
        long tstart = System.currentTimeMillis();
        public void run(){
            long tend = System.currentTimeMillis();
            elapsedtime = 20 - (tend - tstart)/1000;
            while (elapsedtime >= 20) {
                timelefttext.setText(String.valueOf(elapsedtime));
                tend = System.currentTimeMillis();
                elapsedtime = 20 - (tend - tstart)/1000;
            }
            while (elapsedtime >= -5) {
                tend = System.currentTimeMillis();
                elapsedtime = 20 - (tend - tstart)/1000;
            }
            
        }
    };
    /**
     * Create the application.
     */
    public GameGUI() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setForeground(Color.RED);
        frame.setBounds(100, 100, 666, 390);
        frame.setTitle("Whack-a-Mole");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JButton startbtn = new JButton("Start");
        startbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startbtn.setEnabled(false);
                
            }
        });
        startbtn.setBounds(115, 24, 89, 23);
        frame.getContentPane().add(startbtn);
        
        JLabel timeleftlabel = new JLabel("Time Left");
        timeleftlabel.setBounds(241, 28, 46, 14);
        frame.getContentPane().add(timeleftlabel);
        
        timelefttext = new JTextField();
        timelefttext.setBounds(297, 25, 86, 20);
        frame.getContentPane().add(timelefttext);
        timelefttext.setColumns(10);
        
        JLabel scorelabel = new JLabel("Score");
        scorelabel.setBounds(414, 28, 46, 14);
        frame.getContentPane().add(scorelabel);
        
        scoretext = new JTextField();
        scoretext.setBounds(459, 25, 86, 20);
        frame.getContentPane().add(scoretext);
        scoretext.setColumns(10);
        
        //String for the down configuration
        String down = ":-(";
        //String for the up configuration
        String up = ":-)";
        
        JButton btnNewButton = new JButton("");
        btnNewButton.setBackground(Color.RED);
        btnNewButton.setForeground(Color.RED);
        btnNewButton.setBounds(10, 72, 70, 23);
        btnNewButton.setText(down);
        frame.getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setBackground(Color.RED);
        btnNewButton_1.setForeground(Color.RED);
        btnNewButton_1.setBounds(90, 72, 70, 23);
        btnNewButton_1.setText(down);
        frame.getContentPane().add(btnNewButton_1);
        
        JButton btnNewButton_2 = new JButton("");
        btnNewButton_2.setBackground(Color.RED);
        btnNewButton_2.setForeground(Color.RED);
        btnNewButton_2.setBounds(170, 72, 70, 23);
        btnNewButton_2.setText(down);
        frame.getContentPane().add(btnNewButton_2);
        
        JButton btnNewButton_3 = new JButton("");
        btnNewButton_3.setBackground(Color.RED);
        btnNewButton_3.setForeground(Color.RED);
        btnNewButton_3.setBounds(250, 72, 70, 23);
        btnNewButton_3.setText(down);
        frame.getContentPane().add(btnNewButton_3);
        
        JButton btnNewButton_4 = new JButton("");
        btnNewButton_4.setBackground(Color.RED);
        btnNewButton_4.setForeground(Color.RED);
        btnNewButton_4.setBounds(330, 72, 70, 23);
        btnNewButton_4.setText(down);
        frame.getContentPane().add(btnNewButton_4);
        
        JButton button = new JButton("");
        button.setBackground(Color.RED);
        button.setForeground(Color.RED);
        button.setBounds(410, 72, 70, 23);
        button.setText(down);
        frame.getContentPane().add(button);
        
        JButton button_1 = new JButton("");
        button_1.setBackground(Color.RED);
        button_1.setForeground(Color.RED);
        button_1.setBounds(490, 72, 70, 23);
        button_1.setText(down);
        frame.getContentPane().add(button_1);
        
        JButton button_2 = new JButton("");
        button_2.setBackground(Color.RED);
        button_2.setForeground(Color.RED);
        button_2.setBounds(570, 72, 70, 23);
        button_2.setText(down);
        frame.getContentPane().add(button_2);
        
        JButton button_3 = new JButton("");
        button_3.setBackground(Color.RED);
        button_3.setForeground(Color.RED);
        button_3.setBounds(10, 106, 70, 23);
        button_3.setText(down);
        frame.getContentPane().add(button_3);
        
        JButton button_4 = new JButton("");
        button_4.setBackground(Color.RED);
        button_4.setForeground(Color.RED);
        button_4.setBounds(90, 106, 70, 23);
        button_4.setText(down);
        frame.getContentPane().add(button_4);
        
        JButton button_5 = new JButton("");
        button_5.setBackground(Color.RED);
        button_5.setForeground(Color.RED);
        button_5.setBounds(170, 106, 70, 23);
        button_5.setText(down);
        frame.getContentPane().add(button_5);
        
        JButton button_6 = new JButton("");
        button_6.setBackground(Color.RED);
        button_6.setForeground(Color.RED);
        button_6.setBounds(250, 106, 70, 23);
        button_6.setText(down);
        frame.getContentPane().add(button_6);
        
        JButton button_7 = new JButton("");
        button_7.setBackground(Color.RED);
        button_7.setForeground(Color.RED);
        button_7.setBounds(330, 106, 70, 23);
        button_7.setText(down);
        frame.getContentPane().add(button_7);
        
        JButton button_8 = new JButton("");
        button_8.setBackground(Color.RED);
        button_8.setForeground(Color.RED);
        button_8.setBounds(410, 106, 70, 23);
        button_8.setText(down);
        frame.getContentPane().add(button_8);
        
        JButton button_9 = new JButton("");
        button_9.setBackground(Color.RED);
        button_9.setForeground(Color.RED);
        button_9.setBounds(490, 106, 70, 23);
        button_9.setText(down);
        frame.getContentPane().add(button_9);
        
        JButton button_10 = new JButton("");
        button_10.setBackground(Color.RED);
        button_10.setForeground(Color.RED);
        button_10.setBounds(570, 106, 70, 23);
        button_10.setText(down);
        frame.getContentPane().add(button_10);
        
        JButton button_11 = new JButton("");
        button_11.setBackground(Color.RED);
        button_11.setForeground(Color.RED);
        button_11.setBounds(10, 140, 70, 23);
        button_11.setText(down);
        frame.getContentPane().add(button_11);
        
        JButton button_12 = new JButton("");
        button_12.setBackground(Color.RED);
        button_12.setForeground(Color.RED);
        button_12.setBounds(90, 140, 70, 23);
        button_12.setText(down);
        frame.getContentPane().add(button_12);
        
        JButton button_13 = new JButton("");
        button_13.setBackground(Color.RED);
        button_13.setForeground(Color.RED);
        button_13.setBounds(170, 140, 70, 23);
        button_13.setText(down);
        frame.getContentPane().add(button_13);
        
        JButton button_14 = new JButton("");
        button_14.setBackground(Color.RED);
        button_14.setForeground(Color.RED);
        button_14.setBounds(250, 140, 70, 23);
        button_14.setText(down);
        frame.getContentPane().add(button_14);
        
        JButton button_15 = new JButton("");
        button_15.setBackground(Color.RED);
        button_15.setForeground(Color.RED);
        button_15.setBounds(330, 140, 70, 23);
        button_15.setText(down);
        frame.getContentPane().add(button_15);
        
        JButton button_16 = new JButton("");
        button_16.setBackground(Color.RED);
        button_16.setForeground(Color.RED);
        button_16.setBounds(410, 140, 70, 23);
        button_16.setText(down);
        frame.getContentPane().add(button_16);
        
        JButton button_17 = new JButton("");
        button_17.setBackground(Color.RED);
        button_17.setForeground(Color.RED);
        button_17.setBounds(490, 140, 70, 23);
        button_17.setText(down);
        frame.getContentPane().add(button_17);
        
        JButton button_18 = new JButton("");
        button_18.setBackground(Color.RED);
        button_18.setForeground(Color.RED);
        button_18.setBounds(570, 140, 70, 23);
        button_18.setText(down);
        frame.getContentPane().add(button_18);
        
        JButton button_19 = new JButton("");
        button_19.setBackground(Color.RED);
        button_19.setForeground(Color.RED);
        button_19.setBounds(10, 174, 70, 23);
        button_19.setText(down);
        frame.getContentPane().add(button_19);
        
        JButton button_20 = new JButton("");
        button_20.setBackground(Color.RED);
        button_20.setForeground(Color.RED);
        button_20.setBounds(90, 174, 70, 23);
        button_20.setText(down);
        frame.getContentPane().add(button_20);
        
        JButton button_21 = new JButton("");
        button_21.setBackground(Color.RED);
        button_21.setForeground(Color.RED);
        button_21.setBounds(170, 174, 70, 23);
        button_21.setText(down);
        frame.getContentPane().add(button_21);
        
        JButton button_22 = new JButton("");
        button_22.setBackground(Color.RED);
        button_22.setForeground(Color.RED);
        button_22.setBounds(250, 174, 70, 23);
        button_22.setText(down);
        frame.getContentPane().add(button_22);
        
        JButton button_23 = new JButton("");
        button_23.setBackground(Color.RED);
        button_23.setForeground(Color.RED);
        button_23.setBounds(330, 174, 70, 23);
        button_23.setText(down);
        frame.getContentPane().add(button_23);
        
        JButton button_24 = new JButton("");
        button_24.setBackground(Color.RED);
        button_24.setForeground(Color.RED);
        button_24.setBounds(410, 174, 70, 23);
        button_24.setText(down);
        frame.getContentPane().add(button_24);
        
        JButton button_25 = new JButton("");
        button_25.setBackground(Color.RED);
        button_25.setForeground(Color.RED);
        button_25.setBounds(490, 174, 70, 23);
        button_25.setText(down);
        frame.getContentPane().add(button_25);
        
        JButton button_26 = new JButton("");
        button_26.setBackground(Color.RED);
        button_26.setForeground(Color.RED);
        button_26.setBounds(570, 174, 70, 23);
        button_26.setText(down);
        frame.getContentPane().add(button_26);
        
        JButton button_27 = new JButton("");
        button_27.setBackground(Color.RED);
        button_27.setForeground(Color.RED);
        button_27.setBounds(10, 208, 70, 23);
        button_27.setText(down);
        frame.getContentPane().add(button_27);
        
        JButton button_28 = new JButton("");
        button_28.setBackground(Color.RED);
        button_28.setForeground(Color.RED);
        button_28.setBounds(90, 208, 70, 23);
        button_28.setText(down);
        frame.getContentPane().add(button_28);
        
        JButton button_29 = new JButton("");
        button_29.setBackground(Color.RED);
        button_29.setForeground(Color.RED);
        button_29.setBounds(170, 208, 70, 23);
        button_29.setText(down);
        frame.getContentPane().add(button_29);
        
        JButton button_30 = new JButton("");
        button_30.setBackground(Color.RED);
        button_30.setForeground(Color.RED);
        button_30.setBounds(250, 208, 70, 23);
        button_30.setText(down);
        frame.getContentPane().add(button_30);
        
        JButton button_31 = new JButton("");
        button_31.setBackground(Color.RED);
        button_31.setForeground(Color.RED);
        button_31.setBounds(330, 208, 70, 23);
        button_31.setText(down);
        frame.getContentPane().add(button_31);
        
        JButton button_32 = new JButton("");
        button_32.setBackground(Color.RED);
        button_32.setForeground(Color.RED);
        button_32.setBounds(410, 208, 70, 23);
        button_32.setText(down);
        frame.getContentPane().add(button_32);
        
        JButton button_33 = new JButton("");
        button_33.setBackground(Color.RED);
        button_33.setForeground(Color.RED);
        button_33.setBounds(490, 208, 70, 23);
        button_33.setText(down);
        frame.getContentPane().add(button_33);
        
        JButton button_34 = new JButton("");
        button_34.setBackground(Color.RED);
        button_34.setForeground(Color.RED);
        button_34.setBounds(570, 208, 70, 23);
        button_34.setText(down);
        frame.getContentPane().add(button_34);
        
        JButton button_35 = new JButton("");
        button_35.setBackground(Color.RED);
        button_35.setForeground(Color.RED);
        button_35.setBounds(10, 242, 70, 23);
        button_35.setText(down);
        frame.getContentPane().add(button_35);
        
        JButton button_36 = new JButton("");
        button_36.setBackground(Color.RED);
        button_36.setForeground(Color.RED);
        button_36.setBounds(90, 242, 70, 23);
        button_36.setText(down);
        frame.getContentPane().add(button_36);
        
        JButton button_37 = new JButton("");
        button_37.setBackground(Color.RED);
        button_37.setForeground(Color.RED);
        button_37.setBounds(170, 242, 70, 23);
        button_37.setText(down);
        frame.getContentPane().add(button_37);
        
        JButton button_38 = new JButton("");
        button_38.setBackground(Color.RED);
        button_38.setForeground(Color.RED);
        button_38.setBounds(250, 242, 70, 23);
        button_38.setText(down);
        frame.getContentPane().add(button_38);
        
        JButton button_39 = new JButton("");
        button_39.setBackground(Color.RED);
        button_39.setForeground(Color.RED);
        button_39.setBounds(330, 242, 70, 23);
        button_39.setText(down);
        frame.getContentPane().add(button_39);
        
        JButton button_40 = new JButton("");
        button_40.setBackground(Color.RED);
        button_40.setForeground(Color.RED);
        button_40.setBounds(410, 242, 70, 23);
        button_40.setText(down);
        frame.getContentPane().add(button_40);
        
        JButton button_41 = new JButton("");
        button_41.setBackground(Color.RED);
        button_41.setForeground(Color.RED);
        button_41.setBounds(490, 242, 70, 23);
        button_41.setText(down);
        frame.getContentPane().add(button_41);
        
        JButton button_42 = new JButton("");
        button_42.setBackground(Color.RED);
        button_42.setForeground(Color.RED);
        button_42.setBounds(570, 242, 70, 23);
        button_42.setText(down);
        frame.getContentPane().add(button_42);
        
        JButton button_43 = new JButton("");
        button_43.setBackground(Color.RED);
        button_43.setForeground(Color.RED);
        button_43.setBounds(10, 276, 70, 23);
        button_43.setText(down);
        frame.getContentPane().add(button_43);
        
        JButton button_44 = new JButton("");
        button_44.setBackground(Color.RED);
        button_44.setForeground(Color.RED);
        button_44.setBounds(90, 276, 70, 23);
        button_44.setText(down);
        frame.getContentPane().add(button_44);
        
        JButton button_45 = new JButton("");
        button_45.setBackground(Color.RED);
        button_45.setForeground(Color.RED);
        button_45.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        button_45.setBounds(170, 276, 70, 23);
        button_45.setText(down);
        frame.getContentPane().add(button_45);
        
        JButton button_46 = new JButton("");
        button_46.setBackground(Color.RED);
        button_46.setForeground(Color.RED);
        button_46.setBounds(250, 276, 70, 23);
        button_46.setText(down);
        frame.getContentPane().add(button_46);
        
        JButton button_47 = new JButton("");
        button_47.setBackground(Color.RED);
        button_47.setForeground(Color.RED);
        button_47.setBounds(330, 276, 70, 23);
        button_47.setText(down);
        frame.getContentPane().add(button_47);
        
        JButton button_48 = new JButton("");
        button_48.setBackground(Color.RED);
        button_48.setForeground(Color.RED);
        button_48.setBounds(410, 276, 70, 23);
        button_48.setText(down);
        frame.getContentPane().add(button_48);
        
        JButton button_49 = new JButton("");
        button_49.setBackground(Color.RED);
        button_49.setForeground(Color.RED);
        button_49.setBounds(490, 276, 70, 23);
        button_49.setText(down);
        frame.getContentPane().add(button_49);
        
        JButton button_50 = new JButton("");
        button_50.setBackground(Color.RED);
        button_50.setForeground(Color.RED);
        button_50.setBounds(570, 276, 70, 23);
        button_50.setText(down);
        frame.getContentPane().add(button_50);
        
        JButton button_51 = new JButton("");
        button_51.setBackground(Color.RED);
        button_51.setForeground(Color.RED);
        button_51.setBounds(10, 310, 70, 23);
        button_51.setText(down);
        frame.getContentPane().add(button_51);
        
        JButton button_52 = new JButton("");
        button_52.setBackground(Color.RED);
        button_52.setForeground(Color.RED);
        button_52.setBounds(90, 310, 70, 23);
        button_52.setText(down);
        frame.getContentPane().add(button_52);
        
        JButton button_53 = new JButton("");
        button_53.setBackground(Color.RED);
        button_53.setForeground(Color.RED);
        button_53.setBounds(170, 310, 70, 23);
        button_53.setText(down);
        frame.getContentPane().add(button_53);
        
        JButton button_54 = new JButton("");
        button_54.setBackground(Color.RED);
        button_54.setForeground(Color.RED);
        button_54.setBounds(250, 310, 70, 23);
        button_54.setText(down);
        frame.getContentPane().add(button_54);
        
        JButton button_55 = new JButton("");
        button_55.setBackground(Color.RED);
        button_55.setForeground(Color.RED);
        button_55.setBounds(330, 310, 70, 23);
        button_55.setText(down);
        frame.getContentPane().add(button_55);
        
        JButton button_56 = new JButton("");
        button_56.setBackground(Color.RED);
        button_56.setForeground(Color.RED);
        button_56.setBounds(410, 310, 70, 23);
        button_56.setText(down);
        frame.getContentPane().add(button_56);
        
        JButton button_57 = new JButton("");
        button_57.setBackground(Color.RED);
        button_57.setForeground(Color.RED);
        button_57.setBounds(490, 310, 70, 23);
        button_57.setText(down);
        frame.getContentPane().add(button_57);
        
        JButton button_58 = new JButton("");
        button_58.setBackground(Color.RED);
        button_58.setForeground(Color.RED);
        button_58.setBounds(570, 310, 70, 23);
        button_58.setText(down);
        frame.getContentPane().add(button_58);
    }
}
