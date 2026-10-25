package br.com.library.model;

public class Professor extends Usuario{
    public Professor(String nome) {
        super(nome);
    }

    @Override
    public int obterLimiteItens() {
        return 5;
    }
}
