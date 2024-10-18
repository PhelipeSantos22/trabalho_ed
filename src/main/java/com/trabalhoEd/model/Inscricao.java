package main.java.com.trabalhoEd.model;

public class Inscricao {
    private String cpf;
    private String codigoDisciplina;
    private String codigoProcesso;

    public Inscricao(String cpf, String codigoDisciplina, String codigoProcesso) {
        this.cpf = cpf;
        this.codigoDisciplina = codigoDisciplina;
        this.codigoProcesso = codigoProcesso;
    }

    public String getCpf(){
        return cpf;
    }

    public String getCodigoDisciplina(){
        return codigoDisciplina;
    }

    public String getCodigoProcesso(){
        return codigoProcesso;
    }
}
