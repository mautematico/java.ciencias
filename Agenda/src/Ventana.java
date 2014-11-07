import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
public class Ventana extends JFrame implements ActionListener{
    private JFrame frame = new JFrame("Inicio");
    private JPanel panel = new JPanel();
    private JButton volver = new JButton("Volver");
    
    private JButton verContactos, verGrupos, goBuscar, goAjustes, agregar;
    
    private static Agenda miAgenda;
    private static int vistaActual;
    private ArrayList<JTextField> camposDeEntrada;
    private ArrayList<JLabel> etiquetas;
    private ArrayList<JButton> botones1;
    private ArrayList<JButton> botones2;
    private ArrayList<JButton> botones3;

    
        public Ventana() {
        camposDeEntrada = new  ArrayList<>();
        etiquetas = new ArrayList<>();
        botones1 = new ArrayList<>();
        botones2 = new ArrayList<>();
        botones3 = new ArrayList<>(); 
        vistaActual = 0;
        panel = new JPanel();
        frame = new JFrame();
        
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JScrollPane pane = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        setContentPane(pane);
        
    }

   
       
    public void iniciar(){
//        miAgenda.cargarContactos();
        miAgenda.importarContactosDeUnArchivo("/tmp/miAgenda.json");
        System.out.println(miAgenda);
        vistaInicial();
    }
 
    private void mostrarBotonesBuscarYAjustes(){
        goBuscar = new JButton("Q");
        goBuscar.setBounds(350,0,50,50);
        goBuscar.addActionListener(this);
        panel.add(goBuscar);

        goAjustes = new JButton("Aj");
        goAjustes.setBounds(410,0,50,50);
        goAjustes.addActionListener(this);
        panel.add(goAjustes);

    }
    private void mostrarBotonesContactosYGrupos(){
        verContactos = new JButton("Contactos");
        verContactos.setBounds(50,50,150,50);
        verContactos.addActionListener(this);
        panel.add(verContactos);

        verGrupos = new JButton("Grupos");
        verGrupos.setBounds(200,50,150,50);
        verGrupos.addActionListener(this);
        panel.add(verGrupos);
        
        agregar = new JButton("+");
        agregar.setBounds(400,50,50,50);
        agregar.addActionListener(this);
        panel.add(agregar);
    }
        
    public void vistaInicial(){
        frame.setTitle("Agenda");
        ArrayList<Contacto> contactos = miAgenda.getContactos();
        
        panel.removeAll();
        panel.repaint();
        
        etiquetas = new ArrayList<>();
        botones1 = new ArrayList<>();
        botones2 = new ArrayList<>();
        botones3 = new ArrayList<>();

        
        //Aquí van los botones Buscar y AJustes (parte superior), 
        //y los botones para cambiar entre contactos y grupos
        mostrarBotonesBuscarYAjustes();
        mostrarBotonesContactosYGrupos();
        
        int i = 0;
        for (Contacto contacto : contactos) {
            i++;
            JLabel fulano = new JLabel(contacto.getNombre() + " "+ contacto.getApellido());
            fulano.setBounds(10,70 + 50*i,300,50);
            etiquetas.add(fulano);
            panel.add(fulano);
            
            JButton boton = new JButton("V");
            boton.setBounds(320, 70 + 50*i, 50, 50);
            botones1.add(boton);
            panel.add(boton);
            boton.addActionListener(this);
            
            boton = new JButton("E");
            boton.setBounds(370, 70 + 50*i, 50, 50);
            botones2.add(boton);
            panel.add(boton);
            boton.addActionListener(this);

            boton = new JButton("B");
            boton.setBounds(410, 70 + 50*i, 50, 50);
            botones3.add(boton);
            panel.add(boton);
            boton.addActionListener(this);

            frame.add(panel);
            
        }        
    }
    
    public void vistaDeGrupos(){
        vistaActual = 'g';
        
        frame.setTitle("Agenda");
        ArrayList<Grupo> grupos = miAgenda.getGrupos();
        
        panel.removeAll();
        panel.repaint();
        
        etiquetas = new ArrayList<>();
        botones1 = new ArrayList<>();
        botones2 = new ArrayList<>();
        botones3 = new ArrayList<>();

        
        //Aquí van los botones Buscar y AJustes (parte superior), 
        //y los botones para cambiar entre contactos y grupos
        mostrarBotonesBuscarYAjustes();
        mostrarBotonesContactosYGrupos();
        
        int i = 0;
        for (Grupo grupo : grupos) {
            i++;
            JLabel circulo = new JLabel(grupo.getNombre());
            circulo.setBounds(10,70 + 50*i,300,50);
            etiquetas.add(circulo);
            panel.add(circulo);
            
            JButton boton = new JButton("V");
            boton.setBounds(320, 70 + 50*i, 50, 50);
            botones1.add(boton);
            panel.add(boton);
            boton.addActionListener(this);
            
            boton = new JButton("E");
            boton.setBounds(370, 70 + 50*i, 50, 50);
            botones2.add(boton);
            panel.add(boton);
            boton.addActionListener(this);

            boton = new JButton("B");
            boton.setBounds(410, 70 + 50*i, 50, 50);
            botones3.add(boton);
            panel.add(boton);
            boton.addActionListener(this);

            frame.add(panel);
            
        }        
        
    }
    
    public void verContacto(Contacto contacto){
        frame.setTitle("Ver:" + contacto.getNombre() + " " + contacto.getApellido() );

        panel.removeAll();
        panel.repaint();       
        
        JLabel infoDeContacto = new JLabel(contacto.toString());
        infoDeContacto.setBounds(20,20,300,300);
        
        panel.add(infoDeContacto);
        
        volver.setBounds(300,0,100,30);
        volver.addActionListener(this);
            
        panel.add(volver);
        frame.add(panel);
            
    }        
        
        
    
  public static void main(String[] a) {
      
    miAgenda = new Agenda();
  
    Ventana ventana = new Ventana();
    
    ventana.iniciar();
    ventana.frame.setSize(480, 640);
    ventana.setBounds(0,0,480,640);

    ventana.frame.setVisible(true);
  }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (botones1.contains(e.getSource())) {
            System.out.println("Un botón 'VER' fue presionado");
            switch(vistaActual){
                case 0:
                    int i = botones1.indexOf(e.getSource());
                    verContacto(miAgenda.getContactos().get(i));
                    break;
            }
            
            
            return;
        }
        if (botones2.contains(e.getSource())) {
            System.out.println("Un botón 'EDITAR' fue presionado");
            return;
        }
        if (botones3.contains(e.getSource())) {
            switch(vistaActual){
                case 0:
                    int i = botones3.indexOf(e.getSource());
                    System.out.println("borrar al contacto" + i);
                    miAgenda.eliminarContacto(miAgenda.getContactos().get(i));
                    vistaInicial();
                    break;
                case 'g':
                    int j = botones3.indexOf(e.getSource());
                    System.out.println("borrar al grupo" + j);
                    miAgenda.eliminarGrupo(miAgenda.getGrupos().get(j));
                    vistaDeGrupos();
                    break;
                    
            }
            return;
        }
        
        if(e.getSource() == volver){
            switch(vistaActual){
                default:
                    vistaInicial();
                    break;
                    
            }
        }
        if(e.getSource() == verGrupos){
            vistaDeGrupos();
            return;
        }
        if(e.getSource() == verContactos){
            vistaInicial();
            return;
        }
            
        
    }
}