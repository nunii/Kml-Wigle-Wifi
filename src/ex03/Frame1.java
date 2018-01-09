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
import java.util.concurrent.ForkJoinPool;

import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import java.awt.List;
import java.awt.ScrollPane;
import javax.swing.ListSelectionModel;

public class Frame1 extends JPanel implements ActionListener{

	private String name,File,Path,lat,alt,lon,radius,start,end,operator;
	private JFrame frame,DirPathFrame;
	private JTextField textFieldName, textFieldLat;
	private JTextArea log;
	private JFileChooser fc;
	private JButton buttonAddDir, buttonAddCSV, ButtonSaveToCSV, btnFilterdDataTo,
	buttonClearData, ButtonFilterSubmit, buttonAlg1Submit, btnAlgo;
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
	private JRadioButton rdbtnOr, rdbtnAnd;
	private JButton btnClearFilters;
	private JList list;

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
		textFieldTimeStart.setToolTipText("");
		textFieldTimeStart.setColumns(10);
		textFieldTimeStart.setBounds(244, 144, 113, 20);
		frame.getContentPane().add(textFieldTimeStart);

		textFieldLat = new JTextField();
		textFieldLat.setColumns(10);
		textFieldLat.setBounds(280, 107, 37, 20);
		frame.getContentPane().add(textFieldLat);

		textFieldName = new JTextField();
		textFieldName.addActionListener(this);
		textFieldName.setBounds(280, 67, 188, 20);
		frame.getContentPane().add(textFieldName);
		textFieldName.setColumns(10);

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

		ButtonSaveToCSV = new JButton("Data to CSV file");
		ButtonSaveToCSV.addActionListener(this);
		ButtonSaveToCSV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ButtonSaveToCSV.setBounds(10, 158, 127, 39);
		frame.getContentPane().add(ButtonSaveToCSV);

		buttonClearData = new JButton("Clear data");
		buttonClearData.addActionListener(this);
		buttonClearData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonClearData.setBounds(10, 287, 127, 39);
		frame.getContentPane().add(buttonClearData);

		btnAlgo = new JButton("Algo 2 - Submit");
		btnAlgo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAlgo.setBounds(607, 230, 127, 39);
		frame.getContentPane().add(btnAlgo);

		ButtonFilterSubmit = new JButton("Submit Filters");
		ButtonFilterSubmit.addActionListener(this);
		ButtonFilterSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ButtonFilterSubmit.setBounds(211, 287, 127, 39);
		frame.getContentPane().add(ButtonFilterSubmit);



		buttonAlg1Submit = new JButton("Algo 1 - Submit");
		buttonAlg1Submit.addActionListener(this);
		buttonAlg1Submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAlg1Submit.setBounds(607, 57, 127, 39);
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
		txtpnFilters.setText("Current filter:");
		txtpnFilters.setBounds(179, 195, 94, 27);
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
		textFieldTimeEnd.setColumns(10);
		textFieldTimeEnd.setBounds(367, 144, 113, 20);
		frame.getContentPane().add(textFieldTimeEnd);

		JTextPane txtpnfullName = new JTextPane();
		txtpnfullName.setEditable(false);
		txtpnfullName.setText("(Full name)\r\n");
		txtpnfullName.setBackground(SystemColor.info);
		txtpnfullName.setBounds(483, 72, 106, 20);
		frame.getContentPane().add(txtpnfullName);

		textFieldLon = new JTextField();
		textFieldLon.setColumns(10);
		textFieldLon.setBounds(327, 107, 38, 20);
		frame.getContentPane().add(textFieldLon);

		textFieldAlt = new JTextField();
		textFieldAlt.setColumns(10);
		textFieldAlt.setBounds(376, 107, 37, 20);
		frame.getContentPane().add(textFieldAlt);

		textPanePos = new JTextPane();
		textPanePos.setEditable(false);
		textPanePos.setText("(Lat Lon Alt Radius)\r\n");
		textPanePos.setBackground(SystemColor.info);
		textPanePos.setBounds(483, 107, 106, 20);
		frame.getContentPane().add(textPanePos);

		textPaneTime = new JTextPane();
		textPaneTime.setEditable(false);
		textPaneTime.setText("(Begin) (End )\r\n");
		textPaneTime.setBackground(SystemColor.info);
		textPaneTime.setBounds(495, 144, 106, 20);
		frame.getContentPane().add(textPaneTime);

		textFieldRad = new JTextField();
		textFieldRad.setColumns(10);
		textFieldRad.setBounds(423, 107, 37, 20);
		frame.getContentPane().add(textFieldRad);
		
		JTextPane txtpnDdmmyyyyHhmmss = new JTextPane();
		txtpnDdmmyyyyHhmmss.setText("       dd-MM-yyyy HH:mm:ss");
		txtpnDdmmyyyyHhmmss.setEditable(false);
		txtpnDdmmyyyyHhmmss.setBackground(SystemColor.info);
		txtpnDdmmyyyyHhmmss.setBounds(221, 164, 138, 20);
		frame.getContentPane().add(txtpnDdmmyyyyHhmmss);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("       dd-MM-yyyy HH:mm:ss");
		textPane.setEditable(false);
		textPane.setBackground(SystemColor.info);
		textPane.setBounds(345, 164, 138, 20);
		frame.getContentPane().add(textPane);
		
