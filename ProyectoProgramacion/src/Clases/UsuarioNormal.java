package Clases;

public class UsuarioNormal implements InterfazUsuario{
    private String nombre;
    
    public UsuarioNormal(String nombre){
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
        return "UsuarioNormal";
    }
    
    @Override
    public String toString(){
        return nombre;
    }
}
