package co.edu.uniquindio.poo.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class EmpresaEnvios {
    private String nombre;
    private List<Envio> listaEnvios= new LinkedList<>();

    public EmpresaEnvios(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Envio> getListaEnvios() {
        return listaEnvios;
    }

    public void setListaEnvios(List<Envio> listaEnvios) {
        this.listaEnvios = listaEnvios;
    }

    //Logica

    public String registrarEnvio(Envio envio){
        Optional<Envio> encontrado= buscarEnvio(envio.getCodigo());
        if (encontrado.isPresent()){
            return "En envio ya existe";
        }else{
            listaEnvios.add(envio);
            return "Registrado exitosamente";
        }
    }

    private Optional<Envio> buscarEnvio(String codigo) {
        return listaEnvios.stream().filter(e-> e.getCodigo().equals(codigo));
    }

    @Override
    public String toString() {
        return "EmpresaEnvios{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
