package gui;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
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
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

public class ClockGui implements ActionListener {

	
	private JFrame frame;
	
	
	private static int[] time;
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
	private static JRadioButton EasyRadioButton;
	private static JRadioButton HardRadioButton;
	private ButtonGroup BtnGrp;
	private JLabel lblNewLabel_1;
	private JPanel panel;
	private static JSlider slider;

	
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
			//System.out.println("Second passed");
			displayClock();
		}
	private void initialize() {
		
		frame = new JFrame("FractionClock");
		BtnGrp = new ButtonGroup();
		

		
		frame.setBounds(100, 100, 450, 300);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[16.6%,grow][16.6%][16.6%][][16.6%,grow][16.6%][16.6%,grow]", "[10%][10%][10%:10%:10%][7.5%:7.5%:7.5%][10%:10%:10%][][15%,grow][10%][10%,grow][grow]"));
		
		HourNumeratorLabel = new JLabel("");
		HourNumeratorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		HourNumeratorLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		HourNumeratorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(HourNumeratorLabel, "cell 2 2,alignx center,aligny bottom");
		
		MinuteNumeratorLabel = new JLabel("");
		MinuteNumeratorLabel.setHorizontalAlignment(SwingConstants.CENTER);
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
		HourDominatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		HourDominatorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(HourDominatorLabel, "cell 2 4,alignx center,aligny top");
		
		MinuteDominatorLabel = new JLabel("");
		MinuteDominatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		MinuteDominatorLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 33));
		frame.getContentPane().add(MinuteDominatorLabel, "cell 4 4,alignx center,aligny top");
		
		panel = new JPanel();
		frame.getContentPane().add(panel, "cell 0 5 7 4,grow");
		panel.setLayout(new MigLayout("", "[49px][]", "[25px][][][]"));
		
		EasyRadioButton = new JRadioButton("Easy");
		EasyRadioButton.setSelected(true);
		panel.add(EasyRadioButton, "cell 0 2,alignx left,aligny top");
		BtnGrp.add(EasyRadioButton);
		BtnGrp.add(EasyRadioButton);
		
		HardRadioButton = new JRadioButton("Hard");
		panel.add(HardRadioButton, "cell 1 2");
		
		BtnGrp.add(HardRadioButton);
		
		lblNewLabel_1 = new JLabel("<html>complexity<br>(only hard):</html>");
		panel.add(lblNewLabel_1, "flowx,cell 0 3 2 1");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		
		slider = new JSlider();
		slider.setValue(500);
		slider.setMaximum(999);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMinorTickSpacing(100);
		slider.setMinimum(11);
		panel.add(slider, "cell 0 3 2 1");
	}
	
	private static void displayClock() {
			
			
			
			
			if(HardRadioButton.isSelected()) {
				
				time = clock.getRandomized(slider.getMinimum(),slider.getValue());
				HourNumeratorLabel.setText(Integer.toString(time[0]));
				HourDominatorLabel.setText(Integer.toString(time[1]));
				
				MinuteNumeratorLabel.setText(Integer.toString(time[2]));
				MinuteDominatorLabel.setText(Integer.toString(time[3]));
				
				System.out.println(slider.getValue());
			}
			if(EasyRadioButton.isSelected()) {
				HourNumeratorLabel.setText(Integer.toString(clock.getHour()[0]));
				HourDominatorLabel.setText(Integer.toString(clock.getHour()[1]));
				MinuteNumeratorLabel.setText(Integer.toString(clock.getMinute()[0]));
				MinuteDominatorLabel.setText(Integer.toString(clock.getMinute()[1]));
			
			}
			
			if(colon == true) {
				SecondIndicator.setText(":");
				
			}else if(colon == false){
				SecondIndicator.setText(" ");
			}
			colon = !colon;
			
		
			
		
		}
	}

