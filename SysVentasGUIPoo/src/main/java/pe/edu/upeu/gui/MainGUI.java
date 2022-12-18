
package pe.edu.upeu.gui;


import pe.edu.upeu.modelo.comodin.ComboBoxOption;
import javax.swing.JFrame;
import pe.edu.upeu.util.UtilsX;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.table.TableModel;
import pe.com.syscenterlife.comboauto.ComboBoxSuggestion;
import pe.com.syscenterlife.tablepag.ObjectTableModel;
import pe.com.syscenterlife.tablepag.PaginatedTableDecorator;
import pe.com.syscenterlife.tablepag.PaginationDataProvider;
import pe.edu.upeu.dao.ClienteDAO;
import pe.edu.upeu.gui.plano.JPanelMo3d;
import pe.edu.upeu.gui.plano.Plano;
import pe.edu.upeu.gui.planoc.Function;
import pe.edu.upeu.gui.planoc.Plane;
import pe.edu.upeu.modelo.ClienteTO;



public class MainGUI extends JFrame{
    private static final long serialVersionUID = 1L;
    int numeros;
    JPanel panel;
    JTextField texto;
    JScrollPane scrollPane=new JScrollPane();
    BufferedImage image;
    JTable table;
    JMenuBar mb;
    JMenu m1;
    JMenu m2;
    JMenuItem m11;
    JMenuItem m22;
    UtilsX obj=new UtilsX();
    JPanel panelFoot;
    JButton send, reset;
    JTabbedPane tp;
    ComboBoxSuggestion combox;
    JButton SaveBtn = new JButton("Save Row");
    static java.util.List<ClienteTO> listx = null;
    JPanel pp1;
    
    MainCliente mainCliPanel;
    
    public MainGUI() {
        this.setTitle("SystemMain@DMP");
        try {
                image=ImageIO.read(obj.getFile("shop-icon.png"));
                } catch (Exception ex) {
                System.out.println(ex.getMessage());
        }        
        //Image retValue = Toolkit.getDefaultToolkit().getImage("shop-icon.png");
        this.setIconImage(image);
        this.getContentPane().setBackground(new Color(255, 255, 255));
        mb = new JMenuBar();
        m1 = new JMenu("Archivo");
        m2 = new JMenu("Ayuda");
        m11 = new JMenuItem("Listar");
        m22 = new JMenuItem("Guardar como");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(new Dimension(screenSize.width, screenSize.height-36));
        mb.add(m1);
        mb.add(m2);
        
         MenuItemListener menuItemListener = new MenuItemListener();

        
       tp=new JTabbedPane();
        m11.addActionListener(menuItemListener);
        m1.add(m11);
        m1.add(m22);
        panelFoot = new JPanel();
        send = new JButton("Generar");
        reset = new JButton("Borrar");
        texto = new JTextField("6");
        texto.setPreferredSize(new Dimension(100, 25));
        send.addActionListener(menuItemListener);
        reset.addActionListener(menuItemListener);
        m22.addActionListener(menuItemListener);
        panelFoot.add(texto);
        panelFoot.add(send);
        panelFoot.add(reset);
        this.getContentPane().add(BorderLayout.SOUTH, panelFoot);
        this.getContentPane().add(BorderLayout.NORTH, mb);
        this.setVisible(true);
        }
    
        @Override
        public Image getIconImage() {
           Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("resources/shop-icon.png"));


