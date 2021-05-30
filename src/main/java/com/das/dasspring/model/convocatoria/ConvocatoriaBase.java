package com.das.dasspring.model.convocatoria;

import com.das.dasspring.model.empresa.Composite;

public class ConvocatoriaBase implements Composite, Decorator {
    private String codigo;
    private String name;
    private String cargo;

    public ConvocatoriaBase(String codigo, String name, String cargo) {
        this.codigo = codigo;
        this.name = name;
        this.cargo = cargo;
    }



    @Override
    public String verDatos() {
        return  "CODIGO: "+this.codigo+
                "\nNOMBRE COVOCATORIA: "+name+
                "\nCARGO: "+this.cargo;
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
}
