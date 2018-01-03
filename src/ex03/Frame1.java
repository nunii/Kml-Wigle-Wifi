package ex03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;

import Data_classes.Samples;
import EX01.Rashi;
import ex02.Rashi2;
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
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import javafx.stage.FileChooser;
import java.io.File;
import javax.swing.JTextArea;

public class Frame1 extends JPanel implements ActionListener{
	
	private String name,File,Path;
	private JFrame frame,DirPathFrame;
	private JTextField textFieldName, textFieldPosition;
	private JTextArea log;
	private JFileChooser fc;
	private JRadioButton radioButtonAltMax, radioButtonLonMax, radioButtonLatMax,
				radioButtonTimeMax, radioButtonLatMin, radioButtonTimeMin,
				radioButtonLonMin, radioButtonAltMin;
	private JButton buttonAddDir, buttonAddCSV, ButtonSaveToCSV, buttonClearData,
			ButtonFilterSubmit, buttonAlg1Submit, button;
	private JTextPane txtpnFilters, txtpnTimeLatLon, txtpnAlgorithms;
	private JButton buttonToKML;
	File file,dir;
	Samples samps = new Samples();
	
	/**
	 * @wbp.nonvisual location=76,259
	 */
	
	
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
		
		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
	    JScrollPane logScrollPane = new JScrollPane(log);
		
