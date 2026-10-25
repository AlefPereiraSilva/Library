package br.com.library.model;

public abstract class ItemBiblioteca {
    private final int codigo;
    private final String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
        if(codigo <= 0) {
            throw new IllegalArgumentException("Código inválido");
        }
        if(titulo == null || titulo.isBlank()) {
            throw new IllegalArgumentException("Título não pode estar em branco");
        }
        this.codigo = codigo;
        this.titulo = titulo;
        this.disponivel = true;
    }

    public abstract int calcularPrazo();
    public abstract double calcularMulta(int diasAtraso);

    public int getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public boolean isDisponivel() {
        return disponivel;
    }

    public void registrarEmprestimo() {
    if(!this.disponivel) {
        throw new IllegalStateException("Erro: O item já está emprestado!");
        }
    this.disponivel = false;
    }

    public void registrarDevolucao() {
    if(this.disponivel) {
        throw new IllegalStateException("Mensagem: O item já está novamente disponível no acervo!");
        }
    this.disponivel = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] Código: %d | Título: %s | Status: %s", this.getClass().getSimpleName(), codigo, titulo, (disponivel ? "Disponivel" : "Emprestado"));
    }
}
