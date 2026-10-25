package br.com.library.service;

import br.com.library.model.ItemBiblioteca;
import br.com.library.model.Usuario;

public class Biblioteca {
    private ItemBiblioteca[] acervo;
    private int totalItens;

    public Biblioteca(int capacidade) {
        this.acervo = new ItemBiblioteca[capacidade];
        this.totalItens = 0;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if(totalItens < acervo.length) {
            acervo[totalItens] = item;
            totalItens++;
        } else {
            System.out.println("Erro: Acervo da biblioteca cheio");
        }
    }

    public void listarAcervo() {
        System.out.println("\n-- ACERVO DA BIBLIOTECA --");
        for(int i = 0; i < totalItens; i++) {
            System.out.println(acervo[i].toString());
        }
    }

    public boolean emprestarItem(int codigo, Usuario usuario) {
        for(int i = 0; i < totalItens; i++) {
            if(acervo[i].getCodigo() == codigo) {
                if(acervo[i].isDisponivel() && usuario.podeEmprestar()) {
                    acervo[i].setDisponivel(false);
                    usuario.incrementarEmprestimo();
                    System.out.println("Empréstimo efetuado com sucesso! Prazo para devolução: " + acervo[i].calcularPrazo() + " dias.");
                    return true;
                }
                System.out.println("Erro: Item indisponível ou Usuário estourou o limite de empréstimo.");
                return false;
            }
        }
        System.out.println("Erro: Item com código " + codigo + "não foi encontrado.");
        return false;
    }

    public void devolverItem(int codigo, Usuario usuario, int diasAtraso) {
        for(int i = 0; i < totalItens; i++) {
            if(acervo[i].getCodigo() == codigo) {
                if(!acervo[i].isDisponivel()) {
                    acervo[i].setDisponivel(true);
                    usuario.decrementarEmprestimo();

                    double multa = acervo[i].calcularMulta(diasAtraso);
                    if(multa > 0) {
                        System.out.printf("Devolução realizada com ATRASO! Multa aplicada: R$ %.2f\n", multa);
                    } else {
                        System.out.println("Devolução realizada dentro do prazo!");
                    }
                    return;
                }
                System.out.println("Erro: Este item já consta como disponível no sistema.");
                return;
            }
        }
        System.out.println("Erro: Item não encontrado.");
    }
}