	    fc = new JFileChooser();
	    
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
		textFieldName.addActionListener(this);
		textFieldName.setBounds(262, 193, 86, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		radioButtonAltMax = new JRadioButton("Max");
		radioButtonAltMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonAltMax.setBackground(SystemColor.info);
		radioButtonAltMax.setBounds(291, 147, 57, 39);
		frame.getContentPane().add(radioButtonAltMax);
		
		radioButtonLonMax = new JRadioButton("Max");
		radioButtonLonMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLonMax.setBackground(SystemColor.info);
		radioButtonLonMax.setBounds(301, 113, 57, 39);
		frame.getContentPane().add(radioButtonLonMax);
		
		radioButtonLatMax = new JRadioButton("Max");
		radioButtonLatMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLatMax.setBackground(SystemColor.info);
		radioButtonLatMax.setBounds(301, 78, 57, 39);
		frame.getContentPane().add(radioButtonLatMax);
		
		radioButtonTimeMax = new JRadioButton("Max");
		radioButtonTimeMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonTimeMax.setBackground(SystemColor.info);
		radioButtonTimeMax.setBounds(301, 40, 57, 39);
		frame.getContentPane().add(radioButtonTimeMax);
		
		radioButtonLatMin = new JRadioButton("Min");
		radioButtonLatMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLatMin.setBackground(SystemColor.info);
		radioButtonLatMin.setBounds(245, 78, 57, 39);
		frame.getContentPane().add(radioButtonLatMin);
		
		radioButtonTimeMin = new JRadioButton("Min");
		radioButtonTimeMin.setBackground(SystemColor.info);
		radioButtonTimeMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonTimeMin.setBounds(245, 40, 57, 39);
		frame.getContentPane().add(radioButtonTimeMin);
		
		radioButtonLonMin = new JRadioButton("Min");
		radioButtonLonMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLonMin.setBackground(SystemColor.info);
		radioButtonLonMin.setBounds(245, 113, 57, 39);
		frame.getContentPane().add(radioButtonLonMin);
		
		radioButtonAltMin = new JRadioButton("Min");
		radioButtonAltMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonAltMin.setBackground(SystemColor.info);
		radioButtonAltMin.setBounds(245, 147, 57, 39);
		frame.getContentPane().add(radioButtonAltMin);
		
		buttonAddDir = new JButton("Add directory");
		buttonAddDir.addActionListener(this);
		buttonAddDir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAddDir.setBounds(10, 8, 127, 39);
		frame.getContentPane().add(buttonAddDir);
		
		buttonAddCSV = new JButton("Add CSV file");
		buttonAddCSV.addActionListener(this);
		buttonAddCSV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAddCSV.setBounds(10, 107, 127, 39);
		frame.getContentPane().add(buttonAddCSV);
		
		ButtonSaveToCSV = new JButton("Save to CSV file");
		ButtonSaveToCSV.addActionListener(this);
		ButtonSaveToCSV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ButtonSaveToCSV.setBounds(10, 158, 127, 39);
		frame.getContentPane().add(ButtonSaveToCSV);
		
		buttonClearData = new JButton("Clear data");
		buttonClearData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonClearData.setBounds(10, 208, 127, 39);
		frame.getContentPane().add(buttonClearData);
		
		button = new JButton("Submit");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		button.setBounds(607, 266, 127, 39);
		frame.getContentPane().add(button);
		
		ButtonFilterSubmit = new JButton("Submit");
		ButtonFilterSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ButtonFilterSubmit.setBounds(214, 266, 127, 39);
		frame.getContentPane().add(ButtonFilterSubmit);
		
		buttonAlg1Submit = new JButton("Submit");
		buttonAlg1Submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAlg1Submit.setBounds(607, 67, 127, 39);
		frame.getContentPane().add(buttonAlg1Submit);
		
		
		txtpnFilters = new JTextPane();
		txtpnFilters.setEditable(false);
		txtpnFilters.setForeground(new Color(0, 0, 0));
		txtpnFilters.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnFilters.setBackground(SystemColor.info);
		txtpnFilters.setText("Filters");
		txtpnFilters.setBounds(245, 8, 138, 47);
		frame.getContentPane().add(txtpnFilters);
		
		
		txtpnTimeLatLon = new JTextPane();
		txtpnTimeLatLon.setBackground(SystemColor.info);
		txtpnTimeLatLon.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnTimeLatLon.setText("Time\r\n\r\nLat\r\n\r\nLon\r\n\r\nAlt\r\n\r\nName:\r\n\r\nPosition:");
		txtpnTimeLatLon.setBounds(204, 47, 93, 208);
		frame.getContentPane().add(txtpnTimeLatLon);
		
		txtpnAlgorithms = new JTextPane();
		txtpnAlgorithms.setEditable(false);
		txtpnAlgorithms.setText("Algorithms\r\n");
		txtpnAlgorithms.setForeground(Color.BLACK);
		txtpnAlgorithms.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnAlgorithms.setBackground(SystemColor.info);
		txtpnAlgorithms.setBounds(507, 8, 138, 47);
		frame.getContentPane().add(txtpnAlgorithms);
		
		buttonToKML = new JButton("Dir to KML");
		buttonToKML.addActionListener(this);
		buttonToKML.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonToKML.setBounds(10, 57, 127, 39);
		frame.getContentPane().add(buttonToKML);
		
	}
	
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==buttonAddDir){
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddDir);
	        if (returnVal == JFileChooser.APPROVE_OPTION){
	            dir = fc.getSelectedFile();
	            Data.addDir(dir.getPath());
	            log.append("Opening: " + file.getName() + ".");
	        } else {
	        	log.append("Open command cancelled by user.");
	        }
		}
		if(e.getSource()==buttonAddCSV){
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddCSV);
	        if (returnVal == JFileChooser.APPROVE_OPTION) {
	            file = fc.getSelectedFile();
	            Data.addCSV(file.getPath());
	            System.out.println(file.getName());
	            String[] s = {file.getPath()};
	            Rashi2.main(s);
	            //This is where a real application would open the file.
	            log.append("Opening: " + file.getName() + ".");
	        } else {
	        	log.append("Open command cancelled by user.");
	        }
		}
		if(e.getSource()==buttonToKML){
			String[] s = {dir.getPath()};
			Rashi.main(s);
		}
		
		if(e.getSource()==textFieldName){
			name=textFieldName.getText();
		}
	}

	
}
