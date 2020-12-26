package Menu ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Timer;

public class Test {
			
	public Test() {
			
		MenuModel model ;
		try {
			model = new MenuModel("C:\\Users\\Sunay\\eclipse-workspace\\MenuM\\backgroundMenu.png");
			MenuPrincipal view = new MenuPrincipal(model);
			view.pack();
			view.setVisible(true);
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}		
		
	public static void main(String []args) {
		new Test() ;
	}
}


