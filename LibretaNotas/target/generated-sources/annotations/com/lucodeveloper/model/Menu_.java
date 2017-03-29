package com.lucodeveloper.model;

import com.lucodeveloper.model.Menu;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author lucodeveloper
 */

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2017-03-23T01:43:40")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, Integer> codigo;
    public static volatile SingularAttribute<Menu, String> tipo;
    public static volatile SingularAttribute<Menu, Boolean> estado;
    public static volatile SingularAttribute<Menu, Menu> submenu;
    public static volatile SingularAttribute<Menu, String> tipoUsuario;
    public static volatile SingularAttribute<Menu, String> nombre;
    public static volatile SingularAttribute<Menu, String> url;

}