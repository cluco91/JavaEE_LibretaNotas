
package com.lucodeveloper.ejb;

import com.lucodeveloper.model.Nota;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author lucodeveloper
 */

@Local
public interface NotaFacadeLocal {
    
    void create(Nota persona);

    void edit(Nota persona);

    void remove(Nota persona);

    Nota find(Object id);

    List<Nota> findAll();

    List<Nota> findRange(int[] range);

    int count();
    
    List<Nota> buscar(int codigoPersona, int codigoCategoria, Date fechaConsulta) throws Exception;
    
    
}
