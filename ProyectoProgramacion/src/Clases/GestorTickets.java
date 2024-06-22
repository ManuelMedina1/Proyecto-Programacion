package Clases;

import java.util.ArrayList;
import java.util.List;

public class GestorTickets {
    private List<Ticket> tickets;
    
    public GestorTickets(){
        tickets = new ArrayList<>();
    }
    
    public void crearTicket(Ticket ticket){
        tickets.add(ticket);
    }
    
    public List<Ticket>obtenerTickets(){
        return tickets;
    }
    
    public List<Ticket>obtenerTicketsPorEstado(String estado){
        List<Ticket> ticketsPorEstado = new ArrayList<>();
        for(Ticket ticket : tickets){
            if(ticket.getEstado().equalsIgnoreCase(estado)){
                ticketsPorEstado.add(ticket);
            }
        }
        return ticketsPorEstado;
    }
    
    public int contarTicketsPorEstado(String estado){
        return obtenerTicketsPorEstado(estado).size();
    }
    
    public int contarTickets(){
        return tickets.size();
    }
}
