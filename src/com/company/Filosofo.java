package com.company;

public class Filosofo extends Thread {
    private Garfo garfoDireita;
    private Garfo garfoEsquerda;
    private String nome;
    public Filosofo(Garfo garfoEsquerda, Garfo garfoDireita, String nome) {
        this.garfoEsquerda = garfoEsquerda;
        this.garfoDireita = garfoDireita;
        this.nome = nome;
    }
    public void eat() throws InterruptedException {
        if(garfoEsquerda.take()){
            System.out.println(nome + " pegou o garfo da esquerda");
            if( garfoDireita.take()){
                System.out.println(nome + " pegou o garfo da direita");
                System.out.println(nome + " comendo");
                Thread.sleep(((int) (Math.random() * 100)));
                garfoEsquerda.putDown();
                garfoDireita.putDown();
            } else {
                garfoEsquerda.putDown();
                System.out.println(nome + " soltou o garfo da esquerda");
                eat();
            }
        } else {
            System.out.println(nome + " pensando");
            eat();
        }

    }
    @Override
    public void run() {
        while (true) {
            try {
                eat();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
