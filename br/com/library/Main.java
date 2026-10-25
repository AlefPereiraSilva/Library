package br.com.library;

import br.com.library.model.*;
import br.com.library.service.Biblioteca;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(50);

        ItemBiblioteca livro1 = new Livro(101, "Crônicas de Nárnia");
        ItemBiblioteca livro2 = new Livro(102, "O Senhor dos Anéis");
        ItemBiblioteca revista1 = new Revista(201, "Super Interessante");
        ItemBiblioteca revista2 = new Revista(202, "Ciência Hoje");

        biblioteca.adicionarItem(livro1);
        biblioteca.adicionarItem(livro2);
        biblioteca.adicionarItem(revista1);
        biblioteca.adicionarItem(revista2);

        Usuario aluna1 = new Aluno("Sofia Tads");
        Usuario aluno2 = new Aluno("Peter Parker");
        Usuario professor1 = new Professor("Jaques Antunes");
        Usuario professor2 = new Professor("Dr. Connor");

        biblioteca.listarAcervo();

        System.out.println("\n--- Testando Empréstimo ---");

        biblioteca.emprestarItem(202,aluna1);
        biblioteca.emprestarItem(201, aluno2);
        biblioteca.emprestarItem(101,professor2);
        biblioteca.emprestarItem(102, professor1);

        biblioteca.listarAcervo();

        System.out.println("\n--- Testando Devoluções ---");

        System.out.print("[" + aluna1.getNome() + "] ");
        biblioteca.devolverItem(202, aluna1, 20);

        System.out.print("[" + aluno2.getNome() + "] ");
        biblioteca.devolverItem(201, aluno2, 4);

        System.out.print("[" + professor1.getNome() + "] ");
        biblioteca.devolverItem(101, professor1, 0);

        System.out.print("[" + professor2.getNome() + "] ");
        biblioteca.devolverItem(102, professor2, 3);




    }
}
