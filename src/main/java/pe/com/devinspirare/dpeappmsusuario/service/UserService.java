package pe.com.devinspirare.dpeappmsusuario.service;

import pe.com.devinspirare.dpeappjarmodels.dto.GenericResponse;
import pe.com.devinspirare.dpeappjarmodels.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO newUser(UserDTO userDTO);

    List<UserDTO> getAllUsers();

    GenericResponse updateUser(UserDTO userDTO);

    GenericResponse deleteUser(Long id);

    UserDTO getUser(Long id);
}
