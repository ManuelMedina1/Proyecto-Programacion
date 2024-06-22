package Clases;

public class TicketSoporte extends Ticket{
    
    public TicketSoporte(InterfazUsuario creador, String descripcion){
        super(creador, descripcion);
    }
    
    @Override
    public void actualizarEstado(String nuevoEstado){
        setEstado(nuevoEstado);
    }
}
