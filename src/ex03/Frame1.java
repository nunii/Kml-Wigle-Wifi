package ex03;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.TextField;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;

import Data_classes.Position;
import Data_classes.Samples;
import EX01.Rashi;
import EX01.WriteToKml;
import Filter.Filter;
import Filter.WifiFilter;
import Filter.positionFilter;
import Filter.positionFilterTest;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.stage.FileChooser;
import java.io.File;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;

public class Frame1 extends JPanel implements ActionListener{

	private String name,File,Path,lat,alt,lon,radius,start,end;
	private JFrame frame,DirPathFrame;
	private JTextField textFieldName, textFieldLat;
	private JTextArea log;
	private JFileChooser fc;
	private JRadioButton radioButtonAltMax, radioButtonLonMax, radioButtonLatMax, radioButtonLatMin,
	radioButtonLonMin, radioButtonAltMin;
	private JButton buttonAddDir, buttonAddCSV, ButtonSaveToCSV, buttonClearData,
	ButtonFilterSubmit, buttonAlg1Submit, button;
	private JTextPane txtpnFiltersHeader, txtpnFilters, txtpnAlgorithms;
	private JButton buttonToKML;
	File file,dir;
	Samples samps = new Samples();
	private final ButtonGroup Time = new ButtonGroup();
	private final ButtonGroup Lat = new ButtonGroup();
	private final ButtonGroup Lon = new ButtonGroup();
	private final ButtonGroup Alt = new ButtonGroup();
	private JTextField textFieldTimeStart;
	private JTextField textFieldTimeEnd;
	private JTextField textFieldLon;
	private JTextField textFieldAlt;
	private JTextPane textPanePos;
	private JTextPane textPaneTime;
	private JTextField textFieldRad;

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

		textFieldTimeStart = new JTextField();
		textFieldTimeStart.setText("yyy-mm-dd  hh:mm:ss");
		textFieldTimeStart.setColumns(10);
		textFieldTimeStart.setBounds(245, 227, 113, 20);
		frame.getContentPane().add(textFieldTimeStart);

		textFieldLat = new JTextField();
		textFieldLat.setColumns(10);
		textFieldLat.setBounds(262, 193, 37, 20);
		frame.getContentPane().add(textFieldLat);

