package main.java.com.trabalhoEd.model;

public class Professor {
    private String cpf;
    private String nome;
    private String area;
    private int pontos;

    // Construtor
    public Professor(String cpf, String nome, String area, int pontos) {
        this.cpf = cpf;
        this.nome = nome;
        this.area = area;
        this.pontos = pontos;
    }

    public String getCpf(){
        return cpf;
    }

    public String getNome(){
        return nome;
    }

    public String getArea(){
        return area;
    }

    public int getPontos(){
        return pontos;
    }

    // Getters e Setters
}
