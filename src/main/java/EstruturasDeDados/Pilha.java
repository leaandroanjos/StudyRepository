package EstruturasDeDados;

import java.util.EmptyStackException;
import java.util.Stack;

public class Pilha {

    private int size;

    private int topo;

    private int[] vetor;

    public Pilha(int n){
        this.size = n;
        this.topo = -1;
        this.vetor = new int[n];
    }

    public void push(int value){
        if(this.topo == this.size-1)
            throw new StackOverflowError("Pilha cheia!");
        this.vetor[++this.topo] = value;
    }

    public int top(){
        if(this.topo == -1)
            throw new EmptyStackException();
        return this.vetor[this.topo];
    }

    public int pop(){
        if(this.topo == -1)
            throw new EmptyStackException();
        return this.vetor[this.topo--];
    }

    public boolean isEmpty(){
        return this.topo == -1;
    }
}
