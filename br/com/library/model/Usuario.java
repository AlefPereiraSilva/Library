package br.com.library.model;

public abstract class Usuario {
    private String nome;
    private int quantidadeEmprestada;

    public Usuario(String nome) {
        this.nome = nome;
        this.quantidadeEmprestada = 0;
    }

    public abstract int obterLimiteItens();

    public boolean podeEmprestar() {
        return quantidadeEmprestada < obterLimiteItens();
    }

    public void incrementarEmprestimo() {
        this.quantidadeEmprestada++;
    }

    public void decrementarEmprestimo() {
        if(this.quantidadeEmprestada > 0) {
            this.quantidadeEmprestada--;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEmprestada() {
        return quantidadeEmprestada;
    }
}
