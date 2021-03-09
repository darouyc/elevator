package ascenceur;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Aseb {

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
					Aseb window = new Aseb();
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
	public Aseb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAscenceur = new JFrame();
		frmAscenceur.setFont(new Font("Cambria", Font.BOLD, 15));
		frmAscenceur.setForeground(Color.DARK_GRAY);
		frmAscenceur.setTitle("Ascenceur");
		frmAscenceur.setIconImage(Toolkit.getDefaultToolkit().getImage(Aseb.class.getResource("/ascenceur/img/ascenceur.png")));
		frmAscenceur.getContentPane().setBackground(new Color(204, 204, 255));
		frmAscenceur.setBounds(100, 100, 607, 436);
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
	      pn_moved.setBackground(new Color(153, 255, 204));
	      pn_moved.setLayout(null);
	      
	      
	      pn_door = new Panel();
	      pn_door.setBounds(10, 10, 25, 52);
	      pn_moved.add(pn_door);
	      pn_door.setBackground(Color.LIGHT_GRAY);
	      
	      Ascenceur asc = new Ascenceur(pn_moved, panel_1, pn_door, frmAscenceur, 10);
	      JLabel lblEt = new JLabel("");
	      lblEt.setIcon(new ImageIcon(Aseb.class.getResource("/ascenceur/img/btnUpDown.png")));
	      lblEt.setBounds(50, 22, 25, 29);
	      pn_moved.add(lblEt);
	      
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
//	      btn_2.setBounds(213, 203, 55, 23);
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
	      
	      JPanel panel = new JPanel();
	      panel.setLayout(null);
	      panel.setBackground(Color.WHITE);
	      panel.setBounds(380, 60, 108, 255);
	      frmAscenceur.getContentPane().add(panel);
	      
	     
	      Panel pn_moved1 = new Panel();
	      pn_moved1.setLayout(null);
	      pn_moved1.setBackground(new Color(250, 240, 230));
	      pn_moved1.setBounds(0, 194, 108, 62);
	      panel.add(pn_moved1);
	      
	      Panel pn_door1 = new Panel();
	      pn_door1.setBackground(new Color(230, 230, 250));
	      pn_door1.setBounds(10, 10, 25, 52);
	      pn_moved1.add(pn_door1);
	      
	      JLabel label = new JLabel("");
	      label.setIcon(new ImageIcon(Aseb.class.getResource("/ascenceur/img/btnUpDown.png")));
	      label.setBounds(50, 22, 25, 29);
	      pn_moved1.add(label);
	      
	       Ascenceur asc1 = new Ascenceur(pn_moved1, panel, pn_door1, frmAscenceur, 322);
	       
	       JButton btnStart = new JButton("Start");
	       btnStart.setIcon(new ImageIcon(Aseb.class.getResource("/ascenceur/img/start.png")));
	       btnStart.setFont(new Font("Cambria", Font.BOLD, 14));
	       JButton btnStop = new JButton("Stop");
	       btnStop.setIcon(new ImageIcon(Aseb.class.getResource("/ascenceur/img/stop.png")));
	       btnStart.setEnabled(true);
	       btnStop.setEnabled(false);
	       btnStop.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		btnStart.setEnabled(true);
	      		asc.setVer(false);
	      		asc1.setVer(false);
	      		frmAscenceur.repaint();
	       	}
	       });
	       btnStop.setBounds(201, 45, 142, 23);
	       frmAscenceur.getContentPane().add(btnStop);
	       
	       
	       btnStart.addActionListener(new ActionListener() {
	       	public void actionPerformed(ActionEvent e) {
	       		asc.setVer(true);
	      		asc.addPerson();
	      		asc1.setVer(true);
	      		asc1.addPerson();
	      		btnStart.setEnabled(false);
	      		btnStop.setEnabled(true);
	       	}
	       });
	       btnStart.setBounds(201, 11, 142, 23);
	       frmAscenceur.getContentPane().add(btnStart);
//	      JButton btn4 = new JButton("");
//	      btn4.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent e) {
//	      		nbre.add(4);
//	      		asc1.addPerson(frame,4, 322);
//	      	}
//	      });
//	      btn4.setBounds(541, 77, 55, 23);
//	      frame.getContentPane().add(btn4);
//	      
//	      JButton btn3 = new JButton("");
//	      btn3.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent e) {
//	      		nbre.add(3);
//	      		asc1.addPerson(frame,3, 322);
//	      	}
//	      });
//	      btn3.setBounds(541, 137, 55, 23);
//	      frame.getContentPane().add(btn3);
//	      
//	      JButton btn2 = new JButton("");
//	      btn2.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent e) {
//	      		nbre.add(2);
//	      		asc1.addPerson(frame,2, 322);
//	      	}
//	      });
//	      btn2.setBounds(541, 203, 55, 23);
//	      frame.getContentPane().add(btn2);
//	      
//	      JButton btn1 = new JButton("");
//	      btn1.addActionListener(new ActionListener() {
//	      	public void actionPerformed(ActionEvent e) {
//	      		nbre.add(1);
//	      		asc1.addPerson(frame,1, 322);
//	      	}
//	      });
//	      btn1.setBounds(541, 274, 55, 23);
//	      frame.getContentPane().add(btn1);
//	   
	    
	      
	
	
	}

}
