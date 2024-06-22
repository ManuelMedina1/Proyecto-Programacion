package Clases;

public class SuperUsuario implements InterfazUsuario{
    private String nombre;
    
    public SuperUsuario(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String getNombre(){
        return nombre;
    }
    
    @Override
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    @Override
    public String getTipoUsuario(){
        return "SuperUsuario";
    }
}
