package com.example.crudOperations.service;

import com.example.crudOperations.Repository.UserRepository;
import com.example.crudOperations.entity.UserEntity;
import com.example.crudOperations.pojo.UserListDTO;
import com.example.crudOperations.pojo.UserSaveDTO;
import com.example.crudOperations.pojo.UserUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {
        UserEntity user = new UserEntity(
                userSaveDTO.getUserName(),
                userSaveDTO.getEmail()
        );
        userRepository.save(user);
        System.out.println("User Added: " + user.getUserName());
        return user.getUserName();
    }

    @Override
    public List<UserListDTO> getAll() {
        List<UserEntity> list = userRepository.findAll();
        List<UserListDTO> inputDto = new ArrayList<>();
        for (UserEntity user : list) {
            UserListDTO dto = new UserListDTO(
                    user.getId(),
                    user.getUserName(),
                    user.getEmail()
            );
            inputDto.add(dto);
        }
        return inputDto;
    }

    @Override
    public List<UserListDTO> getById(int id) {
        Optional<UserEntity> list = userRepository.findById(id);
        UserListDTO dto = new UserListDTO();
        if (list.isPresent()) {
            dto.setId(list.get().getId());
            dto.setEmail(list.get().getEmail());
            dto.setUserName(list.get().getUserName());
            return Collections.singletonList(dto);
        } else {
            return Collections.emptyList();
        }
    }

    @Override
    public String update(UserUpdateDTO dto) {
        if (userRepository.existsById(dto.getId())) {
            UserEntity user = userRepository.getById(dto.getId());
            user.setUserName(dto.getUserName());
            user.setEmail(dto.getEmail());
            userRepository.save(user);
            return "Updated Successfully";
        } else {
            System.out.println("User Id not found!!" + dto.getId());
            return "User Id not found!!" + dto.getId();
        }

    }

    @Override
    public Boolean delete(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
            System.out.println("User Id not found!!" + id);
            return false;
        }
    }
}