package br.com.library.model;

public class DVD extends ItemBiblioteca{
    public DVD(int codigo, String titulo) {
        super(codigo, titulo);
    }

    @Override
    public int calcularPrazo() {
        return 3;
    }

    @Override
    public double calcularMulta(int diasAtraso) {
        if(diasAtraso <= 0) return 0.0;
        return diasAtraso * 2.50;
    }
}
