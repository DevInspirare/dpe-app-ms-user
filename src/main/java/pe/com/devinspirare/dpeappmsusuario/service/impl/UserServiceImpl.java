package pe.com.devinspirare.dpeappmsusuario.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.com.devinspirare.dpeappjarmodels.dto.GenericResponse;
import pe.com.devinspirare.dpeappjarmodels.dto.UserDTO;
import pe.com.devinspirare.dpeappjarmodels.model.User;
import pe.com.devinspirare.dpeappjarutils.Utils;
import pe.com.devinspirare.dpeappmsusuario.dao.UsuarioDAO;
import pe.com.devinspirare.dpeappmsusuario.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UsuarioDAO usuarioDAO;

    public UserServiceImpl(UsuarioDAO usuarioDAO){
        this.usuarioDAO = usuarioDAO;
    }

    @Override
    public UserDTO newUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUserName());
        user.setSecretPassword(userDTO.getPassword());
        this.usuarioDAO.save(user);
        user.setUserCode(Utils.formatCode('E', new Integer(5).shortValue(), user.getId()));
        userDTO.setId(user.getId());
        userDTO.setUserCode(user.getUserCode());
        return userDTO;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return this.usuarioDAO
                .findAll()
                .stream()
                .map(h-> new UserDTO(h.getId(), h.getUserCode(), h.getUsername(), h.getSecretPassword(), h.getLastModification(), h.getFlagActive()))
                .collect(Collectors.toList());
    }

    @Override
    public GenericResponse updateUser(UserDTO userDTO){
        User user = this.usuarioDAO.findById(userDTO.getId()).orElse(null);
        if(user == null){
            userDTO.setCodeResponse(100);
            userDTO.setResponse("El usuario no se encuentra en nuestra registrado en nuestra base de datos.");
            return userDTO;
        }
        userDTO.setCodeResponse(200);
        userDTO.setResponse("Se actualizado correctamente.");
        user.setSecretPassword(userDTO.getPassword());
        this.usuarioDAO.save(user);
        return userDTO;
    }

    @Override
    public GenericResponse deleteUser(Long id) {
        User user = this.usuarioDAO.findById(id).orElse(null);
        GenericResponse response = new GenericResponse();
        if(user == null){
            response.setCodeResponse(400);
            response.setResponse("El usuario no se encuentra en nuestra registrado en nuestra base de datos.");
            return response;
        }
        this.usuarioDAO.delete(user);
        //Code Success
        response.setCodeResponse(200);
        response.setResponse("Se ha procesado correctamente");
        return response;
    }

    @Override
    public UserDTO getUser(Long id) {
        User user = this.usuarioDAO.getOne(id);
        return new UserDTO(user.getId(), user.getUserCode(), user.getUsername(), user.getSecretPassword(), user.getLastModification(), user.getFlagActive());
    }
}
