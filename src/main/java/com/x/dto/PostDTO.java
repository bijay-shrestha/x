package com.x.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class PostDTO implements Serializable {
    private String post;
}
