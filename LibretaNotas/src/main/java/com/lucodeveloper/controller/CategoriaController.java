
package com.lucodeveloper.controller;

import com.lucodeveloper.ejb.CategoriaFacadeLocal;
import com.lucodeveloper.model.Categoria;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lucodeveloper
 */

@Named
@ViewScoped
public class CategoriaController implements Serializable {
    
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    @Inject
    private Categoria categoria;


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    @PostConstruct
    public void init(){
        //categoria = new Categoria();
    }
    
    public void registrar(){
        try {
            categoriaEJB.create(categoria);
        } catch (Exception e) {
            //Mensaje Exception
        }
    }
    
    
}
