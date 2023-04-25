package Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Action.ButtonClickedListener;

public abstract class BaseButton extends JButton{
	
	public BaseButton(String buttonName, String iconPath) {
		setIconImg(iconPath);
		this.setBackground(Color.white);
		this.setText(buttonName);
		this.setFont(new Font("Arial", Font.PLAIN, 25));
		this.setBorder(BorderFactory.createLineBorder(Color.black, 3));
		this.addMouseListener(new ButtonClickedListener());
	}
	
	private void setIconImg(String iconPath) {
		try {
			BufferedImage master;
			master = ImageIO.read(new File(iconPath));
			Image scaled = master.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			Icon icon = new ImageIcon(scaled);
			this.setIcon(icon);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public abstract void onClicked();
}
