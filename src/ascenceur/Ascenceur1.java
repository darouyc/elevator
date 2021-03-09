package ascenceur;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class Ascenceur1 {

	private JFrame frmAscenceur;
	private JPanel contentPane;
	private static int etage;
	Panel pn_door;
	Point current_pos;
	int update;
	boolean work=true;
	ArrayList<Integer> nbre =new ArrayList<Integer>();
	ArrayList<Tools> person =new ArrayList<Tools>();
	
	int destination;
	int timer;
	Tools value;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ascenceur1 window = new Ascenceur1();
					window.frmAscenceur.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ascenceur1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAscenceur = new JFrame();
		frmAscenceur.setIconImage(Toolkit.getDefaultToolkit().getImage(Ascenceur1.class.getResource("/ascenceur/img/ascenceur.png")));
		frmAscenceur.setTitle("Ascenceur");
		frmAscenceur.setBounds(100, 100, 381, 432);
		frmAscenceur.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frmAscenceur.getContentPane().setLayout(null);
		
		  JPanel panel_1 = new JPanel();
		  panel_1.setBounds(52, 60, 108, 255);
	      panel_1.setBackground(Color.WHITE);
	      frmAscenceur.getContentPane().add(panel_1);
	      panel_1.setLayout(null);
	      
	      Panel pn_moved = new Panel();
	      pn_moved.setBounds(0, 194, 108, 62);
	      panel_1.add(pn_moved);
	      pn_moved.setBackground(SystemColor.inactiveCaption);
	      pn_moved.setLayout(null);
	      
	      
	      pn_door = new Panel();
	      pn_door.setBounds(10, 10, 25, 52);
	      pn_moved.add(pn_door);
	      pn_door.setBackground(Color.LIGHT_GRAY);
	      
	      Ascenceur asc = new Ascenceur(pn_moved, panel_1, pn_door, frmAscenceur, 10);
	      JLabel lblEt = new JLabel("");
	      lblEt.setIcon(new ImageIcon(Ascenceur1.class.getResource("/ascenceur/img/btnUpDown.png")));
	      lblEt.setBounds(41, 30, 17, 17);
	      pn_moved.add(lblEt);
//	      JLabel lbl=new JLabel();
//	      lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("personneIcon .png")));
//		   lbl.setBounds(76, 10, 25, 52);
//		   pn_moved.add(lbl);
//	      JButton btn_1 = new JButton("");
//	      btn_1.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent e) {
//	      		nbre.add(1);
//	      		asc.addPerson(frame,1,10);
//	      	//	asc.go(pn_moved);
//	      		
//	      	}
//	      });
//	      btn_1.setBounds(213, 274, 55, 23);
//	      frame.getContentPane().add(btn_1);
//	      
//	      JButton btn_2 = new JButton("");
//	      btn_2.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent e) {
//	      		nbre.add(2);
//	      		asc.addPerson(frame,2,10);
//	      	//	asc.go(pn_moved);
//	      	}
//	      });
//	      btn_2.setBounds(213, 214, 55, 23);
//	      frame.getContentPane().add(btn_2);
//	      
//	      JButton btn_3 = new JButton("");
//	      btn_3.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent e) {
//	      		nbre.add(3);
//	      		asc.addPerson(frame,3,10);
//	      	//	asc.go(pn_moved);
//	      	}
//	      });
//	      btn_3.setBounds(213, 137, 55, 23);
//	      frame.getContentPane().add(btn_3);
//	      
//	      JButton btn_4 = new JButton("");
//	      btn_4.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent arg0) {
//	      		nbre.add(4);
//	      		asc.addPerson(frame,4,10);
//	      	//	asc.go(pn_moved);
//	      	}
//	      });
//	      btn_4.setBounds(213, 77, 55, 23);
//	      frame.getContentPane().add(btn_4);
	      JButton btnStop = new JButton("Stop");
	      btnStop.setFont(new Font("Cambria", Font.BOLD, 14));
	      btnStop.setIcon(new ImageIcon(Ascenceur1.class.getResource("/ascenceur/img/stop.png")));
	      btnStop.setEnabled(false);
	      JButton btnStart = new JButton("Start");
	      btnStart.setIcon(new ImageIcon(Ascenceur1.class.getResource("/ascenceur/img/start.png")));
	      btnStart.setFont(new Font("Cambria", Font.BOLD, 14));
	      btnStart.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		asc.setVer(true);
	      		asc.addPerson();
	      		btnStart.setEnabled(false);
	      		btnStop.setEnabled(true);
	      	}

	      });
	      btnStart.setBounds(234, 32, 121, 23);
	      frmAscenceur.getContentPane().add(btnStart);
	      
	     
	      btnStop.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		btnStart.setEnabled(true);
	      		asc.setVer(false);
	      	}
	      });
	      btnStop.setBounds(88, 32, 121, 23);
	      frmAscenceur.getContentPane().add(btnStop);
	   
	      
	      
	
	}
}
