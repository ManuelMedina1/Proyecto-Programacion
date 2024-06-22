package Clases;

import Conexion.Conexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketSystemGUI extends JFrame{
    private GestorTickets gestorTickets;
    private JTextArea displayArea;
    
    public TicketSystemGUI(GestorTickets gestorTickets){
        this.gestorTickets = gestorTickets;
        setTitle("Sistema de Control de Tickets");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        add(new JScrollPane(displayArea), BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        JButton btnCrearTicket = new JButton("Crear Ticket");
        JButton btnVerTickets = new JButton("Ver Tickets");
        JButton btnEliminarTicket = new JButton("Eliminar Ticket");
        
        btnCrearTicket.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                crearTicket();
            }
        });
        
        btnVerTickets.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                mostrarTickets();
            }
        });
        
        panel.add(btnCrearTicket);
        panel.add(btnVerTickets);
        add(panel, BorderLayout.SOUTH);
    }
    
    private void crearTicket(){
        InterfazUsuario usuario = null;
        String descripcion = JOptionPane.showInputDialog(this, "Descripción del Problema: ");
        String asignadoA = JOptionPane.showInputDialog(this, "¿A quien va dirigido el ticket?: ");
        usuario = new UsuarioNormal("Usuario Normal");
        if(descripcion != null && !descripcion.trim().isEmpty()){
            Ticket ticket = new TicketSoporte(usuario, descripcion);
            gestorTickets.crearTicket(ticket);
            //mostrarTickets();
        }
        
    }
    
    private void mostrarTickets(){
        displayArea.setText("");
        for(Ticket ticket : gestorTickets.obtenerTickets()){
            displayArea.append("Creador del ticket: " + ticket.getCreador() + "\n" +
                               "Fecha de Creacion: " + ticket.getFechaCreacionFormateada() + "\n" +
                               "Ticket asignado a: " + ticket.getAsignadoA() + "\n" +
                               "Descripción: " + ticket.getDescripcion() + "\n" +
                               "Estado del ticket: " + ticket.getEstado() + "\n" +
                               "Atendido por: " + ticket.getAtentidoPor());
        }
    }
    
    public static void main(String[] args) {
        Conexion con= new Conexion();
        Conexion.main(args);
        GestorTickets gestorTickets = new GestorTickets();
        TicketSystemGUI gui = new TicketSystemGUI(gestorTickets);
        gui.setVisible(true);
    }
}
