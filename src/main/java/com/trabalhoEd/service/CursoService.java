package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Curso;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursoService {
    private final String filePath = "src/main/resources/csv/cursos.csv";

    public void inserir(Curso curso) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(curso.getCodigo() + "," + curso.getNome() + "," + curso.getAreaConhecimento());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Curso> consultar() {
        List<Curso> cursos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            reader.readLine(); // Ignora o cabeçalho
            while ((line = reader.readLine()) != null) {
                String[] dados = line.split(",");
                cursos.add(new Curso(dados[0], dados[1], dados[2]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    public void atualizar(Curso cursoAtualizado) {
        List<Curso> cursos = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("código,nome,área_conhecimento");
            writer.newLine();
            for (Curso curso : cursos) {
                if (curso.getCodigo().equals(cursoAtualizado.getCodigo())) {
                    writer.write(cursoAtualizado.getCodigo() + "," + cursoAtualizado.getNome() + "," + cursoAtualizado.getAreaConhecimento());
                } else {
                    writer.write(curso.getCodigo() + "," + curso.getNome() + "," + curso.getAreaConhecimento());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void remover(String codigo) {
        List<Curso> cursos = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("código,nome,área_conhecimento");
            writer.newLine();
            for (Curso curso : cursos) {
                if (!curso.getCodigo().equals(codigo)) {
                    writer.write(curso.getCodigo() + "," + curso.getNome() + "," + curso.getAreaConhecimento());
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