		textFieldName = new JTextField();
		textFieldName.addActionListener(this);
		textFieldName.setBounds(262, 158, 188, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

		radioButtonAltMax = new JRadioButton("Max");
		Alt.add(radioButtonAltMax);
		radioButtonAltMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonAltMax.setBackground(SystemColor.info);
		radioButtonAltMax.setBounds(301, 113, 57, 39);
		frame.getContentPane().add(radioButtonAltMax);

		radioButtonLonMax = new JRadioButton("Max");
		Lon.add(radioButtonLonMax);
		radioButtonLonMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLonMax.setBackground(SystemColor.info);
		radioButtonLonMax.setBounds(301, 78, 57, 39);
		frame.getContentPane().add(radioButtonLonMax);

		radioButtonLatMax = new JRadioButton("Max");
		Lat.add(radioButtonLatMax);
		radioButtonLatMax.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLatMax.setBackground(SystemColor.info);
		radioButtonLatMax.setBounds(301, 41, 57, 39);
		frame.getContentPane().add(radioButtonLatMax);

		radioButtonLatMin = new JRadioButton("Min");
		Lat.add(radioButtonLatMin);
		radioButtonLatMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLatMin.setBackground(SystemColor.info);
		radioButtonLatMin.setBounds(245, 41, 57, 39);
		frame.getContentPane().add(radioButtonLatMin);

		radioButtonLonMin = new JRadioButton("Min");
		Lon.add(radioButtonLonMin);
		radioButtonLonMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonLonMin.setBackground(SystemColor.info);
		radioButtonLonMin.setBounds(245, 78, 57, 39);
		frame.getContentPane().add(radioButtonLonMin);


		radioButtonAltMin = new JRadioButton("Min");
		Alt.add(radioButtonAltMin);
		radioButtonAltMin.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		radioButtonAltMin.setBackground(SystemColor.info);
		radioButtonAltMin.setBounds(245, 113, 57, 39);
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
		button.setBounds(607, 287, 127, 39);
		frame.getContentPane().add(button);

		ButtonFilterSubmit = new JButton("Submit");
		ButtonFilterSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ButtonFilterSubmit.setBounds(292, 287, 127, 39);
		frame.getContentPane().add(ButtonFilterSubmit);



		buttonAlg1Submit = new JButton("Submit");
		buttonAlg1Submit.addActionListener(this);
		buttonAlg1Submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAlg1Submit.setBounds(607, 67, 127, 39);
		frame.getContentPane().add(buttonAlg1Submit);


		txtpnFiltersHeader = new JTextPane();
		txtpnFiltersHeader.setEditable(false);
		txtpnFiltersHeader.setForeground(new Color(0, 0, 0));
		txtpnFiltersHeader.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnFiltersHeader.setBackground(SystemColor.info);
		txtpnFiltersHeader.setText("Filters");
		txtpnFiltersHeader.setBounds(245, 8, 138, 47);
		frame.getContentPane().add(txtpnFiltersHeader);


		txtpnFilters = new JTextPane();
		txtpnFilters.setBackground(SystemColor.info);
		txtpnFilters.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnFilters.setText("Lat\r\n\r\nLon\r\n\r\nAlt\r\n\r\nName:\r\n\r\nPosition:\r\n\r\nTime:");
		txtpnFilters.setBounds(204, 47, 93, 208);
		frame.getContentPane().add(txtpnFilters);

		txtpnAlgorithms = new JTextPane();
		txtpnAlgorithms.setEditable(false);
		txtpnAlgorithms.setText("Algorithms\r\n");
		txtpnAlgorithms.setForeground(Color.BLACK);
		txtpnAlgorithms.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		txtpnAlgorithms.setBackground(SystemColor.info);
		txtpnAlgorithms.setBounds(559, 8, 138, 47);
		frame.getContentPane().add(txtpnAlgorithms);

		buttonToKML = new JButton("Dir to KML");
		buttonToKML.addActionListener(this);
		buttonToKML.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonToKML.setBounds(10, 57, 127, 39);
		frame.getContentPane().add(buttonToKML);

		textFieldTimeEnd = new JTextField();
		textFieldTimeEnd.setText("yyy-mm-dd  hh:mm:ss");
		textFieldTimeEnd.setColumns(10);
		textFieldTimeEnd.setBounds(368, 227, 113, 20);
		frame.getContentPane().add(textFieldTimeEnd);

		JTextPane txtpnfullName = new JTextPane();
		txtpnfullName.setEditable(false);
		txtpnfullName.setText("(Full name)\r\n");
		txtpnfullName.setBackground(SystemColor.info);
		txtpnfullName.setBounds(483, 158, 106, 20);
		frame.getContentPane().add(txtpnfullName);

		textFieldLon = new JTextField();
		textFieldLon.setColumns(10);
		textFieldLon.setBounds(309, 193, 38, 20);
		frame.getContentPane().add(textFieldLon);

		textFieldAlt = new JTextField();
		textFieldAlt.setColumns(10);
		textFieldAlt.setBounds(358, 193, 37, 20);
		frame.getContentPane().add(textFieldAlt);

		textPanePos = new JTextPane();
		textPanePos.setEditable(false);
		textPanePos.setText("(Lat Lon Alt Radius)\r\n");
		textPanePos.setBackground(SystemColor.info);
		textPanePos.setBounds(483, 193, 106, 20);
		frame.getContentPane().add(textPanePos);

		textPaneTime = new JTextPane();
		textPaneTime.setEditable(false);
		textPaneTime.setText("(Begin) (End )\r\n");
		textPaneTime.setBackground(SystemColor.info);
		textPaneTime.setBounds(483, 227, 106, 20);
		frame.getContentPane().add(textPaneTime);

		textFieldRad = new JTextField();
		textFieldRad.setColumns(10);
		textFieldRad.setBounds(405, 193, 37, 20);
		frame.getContentPane().add(textFieldRad);

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

		/*if(e.getSource()==textFieldName){
			name=textFieldName.getText();
		}*/

		// Submitting ALG1
		if(e.getSource()==buttonAlg1Submit) {
			name=textFieldName.getText();
			lat=textFieldLat.getText();
			lon=textFieldLon.getText();
			alt=textFieldAlt.getText();
			radius=textFieldRad.getText();
			start=textFieldTimeStart.getText();
			end=textFieldTimeEnd.getText();
			//wifi filter by name
			if(name!=null) {
				Filter wffilt = new WifiFilter(name);
				WriteToKml.write(samps.Filter(wffilt),Path+"PosFilt.kml");
			}
			//filter by position
			if(lat!=null && lon!=null){
				if(alt==null){
					Position pos = new Position(lat, lon);
					Filter posFilt = new positionFilter(pos,Double.parseDouble(radius));
					WriteToKml.write(samps.Filter(posFilt), Path+"PosFilt.kml");
				}
				else {
					Position pos = new Position(lat, lon, alt);
					Filter posFilt = new positionFilter(pos,Double.parseDouble(radius));
					WriteToKml.write(samps.Filter(posFilt), Path+"PosFilt.kml");
				}
			}
			//filter by time
			

		}
	}
}



