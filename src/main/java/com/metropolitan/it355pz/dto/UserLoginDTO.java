package com.metropolitan.it355pz.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {

    @JsonProperty("username")
    private String username = null;

    @JsonProperty("password")
    private String password = null;

}
