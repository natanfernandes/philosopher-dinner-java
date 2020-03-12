package com.company;

public class Main {

    public static void main(String[] args) {
        Filosofo[] filosofos = new Filosofo[5];
        Garfo[] garfos = new Garfo[filosofos.length];

        for (int i = 0; i < garfos.length; i++){
            garfos[i] = new Garfo();
        }

        for(int i = 0; i < filosofos.length; i++){
                filosofos[i] = new Filosofo(garfos[i], garfos[(i + 1)% filosofos.length], "Filofo " + i);
                filosofos[i].start();
        }
    }
}
