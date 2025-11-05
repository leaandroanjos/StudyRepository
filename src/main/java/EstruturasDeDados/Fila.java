package EstruturasDeDados;

/*
* Implementação clássica de Fila, com alocação dinamica de memória
* */

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Fila<G> {
    private Node<G> inicio;
    private int size;

    public Fila(){
        this.inicio = null;
        this.size = 0;
    }

    public Fila(G item){
        this.inicio = new Node<G>(item);
        this.size = 1;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public int getSize(){
        return this.size;
    }

    public G get(G valor){
        Node<G> atual = this.inicio;
        while (atual != null) {
            if (atual.getValue().equals(valor))
                return atual.getValue();
            atual = atual.getNext();
        }
        throw new NoSuchElementException();
    }

    public void push(G item){
        Node<G> atual = this.inicio;
        this.size++;
        if(atual == null){
            this.inicio = new Node<>(item);
            return;
        }
        while (atual.getNext() != null){
            atual = atual.getNext();
        }
        atual.setNext(new Node<>(item));
    }

    public G pop(){
        if(this.size == 0){
            throw new EmptyStackException();
        }
        size--;
        Node<G> atual = this.inicio;
        this.inicio = atual.getNext();
        return atual.getValue();
    }
}

class Node<G> {

    private G value;

    private Node<G> next;

    protected Node(G value){
        this.value = value;
        this.next = null;
    }

    protected void setNext(Node<G> node){
        this.next = node;
    }

    protected Node<G> getNext(){
        return next;
    }

    protected G getValue(){
        return value;
    }
}
