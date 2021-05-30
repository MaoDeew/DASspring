package com.das.dasspring.model.convocatoria;

import com.das.dasspring.model.empresa.Composite;

public class ConvocatoriaDinamica extends ConvocatoriaDecorator{
    private String atributo;
    private String descripcion;

    public ConvocatoriaDinamica(Composite specialConvocatoria, String descripcion, String atributo){
        super(specialConvocatoria);
        this.descripcion = descripcion;
        this.atributo = atributo;
    }

    @Override
    public String verDatos() {
        String temp = "";

        if (showConvocatoria() != null)
            temp = showConvocatoria();

        temp+= addAtributo();
        return temp;
    }

    @Override
    public String[] getAtributo() {
        String temp[] = new String[this.verDatos().split("\n").length*2];

        int index = 0;
        for (String c:this.verDatos().split("\n")) {
            temp[index] = c.split(": ")[0];
            temp[index+1] = c.split(": ")[1];
            index += 2;
        }
        return temp;
    }

    private String addAtributo(){
        return "\n"+this.atributo.toUpperCase()+": "+this.descripcion;
    }

}
