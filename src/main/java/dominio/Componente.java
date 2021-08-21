package dominio;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;

public class Componente extends JFrame {

    JPanel panel;
    JTextField texto;
    ArrayList<Producto> productos = new ArrayList<>();

    public Componente() {

        setBounds(10, 10, 600, 600);
        setTitle("Ventana Principal ");
        setVisible(true);
        setLocationRelativeTo(null);
        agregar();
        etiquetas();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void agregar() {
        paneles();
        etiquetas();
        botones();
        radioBotones();
        cajaTexto();
        listas();
        tablas();
    }

    public void paneles() {

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.ORANGE);
        this.add(panel);//añade un panel al frame 

    }

    public void etiquetas() {
        JLabel etiqueta = new JLabel();
        //no se puede instanciar objetos de una clase pero si de un objeto
        JLabel etiqueta2 = new JLabel(new ImageIcon("pumba.png"));
        etiqueta.setText("Figura");

        etiqueta.setBounds(10, 10, 50, 30);
        etiqueta2.setBounds(10, 30, 100, 100);
        
        //evento de escucha
        MouseListener escuchador = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
//               JOptionPane.showMessageDialog(null, "Click y suelto sobre pumba");
            }

            @Override
            public void mousePressed(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Click en pumba");
                
            }
            

            @Override
            public void mouseReleased(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Click y suelto fuera de pumba");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Ingresando a  pumba");
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                JOptionPane.showMessageDialog(null, "Saliendo de pumba");
            }
        };
        etiqueta2.addMouseListener(escuchador);
        panel.add(etiqueta);
        panel.add(etiqueta2);
        panel.repaint();

    }

    public void botones() {

        JButton boton1 = new JButton("Click");
        JButton boton2 = new JButton();
        ImageIcon panda = new ImageIcon("panda.png");
//        JButton boton2 = new JButton(new ImageIcon("panda.jpg"));

        boton2.setBounds(10, 220, 100, 60);
        boton2.setIcon(new ImageIcon(panda.getImage().getScaledInstance(boton2.getWidth(), boton2.getHeight(), Image.SCALE_SMOOTH)));
        boton1.setBounds(10, 160, 100, 50);
        boton1.setMnemonic('c');
        boton1.setForeground(Color.red);
        
        panel.add(boton1);
        panel.add(boton2);
        
        ActionListener escuchabtn1= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==boton1){
                    texto.setText("Hola");
                } else if(e.getSource()==boton2){
                    texto.setText("Panda");
                }
                
            }
        };
        
        boton1.addActionListener(escuchabtn1);
        boton2.addActionListener(escuchabtn1);
        panel.repaint();

    }

    public void radioBotones() {

        JRadioButton botonop1 = new JRadioButton("Opción 1", true);
        JRadioButton botonop2 = new JRadioButton("Opción 2");
        JRadioButton botonop3 = new JRadioButton("Opción 3");

        botonop1.setBounds(10, 300, 100, 30);
        botonop2.setBounds(10, 330, 100, 30);
        botonop3.setBounds(10, 360, 100, 30);

        botonop1.setBackground(Color.ORANGE);
        botonop2.setBackground(Color.ORANGE);
        botonop3.setBackground(Color.ORANGE);

        panel.add(botonop1);
        panel.add(botonop2);
        panel.add(botonop3);
        panel.repaint();
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(botonop1);
        grupo.add(botonop2);
        grupo.add(botonop3);
        panel.repaint();

    }

    public void cajaTexto() {

        texto = new JTextField();
        texto.setBounds(10, 400, 100, 20);
        texto.setColumns(5);
        texto.setBorder(BorderFactory.createLineBorder(Color.yellow,2));
        KeyListener escuchat = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(texto.getText().length()>=5){
                    e.consume();//elimina el caracter desde el 6 
                }
                
            }
            @Override
            public void keyPressed(KeyEvent e) {
               
                
            }

            @Override
            public void keyReleased(KeyEvent e) {
                
            }
        };
        texto.addKeyListener(escuchat);
        panel.add(texto);
        panel.repaint();

    }

    public void insertarObjetos() {

        productos.add(new Producto("Camiseta", 5.67));
        productos.add(new Producto("Pantalones", 33.67));
        productos.add(new Producto("Camisa", 5.67));
    }
    
    @SuppressWarnings("unchecked")
    public void listas() {
        String[] ciudades = {"Quito", "Guayaquil", "Cuenca"};
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();// en este modelo se insertan los elementos 
        insertarObjetos();
        modelo.addAll(productos);

        JComboBox listap = new JComboBox(modelo);
        @SuppressWarnings("unchecked")
        JComboBox lista = new JComboBox(ciudades);
        
        lista.setSelectedItem("Cuenca");
        lista.setBounds(10, 450, 70, 30);
        listap.setBounds(10,500, 70, 30);
        
        listap.setSelectedItem(productos.get(0));
        panel.add(lista);
        panel.add(listap);
        panel.repaint();

    }

    public void tablas() {
        DefaultTableModel modelot = new DefaultTableModel();
        DefaultTableModel modelop = new DefaultTableModel();
        
        modelot.addColumn("Nombre");
        modelot.addColumn("Ciudad");
        modelot.addColumn("Direccion");
        
        modelop.addColumn("Nombre p");
        modelop.addColumn("Precio p");
        
        String[] fila1 = {"Juan", "Quito", "El Recreo"};
        String[] fila2 = {"Francisco", "Guayaquil", "El Seguro"};
        
        modelot.addRow(fila1);
        modelot.addRow(fila2);
        JTable tabla = new JTable(modelot);
        
        tabla.setBounds(120, 10, 250, 200);
        panel.add(tabla);
        JScrollPane barra = new JScrollPane(tabla, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barra.setBounds(120, 10, 250, 200);
        
        panel.add(barra);
        
        
        Object [] p = null;
        for(int i=0; i<productos.size();i++){
            
            modelop.addRow(p);
            Producto p1= productos.get(i);
            modelop.setValueAt(p1.getNombre(), i, 0);
            modelop.setValueAt(p1.getPrecio(), i, 1);
        }
        JTable tablap =new JTable(modelop);
        tablap.setBounds(120, 220, 150, 200);
        panel.add(tablap);
        JScrollPane barrap = new JScrollPane(tablap, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        barrap.setBounds(120, 220, 150, 200);
        panel.add(barrap);
        
        
        
        panel.repaint();

    }

};
