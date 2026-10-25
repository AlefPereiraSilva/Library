package br.com.library;

import br.com.library.model.*;
import br.com.library.service.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = getBiblioteca();

        Usuario aluna1 = new Aluno("Sofia Tads");
        Usuario aluno2 = new Aluno("Peter Parker");
        Usuario professor1 = new Professor("Jaques Antunes");
        Usuario professor2 = new Professor("Dr. Connor");

        biblioteca.listarAcervo();

        System.out.println("\n--- Testando Empréstimo ---");

        testarEmprestimo(biblioteca, 202, aluna1);
        testarEmprestimo(biblioteca, 201, aluno2);
        testarEmprestimo(biblioteca, 303, aluna1);
        testarEmprestimo(biblioteca, 101, professor2);
        testarEmprestimo(biblioteca, 102, professor1);
        testarEmprestimo(biblioteca, 202, aluno2);
        testarEmprestimo(biblioteca, 301, aluna1);
        testarEmprestimo(biblioteca, 302, aluna1);

        biblioteca.listarAcervo();

        System.out.println("\n--- Testando Devoluções ---");

        System.out.print("[" + aluna1.getNome() + "] ");
        biblioteca.devolverItem(202, aluna1, 20);

        System.out.print("[" + aluno2.getNome() + "] ");
        biblioteca.devolverItem(201, aluno2, 4);

        System.out.print("[" + professor2.getNome() + "] ");
        biblioteca.devolverItem(101, professor2, 3);

        System.out.print("[" + professor1.getNome() + "] ");
        biblioteca.devolverItem(102, professor1, 0);

        System.out.print("[" +aluna1.getNome() + "] ");
        biblioteca.devolverItem(303, aluna1, 10);

        biblioteca.listarAcervo();

    }

    private static void testarEmprestimo(Biblioteca biblioteca, int codigo, Usuario usuario) {
        if(biblioteca.emprestarItem(codigo, usuario)) {
            System.out.println("Empréstimo realizado com sucesso - " + usuario.getNome() + " tem " + usuario.getQuantidadeEmprestada() + " item(ns) em empréstimo");
        } else {
            System.out.println("Falha no empréstimo - " + usuario.getNome()  + " já está com limite de itens emprestados ou item está indisponível no momento");
        }
    }

    private static Biblioteca getBiblioteca() {
        Biblioteca biblioteca = new Biblioteca(50);

        ItemBiblioteca livro1 = new Livro(101, "Crônicas de Nárnia");
        ItemBiblioteca livro2 = new Livro(102, "O Senhor dos Anéis");
        ItemBiblioteca revista1 = new Revista(201, "Super Interessante");
        ItemBiblioteca revista2 = new Revista(202, "Ciência Hoje");
        ItemBiblioteca dvd1 = new DVD(301,"Homem-Aranha");
        ItemBiblioteca dvd2 = new DVD(302,"Viagem aos PLanetas e Além");
        ItemBiblioteca dvd3 = new DVD(303,"12 Macacos");

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(revista1);
        biblioteca.adicionarItem(revista2);
        biblioteca.adicionarItem(dvd1);
        biblioteca.adicionarItem(dvd2);
        biblioteca.adicionarItem(dvd3);
        return biblioteca;
    }
}
