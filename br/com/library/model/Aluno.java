package br.com.library.model;

public class Aluno extends Usuario{
    public Aluno(String nome) {
        super(nome);
    }

    @Override
    public int obterLimiteItens() {
        return 3;
    }
}
