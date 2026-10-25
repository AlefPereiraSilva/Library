package br.com.library.model;

public class Revista extends ItemBiblioteca{
    public Revista(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int calcularPrazo() {
        return 7;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        if(diasAtraso <= 0) return 0.0;
        return diasAtraso * 1.00;
    }
}
