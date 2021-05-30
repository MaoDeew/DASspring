package com.das.dasspring.model.usuarios;

public class Psicologo extends Adapter {
    private String usuario;
    private String contrasena;
    private String nombre;
    private String documento;

    public Psicologo() {
        this.usuario = "";
        this.contrasena = "";
        this.nombre = "";
        this.documento = "";
    }

    public Psicologo(String usuario, String contrasena, String nombre, String documento) {
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.documento = documento;
    }

    public String getUser() {
        return this.usuario;
    }

    public String getPassword() {
        return this.contrasena;
    }

    public void setUser(String user) {
        this.usuario=user;
    }

    public void setPassword(String password) {
        this.contrasena=password;
    }

    public boolean autLogin(String user, String password) {
        return(this.contrasena.equals(password) && this.usuario.equals(user));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
