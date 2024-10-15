package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Inscricao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InscricaoService {
    private final String filePath = "src/main/resources/csv/inscricoes.csv";

    public void inserir(Inscricao inscricao) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(inscricao.getCpf() + "," + inscricao.getCodigoDisciplina() + "," + inscricao.getCodigoProcesso());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Inscricao> consultar() {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Ignora o cabeçalho
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                inscricoes.add(new Inscricao(dados[0], dados[1], dados[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inscricoes;
    }

    public void atualizar(Inscricao inscricaoAtualizada) {
        List<Inscricao> inscricoes = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("cpf,codigo_disciplina,codigo_processo");
            writer.newLine();
            for (Inscricao inscricao : inscricoes) {
                if (inscricao.getCpf().equals(inscricaoAtualizada.getCpf()) &&
                        inscricao.getCodigoDisciplina().equals(inscricaoAtualizada.getCodigoDisciplina())) {
                    writer.write(inscricaoAtualizada.getCpf() + "," + inscricaoAtualizada.getCodigoDisciplina() + "," + inscricaoAtualizada.getCodigoProcesso());
                } else {
                    writer.write(inscricao.getCpf() + "," + inscricao.getCodigoDisciplina() + "," + inscricao.getCodigoProcesso());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String cpf, String codigoDisciplina) {
        List<Inscricao> inscricoes = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("cpf,codigo_disciplina,codigo_processo");
            writer.newLine();
            for (Inscricao inscricao : inscricoes) {
                if (!(inscricao.getCpf().equals(cpf) && inscricao.getCodigoDisciplina().equals(codigoDisciplina))) {
                    writer.write(inscricao.getCpf() + "," + inscricao.getCodigoDisciplina() + "," + inscricao.getCodigoProcesso());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
