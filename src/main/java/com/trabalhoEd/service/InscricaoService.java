package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Inscricao;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class InscricaoService {
    private final String filePath = "src/main/resources/csv/inscricoes.csv";

    public void inserir(Inscricao inscricao) {
        boolean arquivoExiste = new File(filePath).exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (!arquivoExiste) {
                writer.write("cpf,codigo_disciplina,codigo_processo");
                writer.newLine();
            }
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

            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 3) { // Verificar se a linha tem o número correto de colunas
                    inscricoes.add(new Inscricao(partes[0], partes[1], partes[2]));
                } else {
                    System.err.println("Linha inválida: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inscricoes;
    }

    public void atualizar(Inscricao inscricaoAtualizada) {
        List<Inscricao> inscricoes = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Reescrever o cabeçalho
            writer.write("cpf,codigo_disciplina,codigo_processo");
            writer.newLine();
            for (Inscricao inscricao : inscricoes) {
                if (inscricao.getCpf().equals(inscricaoAtualizada.getCpf())) {
                    writer.write(inscricaoAtualizada.getCpf() + "," + inscricaoAtualizada.getCodigoDisciplina() + "," +
                            inscricaoAtualizada.getCodigoProcesso());
                } else {
                    writer.write(inscricao.getCpf() + "," + inscricao.getCodigoDisciplina() + "," + inscricao.getCodigoProcesso());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String cpf) {
        List<Inscricao> inscricoes = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Reescrever o cabeçalho
            writer.write("cpf,codigo_disciplina,codigo_processo");
            writer.newLine();
            for (Inscricao inscricao : inscricoes) {
                if (!inscricao.getCpf().equals(cpf)) {
                    writer.write(inscricao.getCpf() + "," + inscricao.getCodigoDisciplina() + "," + inscricao.getCodigoProcesso());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
