package inteface;

import java.util.List;
import models.Usuario;


public interface Crud {
    
    public List<Usuario>  listUsers();
    
    public Usuario seeUser(int id);
    
    public Boolean Add(Usuario usuario);
    
    public Boolean Edit(Usuario usuario);
    
    public Boolean Delete(int id);
    
}
