package com.das.dasspring.control.logica;

import com.das.dasspring.model.empresa.Empresa;
import com.das.dasspring.model.usuarios.Adapter;
import com.das.dasspring.model.usuarios.Postulante;
import com.das.dasspring.model.usuarios.Psicologo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserFactory {
    private HashMap <String, Adapter> usuarios = new HashMap<>();

    public void createEmpresa(String user, String pass, String nit, String nombre, String direccion, String descripcion){
        Empresa temp = new Empresa();
        temp.setUser(user);
        temp.setPassword(pass);
        temp.setNit(nit);
        temp.setNombre(nombre);
        temp.setDireccion(direccion);
        temp.setDescripcion(descripcion);
        this.usuarios.put(user,temp);
    }

    public void createPostulante(String user, String password, String nombre, String documento){
        Postulante temp = new Postulante();
        temp.setUser(user);
        temp.setPassword(password);
        temp.setNombre(nombre);
        temp.setDocumento(documento);
        this.usuarios.put(user,temp);
    }

    public void createPsicologo(String user, String password, String nombre, String documento){
        Psicologo temp = new Psicologo();
        temp.setUser(user);
        temp.setUser(password);
        temp.setNombre(nombre);
        temp.setDocumento(documento);
        this.usuarios.put(user,temp);
    }

    public Adapter getUser(String user){
        return this.usuarios.get(user);
    }
    
    public ArrayList<String> getAllEmpresasUsers(){
        ArrayList <String> temp= new ArrayList<>();
        for (Map.Entry c: usuarios.entrySet()) {
            if(c.getValue() instanceof Empresa)
                temp.add((String) c.getKey());
        }
        return temp;
    }

    public ArrayList<String> getAllUsers(){
        ArrayList <String> temp= new ArrayList<>();
        for (Map.Entry c: usuarios.entrySet()) {
            if(!(c.getValue() instanceof Empresa))
                temp.add((String) c.getKey());
        }
        return temp;
    }

    public void setUser(String user, Adapter adapter){
        if(adapter.getClass().equals(this.usuarios.get(user).getClass())){
            this.usuarios.replace(user,adapter);
        }
    }

    public void removeUser(String user){
        this.usuarios.remove(user);
    }

    public HashMap<String, Adapter> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(HashMap<String, Adapter> usuarios) {
        this.usuarios = usuarios;
    }


}
