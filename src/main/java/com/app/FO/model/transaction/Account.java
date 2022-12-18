package com.app.FO.model.transaction;

import com.app.FO.model.user.User;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Account {
    
    private String Name;

    private User creater;

    private List<User> usersSharing;

    private List<Transaction> transactions;
}
