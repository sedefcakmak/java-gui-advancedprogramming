package restaurant;

import javax.swing.JFrame;

public class GuiMain {

	public static void main(String[] args) {
		/* *********** Pledge of Honor ***************************************************************************
		* I hereby certify that I have completed this programming project on my own
		* without any help from anyone else. The effort in the project thus belongs
		* completely to me. I did not search for a solution, or I did not consult to any program
		* written by other students or did not copy any program from other sources. I read and
		* followed the guidelines provided in the project description.
		*
		* READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
		* SIGNATURE: <Sedef Çakmak, 71614>
		*
		************************************************************************************************************/
		
		//restaurant objects that manages everything is created
		Restaurant c=new Restaurant();
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setSize(450,450);
		c.setVisible(true);
		

	}

}
