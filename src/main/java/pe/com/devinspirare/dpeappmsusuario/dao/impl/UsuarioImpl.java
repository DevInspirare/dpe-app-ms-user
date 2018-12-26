package pe.com.devinspirare.dpeappmsusuario.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.com.devinspirare.dpeappmsusuario.dao.UserDAOCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
@Transactional(readOnly = true)
public class UsuarioImpl implements UserDAOCustom {

    @PersistenceContext
    EntityManager entityManager;

}
