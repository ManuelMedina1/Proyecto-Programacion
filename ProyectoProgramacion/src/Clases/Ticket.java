package Clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Ticket {
    private static int contador = 0;
    private int id;
    private InterfazUsuario creador;
    private LocalDateTime fechaCreacion;
    private String descripcion;
    private String estado;
    private InterfazUsuario asignadoA;
    private InterfazUsuario atentidoPor;
    
    public Ticket(InterfazUsuario creador, String descripcion){
        this.id = ++contador;
        this.creador = creador;
        this.fechaCreacion = LocalDateTime.now();
        this.descripcion = descripcion;
        this.estado = "Nuevo";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InterfazUsuario getCreador() {
        return creador;
    }

    public void setCreador(InterfazUsuario creador) {
        this.creador = creador;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public InterfazUsuario getAsignadoA() {
        return asignadoA;
    }

    public void setAsignadoA(InterfazUsuario asignadoA) {
        this.asignadoA = asignadoA;
    }

    public InterfazUsuario getAtentidoPor() {
        return atentidoPor;
    }

    public void setAtentidoPor(InterfazUsuario atentidoPor) {
        this.atentidoPor = atentidoPor;
    }
    
    public abstract void actualizarEstado(String nuevoEstado);
    
    public String getFechaCreacionFormateada(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return fechaCreacion.format(formatter);
    }
}
