package com.das.dasspring.model.convocatoria;

import com.das.dasspring.model.empresa.Composite;

abstract class ConvocatoriaDecorator implements Composite, Decorator {
    protected Composite specialConvocatoria;

    public ConvocatoriaDecorator(Composite specialConvocatoria) {
        this.specialConvocatoria = specialConvocatoria;
    }

    public String showConvocatoria(){
        if(specialConvocatoria != null)
            return specialConvocatoria.verDatos();
        return null;
    }
}
