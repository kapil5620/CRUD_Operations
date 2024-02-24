package com.example.crudOperations.service;

import com.example.crudOperations.pojo.UserListDTO;
import com.example.crudOperations.pojo.UserSaveDTO;
import com.example.crudOperations.pojo.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserListDTO> getAll();

    List<UserListDTO> getById(int id);

    String update(UserUpdateDTO dto);

    Boolean delete(int id);
}
