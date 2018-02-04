package ex03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextArea;

public class DirPathFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField txtEnterTheDirectory;
	private JTextField dirPathString;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirPathFrame frame = new DirPathFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DirPathFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 154);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		txtEnterTheDirectory = new JTextField();
		txtEnterTheDirectory.setFont(new Font("Times New Roman", Font.PLAIN, 21));
		txtEnterTheDirectory.setBackground(SystemColor.info);
		txtEnterTheDirectory.setEditable(false);
		txtEnterTheDirectory.setText("Enter The directory path:");
		contentPane.add(txtEnterTheDirectory, BorderLayout.CENTER);
		txtEnterTheDirectory.setColumns(10);
		
		dirPathString = new JTextField();
		dirPathString.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		contentPane.add(dirPathString, BorderLayout.SOUTH);
		dirPathString.setColumns(10);
	}

}
