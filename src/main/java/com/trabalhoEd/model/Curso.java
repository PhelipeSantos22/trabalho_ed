package main.java.com.trabalhoEd.model;

public class Curso {
    private String codigo;
    private String nome;
    private String areaConhecimento;

    public Curso(String codigo, String nome, String areaConhecimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.areaConhecimento = areaConhecimento;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public String getAreaConhecimento(){
        return areaConhecimento;
    }
}
