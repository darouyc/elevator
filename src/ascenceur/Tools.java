package ascenceur;

import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tools {
	int dest;
	int from;
	private JLabel lbl=new JLabel();
	
	
//	public Tools(int dest ,JPanel frame,int from ) {
//		this.dest=dest;
//		lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("personneIcon .png")));
//	    lbl.setBounds(10, 270, 25, 52);
//	    frame.add(lbl);
//	    this.from=from;
//		
//	}
	public Tools(int from ,JPanel frame) {
		this.from=from;
		lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("personneIcon .png")));
	    lbl.setBounds(10, 270+from, 25, 52);
	    frame.add(lbl);
	    
		
	}
	public Tools(int from,Panel pn_moved,int dest, int x ) {
		this.dest=dest;
		lbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("personneIcon .png")));
		lbl.setBounds(76, 10, 25, 52);
//		pn_moved.add(lbl);
//	    pn_moved.repaint();
		
	}
	
	public JLabel getLbl() {
		return lbl;
	}

	public void setLbl(JLabel lbl) {
		this.lbl = lbl;
	}

	public int getDest() {
		return dest;
	}
	public void setDest(int dest) {
		this.dest = dest;
	}

}
