package com.das.dasspring.model.usuarios;

import java.util.ArrayList;

public class Postulante extends Adapter {
    private String user;
    private String password;
    private String nombre;
    private String documento;
    private ArrayList<String> misConvocatoria = new ArrayList<>();

    public Postulante() {
        this.user = "";
        this.password = "";
        this.nombre = "";
        this.documento = "";
    }

    public Postulante(String user, String password, String nombre, String documento) {
        super();
        this.setUser(user);
        this.setPassword(password);
        this.setNombre(nombre);
        this.setDocumento(documento);
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

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean autLogin(String login, String password) {
        return(this.password.equals(password) && this.user.equals(login));
    }

    public ArrayList<String> getMisConvocatoria() {
        return misConvocatoria;
    }

    public void setMisConvocatoria(ArrayList<String> misConvocatoria) {
        this.misConvocatoria = misConvocatoria;
    }

    public void addConvocatoria(String con){
        this.misConvocatoria.add(con);
    }

}
