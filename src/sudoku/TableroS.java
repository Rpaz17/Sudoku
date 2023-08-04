package sudoku;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TableroS extends JPanel{
    
    private JTextField[][] casillasS;
    private int casillasAncho;
    private int casillasAltura;
    private int  casillasMargen;
    private int tamañoLt;
    private Color backgroundPanel;
     private Color background1;
     private Color background2;
     private Color fcSeleccionada1;
     private Color fcSeleccionada2;
     private Color txtSeleccionado1;
     private Color txtSeleccionado2; 
     
     public TableroS(){
            initComponents();
     }
     public void initComponents(){
         casillasS= new JTextField[9][9];
         casillasAncho = 50;
         casillasAltura = 51;
         casillasMargen = 5;
         tamañoLt = 30;
        backgroundPanel = Color.black;
         background1 = Color.white;
         background2 = Color.black;
          fcSeleccionada1= Color.white;
          fcSeleccionada2= Color.white;
         txtSeleccionado1 = Color.black;
         txtSeleccionado2 = Color.white;
     }

     public void create(){
         this.setLayout(null);
         this.setSize(casillasAncho*9+(casillasMargen*4), casillasAltura*9+(casillasMargen*4));
         this.setBackground(backgroundPanel);
         createTextFields();
     }
     
     public void createTextFields(){
         int x = casillasMargen;
         int y = casillasMargen;
         for (int i = 0; i < casillasS.length; i++) {
            for (int j = 0; j < casillasS[0].length; j++) {
                JTextField caja = new JTextField();
                this.add(caja);
                caja.setBounds(x, y, casillasAncho, casillasAltura);
                caja.setBackground(new Color(69,108,255));
                caja.setForeground(background1);
                caja.setFont(new Font("Montserrat", Font.BOLD, tamañoLt));
                caja.setEditable(false);
                caja.setCursor(new Cursor(Cursor.HAND_CURSOR));
                caja.setBorder(BorderFactory.createLineBorder(backgroundPanel, 1));
                caja.setVisible(true);
                x += casillasAncho;
                if ((j + 1) % 3 == 0) {
                    x += casillasMargen;
                }
                casillasS[i][j] = caja;
                generate(caja);
            }
            x = casillasMargen;
            y += casillasAltura;
            if ((i + 1) % 3 == 0) {
                y += casillasMargen;
            }
        }
     }
     public void generate(JTextField texto){
         MouseListener evento = new MouseListener() {
             @Override
             public void mouseClicked(MouseEvent e) {
             }

             @Override
             public void mousePressed(MouseEvent e) {
                 // al presionar el textField se cambiaran el color de fondo y el color de la letra.
                 pressed(texto);
             }

             @Override
             public void mouseReleased(MouseEvent e) {
             }

             @Override
             public void mouseEntered(MouseEvent e) {
             }

             @Override
             public void mouseExited(MouseEvent e) {
             }
         };
         texto.addMouseListener(evento);
     }
     public void pressed(JTextField texto){
           for (int i = 0; i<casillasS.length;i++){
                     for (int x=0; x<casillasS[0].length;x++){
                         if (casillasS[i][x]==texto){
                             for (int j=0; j<casillasS.length;j++){
                                 casillasS[j][x].setBackground(background1);
                                 casillasS[j][x].setForeground(background2);
                             }
                             for (int j=0;j<casillasS.length;j++){
                                 casillasS[i][j].setBackground(background1);
                                 casillasS[i][j].setForeground(background2);
                             }
                             casillasS[i][x].setBackground(txtSeleccionado2);
                             casillasS[i][x].setBackground(txtSeleccionado1);
                             
                             casillasS[i][x].setBorder(BorderFactory.createLineBorder(Color.white,1));
                             return;
                         }
                     }
                 }
     }
    public JTextField[][] getCasillasS() {
        return casillasS;
    }

    public int getCasillasAncho() {
        return casillasAncho;
    }

    public int getCasillasAltura() {
        return casillasAltura;
    }

    public int getCasillasMargen() {
        return casillasMargen;
    }

    public int getTamañoLt() {
        return tamañoLt;
    }

    public Color getBackgroundPanel() {
        return backgroundPanel;
    }

    public Color getBackground1() {
        return background1;
    }

    public Color getBackground2() {
        return background2;
    }

    public Color getFcSeleccionada1() {
        return fcSeleccionada1;
    }

    public Color getFcSeleccionada2() {
        return fcSeleccionada2;
    }

    public Color getTxtSeleccionado1() {
        return txtSeleccionado1;
    }

    public Color getTxtSeleccionado2() {
        return txtSeleccionado2;
    }

    public void setCasillasS(JTextField[][] casillasS) {
        this.casillasS = casillasS;
    }

    public void setCasillasAncho(int casillasAncho) {
        this.casillasAncho = casillasAncho;
    }

    public void setCasillasAltura(int casillasAltura) {
        this.casillasAltura = casillasAltura;
    }

    public void setCasillasMargen(int casillasMargen) {
        this.casillasMargen = casillasMargen;
    }

    public void setTamañoLt(int tamañoLt) {
        this.tamañoLt = tamañoLt;
    }

    public void setBackgroundPanel(Color background) {
        this.backgroundPanel = background;
    }

    public void setBackground1(Color background1) {
        this.background1 = background1;
    }

    public void setBackground2(Color background2) {
        this.background2 = background2;
    }

    public void setFcSeleccionada1(Color fcSeleccionada1) {
        this.fcSeleccionada1 = fcSeleccionada1;
    }

    public void setFcSeleccionada2(Color fcSeleccionada2) {
        this.fcSeleccionada2 = fcSeleccionada2;
    }

    public void setTxtSeleccionado1(Color txtSeleccionado1) {
        this.txtSeleccionado1 = txtSeleccionado1;
    }

    public void setTxtSeleccionado2(Color txtSeleccionado2) {
        this.txtSeleccionado2 = txtSeleccionado2;
    }
     
}
