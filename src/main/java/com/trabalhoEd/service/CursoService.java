package main.java.com.trabalhoEd.service;

import main.java.com.trabalhoEd.model.Curso;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CursoService {
    private final String filePath = "src/main/resources/csv/cursos.csv";

    public void inserir(Curso curso) {
        boolean arquivoExiste = new File(filePath).exists();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            if (!arquivoExiste) {
                writer.write("codigo,nome,area_conhecimento");
                writer.newLine();
            }
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
            reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] partes = line.split(",");
                if (partes.length == 3) {
                    cursos.add(new Curso(partes[0], partes[1], partes[2]));
                } else {
                    System.err.println("Linha inválida: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cursos;
    }

    public void atualizar(Curso cursoAtualizado) {
        List<Curso> cursos = consultar();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // Reescrever o cabeçalho
            writer.write("codigo,nome,area_conhecimento");
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
            writer.write("codigo,nome,area_conhecimento");
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