		btnFilterdDataTo = new JButton("Filterd data\r\nto CSV file");
		btnFilterdDataTo.addActionListener(this);
		btnFilterdDataTo.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnFilterdDataTo.setBounds(10, 208, 127, 39);
		frame.getContentPane().add(btnFilterdDataTo);
		
		JTextPane txtpnMacPositionTime = new JTextPane();
		txtpnMacPositionTime.setText("\r\nMac:\r\n\r\nPosition:\r\n\r\nTime:");
		txtpnMacPositionTime.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnMacPositionTime.setBackground(SystemColor.info);
		txtpnMacPositionTime.setBounds(179, 45, 55, 127);
		frame.getContentPane().add(txtpnMacPositionTime);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		textPane_2.setBackground(Color.WHITE);
		textPane_2.setBounds(280, 195, 200, 20);
		textPane_2.setText(Data.currentFilter());
		frame.getContentPane().add(textPane_2);
		
		JTextPane txtpnToAddFilter = new JTextPane();
		txtpnToAddFilter.setText("To add filter, choose OR / AND:");
		txtpnToAddFilter.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnToAddFilter.setBackground(SystemColor.info);
		txtpnToAddFilter.setBounds(179, 242, 204, 27);
		frame.getContentPane().add(txtpnToAddFilter);
		
		rdbtnOr = new JRadioButton("OR");
		/*if(!rdbtnAnd.isSelected())
			rdbtnOr.setEnabled(false);
		else
		*/	rdbtnOr.setEnabled(true);
		rdbtnOr.addActionListener(this);
		rdbtnOr.setBackground(UIManager.getColor("info"));
		rdbtnOr.setBounds(389, 242, 47, 23);
		frame.getContentPane().add(rdbtnOr);
		
		rdbtnAnd = new JRadioButton("AND");
		/*if(!rdbtnOr.isSelected())
			rdbtnAnd.setEnabled(false);
		else
		*/	rdbtnAnd.setEnabled(true);			
		rdbtnAnd.addActionListener(this);
		rdbtnAnd.setBackground(UIManager.getColor("info"));
		rdbtnAnd.setBounds(438, 242, 55, 23);
		frame.getContentPane().add(rdbtnAnd);
		
		btnClearFilters = new JButton("Clear Filters");
		btnClearFilters.addActionListener(this);
		btnClearFilters.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnClearFilters.setBounds(374, 287, 106, 39);
		frame.getContentPane().add(btnClearFilters);
		
		list = new JList();
		list.setValueIsAdjusting(true);
		list.setDragEnabled(true);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(617, 126, 117, 20);
		frame.getContentPane().add(list);
		
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
				log.append("Opening: " + dir.getPath() + ".");
			} else {
				log.append("Open command cancelled by user.");
			}
			list.setListData(Data.myVector);
		}
		if(e.getSource()==buttonAddCSV){
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddCSV);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				Data.addCSV(file.getPath());
				//This is where a real application would open the file.
				log.append("Opening: " + file.getName() + ".");
			} else {
				log.append("Open command cancelled by user.");
			}
			list.setListData(Data.myVector);
		}
		
		if(e.getSource()==ButtonSaveToCSV){
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddDir);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				dir = fc.getSelectedFile();
				Data.toCSV(dir.getPath());
				log.append("Opening: " + file.getName() + ".");
			} else {
				log.append("Open command cancelled by user.");
			}
		}
		
		if(e.getSource()==btnFilterdDataTo){
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddDir);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				dir = fc.getSelectedFile();
				Data.FilterstoCSV(dir.getPath());
				log.append("Opening: " + file.getName() + ".");
			} else {
				log.append("Open command cancelled by user.");
			}
		}
		
		if(e.getSource()==buttonClearData)
			Data.ClearData();
		
		if(e.getSource()==btnClearFilters)
			Data.ClearFilters();
			
		
		
		// Submitting filters
		if(e.getSource()==ButtonFilterSubmit) {
			name=textFieldName.getText();
			lat=textFieldLat.getText();
			lon=textFieldLon.getText();
			alt=textFieldAlt.getText();
			radius=textFieldRad.getText();
			start=textFieldTimeStart.getText();
			end=textFieldTimeEnd.getText();
			
			if(rdbtnAnd.isSelected())
				operator = "And";
			else
				if(rdbtnOr.isSelected())
					operator = "OR";
				else
					operator = null;
			//wifi filter by mac name
			if(name!=null) {
				Data.macFilter(name,operator);
			}
			//filter by position
			if(lat!=null && lon!=null){
				if(alt==null){
					Data.positionfilter(lat, lon, "0", radius, operator);
				}
				else {
					Data.positionfilter(lat, lon, alt, radius, operator);
				}
			}
			//filter by time
			if(start!=null&&end!=null){
				Data.Timefilter(start, end, operator);
			}

		}
	}
}



