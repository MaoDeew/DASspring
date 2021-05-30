package com.das.dasspring.control.controlCargas;


import com.das.dasspring.control.logica.Operaciones;
import com.das.dasspring.control.logica.Proxy;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@RestController
@RequestMapping("/controller")
public class Controlador {

    private Operaciones operaciones = Operaciones.crearIFacade();


    public Controlador() throws NoSuchAlgorithmException {
    }

    @GetMapping("/getTipo/{key}")
    public String getTipo(@PathVariable String key){
        String temp = key.replace("_","/");
        return operaciones.tipoUser(temp);
    }

    @GetMapping("/registerUser/{user}/{pass}/{nombre}/{documento}")
    public boolean registerUser(@PathVariable String user,@PathVariable String pass,@PathVariable String nombre,@PathVariable String documento){
        return operaciones.registerUser(user,pass,nombre,documento);
    }

    @GetMapping("/registerEmpresa/{key}/{user}/{pass}/{nombre}/{documento}/{direccion}/{descripcion}")
    public boolean registerEmpresa(@PathVariable String key,@PathVariable String user,@PathVariable String pass,@PathVariable String nombre,@PathVariable String documento,@PathVariable String direccion, @PathVariable String descripcion) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        key = key.replace("_","/");
        return operaciones.registerEmpresa(key,user,pass,nombre,documento,direccion,descripcion);
    }

    @GetMapping("/login/{user}/{pass}")
    public String login(@PathVariable String user,@PathVariable String pass){
        try {
            Proxy proxy = new Proxy(user,pass);
            String temp = proxy.performOperation();
            temp = temp.replace("/","_");
            return temp;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "null";
        }
    }

    @GetMapping("/getInfoEmpresas")
    public String[] getInfoEmpresas(){
        return operaciones.getInfoEmpresas();
    }

    @GetMapping("/deleteUser/{key}/{user}")
    public boolean deleteEmpresa(@PathVariable String key, @PathVariable String user){
        key = key.replace("_","/");
        return operaciones.removeUser(key,user);
    }



    @GetMapping("/getAllUsuarios/{key}")
    public String[] getInfoEmpresas(@PathVariable String key){
        key = key.replace("_","/");
        return operaciones.getAllUsuarios(key);
    }

    @GetMapping(("/getUser/{key}/{user}"))
    public String[] getUser(@PathVariable String key,@PathVariable String user){
        String temp = key.replace("_","/");
        return operaciones.getUsuario(temp,user);
    }

    @GetMapping("/updateEmpresa/{key}/{user}/{pass}/{nombre}/{documento}/{direccion}/{descripcion}")
    public boolean updateEmpresa(@PathVariable String key,@PathVariable String user,@PathVariable String pass,@PathVariable String nombre,@PathVariable String documento,@PathVariable String direccion, @PathVariable String descripcion){
        key = key.replace("_","/");
        return operaciones.updateUser(key,user,pass,nombre,documento,direccion,descripcion);
    }

    @GetMapping("/updateUser/{key}/{user}/{pass}/{nombre}/{documento}")
    public boolean updateUser(@PathVariable String key,@PathVariable String user,@PathVariable String pass,@PathVariable String nombre,@PathVariable String documento) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        key = key.replace("_","/");
        return operaciones.updateUser(key,user,pass,nombre,documento);
    }

    @GetMapping("/addConvocatoria/{key}/{codigo}/{name}/{cargo}/{descripcion}")
    public boolean crearConvocatoria(@PathVariable String key,@PathVariable String codigo,@PathVariable String name,@PathVariable String cargo,@PathVariable String descripcion) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        key = key.replace("_","/");
        return operaciones.crearConvocatoria(key,codigo,name,cargo,"","");
    }

    @GetMapping("/getConvocatorias/{key}")
    public ArrayList<String> getConvocatoriasEmpresa(@PathVariable String key) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        key = key.replace("_","/");
        return operaciones.getConvocatoriasEmpresa(key);
    }

    @GetMapping("/getConvocatoriasM/{empresa}")
    public ArrayList<String> getConvocatorias(@PathVariable String empresa) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        return operaciones.getConvocatoriasEmpr(empresa);
    }

    @GetMapping("/getConvocatoria/{key}/{codigo}")
    public String getConvocatoria(@PathVariable String key, @PathVariable String codigo) throws IllegalBlockSizeException, NoSuchPaddingException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
        key = key.replace("_","/");
        return operaciones.getConvocatoria(key,codigo);
    }


    @GetMapping("/removeConvocatoria/{key}/{codigo}")
    public boolean removeConvocatoria(@PathVariable String key,@PathVariable String codigo){
        key = key.replace("_","/");
        return operaciones.removeConvocatoria(key,codigo);
    }

    @GetMapping("/updateConvocatoria/{key}/{codigo}/{name}/{cargo}")
    public boolean updateConvocatoria(@PathVariable String key,@PathVariable String codigo,@PathVariable String name,@PathVariable String cargo){
        key = key.replace("_","/");
        return operaciones.updateConvotario(key,codigo,name,cargo,"","");
    }

    @GetMapping("/removeUser/{key}")
    public boolean removeUser(@PathVariable String key){
        key = key.replace("_","/");
        return operaciones.removeUser(key);
    }

    @GetMapping("/addConvocatoria/{key}/{convocatoria}")
    public boolean addConvocatoria(@PathVariable String key,@PathVariable String convocatoria){
        key = key.replace("_","/");
        return operaciones.addConvocatoriaUsario(key,convocatoria);
    }

    @GetMapping("/getMisConvocatorias/{key}")
    public ArrayList<String> getMisConvocatorias(@PathVariable String key){
        key = key.replace("_","/");
        return operaciones.getConvocatoriasUser(key);
    }

}
