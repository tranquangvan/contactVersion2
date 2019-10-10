package com.example.contactversion2;
import java.io.Serializable;
public class Contact implements Serializable {
    private  int id;
    private  String name;
   private  String numberPhone;
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
}
