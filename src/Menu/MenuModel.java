
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class MenuModel {
	
	public BufferedImage image ;

	
	public MenuModel(String chemin)throws IOException{	
		
		this.image = ImageIO.read(new File(chemin));
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
