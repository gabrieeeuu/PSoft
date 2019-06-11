package com.example.demo;

import java.time.LocalTime;

public class ServerTime {
    
    private String serverTime;
    
    public ServerTime (){
        this.serverTime = (LocalTime.now() + "").substring(0, 8);
    }

    public String getServerTime(){
        return this.serverTime;
    }
    
}