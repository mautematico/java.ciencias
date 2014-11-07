import javax.swing.*;
import java.awt.event.*;
import com.google.gson.*;

public class Ventana extends JFrame implements ActionListener{
    private JTextField textfield1,textfield2;
    private JButton boton1;
    public Ventana() {
        setLayout(null);
        textfield1=new JTextField();
        textfield1.setBounds(10,10,100,30);
        add(textfield1);
        textfield2=new JTextField();
        textfield2.setBounds(10,50,100,30);
        add(textfield2);
        boton1=new JButton("Sumar");
        boton1.setBounds(10,90,100,30);
        add(boton1);
        boton1.addActionListener(this);
    }
    
    public void iniciar(){
        Agenda miAgenda = new Agenda();
        miAgenda.cargarContactos();
    }
    
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            String cad1=textfield1.getText();
            String cad2=textfield2.getText();
            int x1=Integer.parseInt(cad1);
            int x2=Integer.parseInt(cad2);
            int suma=x1+x2;
            String total=String.valueOf(suma);
            setTitle(total);
        }
    }
    
    public static void main(String[] ar) {
        Ventana formulario1=new Ventana();
        formulario1.setBounds(0,0,140,150);
        formulario1.setVisible(true);
        
        formulario1.iniciar();
        
        
        /*
        
                    Telefono miTelefono = new Telefono("07913128993120");
            Agenda miAgenda = new Agenda();
   
            miAgenda.ingresarContacto("juan","perez",miTelefono);
 
            miAgenda.ingresarContacto("juan","sánchez",miTelefono);
           miAgenda.ingresarContacto("juan","andrade",miTelefono);
            miAgenda.ingresarContacto("juan","rival",miTelefono);
            miAgenda.ingresarContacto("juan","real",miTelefono);
            
            Grupo juanes = miAgenda.crearGrupo("Juanes");
            
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(1));
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(2));
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(3));
            juanes.asignarContactoAGrupo(miAgenda.getContactos().get(0));
            

            
            Exportador.escribir("miAgenda.json",miAgenda);
            
            Agenda Otra = new Agenda();
            
            Otra = Importador.leer("miAgenda.json");
            System.out.println(miAgenda);
            System.out.println(Otra);

*/
        
    }
}