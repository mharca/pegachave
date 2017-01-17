package pegachave;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import org.apache.log4j.lf5.LF5Appender;

public class Foto extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel lFoto;
	public Foto(String mat){
		lFoto = new JLabel();
		this.setBorder(BorderFactory.createTitledBorder("Foto"));
		//String fotoUrl="http://static.batanga.com.br/sites/default/files/bozo_cc_div.jpg";
		String fotoUrl=null;
		if(mat.length() == 7)
			 fotoUrl = "http://apl.ti.petrobras.com.br/fotos/0"+mat+".jpg";
		if(mat.length() < 7)
			fotoUrl = "http://apl.ti.petrobras.com.br/fotos/00"+mat+".jpg";
		try{
			URL url = new URL(fotoUrl);
			BufferedImage image = ImageIO.read(url);
			ImageIcon iicon = new ImageIcon(image);
			Image bimage = iicon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
			
			lFoto.setIcon(new ImageIcon(bimage));
		}catch(Exception e){
			try{
				String fotoUrl2 = "http://spme.petrobras.com.br/fotos/"+mat+".jpg";
				URL url2 = new URL(fotoUrl2);
				BufferedImage image2 = ImageIO.read(url2);
				ImageIcon iicon2 = new ImageIcon(image2);
				Image bimage2 = iicon2.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
				lFoto.setIcon(new ImageIcon(bimage2));
			}catch(Exception e2){
				System.out.println("Sem foto");
				try{
					ImageIcon iicon3 = new ImageIcon("sem-foto.jpg");
					Image bimage3 = iicon3.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
					lFoto.setIcon(new ImageIcon(bimage3));
				}catch(Exception e3){
					System.out.println("Erro bizarro");
				}
			}
		
		}
		add(lFoto);	
	}
	public Foto(String mat,int x, int y){
		lFoto = new JLabel();
		this.setBorder(BorderFactory.createTitledBorder("Foto"));
	//	this.setBorder(BorderFactory.createTitledBorder("Foto"));
		//String fotoUrl="http://static.batanga.com.br/sites/default/files/bozo_cc_div.jpg";
		String fotoUrl = "http://apl.ti.petrobras.com.br/fotos/0"+mat+".jpg";
		try{
			URL url = new URL(fotoUrl);
			BufferedImage image = ImageIO.read(url);
			ImageIcon iicon = new ImageIcon(image);
			Image bimage = iicon.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT);
			
			lFoto.setIcon(new ImageIcon(bimage));
		}catch(Exception e){
			try{
				String fotoUrl2 = "http://spme.petrobras.com.br/fotos/"+mat+".jpg";
				URL url2 = new URL(fotoUrl2);
				BufferedImage image2 = ImageIO.read(url2);
				ImageIcon iicon2 = new ImageIcon(image2);
				Image bimage2 = iicon2.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT);
				lFoto.setIcon(new ImageIcon(bimage2));
			}catch(Exception e2){
				System.out.println("Sem foto");
				try{
					ImageIcon iicon3 = new ImageIcon("sem-foto.jpg");
					Image bimage3 = iicon3.getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT);
					lFoto.setIcon(new ImageIcon(bimage3));
				}catch(Exception e3){
					System.out.println("Erro bizarro");
				}
			}
		
		}
		add(lFoto);	
	}
}
