package main.java.gui_pack;


import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import main.java.data_classes.Samples;

public class Frame1 extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7605024166767458056L;
	/**
		 * @author amit nuni bar janach
		 * this class is the implemention of the gui.
		 */
	
	public Data data;
	private String mac=null,name,lat,alt,lon,radius,start,end,operator;
	public JFrame frame,DirPathFrame;
	private JTextField textFieldLat;
	private JTextArea log;
	private JFileChooser fc;
	private JButton buttonAddDir, buttonAddCSV, ButtonSaveToCSV, btnFilterdDataTo,
	buttonClearData, ButtonFilterSubmit, buttonAlg1Submit, btnAlgo;
	private JTextPane txtpnFiltersHeader, txtpnFilters, txtpnAlgorithms;
	private JButton buttonToKML, btnAddSqlTable;
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
	private JTextPane textPanePos, textPaneMacPos;
	private JTextPane textPaneTime;
	private JTextField textFieldRad;
	private JRadioButton rdbtnOr, rdbtnAnd;
	private JButton btnClearFilters;
	private JList<String> list, list_1;
	private JScrollPane scrollPane, scrollPane_1;
	private JTextField IP;
	private JTextField URL;
	private JTextField User;
	private JTextField Password;
	private JTextPane txtpnUrl;
	private JTextPane txtpnUser;
	private JTextPane txtpnPassword;

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
		data = new Data();
		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);
		JScrollPane logScrollPane = new JScrollPane(log);

		fc = new JFileChooser();

		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.info);
		frame.setBounds(150, 150, 1140, 565);
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

		buttonAddDir = new JButton("Add directory");
		buttonAddDir.addActionListener(this);
		buttonAddDir.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAddDir.setBounds(10, 8, 127, 39);
		frame.getContentPane().add(buttonAddDir);

		buttonAddCSV = new JButton("Add CSV file");
		buttonAddCSV.addActionListener(this);
		buttonAddCSV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAddCSV.setBounds(10, 53, 127, 39);
		frame.getContentPane().add(buttonAddCSV);

		ButtonSaveToCSV = new JButton("Data to CSV file");
		ButtonSaveToCSV.addActionListener(this);
		ButtonSaveToCSV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		ButtonSaveToCSV.setBounds(10, 158, 127, 39);
		frame.getContentPane().add(ButtonSaveToCSV);

		buttonClearData = new JButton("Clear data");
		buttonClearData.addActionListener(this);
		buttonClearData.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonClearData.setBounds(10, 461, 127, 39);
		frame.getContentPane().add(buttonClearData);

		btnAlgo = new JButton("Algo 2 - Submit");
		btnAlgo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnAlgo.setBounds(607, 176, 127, 39);
		frame.getContentPane().add(btnAlgo);

		ButtonFilterSubmit = new JButton("Submit Filters");
		ButtonFilterSubmit.addActionListener(this);
		ButtonFilterSubmit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ButtonFilterSubmit.setBounds(211, 287, 127, 39);
		frame.getContentPane().add(ButtonFilterSubmit);



		buttonAlg1Submit = new JButton("Algo 1 - Submit");
		buttonAlg1Submit.addActionListener(this);
		buttonAlg1Submit.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		buttonAlg1Submit.setBounds(607, 45, 127, 39);
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
		buttonToKML.setBounds(10, 107, 127, 39);
		frame.getContentPane().add(buttonToKML);

		textFieldTimeEnd = new JTextField();
		textFieldTimeEnd.setColumns(10);
		textFieldTimeEnd.setBounds(367, 144, 113, 20);
		frame.getContentPane().add(textFieldTimeEnd);

		JTextPane txtpnfullName = new JTextPane();
		txtpnfullName.setEditable(false);
		txtpnfullName.setText("(Full name)\r\n");
		txtpnfullName.setBackground(SystemColor.info);
		txtpnfullName.setBounds(483, 72, 67, 20);
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
		textPaneTime.setBounds(483, 144, 81, 20);
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
		
		btnFilterdDataTo = new JButton("Filterd data\r \nto CSV file");
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
		textPane_2.setText(data.currentFilter());
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
		
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setValueIsAdjusting(true);
		list.setDragEnabled(true);
		list.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
			    if (e.getValueIsAdjusting() == true) {

			        if (list.getSelectedIndex() != -1) {
			        //No selection, disable fire button.
			        	mac = (String)list.getSelectedValue(); 
			        }
			        else
			        	mac = null;
			    }
			}	
		});
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setBackground(new Color(255, 255, 255));
		list.setBounds(617, 145, 117, 20);
		frame.getContentPane().add(list);
		
		scrollPane = new JScrollPane(list);
		scrollPane.setBounds(607, 107, 127, 21);
		frame.getContentPane().add(scrollPane);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		JTextPane txtpnMacAdresses = new JTextPane();
		txtpnMacAdresses.setBackground(SystemColor.info);
		txtpnMacAdresses.setText("Mac Adresses:");
		txtpnMacAdresses.setBounds(607, 84, 127, 20);
		frame.getContentPane().add(txtpnMacAdresses);
		
		JTextPane txtpnPosition = new JTextPane();
		txtpnPosition.setBackground(SystemColor.info);
		txtpnPosition.setText("Position:");
		txtpnPosition.setBounds(607, 126, 127, 18);
		frame.getContentPane().add(txtpnPosition);
		
		textPaneMacPos = new JTextPane();
		textPaneMacPos.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPaneMacPos.setBackground(Color.WHITE);
		textPaneMacPos.setBounds(579, 145, 155, 20);
		frame.getContentPane().add(textPaneMacPos);
		
		list_1 = new JList<String>();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setValueIsAdjusting(true);
		list_1.setDragEnabled(true);
		list_1.addListSelectionListener(new ListSelectionListener(){
			@Override
			public void valueChanged(ListSelectionEvent e) {
			    if (e.getValueIsAdjusting() == true) {
			    	System.out.println("i'm in");
			        if (list_1.getSelectedIndex() != -1) {
			        //No selection, disable fire button.
			        	name = (String)list_1.getSelectedValue(); 
			        	//System.out.println("name: "+name);
			        }
			        else{
			        	name = null;
			        }
			    }
			}	
		});
		list_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		list_1.setBackground(new Color(255, 255, 255));
		list_1.setBounds(275, 61, 174, 27);
		frame.getContentPane().add(list_1);
		
		scrollPane_1 = new JScrollPane(list_1);
		scrollPane_1.setBounds(280, 66, 180, 20);
		frame.getContentPane().add(scrollPane_1);
		scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		btnAddSqlTable = new JButton("Add SQL Table");
		btnAddSqlTable.addActionListener(this);
		btnAddSqlTable.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnAddSqlTable.setBounds(10, 373, 127, 39);
		frame.getContentPane().add(btnAddSqlTable);
		
		IP = new JTextField();
		IP.setColumns(10);
		IP.setBounds(244, 378, 94, 20);
		frame.getContentPane().add(IP);
		
		URL = new JTextField();
		URL.setColumns(10);
		URL.setBounds(399, 378, 267, 20);
		frame.getContentPane().add(URL);
		
		User = new JTextField();
		User.setColumns(10);
		User.setBounds(254, 409, 84, 20);
		frame.getContentPane().add(User);
		
		Password = new JTextField();
		Password.setColumns(10);
		Password.setBounds(423, 409, 106, 20);
		frame.getContentPane().add(Password);
		
		JTextPane txtpnIp = new JTextPane();
		txtpnIp.setText("IP:");
		txtpnIp.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnIp.setBackground(SystemColor.info);
		txtpnIp.setBounds(211, 373, 28, 27);
		frame.getContentPane().add(txtpnIp);
		
		txtpnUrl = new JTextPane();
		txtpnUrl.setText("URL:");
		txtpnUrl.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnUrl.setBackground(SystemColor.info);
		txtpnUrl.setBounds(355, 373, 47, 27);
		frame.getContentPane().add(txtpnUrl);
		
		txtpnUser = new JTextPane();
		txtpnUser.setText("User:");
		txtpnUser.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnUser.setBackground(SystemColor.info);
		txtpnUser.setBounds(211, 407, 47, 27);
		frame.getContentPane().add(txtpnUser);
		
		txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password:");
		txtpnPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtpnPassword.setBackground(SystemColor.info);
		txtpnPassword.setBounds(355, 407, 67, 27);
		frame.getContentPane().add(txtpnPassword);
	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		/**
				 * @author amit nuni bar janach
				 * this func reacting according to actions preformed on the frame.
				 */
		
		if(e.getSource()==buttonAddDir){
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddDir);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				dir = fc.getSelectedFile();
				data.addDir(dir.getPath());
				log.append("Opening: " + dir.getPath() + ".");
			} else {
				log.append("Open command cancelled by user.");
			}
			list.setListData(data.myVector);
			list_1.setListData(data.myVector);
		}
		if(e.getSource()==buttonAddCSV){
			fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddCSV);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				file = fc.getSelectedFile();
				data.addCSV(file.getPath());
				//This is where a real application would open the file.
				log.append("Opening: " + file.getName() + ".");
			} else {
				log.append("Open command cancelled by user.");
			}
			list.setListData(data.myVector);
			list_1.setListData(data.myVector);
		}
		
		if(e.getSource()==ButtonSaveToCSV){
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddDir);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				dir = fc.getSelectedFile();
				data.toCSV(dir.getPath());
				//log.append("Opening: " + file.getName() + ".");
			} else {
				//log.append("Open command cancelled by user.");
			}
		}
		
		if(e.getSource()==btnFilterdDataTo){
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(buttonAddDir);
			if (returnVal == JFileChooser.APPROVE_OPTION){
				dir = fc.getSelectedFile();
				data.FilterstoCSV(dir.getPath());
				//log.append("Opening: " + file.getName() + ".");
			} else {
				//log.append("Open command cancelled by user.");
			}
		}
		
		if(e.getSource()==buttonClearData)
			data.ClearData();
		
		if(e.getSource()==btnClearFilters)
			data.ClearFilters();
			
		
		// Submitting filters
		if(e.getSource()==ButtonFilterSubmit) {
			lat=textFieldLat.getText();
			lon=textFieldLon.getText();
			alt=textFieldAlt.getText();
			radius=textFieldRad.getText();
			start=textFieldTimeStart.getText();
			end=textFieldTimeEnd.getText();
//			System.out.println("name: "+name+" lat:"+lat+" lon:"+lon+" radius:"+radius+" start:"+start);
//			System.out.println((name==null)+","+(lat==null)+","+(radius==null)+","+(start==null));
			if(rdbtnAnd.isSelected())
				operator = "And";
			else
				if(rdbtnOr.isSelected())
					operator = "OR";
				else
					operator = null;
			//wifi filter by mac name
			if(name!=null) {
				data.macFilter(name,operator);
			}
			//filter by position
			if(!lat.equals("") && !lon.equals("")){
				if(alt.equals("")){
					data.positionfilter(lat, lon, "0", radius, operator);
				}
				else {
					data.positionfilter(lat, lon, alt, radius, operator);
				}
			}
			//filter by time
			if(!start.equals("")&&!end.equals("")){
				data.Timefilter(start, end, operator);
			}
			list_1.clearSelection();
		}
		
		if(e.getSource()==buttonAlg1Submit){
			if(mac!=null){
				textPaneMacPos.setText(data.getPositionAlg1(mac));
			}
			list.clearSelection();
		}
		
		if(e.getSource()==btnAddSqlTable) {
			String ip, url, user, pass;
			ip = IP.getText();
			url = URL.getText();
			user = User.getText();
			pass = Password.getText();
			data.addSQLtable(ip, url, user, pass);
			list.setListData(data.myVector);
			list_1.setListData(data.myVector);
		}
	}

	/**
		 * @author amit nuni bar janach
		 * always checking if files has been changed.
		 */
	
	public void ifModified(){
		System.out.println("1");
		int size = data.modified.size();
		String[] file = new String[2];
		for (int i = 0; i < size; i++) {
			file = data.modified.get(i).split(",");
			File newfile = new File(file[0]);
			if(!newfile.exists()||!String.valueOf(newfile.lastModified()).equals(file[1])){
				System.out.println("2");
				if(!newfile.exists())
					data.modified.remove(i);
				ArrayList<String> mod = new ArrayList<String>();
				mod.addAll(data.modified);
				data.ClearData();
				for (int j = 0; j < mod.size(); j++) {
					System.out.println("s");
					file = mod.get(j).split(",");
					data.addCSV(file[0]);
				}
				i = size;
			}
		}
	}
}



