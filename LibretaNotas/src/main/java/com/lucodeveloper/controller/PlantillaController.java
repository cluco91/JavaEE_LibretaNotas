
package com.lucodeveloper.controller;

import com.lucodeveloper.model.Usuario;
import java.io.Serializable;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author lucodeveloper
 */


@Named
@ViewScoped
public class PlantillaController implements Serializable {
    
    public void verificarSesion(){
        try {
           FacesContext context = FacesContext.getCurrentInstance();
           Usuario us = (Usuario) context.getExternalContext().getSessionMap().get("usuario");
        
           if(us == null){
               context.getExternalContext().redirect("./../permisos.xhtml");
           }
        } catch (Exception e) {
            //...
        }
    }
    
}
