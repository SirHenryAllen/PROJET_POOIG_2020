package view ;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BackgroundModel {
	
	public BufferedImage image ;

	
	public BackgroundModel(String chemin)throws IOException{	
		
		this.image = ImageIO.read(getClass().getResource(chemin));
    }
	
	public BufferedImage getImage() {
		return image ;
	}
    
    public void zoomIn(){
    	this.image.getScaledInstance(this.image.getWidth()-10, this.image.getHeight()-10, java.awt.Image.SCALE_SMOOTH)  ; 
    	getImage() ;
    }
    
    
    public void zoomOut(){
    	this.image.getScaledInstance(this.image.getWidth()+1, this.image.getHeight()+1, java.awt.Image.SCALE_SMOOTH)  ; 
    	getImage() ;
    }
}
