package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Profil extends JFrame {
    private static final long serialVersionUID = -2275907394706337769L;
    private JTextField _name;
    private JFrame _profilPanel;

    public Profil() {
        this._profilPanel = new JFrame("Profil");    
        this._name=new JTextField("Nom...");  
        this._name.setBounds(50,100, 100,30);  
        this._profilPanel.add(this._name);  
        this._profilPanel.setSize(400,400);  
        this._profilPanel.setLayout(null);  
        this._profilPanel.setVisible(true);  
    }
}
