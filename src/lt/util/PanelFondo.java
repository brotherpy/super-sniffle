/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.util;


import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author brother
 */
public class PanelFondo extends JPanel {

    public PanelFondo(){    
        this.setSize(1920,1080);
    }
        
    @Override
    public void paint(Graphics g){
        Dimension dimension = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/lt/images/gear.png"));        
        g.drawImage(imagenFondo.getImage(),0,0,dimension.width, dimension.height, null);        
        setOpaque(false);
        super.paintComponent(g);
}
    
}