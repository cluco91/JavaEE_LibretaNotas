
package com.lucodeveloper.ejb;

import com.lucodeveloper.model.Telefono;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lucodeveloper
 */

@Local
public interface TelefonoFacadeLocal {

    void create(Telefono telefono);

    void edit(Telefono telefono);

    void remove(Telefono telefono);

    Telefono find(Object id);

    List<Telefono> findAll();

    List<Telefono> findRange(int[] range);

    int count();
    
    List<Telefono> buscarTelefono(int codigoPersona) throws Exception;
}