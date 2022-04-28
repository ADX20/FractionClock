package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import clock.FractionClock;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ClockGui implements ActionListener {

	
	private JFrame frame;
	
	private static int HourNum;
	private static int HourDom;
	private static int MinuteNum;
	private static int MinuteDom;
	private static boolean colon = false;
	
	private static JLabel HourNumeratorLabel;
	private static JLabel HourDominatorLabel;
	private JLabel lblNewLabel_2;
	private static JLabel MinuteNumeratorLabel;
	private JLabel lblNewLabel;
	private static JLabel MinuteDominatorLabel;
	private static JLabel SecondIndicator;

	private static ClockGui window;
	
	static FractionClock clock = new FractionClock();

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new ClockGui();
					window.frame.setVisible(true);		
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
				
		});
	}
	/**
	 * Create the application.
	 */

	public ClockGui() {
		initialize();
		Timer timer = new Timer(1000,this);
		timer.start();

		
	}
	/**
	 * Initialize the contents of the frame.
	 */
		public void actionPerformed(ActionEvent e) {
			System.out.println("Second passed");
			displayClock();
		}
	private void initialize() {
		
		frame = new JFrame();
		

		
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[16.6%][16.6%][16.6%][][16.6%][16.6%][16.6%]", "[10%][10%][10%:10%:10%][7.5%:7.5%:7.5%][10%:10%:10%][][15%][10%][10%][]"));
		
		HourNumeratorLabel = new JLabel("");
		HourNumeratorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		HourNumeratorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		HourNumeratorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(HourNumeratorLabel, "cell 2 2,alignx center,aligny bottom");
		
		MinuteNumeratorLabel = new JLabel("");
		MinuteNumeratorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(MinuteNumeratorLabel, "cell 4 2,alignx center,aligny bottom");
		
		lblNewLabel_2 = new JLabel("\u2014");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 41));
		frame.getContentPane().add(lblNewLabel_2, "cell 2 3,alignx center,aligny baseline");
		
		SecondIndicator = new JLabel(":");
		SecondIndicator.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(SecondIndicator, "cell 3 2 1 3");
		
		lblNewLabel = new JLabel("\u2014");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 41));
		frame.getContentPane().add(lblNewLabel, "cell 4 3,alignx center,aligny baseline");
		
		HourDominatorLabel = new JLabel("");
		HourDominatorLabel.setBackground(Color.WHITE);
		HourDominatorLabel.setVerticalAlignment(SwingConstants.TOP);
		HourDominatorLabel.setHorizontalAlignment(SwingConstants.LEFT);
		HourDominatorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(HourDominatorLabel, "cell 2 4,alignx center,aligny top");
		
		MinuteDominatorLabel = new JLabel("");
		MinuteDominatorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(MinuteDominatorLabel, "cell 4 4,alignx center,aligny top");
		
	}
	
	private static void displayClock() {
		
			HourNum = clock.getHour()[0];
			HourDom = clock.getHour()[1];
			MinuteNum = clock.getMinute()[0];
			MinuteDom = clock.getMinute()[1];
			
			HourNumeratorLabel.setText(Integer.toString(HourNum));
			HourDominatorLabel.setText(Integer.toString(HourDom));
			
			MinuteNumeratorLabel.setText(Integer.toString(MinuteNum));
			MinuteDominatorLabel.setText(Integer.toString(MinuteDom));
			if(colon == true) {
				SecondIndicator.setText(":");
				
			}else if(colon == false){
				SecondIndicator.setText(" ");
			}
			colon = !colon;
			
		
			
		
		}
	}

