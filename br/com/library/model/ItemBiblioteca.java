package br.com.library.model;

public abstract class ItemBiblioteca {
    private int codigo;
    private String titulo;
    private boolean disponivel;

    public ItemBiblioteca(int codigo, String titulo) {
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

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return String.format("[%s] Código: %d | Título: %s | Status: %s", this.getClass().getSimpleName(), codigo, titulo, (disponivel ? "Disponivel" : "Emprestado"));
    }
}
