package ascenceur;

import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ascenceur {

	
	private Panel pn_moved, pn_door;
	private JPanel pn_path;
	private JFrame frame;
	ArrayList<Integer> nbre =new ArrayList<Integer>();
	ArrayList<Integer> dest =new ArrayList<Integer>();
	ArrayList<Tools> person =new ArrayList<Tools>();
	Tools per;
	Point current_pos;
    Point next_pos;
    int nbrPer1=0;
    int nbrPer2=0;
    int nbrPer3=0;
    int nbrPer4=0;
    int from;
    int to;
   boolean ver= false;
   int x;
 //   private ArrayList<Integer> nbre;
	
	public boolean isVer() {
	return ver;
}


public void setVer(boolean ver) {
	this.ver = ver;
}


	public Point getNext_pos() {
		return next_pos;
	}


	public void setNext_pos(Point next_pos) {
		this.next_pos = next_pos;
	}


	public Ascenceur(Panel pn_moved, JPanel panel_1, Panel pn_door, JFrame frame, int x) {
		super();
		
		this.pn_moved = pn_moved;
		this.pn_path = panel_1;
		this.pn_door = pn_door;
		this.frame = frame;
		this.x =x;
		current_pos = pn_moved.getLocation();
	}


	
	 public void moveAsc()
     {	
		
		
		  pn_door.setBackground(Color.LIGHT_GRAY);
   			
   		int y;
   		
   		switch(from)
   		{
   		 case(1): y=194;
   		
   		 	break;
   		 case(2): y=219;
   		    break;
   		 case(3): y=244;
   		 	break;
   		 case(4): y=269;
   		 break;
   		 default:y=current_pos.getLocation().y;
   		
   		}
   		
   		new Thread(){
         	 public void run() {
         try {
         	  System.out.println(current_pos.getLocation().x);
         	 setNext_pos(new Point(current_pos.getLocation().x ,y));

         	System.out.println(next_pos.y);
         	
         	if(current_pos.y > next_pos.y)
         	{
         		
	                while (current_pos.y != next_pos.y) 
	                {
	                	System.out.println("cu down "+current_pos.y );
	                	pn_moved.setLocation(pn_moved.getLocation().x,pn_moved.getLocation().y +64);
	                	
	                	current_pos.y  -= 25;
	                	
	                    Thread.sleep(1100);
	                    
	                  } 

	                pn_door.setBackground(Color.white);
	                Thread.sleep(300);
	                moveAscDes();    
             }else if(current_pos.y < next_pos.y) 
             {
             	 while (current_pos.y != next_pos.y) 
             	   { 
             		 System.out.println("cu uuup "+current_pos.y );   	
	                	pn_moved.setLocation(pn_moved.getLocation().x, pn_moved.getLocation().y-64);

	                	current_pos.y += 25;
	                	
	                    Thread.sleep(1100); 
	                    }  
             	 pn_door.setBackground(Color.white);
             	Thread.sleep(300);
             	 moveAscDes();
              }
             else{
            	 String msg ="Vous êtes dans le même etage";
             	JLabel label = new JLabel(msg);
             	label = new JLabel(msg);
             	label.setFont(new Font("Arial", Font.BOLD, 12));
             	JOptionPane.showMessageDialog(null , label,"Etage",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/ascenceur/img/JoptionPane.png")));
				
             	pn_door.setBackground(Color.white);
             	Thread.sleep(1100); 
             	addPerson();
             }
         	
         } 
         catch (Exception e) { 
         } 
         	 } }.start();
         
         	
         	 
         
     }
	 
	 public int destination()
	 {
		 Random rand =new Random();
		 this.to =rand.nextInt(5-1)+1;
		 System.out.println("to :"+to);
   		 
   	 return to;
	 }
	 public int appel()
	 {
		 Random rand =new Random();
		 this.from =rand.nextInt(5-1)+1;
		 System.out.println("from :"+from);
   		 
   	 return from;
	 }
	 public void addPerson()
	 {
		if(ver== true)
		{
			
			per =new Tools(appel(), pn_moved, destination(), this.x);
		// this.from=etage;
		 person.add(per);
		 moveAsc();
		}
		  
//		 startSignal.countDown();
//			 
//			 try {
//				doneSignal.await();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 	 
	 }
	 public void goDest ()
	 {
		
		 new Thread()
		 {
			 public void run() {
			
				 Iterator<Integer> it = dest.iterator();
		    while(it.hasNext())
		   	  {	
		    int	 etage =it.next();
		    	it.remove();
				 moveAscDes();
				 
				 try {
						Thread.sleep((etage+1)*1200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
				 
			 }
			 }
		 }.start();
			 
		 
	 }
	 
	 
	 public void moveAscDes()
		{	
		  pn_moved.add(per.getLbl());
		  pn_moved.repaint();
		  pn_door.setBackground(Color.LIGHT_GRAY);
  			
  		int y;
  		
  		switch(to)
  		{
  		 case(1): y=194;
  		
  		 	break;
  		 case(2): y=219;
  		    break;
  		 case(3): y=244;
  		 	break;
  		 case(4): y=269;
  		 break;
  		 default:y=current_pos.getLocation().y;
  		
  		}
  		
  		new Thread(){
        	 public void run() {
        try {
        	  System.out.println(current_pos.getLocation().x);
        	 setNext_pos(new Point(current_pos.getLocation().x ,y));

        	System.out.println(next_pos.y);
        	
        	if(current_pos.y > next_pos.y)
        	{
        		
	                while (current_pos.y != next_pos.y) 
	                {
	                	System.out.println("cu down "+current_pos.y );
	                	pn_moved.setLocation(pn_moved.getLocation().x,pn_moved.getLocation().y +64);
	                	
	                //	per.getLbl().setLocation(per.getLbl().getLocation().x ,per.getLbl().getLocation().y +52);
	                	//	Thread.sleep(1100);
	                	
	                	
	                	
	                	current_pos.y  -= 25;
	                	
	                    Thread.sleep(1100);
	                    
	                  } 
	                Iterator<Tools> it = person.iterator();
	                while(it.hasNext())
	                {
	                	Tools va=it.next();
	                	if(va.dest == to)
	                	{
	                		for (Tools per:person)
	                		{
	                			if(va.dest==per.dest)
	                			{
	                				pn_moved.remove(per.getLbl());
	                				pn_moved.repaint();
	                				frame.add(per.getLbl());
	                				 nbrPer1++;
	                				per.getLbl().setLocation(x+175+10*nbrePersInF(per.dest),pn_moved.getLocation().y+64 );
	                				frame.repaint();
	                			}
	                		}
	                		it.remove();
	                	}
	                	
	                }
	                pn_door.setBackground(Color.white);
	                addPerson();
            }else if(current_pos.y < next_pos.y) 
            {
            	 while (current_pos.y != next_pos.y) 
            	   { 
            		 System.out.println("cu uuup "+current_pos.y );   	
	                	pn_moved.setLocation(pn_moved.getLocation().x, pn_moved.getLocation().y-64);
	                //	lbl.setLocation(lbl.getLocation().x,lbl.getLocation().y -64);
	                	
	                //	per.getLbl().setLocation(per.getLbl().getLocation().x,per.getLbl().getLocation().y -52);
	                	//	Thread.sleep(1100);
	                		
	                	
	                	current_pos.y += 25;
	                	
	                    Thread.sleep(1100); 
	                    }  
            	 Iterator<Tools> it = person.iterator();
	                while(it.hasNext())
	                {
	                	Tools va=it.next();
	                	if(va.dest == to)
	                	{
	                		for (Tools per:person)
	                		{
	                			if(va.dest==per.dest)
	                			{
	                				pn_moved.remove(per.getLbl());
	                				pn_moved.repaint();
	                				frame.add(per.getLbl());
	                				nbrPer2++;
	                				per.getLbl().setLocation(x+175+10*nbrePersInF(per.dest),pn_moved.getLocation().y+64);
	                				frame.repaint();
	                			}
	                		}
	                		it.remove();
	                	}
	                	
	                }
            	 pn_door.setBackground(Color.white);
            	 addPerson();
             }
            else{
            	 String msg ="Vous êtes dans le même etage";
              	JLabel label = new JLabel(msg);
              	label = new JLabel(msg);
              	label.setFont(new Font("Arial", Font.BOLD, 12));
              	JOptionPane.showMessageDialog(null , label,"Etage",JOptionPane.YES_NO_CANCEL_OPTION, new ImageIcon(getClass().getResource("/ascenceur/img/JoptionPane.png")));
 				
          	//	per.getLbl().setLocation(per.getLbl().getLocation().x,per.getLbl().getLocation().y);
        	//	Thread.sleep(1100);
        		
        	
            	pn_door.setBackground(Color.white);
            	Thread.sleep(1100); 
            	 Iterator<Tools> it = person.iterator();
	                while(it.hasNext())
	                {
	                	Tools va=it.next();
	                	if(va.dest == to)
	                	{
	                		for (Tools per:person)
	                		{
	                			if(va.dest==per.dest)
	                			{
	                				pn_moved.remove(per.getLbl());
	                				pn_moved.repaint();
	                				frame.add(per.getLbl());
	                				
	                				per.getLbl().setLocation(x+175+10*nbrePersInF(per.dest),pn_moved.getLocation().y+64);
	                				frame.repaint();
	                			}
	                		}
	                		it.remove();
	                	}
	                	
	                }
	                addPerson();
            }
        	
        } 
        catch (Exception e) { 
        } 
        	 } }.start();
        
		 
        	 
		}
	 
	 
	 public int nbrePersInF(int to)
	 {
		 int val=0;
		 switch(to)
		 {
		 	case (1): val = nbrPer1++;
		 		break;
		 		
		 	case (2): val = nbrPer2++;
		 		break;
		 		
		 	case (3): val = nbrPer3++;
		 		break;
		 		
		 	case (4): val = nbrPer4++;
		 		break;
		 		
		 	default :val = 1;
		 }
		 return val;
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	
}
