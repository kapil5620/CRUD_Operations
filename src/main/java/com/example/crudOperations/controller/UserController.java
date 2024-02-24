package com.example.crudOperations.controller;

import com.example.crudOperations.pojo.UserInputDTO;
import com.example.crudOperations.pojo.UserListDTO;
import com.example.crudOperations.pojo.UserSaveDTO;
import com.example.crudOperations.pojo.UserUpdateDTO;
import com.example.crudOperations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usercontroller")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping(path = "/adduser")
    public String addUser(@RequestBody UserSaveDTO userSaveDTO) {
        return service.addUser(userSaveDTO);
    }

    @GetMapping(path = "/getAllUsers")
    public List<UserListDTO> getAllUsers() {
        List<UserListDTO> list = service.getAll();
        System.out.println("List: \n" + list);
        return list;
    }

    @GetMapping(path = "/getUserById/{id}")
    public List<UserListDTO> getUserById(@PathVariable(value = "id") int id) {
        List<UserListDTO> list = service.getById(id);
        System.out.println("List: \n" + list);
        return list;
    }

    @PutMapping(path = "/updateUser")
    public String updateUser(@RequestBody UserUpdateDTO dto) {
        return service.update(dto);
    }

    @DeleteMapping(path = "/deleteUser/{id}")
    public Boolean deleteUser(@PathVariable(value = "id") int id) {
        return service.delete(id);
    }
}