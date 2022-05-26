package com.example.py4jdemo.utils.operators;

public class PingPlayer {

    public String firstPing(PongPlayer player) {
        return player.firstPong(this);
    }

    public String secondPing(PongPlayer player) {
        return player.secondPong(this);
    }

}