           return retValue;
        }
        public void panelTabla(Container contai){
     
            table = new JTable(obj.reporData());
            scrollPane = new JScrollPane(table);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
            scrollPane.invalidate();
            scrollPane.validate();
            scrollPane.repaint();
            contai.add(BorderLayout.CENTER, scrollPane); 
            contai.invalidate();
            contai.validate();
            contai.repaint();
        }
    
        private static TableModel createObjectDataModel() {
               return new ObjectTableModel<ClienteTO>() {
                   @Override
                   public Object getValueAt(ClienteTO employee, int columnIndex) {
                       switch (columnIndex) {
                           case 0:
                               return employee.getDniruc();
                           case 1:
                               return employee.getNombresrs();
                           case 2:
                               return employee.getTipo();
                       }
                       return employee;
                   }

                   @Override
                   public int getColumnCount() {
                       return 3;
                   }
                   @Override
                   public String getColumnName(int column) { 
                       switch (column) {
                           case 0:
                               return "DNI";
                           case 1:
                               return "Nombre";
                           case 2:
                               return "Tipo";
                       }
                       return null;
                   }

                   @Override
                   public boolean isCellEditable(ClienteTO t, int column) {
                           if(column==2){
                           return true;
                           }
                           return false;                
                   }

               };
           }

        private static PaginationDataProvider<ClienteTO> createDataProvider() {
              
            listx=new ClienteDAO().listarClientes();
            System.out.println("Cantidad:"+listx.size());
            return new PaginationDataProvider<ClienteTO>() {
            @Override
            public int getTotalRowCount() {
                return listx.size();
            }

            @Override
            public java.util.List<ClienteTO> getRows(int startIndex, int endIndex) {
                return listx.subList(startIndex, endIndex);
            }
        };
    }            
        
        public void pintarConejos(Graphics g){
            int fibo=0;
            int incx=0;
            int incy=0;
            for(int x=1;x<=numeros;x++){
            fibo=obj.fibonaciRecur(x);
            for(int y=1;y<=fibo;y++){
            g.drawImage(image, incx, incy, null);
            incx=incx+100;
            }
            incx=0;
            incy=incy+100;
            }
            } 
            
        public void panelDibujoImagen(Container contai){
                numeros=Integer.parseInt(texto.getText());
                try {
                image=ImageIO.read(obj.getFile("images/conejo3.png"));
                } catch (Exception ex) {
                System.out.println(ex.getMessage());
                }
                panel = new JPanel(){
                private static final long serialVersionUID = 1L;
                @Override
                protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                pintarConejos(g);
                }
                };
                panel.setPreferredSize(new Dimension(2000, 1000));
                contai.remove(tp);
                tp=new JTabbedPane();
                tp.setBounds(10,20,400,200); 
                tp.add("main",panel); 
                
                contai.add(BorderLayout.CENTER, tp);
                contai.invalidate();
                contai.validate();
                contai.repaint();
            }


            
   class MenuItemListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {    
            System.out.println("pasa por aqui");          
            Container contai=MainGUI.this.getContentPane(); 
         
         if(e.getSource()==m11){
            JPanel pp=new JPanel();
            
            
            
            pp.setPreferredSize(new Dimension(2000, 1000));
            scrollPane = new JScrollPane(pp);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);          
            JPanel pp1=new JPanel();
            pp1.setPreferredSize(new Dimension(2000, 1000));
            JPanel pp2=new JPanel();
            pp2.setPreferredSize(new Dimension(2000, 1000));
            contai.remove(tp);
            tp=new JTabbedPane();
            tp.setBounds(10,20,400,200); 
            tp.add("main",pp);  
            tp.add("visit",pp1);  
            tp.add("help",pp2); 
            tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            contai.add(BorderLayout.CENTER, tp);
            contai.invalidate();
            contai.validate();
            contai.repaint();
         }
         if(e.getSource()==m22){
            JPanel pp=new JPanel();
            pp1=new Plano();
            JPanel pp2=new MainCliente();
            Plane pp3=new Plane();
            ClienteMain pp4=new ClienteMain();
            JPanel pp1=new JPanelMo3d();
            //Inicio
        JTable table = new JTable(createObjectDataModel());
        table.setAutoCreateRowSorter(true);
        
        //table.createDefaultColumnsFromModel();        
        //String[] bloodGroups = { "Man Utd", "Chelsea", "Arsenal", "Liverpool", "Everton" };
        
        //JComboBox comboBox = new JComboBox(bloodGroups);
        //table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(comboBox));          
        
        
        PaginationDataProvider<ClienteTO> dataProvider = createDataProvider();
        PaginatedTableDecorator<ClienteTO> paginatedDecorator = PaginatedTableDecorator.decorate(table,
                dataProvider, new int[]{5, 10, 20, 50, 75, 100}, 10);
        pp.add(paginatedDecorator.getContentPanel());  
        
        
        combox = new ComboBoxSuggestion();
        //combox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antarctica", "Antigua and Barbuda", "Argentina", "Armenia", "Aruba", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cambodia", "Cameroon", "Canada", "Canary Islands", "Cape Verde Islands", "Cayman islands", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Cook Islands", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Democratic Republic of the Congo (Zaire)", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Federated States of Micronesia", "Fiji", "Finland", "France", "French Guyana", "French Polynesia", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Greenland", "Grenada", "Guatemala", "Guinea", "Guinea Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Israel", "Italy", "Ivory Coast/C�te d�Ivoire", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Martinique", "Mauritania", "Mauritius", "Mexico", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia", "Nauru", "Nepal", "New Caledonia", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Pitcairn Islands", "Poland", "Portugal", "Puerto Rico", "Qatar", "Republic of Ireland", "Republic of San Marino", "Romania", "Russia", "Rwanda", "Samoa", "Sao Tome", "Saudi Arabia", "Scotland", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "Spain", "Sri Lanka", "St. Kitts and Nevis", "St. Lucia", "St. Vincent and The Grenadines", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "The Netherlands", "The Vatican", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Wales", "West Bank and Gaza", "Western Sahara", "Yemen", "Zambia", "Zimbabwe" }));
        
        combox.addItem(new ComboBoxOption("O1","Peru"));
        combox.addItem(new ComboBoxOption("O2","Bolivia"));        
        combox.addItem(new ComboBoxOption("O3","Chile"));        
        combox.addItem(new ComboBoxOption("O4","Argentina")); 
        
        combox.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println(((ComboBoxOption)combox.getSelectedItem()).getKey());
            }
        });                
        pp.add(combox);
        
        
        SaveBtn = new JButton("Seleccionar");
        SaveBtn.addActionListener(new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
                     int row = table.getSelectedRow(); // select a row
                     int column = table.getSelectedColumn(); // select a column
                     ClienteTO to=(ClienteTO)listx.get(row);
                     System.out.println("VER:"+to.getDniruc());
                     JOptionPane.showMessageDialog(null, table.getValueAt(row, column));                
             }
        });       
        pp.add(SaveBtn);

        
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                if (me.getClickCount() == 2) {     // to detect doble click events
                    JTable target = (JTable)me.getSource();
                    int row = target.getSelectedRow(); // select a row
                    int column = target.getSelectedColumn(); // select a column
                    JOptionPane.showMessageDialog(null, table.getValueAt(row, column)); // get the value of a row and column.
                }
            }
        });          
            //Fin
            contai.remove(tp);
            tp=new JTabbedPane();
            tp.setBounds(10,20,800,600); 
            tp.add("prueba1",pp);  
            tp.add("Prueba 2",pp1);  
            tp.add("Preueba 3",pp2);

            // Create a function with expression and name
            Function f = new Function("sin(x) * 2", "f(x)");
            f.setColor(Color.RED); // Set color for the graph

            // Set the desired scale for the plane
            pp3.setScaleInX(1);
            pp3.setScaleInY(5);

            // Enable grid in plane
            pp3.setShowGrid(true);

            // Plot function, the plane store a list of functions so that you can
            // graph many functions at the same time
            pp3.plot(f);

            Function g = new Function("x^3 - x", "g(x)");
            g.setColor(Color.BLUE);
            pp3.plot(g);            
            
            
            tp.add("Preueba 4",pp3); 
            tp.add("Preueba 5",pp4); 
            tp.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
            contai.add(BorderLayout.CENTER, tp);
            contai.invalidate();
            contai.validate();
            contai.repaint();
         }
         
         if(e.getSource()==send){
             panelDibujoImagen(contai);
         }
    
         
         
      }    
   }            

}