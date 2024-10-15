package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Professor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorService {
    private final String filePath = "src/main/resources/csv/professor.csv";

    public void inserir(Professor professor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Professor> consultar() {
        List<Professor> professores = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Ignora o cabeçalho
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                professores.add(new Professor(dados[0], dados[1], dados[2], Integer.parseInt(dados[3])));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return professores;
    }

    public void atualizar(Professor professorAtualizado) {
        List<Professor> professores = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("cpf,nome,área,pontos");
            writer.newLine();
            for (Professor professor : professores) {
                if (professor.getCpf().equals(professorAtualizado.getCpf())) {
                    writer.write(professorAtualizado.getCpf() + "," + professorAtualizado.getNome() + "," +
                            professorAtualizado.getArea() + "," + professorAtualizado.getPontos());
                } else {
                    writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String cpf) {
        List<Professor> professores = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("cpf,nome,área,pontos");
            writer.newLine();
            for (Professor professor : professores) {
                if (!professor.getCpf().equals(cpf)) {
                    writer.write(professor.getCpf() + "," + professor.getNome() + "," + professor.getArea() + "," + professor.getPontos());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}