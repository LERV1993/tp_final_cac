package models;

public class Usuario {
    
    int id;
    String dni;
    String name;

    public Usuario() {
    }

    public Usuario(String dni, String name) {
        this.dni = dni;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
        
}
