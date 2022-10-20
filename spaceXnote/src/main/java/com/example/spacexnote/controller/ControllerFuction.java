package com.example.spacexnote.controller;

import com.example.spacexnote.security.UserDetailsImpl;


public class ControllerFuction {
static void membercheck(UserDetailsImpl userDetails){
    if (userDetails == null){
       throw new IllegalArgumentException("너는 누구냐");
    }
}
}

