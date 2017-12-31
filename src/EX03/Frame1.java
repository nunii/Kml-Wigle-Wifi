package EX03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.DropMode;
import javax.swing.JInternalFrame;
import javax.swing.JSplitPane;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Frame1 {
	
	private String name,File,Path;
	private JFrame DirPathFrame;
	private JFrame frame;
	private JTextField textFieldName;
	private JTextField textFieldPosition;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
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
	public Frame1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(100, 100, 760, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldPosition = new JTextField();
		textFieldPosition.setColumns(10);
		textFieldPosition.setBounds(262, 227, 86, 20);
		frame.getContentPane().add(textFieldPosition);
		
		textFieldName = new JTextField();
		textFieldName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=textFieldName.getText();
			}
		});
		textFieldName.setBounds(262, 193, 86, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		JRadioButton radioButtonAltMax = new JRadioButton("Max");
		radioButtonAltMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonAltMax.setBackground(SystemColor.info);
		radioButtonAltMax.setBounds(291, 147, 57, 39);
		frame.getContentPane().add(radioButtonAltMax);
		
		JRadioButton radioButtonLonMax = new JRadioButton("Max");
		radioButtonLonMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLonMax.setBackground(SystemColor.info);
		radioButtonLonMax.setBounds(301, 113, 57, 39);
		frame.getContentPane().add(radioButtonLonMax);
		
		JRadioButton radioButtonLatMax = new JRadioButton("Max");
		radioButtonLatMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLatMax.setBackground(SystemColor.info);
		radioButtonLatMax.setBounds(301, 78, 57, 39);
		frame.getContentPane().add(radioButtonLatMax);
		
		JRadioButton radioButtonTimeMax = new JRadioButton("Max");
		radioButtonTimeMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonTimeMax.setBackground(SystemColor.info);
		radioButtonTimeMax.setBounds(301, 40, 57, 39);
		frame.getContentPane().add(radioButtonTimeMax);
		
		JButton buttonAddDir = new JButton("Add directory");
		buttonAddDir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DirPathFrame.dispose();
			//	DirPathFrame dirpath = new DirPathFrame;
			
			}
		});
		buttonAddDir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAddDir.setBounds(10, 8, 127, 39);
		frame.getContentPane().add(buttonAddDir);
		
		JButton buttonAddCSV = new JButton("Add CSV file");
		buttonAddCSV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAddCSV.setBounds(10, 58, 127, 39);
		frame.getContentPane().add(buttonAddCSV);
		
		JButton ButtonSaveToCSV = new JButton("Save to CSV file");
		ButtonSaveToCSV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ButtonSaveToCSV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		ButtonSaveToCSV.setBounds(10, 109, 127, 39);
		frame.getContentPane().add(ButtonSaveToCSV);
		
		JButton buttonClearData = new JButton("Clear data");
		buttonClearData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonClearData.setBounds(10, 159, 127, 39);
		frame.getContentPane().add(buttonClearData);
		
		JRadioButton radioButtonLatMin = new JRadioButton("Min");
		radioButtonLatMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLatMin.setBackground(SystemColor.info);
		radioButtonLatMin.setBounds(245, 78, 57, 39);
		frame.getContentPane().add(radioButtonLatMin);
		
		JRadioButton radioButtonTimeMin = new JRadioButton("Min");
		radioButtonTimeMin.setBackground(SystemColor.info);
		radioButtonTimeMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonTimeMin.setBounds(245, 40, 57, 39);
		frame.getContentPane().add(radioButtonTimeMin);
		
		JTextPane txtpnFilters = new JTextPane();
		txtpnFilters.setEditable(false);
		txtpnFilters.setForeground(new Color(0, 0, 0));
		txtpnFilters.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnFilters.setBackground(SystemColor.info);
		txtpnFilters.setText("Filters");
		txtpnFilters.setBounds(245, 8, 138, 47);
		frame.getContentPane().add(txtpnFilters);
		
		JRadioButton radioButtonLonMin = new JRadioButton("Min");
		radioButtonLonMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLonMin.setBackground(SystemColor.info);
		radioButtonLonMin.setBounds(245, 113, 57, 39);
		frame.getContentPane().add(radioButtonLonMin);
		
		JRadioButton radioButtonAltMin = new JRadioButton("Min");
		radioButtonAltMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonAltMin.setBackground(SystemColor.info);
		radioButtonAltMin.setBounds(245, 147, 57, 39);
		frame.getContentPane().add(radioButtonAltMin);
		
		JTextPane txtpnTimeLatLon = new JTextPane();
		txtpnTimeLatLon.setBackground(SystemColor.info);
		txtpnTimeLatLon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnTimeLatLon.setText("Time\r\n\r\nLat\r\n\r\nLon\r\n\r\nAlt\r\n\r\nName:\r\n\r\nPosition:");
		txtpnTimeLatLon.setBounds(204, 47, 93, 208);
		frame.getContentPane().add(txtpnTimeLatLon);
		
		JTextPane txtpnAlgorithms = new JTextPane();
		txtpnAlgorithms.setEditable(false);
		txtpnAlgorithms.setText("Algorithms\r\n");
		txtpnAlgorithms.setForeground(Color.BLACK);
		txtpnAlgorithms.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnAlgorithms.setBackground(SystemColor.info);
		txtpnAlgorithms.setBounds(507, 8, 138, 47);
		frame.getContentPane().add(txtpnAlgorithms);
		
		JButton ButtonFilterSubmit = new JButton("Submit");
		ButtonFilterSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ButtonFilterSubmit.setBounds(214, 266, 127, 39);
		frame.getContentPane().add(ButtonFilterSubmit);
		
		JButton buttonAlg1Submit = new JButton("Submit");
		buttonAlg1Submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAlg1Submit.setBounds(607, 67, 127, 39);
		frame.getContentPane().add(buttonAlg1Submit);
		
		JButton button = new JButton("Submit");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		button.setBounds(607, 266, 127, 39);
		frame.getContentPane().add(button);
	}
}
