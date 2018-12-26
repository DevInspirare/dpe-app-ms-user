package pe.com.devinspirare.dpeappmsusuario.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.devinspirare.dpeappjarmodels.model.User;

@Repository
public interface UsuarioDAO extends JpaRepository<User, Long>, UserDAOCustom {

}
