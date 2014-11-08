import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
public class Ventana extends JFrame implements ActionListener{
    private JFrame frame = new JFrame("Inicio");
    private JPanel panel = new JPanel();
    private JButton volver = new JButton("Volver");
    private JScrollPane scrollPanel;
    private JButton verContactos, verGrupos, goBuscar, goAjustes, botonAgregar, exportar, importar;
    private JTextField archivo;
    
    
    private static Agenda miAgenda;
    private static int vistaActual;
    private ArrayList<JTextField> camposDeEntrada;
    private ArrayList<JLabel> etiquetas;
    private ArrayList<JButton> botones1;
    private ArrayList<JButton> botones2;
    private ArrayList<JButton> botones3;
    private ArrayList<JComboBox> tipos;

    
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
        scrollPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPanel.setBounds(0,0,400,400);

//        frame.setContentPane(pane);
//        frame.add(scrollPanel);
        
    }

   
       
    public void iniciar(){
        miAgenda.cargarContactos();
        System.out.println(miAgenda);
        vistaInicial();
    }
 
    private void mostrarBotonesBuscarYAjustes(){
        goBuscar = new JButton("Q");
        goBuscar.setBounds(430-50,0,50,50);
        goBuscar.addActionListener(this);
        panel.add(goBuscar);

        goAjustes = new JButton("Aj");
        goAjustes.setBounds(430,0,50,50);
        goAjustes.addActionListener(this);
        panel.add(goAjustes);

    }
    private void mostrarBotonesContactosYGrupos(){
        verContactos = new JButton("Contactos");
        verContactos.setBounds(130,50,150,50);
        verContactos.addActionListener(this);
        panel.add(verContactos);

        verGrupos = new JButton("Grupos");
        verGrupos.setBounds(280,50,150,50);
        verGrupos.addActionListener(this);
        panel.add(verGrupos);
        
        botonAgregar = new JButton("+");
        botonAgregar.setBounds(430,50,50,50);
        botonAgregar.addActionListener(this);
        panel.add(botonAgregar);
    }
    
    public void vistaInicial(){
        vistaDeContactos(null);
    }
    public void vistaDeContactos(ArrayList<Contacto> contactos){
        vistaActual = 0;
        frame.setTitle("Agenda");
        
        if(contactos == null)
            contactos = miAgenda.getContactos();
        
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
            boton.setBounds(310, 70 + 50*i, 50, 50);
            botones1.add(boton);
            panel.add(boton);
            boton.addActionListener(this);
            
            boton = new JButton("E");
            boton.setBounds(410-50, 70 + 50*i, 50, 50);
            botones2.add(boton);
            panel.add(boton);
            boton.addActionListener(this);

            boton = new JButton("B");
            boton.setBounds(410, 70 + 50*i, 50, 50);
            botones3.add(boton);
            panel.add(boton);
            boton.addActionListener(this);            
        }
        frame.add(panel);
    }
    
    public void vistaDeBusqueda(){
        vistaActual = 'b';
        
        frame.setTitle("Buscar contactos");
        panel.removeAll();
        panel.repaint();
        agregarBotonVolver();
        
        String	listData[] = {
                "Por nombre",
                "Por apellido",
                "Por teléfono",
                "Por email"
//                ,                "Por grupo"
        };

        JTextField query = new JTextField("ingresa el término a buscar");
        query.setBounds(50,100,200,30);
        panel.add(query);

        // Create a new listbox control
        JComboBox criterioDeBusqueda = new JComboBox(listData);
        criterioDeBusqueda.setBounds(250,100,100,30);
        panel.add( criterioDeBusqueda);
        
        JButton buscar = new JButton("Buscar");
        buscar.setBounds(380,100,80,30);
        panel.add(buscar);
        

        final ArrayList<Object> objetoBusqueda = new ArrayList<>();
        objetoBusqueda.add(criterioDeBusqueda);
        objetoBusqueda.add(query);
        
        
        buscar.addActionListener(new Vigilante(objetoBusqueda) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                JComboBox lista = (JComboBox)objetoBusqueda.get(0);
                JTextField query = (JTextField)objetoBusqueda.get(1);
                String busqueda = query.getText();
                
                switch(lista.getSelectedIndex()){
                    case 0:
                        vistaDeContactos(miAgenda.consultarContactoPorNombre(busqueda));
                        break;
                    case 1:
                        vistaDeContactos(miAgenda.consultarContactoPorApellido(busqueda));
                        break;
                    case 2:
                        vistaDeContactos(miAgenda.consultarContactoPorTelefono(busqueda));
                        break;
                    case 3:
                        vistaDeContactos(miAgenda.consultarContactoPorEmail(busqueda));
                        break;
                    default:
                        System.out.println("Ninguna opción seleccionada");
                        break;
                }
            }
        });
        
        frame.add(panel);
        
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
    private void agregarBotonVolver(){
        volver.setBounds(400,0,80,30);
        volver.addActionListener(this);    
        panel.add(volver);       
    }
    
    public void verContacto(Contacto contacto){
        frame.setTitle("Ver:" + contacto.getNombre() + " " + contacto.getApellido() );

        panel.removeAll();
        panel.repaint();       
        
        JLabel infoDeContacto = new JLabel(contacto.toString());
                infoDeContacto.setText(convertirAMultilinea(infoDeContacto));
        infoDeContacto.setBounds(20,20,300,300);
        
        panel.add(infoDeContacto);
        
        agregarBotonVolver();
        frame.add(panel);
            
    }
    public void verGrupo(Grupo grupo){
        frame.setTitle("Ver: " + grupo.getNombre());
        panel.removeAll();
        panel.repaint();       
     
        JLabel infoDeGrupo = new JLabel(grupo.toString());
                infoDeGrupo.setText(convertirAMultilinea(infoDeGrupo));
        infoDeGrupo.setBounds(20,20,400,400);
        
        panel.add(infoDeGrupo);
        
        agregarBotonVolver();
        
        frame.add(panel);        
    }
    public void agregarContacto(){
        Contacto contacto = new Contacto("","", new Telefono("",1));
        modificarContacto(contacto,true);
    }
    
    public void modificarContacto(final Contacto contacto, boolean esNuevo){
        
        if(esNuevo)
            frame.setTitle("Agregar nuevo contacto");
        else
            frame.setTitle("Modificar: " + contacto.getNombre() + " " + contacto.getApellido());

        panel.removeAll();
        panel.repaint();       
        
        etiquetas = new ArrayList<>();
        botones1 = new ArrayList<>();
        botones2 = new ArrayList<>();
        botones3 = new ArrayList<>();
        camposDeEntrada = new ArrayList<>();
        tipos = new ArrayList<>();
        
        etiquetas.add(new JLabel("Nombre"));
        etiquetas.add(new JLabel("Apellido"));
        
        camposDeEntrada.add(new JTextField(contacto.getNombre()));
        camposDeEntrada.add(new JTextField(contacto.getApellido()));
        
        JButton agregarTelefono = new JButton("+Teléfono");
        agregarTelefono.setBounds(300,40,100,20);
        panel.add(agregarTelefono);

        JButton agregarEmail = new JButton("+Email");
        agregarEmail.setBounds(300,60,100,20);
        panel.add(agregarEmail);

        for (Telefono telefono : contacto.getTelefonos()) {
            String[] listaTipos = {"T Otro","T Casa", "T Oficina", "T Celular"};
            JComboBox combo = new JComboBox(listaTipos);
            combo.setSelectedIndex(telefono.getTipo());
            tipos.add(combo);
            camposDeEntrada.add(new JTextField(telefono.getNumero()));
        }

        for (Email email : contacto.getEmails()) {
            String[] listaTipos = {"E Otro","E Personal", "E Trabajo", "E Escuela"};
            JComboBox combo = new JComboBox(listaTipos);
            combo.setSelectedIndex(email.getTipo());
            tipos.add(combo);
            camposDeEntrada.add(new JTextField(email.getCorreo()));
        }
        
        int i = 0;
        for (JTextField camposDeEntrada1 : camposDeEntrada) {
            camposDeEntrada1.setBounds(50, 100 + 40*i, 100, 20);
            panel.add(camposDeEntrada1);
            i++;
        }
        i = 0;
        for (JLabel etiqueta : etiquetas) {
            etiqueta.setLabelFor(camposDeEntrada.get(i));
            etiqueta.setBounds(30, 80 + 40*i, 100, 20);
            panel.add(etiqueta);
            i++;
        }
        i = 0;
        for (JComboBox combo : tipos) {
            combo.setBounds(150, 100 + 40*(i+2), 80, 20);
            panel.add(combo);
            i++;
        }
        
        agregarBotonVolver();
        
        JButton guardar = new JButton("Guardar");
        guardar.setBounds(320,0,80,30);

        panel.add(guardar);

        agregarTelefono.addActionListener(new Vigilante(null) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                camposDeEntrada.add(new JTextField("5555555555"));
                camposDeEntrada.get(camposDeEntrada.size()-1).setBounds(300,100+camposDeEntrada.size()*20,80,20);
                panel.add(camposDeEntrada.get(camposDeEntrada.size()-1));
                
                String[] listaTipos = {"T Otro","T Casa", "T Oficina", "T Celular"};

                JComboBox combo = new JComboBox(listaTipos);
                combo.setSelectedIndex(0);
                tipos.add(combo);
                combo.setBounds(380,100+camposDeEntrada.size()*20,60,20);
                panel.add(combo);

                
                panel.repaint();
            }
        });
        
        agregarEmail.addActionListener(new Vigilante(null) {
            @Override
            public void actionPerformed(ActionEvent evt) {
                camposDeEntrada.add(new JTextField("correo@example.com"));
                camposDeEntrada.get(camposDeEntrada.size()-1).setBounds(300,100+camposDeEntrada.size()*20,80,20);
                panel.add(camposDeEntrada.get(camposDeEntrada.size()-1));
                
                String[] listaTipos = {"E Otro","E Personal", "E Correo", "E Escuela"};

                JComboBox combo = new JComboBox(listaTipos);
                combo.setSelectedIndex(0);
                tipos.add(combo);
                combo.setBounds(380,100+camposDeEntrada.size()*20,60,20);
                panel.add(combo);

                
                panel.repaint();
            }
        });

        guardar.addActionListener(new Vigilante(contacto) {
            @Override
            public void actionPerformed(ActionEvent evt) {
               contacto.setNombre(camposDeEntrada.get(0).getText());
               contacto.setApellido(camposDeEntrada.get(1).getText());
               
               ArrayList<Telefono> telefonos = new ArrayList<>();
               ArrayList<Email> emails = new ArrayList<>();
               
                int i = 0;
                for (JTextField campo : camposDeEntrada) {
                    if(i<=1){
                     i++;
                     continue;
                    }
                    
                    String tipo = (String) tipos.get(i-2).getSelectedItem();
                    if(tipo.contains("T ")){
                        Telefono telefono = new Telefono(campo.getText(),tipos.get(i-2).getSelectedIndex());
                        telefonos.add(telefono);
                    }
                    if(tipo.contains("E ")){
                        Email email = new Email(campo.getText(),tipos.get(i-2).getSelectedIndex());
                        emails.add(email);
                    }
                    
                    
                    i++;
                }
                
                contacto.setTelefonos(telefonos);
                contacto.setEmails(emails);
               
               miAgenda.ingresarContacto(contacto);               
            }
        });
        
        
       frame.add(panel);
    }
       
    public String convertirAMultilinea(JLabel orig){
        return "<html>" + orig.getText().replaceAll("\n", "<br>");
    }
    
    public void vistaAjustes(){
        panel.removeAll();
        panel.repaint();
        agregarBotonVolver();
        
        archivo = new JTextField(miAgenda.getArchivo());
        archivo.setBounds(50, 50, 200, 20);
        
        exportar = new JButton ("Exportar");
        importar = new JButton ("Importar");
        importar.setBounds(250,50,100,20);
        exportar.setBounds(350,50,100,20);
        
        exportar.addActionListener(this);
        importar.addActionListener(this);
        
        panel.add(archivo);
        panel.add(exportar);
        panel.add(importar);
        
        
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
        int i;
        
        if (botones1.contains(e.getSource())) {
            System.out.println("Un botón 'VER' fue presionado");
            switch(vistaActual){
                case 0:
                    i = botones1.indexOf(e.getSource());
                    verContacto(miAgenda.getContactos().get(i));
                    break;
                case 'g':
                    i = botones1.indexOf(e.getSource());
                    verGrupo(miAgenda.getGrupos().get(i));
                    break;
                    
            }
            
            
            return;
        }
        if (botones2.contains(e.getSource())) {
            System.out.println("Un botón 'EDITAR' fue presionado");
            switch(vistaActual){
                case 'g':
                    break;
                case 0:
                    i = botones2.indexOf(e.getSource());
                    modificarContacto(miAgenda.getContactos().get(i),false);
       
            }
            return;
        }
        if (botones3.contains(e.getSource())) {
            switch(vistaActual){
                case 0:
                    i = botones3.indexOf(e.getSource());
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
                case 'g':
                    vistaDeGrupos();
                    break;
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
        if(e.getSource() == goBuscar){
            vistaDeBusqueda();
            return;
        }
        if(e.getSource() == botonAgregar){
            agregarContacto();
            return;
        }
        if(e.getSource() == goAjustes){
            vistaAjustes();
            return;
        }
            
        if(e.getSource() == importar){
            miAgenda.setArchivo(archivo.getText());
            miAgenda.cargarContactos();
            return;
        }
        if(e.getSource() == exportar){
            miAgenda.setArchivo(archivo.getText());
            miAgenda.guardarCambios();
            return;
        }
        
    }
}