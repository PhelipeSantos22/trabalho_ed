package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Inscricao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InscricaoService {
    private final String filePath = "src\\main\\resources\\csv\\inscricoes.csv";

    public void inserir(Inscricao inscricao) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.append(inscricao.getCpf()).append(",")
                    .append(inscricao.getCodigoDisciplina()).append(",")
                    .append(inscricao.getCodigoProcesso()).append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Inscricao> consultar() {
        List<Inscricao> inscricoes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                Inscricao inscricao = new Inscricao(partes[0], partes[1], partes[2]);
                inscricoes.add(inscricao);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inscricoes;
    }

    public void atualizar(Inscricao inscricao) {
        List<Inscricao> inscricoes = consultar();
        try (FileWriter writer = new FileWriter(filePath, false)) { // Sobrescreve o arquivo
            for (Inscricao i : inscricoes) {
                if (i.getCpf().equals(inscricao.getCpf())) {
                    writer.append(inscricao.getCpf()).append(",")
                            .append(inscricao.getCodigoDisciplina()).append(",")
                            .append(inscricao.getCodigoProcesso()).append("\n");
                } else {
                    writer.append(i.getCpf()).append(",")
                            .append(i.getCodigoDisciplina()).append(",")
                            .append(i.getCodigoProcesso()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String cpf) {
        List<Inscricao> inscricoes = consultar();
        try (FileWriter writer = new FileWriter(filePath, false)) { // Sobrescreve o arquivo
            for (Inscricao inscricao : inscricoes) {
                if (!inscricao.getCpf().equals(cpf)) {
                    writer.append(inscricao.getCpf()).append(",")
                            .append(inscricao.getCodigoDisciplina()).append(",")
                            .append(inscricao.getCodigoProcesso()).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
