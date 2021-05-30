package com.das.dasspring.model.empresa;

import com.das.dasspring.model.convocatoria.ConvocatoriaDinamica;
import com.das.dasspring.model.usuarios.Adapter;

import java.util.ArrayList;

public class Empresa extends Adapter implements Composite{
    private String user;
    private String password;
    private String nit;
    private String nombre;
    private String direccion;
    private String descripcion;
    private ArrayList <Composite> componentes;

    //---------------------------------CRUD EMPRESA--------------------------------------//

    public Empresa() {
        super();
        this.nit = "";
        this.nombre = "";
        this.direccion = "";
        this.descripcion = "";
        this.componentes = new ArrayList<>();
    }

    public Empresa(String user, String pass, String nit, String nombre, String direccion, String descripcion) {
        super();
        this.user = user;
        this.password = pass;
        this.nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.componentes = new ArrayList<>();
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUser() {
        return this.user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setUser(String login) {
        this.user = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean autLogin(String user, String password) {
        return (password.equals(this.password) && user.equals(this.user));
    }

    public String verSoloEmpresa() {
        String temp="\nEmpresa: "+getNombre()+
                "\nNIT: "+getNit()+
                "\nDireccion: "+getDireccion()+
                "\nAcerca de la empresa"+
                "\n"+descripcion;
        return temp;
    }

    //---------------------------------CRUD CONVOCATORIAS--------------------------------------//

    public ConvocatoriaDinamica getConvocatoriaCodigo(String codigo){
        int temp = this.getIndexConvocatoria(codigo);
        if(temp != -1)
            return ((ConvocatoriaDinamica) this.componentes.get(temp));
        return null;
    }

    public ConvocatoriaDinamica getConvocatoriaIndex(int index){
        if(this.componentes.get(index) instanceof ConvocatoriaDinamica)
            return ((ConvocatoriaDinamica) this.componentes.get(index));
        return null;
    }

    public void setConvocatoria(String codigo, Composite convocatoria){
        int temp = this.getIndexConvocatoria(codigo);
        if(temp != -1)
            this.componentes.set(temp,convocatoria);
    }

    public void deleteConvocatoria(String codigo){
        int temp = this.getIndexConvocatoria(codigo);
        if(temp != -1)
            this.componentes.remove(temp);
    }

    public int getCantidadConvocatorias(){
        int contador = 0;
        for (Composite c : this.componentes) {
            if(c instanceof ConvocatoriaDinamica){
                contador++;
            }
        }
        return contador;
    }

    public boolean convocatoriExiste(String codigo){
        return (this.getIndexConvocatoria(codigo) != -1);
    }

    //---------------------------------CRUD COMPONENTES--------------------------------------//

    public void addComponente(Composite componente){
        this.componentes.add(componente);
    }

    public ArrayList<Composite> getComponentes() {
        return componentes;
    }

    public void setComponentes(ArrayList<Composite> componentes) {
        this.componentes = componentes;
    }

    public String verDatos() {
        String temp="\nEmpresa: "+getNombre()+" NIT: "+getNit()+" Direccion: "+getDireccion();
        for (Composite e:this.componentes) {
            temp+="\n\n"+e.verDatos();
        }

        return temp;
    }
    //---------------------------------METODOS INTERNOS--------------------------------------//

    public int getIndexConvocatoria(String codigo){
        int contador=0;
        for (Composite c: componentes) {
            if(c instanceof ConvocatoriaDinamica)
                if(((ConvocatoriaDinamica) c).getAtributo()[1].equals(codigo)){
                    return contador;
                }
            contador++;
        }
        return -1;
    }
}
