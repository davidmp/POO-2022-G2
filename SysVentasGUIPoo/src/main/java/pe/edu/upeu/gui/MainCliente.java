
package pe.edu.upeu.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;


public class MainCliente extends JPanel{
    JPanel panelForm;
    JPanel panelReport;
    JButton btnNuevo=new JButton("Nuevo");
    JButton btnRegistro=new JButton("Registrar");
    JButton btnEliminar=new JButton("Eliminar");
    JScrollPane scrollPane;
    
    public MainCliente() {
        this.setLayout(new MigLayout());
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        panelForm=new JPanel();
        panelReport=new JPanel();
        panelForm.setBackground(Color.blue);
        panelForm.add(btnNuevo);
        panelForm.add(btnRegistro);
        panelForm.add(btnEliminar);
        panelForm.setPreferredSize(new Dimension((screenSize.width/2)-(screenSize.width/4), screenSize.height));
        //scrollPane = new JScrollPane(panelForm);
        //scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);        
        add(panelForm);
        add(panelReport);
        
        
    }
    
}
