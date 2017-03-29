
package com.lucodeveloper.controller;

import com.lucodeveloper.ejb.CategoriaFacadeLocal;
import com.lucodeveloper.ejb.NotaFacadeLocal;
import com.lucodeveloper.model.Categoria;
import com.lucodeveloper.model.Nota;
import com.lucodeveloper.model.Usuario;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author lucodeveloper
 */

@Named
@ViewScoped
public class BuscarController implements Serializable {

    @EJB
    private CategoriaFacadeLocal categoriaEJB;

    @EJB
    private NotaFacadeLocal notaEJB;

    private List<Categoria> listaCategorias;
    private List<Nota> listaNotas;
    private int codigoCategoria;
    private Date fechaConsulta;

    public List<Nota> getListaNotas() {
        return listaNotas;
    }

    public void setListaNotas(List<Nota> listaNotas) {
        this.listaNotas = listaNotas;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    public void setFechaConsulta(Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
    }

    @PostConstruct
    public void init() {
        listaCategorias = categoriaEJB.findAll();
    }

    public void buscar() {
        try {
            Usuario us = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            listaNotas = notaEJB.buscar(us.getCodigo().getCodigo(), codigoCategoria, fechaConsulta);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}