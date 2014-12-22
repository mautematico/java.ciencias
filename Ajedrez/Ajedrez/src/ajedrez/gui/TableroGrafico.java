package ajedrez.gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import ajedrez.juego.*;
import ajedrez.piezas.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Armand
 */
public class TableroGrafico extends JFrame {
    private JLabel escaques[][];
    private final byte TAMANIO = 8;

    private final ImageIcon[] imagenPeon;
    private final ImageIcon[] imagenTorre;
    private final ImageIcon[] imagenAlfil;
    private final ImageIcon[] imagenReina;
    private final ImageIcon[] imagenRey;
    private final ImageIcon[] imagenCaballo;
    
    private Escaque[] escaquesDeMovimiento;
    
    JMenuItem coronar;
    JMenuItem torre;
    JMenuItem alfil;
    Ajedrez miAjedrez;

    private final void cargarImagenes(){
        //Crea una imagen a partir de la imagen "imagenes/caballo.png" escalándola
        //a un tamaño de 50x50 px

        
        Image img = (new ImageIcon(getClass().getResource("/peon.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        //Se crea un ImageIcon a partir de la imagen de arriba
        imagenPeon[0] = new ImageIcon(img);

        img = (new ImageIcon(getClass().getResource("/torre.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenTorre[0] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/alfil.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenAlfil[0] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/reina.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenReina[0] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/rey.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenRey[0] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/caballo.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenCaballo[0] = new ImageIcon(img);

        img = (new ImageIcon(getClass().getResource("/torreotra.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenTorre[1] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/alfilotro.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenAlfil[1] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/reinaotra.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenReina[1] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/reyotro.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenRey[1] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/peonotro.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenPeon[1] = new ImageIcon(img);
        img = (new ImageIcon(getClass().getResource("/caballootro.png"))).getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        imagenCaballo[1] = new ImageIcon(img);

    }
    
        
    
    public TableroGrafico() {
        super("Mi ajedrez");

        miAjedrez = new Ajedrez();
        imagenPeon = new ImageIcon[2];
        imagenCaballo = new ImageIcon[2];
        imagenAlfil = new ImageIcon[2];
        imagenRey = new ImageIcon[2];
        imagenReina = new ImageIcon[2];
        imagenTorre = new ImageIcon[2];
        cargarImagenes();

        inicializarComponentes();//Inicializa los componentes que contendrá el JFrame
        pintarTablero();
        establecerConfiguracionDelFrame();        
    }
    
    private void pintarTablero(){
        //inicializarComponentes();
 
        for(int i = 0; i < escaques.length; i++){
            for(int j = 0; j < escaques[i].length; j++){
                escaques[i][j].setIcon(null);
            }
        }
        super.revalidate();
        super.repaint();
//        System.out.println("todos a null");        
        
        for (int i = 0; i<8; i++){
            for (int j=0; j<8; j++){
                
                Pieza pieza = miAjedrez.getTablero().getCasillas()[j][7-i].getPieza();
                int blancoOnegro = 0;
                if (pieza.isEquipo())
                    blancoOnegro = 1;
                
                if(pieza instanceof Torre )
                    escaques[i][j].setIcon(imagenTorre[blancoOnegro]);                    
                if(pieza instanceof Peon )
                    escaques[i][j].setIcon(imagenPeon[blancoOnegro]);                    
                if(pieza instanceof Alfil )
                    escaques[i][j].setIcon(imagenAlfil[blancoOnegro]);                    
                if(pieza instanceof Reina )
                    escaques[i][j].setIcon(imagenReina[blancoOnegro]);                    
                if(pieza instanceof Rey )
                    escaques[i][j].setIcon(imagenRey[blancoOnegro]);                    
                if(pieza instanceof Caballo )
                    escaques[i][j].setIcon(imagenCaballo[blancoOnegro]);    

            }
            
        }
        
        super.revalidate();
        super.repaint();
    }
    
    private void inicializarComponentes() {
        //Se crea una barra de menús y el primer menú que estará en ella
        JMenuBar barraMenus = new JMenuBar();
        JMenu menuConfiguraiones = new JMenu("Configuraciones");
        
        //Se crea manejador de acciones que estará a la escucha de eventos de acción
        ManejadorConfiguraciones manejador = new ManejadorConfiguraciones();
        
        //Se crean 3 JMenuItem
        coronar = new JMenuItem("Coronación");
        torre = new JMenuItem("Torre");
        alfil = new JMenuItem("Alfil");
        
        //Se agrega un escucha de acciones a cada JMenuItem
        coronar.addActionListener(manejador);
        torre.addActionListener(manejador);
        alfil.addActionListener(manejador);
        
        //Se agregan los JMenuItem al JMenu
        menuConfiguraiones.add(coronar);
        menuConfiguraiones.add(torre);
        menuConfiguraiones.add(alfil);
        barraMenus.add(menuConfiguraiones);
        add(barraMenus, BorderLayout.NORTH);
        
        //Se crea un contenedor para acomodar los escaques
        JPanel contenedorEscaques = new JPanel(new GridLayout(8, 8));
        
        //Se crean los escaques como etiquetas y se establece un color a cada uno
        //posteriormente se añaden al contenedor
        boolean colorNegro = false;
        escaques = new JLabel[TAMANIO][TAMANIO];
        for(int i = 0; i < escaques.length; i++){
            for(int j = 0; j < escaques[i].length; j++){
                escaques[i][j] = new JLabel();
                escaques[i][j].setOpaque(true);
//                escaques[i][j].setText(i+","+j);
                if(colorNegro) escaques[i][j].setBackground(Color.black);
                else escaques[i][j].setBackground(Color.white);
                colorNegro = !colorNegro;
                contenedorEscaques.add(escaques[i][j]);
                
                escaques[i][j].addMouseListener(
                        new ManejadorDeClics(miAjedrez.getTablero().getCasillas()[j][7-i]));

            }
            colorNegro = !colorNegro;
        }
        
        //Se agrega el contenedor de escaques al contenedor principal en la parte central
        add(contenedorEscaques);
    } //fin del método inicializarComponentes
    
    private void establecerConfiguracionDelFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(501, 527);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String [] argv){
        TableroGrafico tablero = new TableroGrafico();

/*        Escaque origen = tablero.miAjedrez.getTablero().getCasillas()[0][1];
        Escaque destino = tablero.miAjedrez.getTablero().getCasillas()[0][3];
        
        tablero.miAjedrez.moverPieza(origen, destino);
        tablero.pintarTablero();
  */      
    }
    
    private class ManejadorConfiguraciones implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent evento) {
            if(evento.getSource() == coronar){
                miAjedrez = new Ajedrez("coronar");
                pintarTablero();
            }
            if(evento.getSource() == torre){
                miAjedrez = new Ajedrez("torre");
                pintarTablero();
            }
            if(evento.getSource() == alfil){
                miAjedrez = new Ajedrez("rey");
                pintarTablero();
            }
        }
        
    } //fin de la clase interna ManejadorConfiguraciones

    private class ManejadorDeClics implements MouseListener{
        private Escaque escaque;

        ManejadorDeClics(final Escaque escaque){
            super();
            this.escaque = escaque;
        }

        @Override
        public void mouseClicked(MouseEvent e) {            
//            System.out.println("Clic!!!");

            if(escaquesDeMovimiento == null){
                escaquesDeMovimiento = new Escaque[2];
                escaquesDeMovimiento[0] = this.escaque;
                escaquesDeMovimiento[1] = null;
                System.out.println("Primer escaque "+ escaquesDeMovimiento[0].getPieza().getPosicion().getX() 
                        +"," +  escaquesDeMovimiento[0].getPieza().getPosicion().getY() );
                System.out.println("Pieza: ");
                
                if(escaquesDeMovimiento[0].getPieza() instanceof Reina)
                    System.out.println("Reina");
                if(escaquesDeMovimiento[0].getPieza() instanceof NoPieza)
                    System.out.println("NoPieza");
                if(escaquesDeMovimiento[0].getPieza() instanceof Rey)
                    System.out.println("Rey");
                if(escaquesDeMovimiento[0].getPieza() instanceof Peon)
                    System.out.println("Peon");
                if(escaquesDeMovimiento[0].getPieza() instanceof Caballo)
                    System.out.println("Caballo");
                if(escaquesDeMovimiento[0].getPieza() instanceof Torre)
                    System.out.println("Torre");
                if(escaquesDeMovimiento[0].getPieza() instanceof Alfil)
                    System.out.println("Alfil");
                escaquesDeMovimiento[0].getPieza().imprimirPosicionesPosibles();
                        
                
            } else if(escaquesDeMovimiento[1] == null){
                escaquesDeMovimiento[1] = this.escaque;
                System.out.println("Segundo escaque "+ escaquesDeMovimiento[1].getPieza().getPosicion().getX() 
                        +"," +  escaquesDeMovimiento[1].getPieza().getPosicion().getY() );


                if(escaquesDeMovimiento[1].getPieza() instanceof Reina)
                    System.out.println("Reina");
                if(escaquesDeMovimiento[1].getPieza() instanceof NoPieza)
                    System.out.println("NoPieza");
                if(escaquesDeMovimiento[1].getPieza() instanceof Rey)
                    System.out.println("Rey");
                if(escaquesDeMovimiento[1].getPieza() instanceof Peon)
                    System.out.println("Peon");
                if(escaquesDeMovimiento[1].getPieza() instanceof Caballo)
                    System.out.println("Caballo");
                if(escaquesDeMovimiento[1].getPieza() instanceof Torre)
                    System.out.println("Torre");
                if(escaquesDeMovimiento[1].getPieza() instanceof Alfil)
                    System.out.println("Alfil");

                try{
                    miAjedrez.moverPieza(escaquesDeMovimiento[0], escaquesDeMovimiento[1]);
                    escaquesDeMovimiento = null;
                    pintarTablero();
               } catch(RuntimeException ex){
                    System.out.println("¡Algo pasó!");
                }
            }

            
        }

        @Override
        public void mousePressed(MouseEvent e) {
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
    }

    
} //fin de la clase TableroGrafico