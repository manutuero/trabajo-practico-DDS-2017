package com.utn.dds.javaianos.domain;

import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import org.springframework.beans.factory.annotation.Autowired;
import com.utn.dds.javaianos.repository.CuentaRepository;
import com.utn.dds.javaianos.repository.IndicadorRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.script.ScriptException;

@Entity
@Table(name = "Indicador")
public class Indicador implements Serializable, Componente {

    @Id
    private String nombre;
    private String tipo;
    private String formula;

    @Autowired
    @Transient
    IndicadorRepository indicadorRepository;

    @Autowired
    @Transient
    CuentaRepository cuentaRepository;

    @Transient
    private List<Componente> componentes;

    public Indicador() {
        this.componentes = new ArrayList();
    }

    public Indicador(String nombre, String tipo, String formula) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.formula = formula;
        this.componentes = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }

    @Override

    public Double calcularValor(String empresa, Integer periodo) {
        Double valor = 0.0; 
        String[] result = formula.split("(?<=[-+*/)( ])|(?=[-+*/)( ])");
        String formulaFinal = "";  
        Indicador indicador;
        Cuenta cuenta;
        Componente componente=null;
        
        for (String elemento : result) {
            indicador=null;
            cuenta=null;
            if ((elemento.matches("([0-9.]+)")) || (elemento.matches("[-+*/()]"))) {
                formulaFinal = formulaFinal + elemento;
            } else //Es un componente. Busco su valor. 
            {   try {
                indicador=indicadorRepository.findByNombre(elemento);
                cuenta=cuentaRepository.findByNombreAndEmpresaAndPeriodo(elemento, empresa, periodo);
                }catch (Exception ex)
                {System.out.println("ERROR AL BUSCAR CUENTAS E INDICADORES.");}
                if ( indicador!= null) {
                    System.out.println("Es indicador");
                    componente=indicador;
                    
                } else if ( cuenta!= null) {
                    System.out.println("Es cuenta");
                    componente=cuenta;
                } else {
                    System.out.println("Error, no encontro ni cuenta ni indicador. indicador.java");
                }
            
            if(componente!=null){
             valor = componente.calcularValor(empresa, periodo);
             formulaFinal = formulaFinal + valor.toString();//obtiene el valor en formato string de una cuenta o indicador. 
            } else {System.out.println("componente vino null");}  
            }
        }
        System.out.println("FOrmula final aca: ---"+formulaFinal); 
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        try {
            valor = (Double) engine.eval(formulaFinal);
        } catch (ScriptException ex) {
            Logger.getLogger(Indicador.class.getName()).log(Level.SEVERE, null, ex);
            valor = 0.0;
        }
        return valor;
    }

    @Override
    public void add(Componente componente) {
        componentes.add(componente);
    }

    @Override
    public void remove(Componente componente) {
        componentes.remove(componente);
    }

    @Override
    public Componente getChild(int i) {
        return componentes.get(i);
    }

    @Override
    public Double calcularValor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
