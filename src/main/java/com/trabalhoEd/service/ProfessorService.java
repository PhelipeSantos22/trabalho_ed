package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Professor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService {
    private final String filePath = "src/main/resources/csv/professor.csv";

    // Método para inserir um professor no arquivo CSV
    public boolean inserir(Professor professor) {
        if (consultarPorCpf(professor.getCpf()) != null) {
            return false; // Retorna false se o CPF já estiver cadastrado
        }

        boolean arquivoExiste = new File(filePath).exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            // Escrever o cabeçalho se o arquivo ainda não existir
            if (!arquivoExiste) {
                writer.write("cpf,nome,área,pontos");
                writer.newLine();
            }
            writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
            writer.newLine();
            return true; // Retorna true se o professor for inserido com sucesso
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método para consultar todos os professores
    public List<Professor> consultar() {
        List<Professor> professores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Ignora o cabeçalho
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                if (dados.length == 4) { // Verificar se a linha tem o número correto de colunas
                    professores.add(new Professor(dados[0], dados[1], dados[2], Integer.parseInt(dados[3])));
                } else {
                    System.err.println("Linha inválida: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return professores;
    }

    // Método para consultar professor por CPF
    public Professor consultarPorCpf(String cpf) {
        List<Professor> professores = consultar();
        for (Professor professor : professores) {
            if (professor.getCpf().equals(cpf)) {
                return professor; // Retorna o professor correspondente
            }
        }
        return null; // Retorna null se não encontrar o professor
    }

    // Método para atualizar um professor
    public boolean atualizar(Professor professorAtualizado) {
        List<Professor> professores = consultar();
        boolean encontrado = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Reescreve o cabeçalho
            writer.write("cpf,nome,área,pontos");
            writer.newLine();
            for (Professor professor : professores) {
                if (professor.getCpf().equals(professorAtualizado.getCpf())) {
                    // Atualiza o professor correspondente
                    writer.write(professorAtualizado.getCpf() + "," + professorAtualizado.getNome() + "," +
                            professorAtualizado.getArea() + "," + professorAtualizado.getPontos());
                    encontrado = true;
                } else {
                    // Mantém os outros professores
                    writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encontrado; // Retorna true se o professor foi encontrado e atualizado
    }

    // Método para remover um professor
    public boolean remover(String cpf) {
        List<Professor> professores = consultar();
        boolean encontrado = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Reescreve o cabeçalho
            writer.write("cpf,nome,área,pontos");
            writer.newLine();
            for (Professor professor : professores) {
                if (!professor.getCpf().equals(cpf)) {
                    // Mantém os professores que não têm o CPF indicado
                    writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
                } else {
                    encontrado = true; // Marca que o professor foi encontrado e removido
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encontrado; // Retorna true se o professor foi encontrado e removido
    }
}
