package me.moteloff.realisticexplosion.utils;

public class Random {
    public int random(int min, int max){
        return (int) (Math.random()*((max-min)+1))+min;
    }

    public int random(int max){
        return (int) (Math.random()*((max)+1));
    }

    public double random(double min, double max){
        return (Math.random() * (max - min)) + min;
    }

    public double random(double max){
        return (Math.random()*((max)));
    }
}
