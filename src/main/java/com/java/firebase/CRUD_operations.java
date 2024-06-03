package com.java.firebase;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter

public class CRUD_operations {
    private String documentID;
    private String ID;
    private String Name;

    public String getName() {
        return Name;
    }

}
