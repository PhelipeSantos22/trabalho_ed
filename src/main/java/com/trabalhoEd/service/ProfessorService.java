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
            return false; // Não insere se o CPF já existir
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
            writer.newLine();
            return true; // Inserção bem-sucedida
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Falha na inserção
        }
    }

    // Método para consultar todos os professores
    public List<Professor> consultar() {
        List<Professor> professores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Ignora o cabeçalho
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                professores.add(new Professor(dados[0], dados[1], dados[2], Integer.parseInt(dados[3])));
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
                return professor;
            }
        }
        return null; // Professor não encontrado
    }

    // Método para atualizar um professor
    public boolean atualizar(Professor professorAtualizado) {
        List<Professor> professores = consultar();
        boolean encontrado = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("cpf,nome,área,pontos");
            writer.newLine();
            for (Professor professor : professores) {
                if (professor.getCpf().equals(professorAtualizado.getCpf())) {
                    writer.write(professorAtualizado.getCpf() + "," + professorAtualizado.getNome() + "," +
                            professorAtualizado.getArea() + "," + professorAtualizado.getPontos());
                    encontrado = true;
                } else {
                    writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encontrado; // Retorna verdadeiro se o professor foi encontrado e atualizado
    }

    // Método para remover um professor
    public boolean remover(String cpf) {
        List<Professor> professores = consultar();
        boolean encontrado = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("cpf,nome,área,pontos");
            writer.newLine();
            for (Professor professor : professores) {
                if (!professor.getCpf().equals(cpf)) {
                    writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
                } else {
                    encontrado = true; // Marcamos que o professor foi encontrado
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return encontrado; // Retorna verdadeiro se o professor foi encontrado e removido
    }
}
