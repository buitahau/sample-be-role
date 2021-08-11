package com.haubui.sample.backendrole.web.rest.dto;

import java.io.Serializable;

public class RoleDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public RoleDto(){
    }

    public RoleDto(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
