package main.java.com.trabalhoEd.model;

public class Disciplina {
    private String codigo;
    private String nome;
    private String diaDaSemana;
    private String horarioInicial;
    private int horasDiarias;
    private String codigoCurso;

    public Disciplina(String codigo, String nome, String diaDaSemana, String horarioInicial, int horasDiarias, String codigoCurso) {
        this.codigo = codigo;
        this.nome = nome;
        this.diaDaSemana = diaDaSemana;
        this.horarioInicial = horarioInicial;
        this.horasDiarias = horasDiarias;
        this.codigoCurso = codigoCurso;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public int getHorasDiarias(){
        return horasDiarias;
    }

    public String getHorarioInicial(){
        return horarioInicial;
    }

    public String getDiaDaSemana(){
        return diaDaSemana;
    }

    public String getCodigoCurso(){
        return codigoCurso;
    }
}
