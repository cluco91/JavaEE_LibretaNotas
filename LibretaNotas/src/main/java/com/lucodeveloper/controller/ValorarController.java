
package com.lucodeveloper.controller;

import com.lucodeveloper.ejb.NotaFacadeLocal;
import com.lucodeveloper.model.Nota;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author lucodeveloper
 */


@Named
@ViewScoped
public class ValorarController implements Serializable {

    @EJB
    private NotaFacadeLocal notaEJB;
    @Inject
    private ComentarController comentarController;
    private Nota nota;

    @PostConstruct
    public void init() {
        this.nota = comentarController.getNota();
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public void registrar() {
        try {
            notaEJB.edit(nota);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se comentó perfectamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error"));
        } finally {
            FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
        }
    }

}