package main.java.com.trabalhoEd.ui.disciplinaUI;

import main.java.com.trabalhoEd.ui.cursosUI.CursoAtualizarUI;
import main.java.com.trabalhoEd.ui.cursosUI.CursoConsultarUI;
import main.java.com.trabalhoEd.ui.cursosUI.CursoInserirUI;
import main.java.com.trabalhoEd.ui.cursosUI.CursoRemoverUI;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisciplinaMenuUI extends JFrame{
    public DisciplinaMenuUI() {
        setTitle("Menu Disciplinas");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        JButton inserirButton = new JButton("Inserir Disciplina");
        inserirButton.setBounds(50, 30, 200, 30);
        add(inserirButton);

        JButton consultarButton = new JButton("Consultar Disciplina");
        consultarButton.setBounds(50, 70, 200, 30);
        add(consultarButton);

        JButton atualizarButton = new JButton("Atualizar Disciplina");
        atualizarButton.setBounds(50, 110, 200, 30);
        add(atualizarButton);

        JButton removerButton = new JButton("Remover Disciplina");
        removerButton.setBounds(50, 150, 200, 30);
        add(removerButton);

        inserirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisciplinaInserirUI();
            }
        });

        atualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisciplinaAtualizarUI();
            }
        });

        removerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisciplinaRemoverUI();
            }
        });

        consultarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DisciplinaConsultarUI();
            }
        });
        setVisible(true);
    }
}