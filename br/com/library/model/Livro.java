package br.com.library.model;

public class Livro extends ItemBiblioteca{
    public Livro(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int calcularPrazo() {
        return 14;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        if(diasAtraso <= 0 ) return 0.0;
        return diasAtraso *0.50;
    }
}
