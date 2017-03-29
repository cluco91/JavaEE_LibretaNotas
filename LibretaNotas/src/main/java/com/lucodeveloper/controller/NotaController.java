
package com.lucodeveloper.controller;

import com.lucodeveloper.ejb.CategoriaFacadeLocal;
import com.lucodeveloper.ejb.NotaFacadeLocal;
import com.lucodeveloper.model.Categoria;
import com.lucodeveloper.model.Nota;
import com.lucodeveloper.model.Persona;
import com.lucodeveloper.model.Usuario;
import java.io.Serializable;
import java.util.List;
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
public class NotaController implements Serializable {

    @EJB
    private NotaFacadeLocal notaEJB;
    @EJB
    private CategoriaFacadeLocal categoriaEJB;
    @Inject
    private Nota nota;
    @Inject
    private Categoria categoria;

    private List<Categoria> categorias;

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

    @PostConstruct
    public void init() {
        categorias = categoriaEJB.findAll();
    }

    public void registrar() {

        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            nota.setCategoria(categoria);
            nota.setPersona(us.getCodigo());
            notaEJB.create(nota);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Se registró"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
    }
}
