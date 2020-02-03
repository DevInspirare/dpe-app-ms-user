package pe.com.devinspirare.dpeappmsusuario;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pe.com.devinspirare.dpeappjarmodels.dto.UserDTO;
import pe.com.devinspirare.dpeappmsusuario.dao.UsuarioDAO;
import pe.com.devinspirare.dpeappmsusuario.service.UserService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DpeAppMsUserApplicationTests {



    @Mock
    private UsuarioDAO usuarioDAO;

    @Mock
    private UserService userService;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRegisterUser() {
        userService.newUser(new UserDTO());
    }

    @Test
    public void testListUser(){
        List<UserDTO> list = userService.getAllUsers();

    }

}
