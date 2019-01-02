package pe.com.devinspirare.dpeappmsusuario.controller;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pe.com.devinspirare.dpeappjarmodels.dto.GenericResponse;
import pe.com.devinspirare.dpeappjarmodels.dto.UserDTO;
import pe.com.devinspirare.dpeappjarutils.EndPoint;
import pe.com.devinspirare.dpeappmsusuario.service.UserService;

import java.util.List;

/**
 *
 * @apiNote Service Api RestFul with microservice user.
 * @author Zeler Benji Villarreal Marcelo
 * @version 0.0.1
 * @since 01/01/2018
 *
 */
@RestController
@RequestMapping(value = EndPoint.API_USER)
@Api(value = " /user", description = "Api Restful Microservice User", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController{

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    UserDTO getUser(@PathVariable("id") String id){
        return this.userService.getUser(Long.valueOf(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    List<UserDTO> getAll(){
        return this.userService.getAllUsers();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    UserDTO newUser(@RequestBody UserDTO userDTO){
        return this.userService.newUser(userDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    GenericResponse updateUser(@RequestBody UserDTO userDTO){
        return this.userService.updateUser(userDTO);
    }

    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    GenericResponse deleteUser(@PathVariable("id") String id){
       return this.userService.deleteUser(Long.valueOf(id));
    }

}
