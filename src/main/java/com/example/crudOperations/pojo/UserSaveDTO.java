package com.example.crudOperations.pojo;

public class UserSaveDTO {
    private String userName;
    private String email;

    public UserSaveDTO(String userName, String email) {
        this.userName = userName;
        this.email = email;
    }

    public UserSaveDTO() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserSaveDTO{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
