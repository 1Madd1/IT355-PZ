package com.metropolitan.it355pz.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserInfoResponse {
    private Integer id;
    private String username;
    private String email;
    private List<String> roles;


}
