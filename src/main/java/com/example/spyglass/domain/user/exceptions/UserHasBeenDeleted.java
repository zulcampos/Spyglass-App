package com.example.spyglass.domain.user.exceptions;

import com.example.spyglass.domain.user.models.User;

public class UserHasBeenDeleted extends Exception{
    public UserHasBeenDeleted(String message){super(message);}
}
