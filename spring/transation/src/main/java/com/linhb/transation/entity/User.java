package com.linhb.transation.entity;

import javax.persistence.*;

/**
 * @Author linhb
 * @Date 2020/6/9
 **/
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int guid;
    @Column
    private String name;

    public int getGuid() {
        return guid;
    }

    public void setGuid(int guid) {
        this.guid = guid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
