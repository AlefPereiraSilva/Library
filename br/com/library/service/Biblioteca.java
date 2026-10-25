package br.com.library.service;

import br.com.library.model.ItemBiblioteca;
import br.com.library.model.Usuario;

public class Biblioteca {
    private final ItemBiblioteca[] acervo;
    private int totalItens;

    public Biblioteca(int capacidade) {
        this.acervo = new ItemBiblioteca[capacidade];
        this.totalItens = 0;
    }

    public void adicionarItem(ItemBiblioteca item) {
        if(item == null) {
            System.out.println("Erro: Item inválido não pode ser adicionado!");
            return;
        }
        if(item.getTitulo() == null || item.getTitulo().isBlank()) {
            System.out.println("Erro: Titulo não pode estar em branco!");
            return;
        }
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

    public ItemBiblioteca buscarItemPorCodigo(int codigo) {
        for(int i = 0; i < totalItens; i++) {
            if(acervo[i].getCodigo() == codigo) {
                return acervo[i];
            }
        }
        return null;
    }

    public boolean emprestarItem(int codigo, Usuario usuario) {
        if(usuario == null) {
            System.out.println("Erro: Usuario inválido");
            return false;
        }

        ItemBiblioteca itemEncontrado = buscarItemPorCodigo(codigo);
        if(itemEncontrado == null) {
            System.out.println("Erro: Item com código " + codigo + " não foi encontrado.");
            return false;
        }

        System.out.println("[" + usuario.getNome() + "] Tentando emprestar: " + itemEncontrado.getTitulo() + " (cod " + codigo + ")...");

        if(itemEncontrado.isDisponivel() && usuario.podeEmprestar()) {
            itemEncontrado.registrarEmprestimo();
            usuario.incrementarEmprestimo();

            String tipoItem = itemEncontrado.getClass().getSimpleName();
            System.out.println("Empréstimo efetuado com sucesso! " + tipoItem + ": " + itemEncontrado.getTitulo() + " - Prazo para devolução: " + itemEncontrado.calcularPrazo() + " dias.");
            return true;
        } else {
            System.out.println("Erro: Item indisponível ou Usuário estourou o limite de empréstimo.");
            return false;
        }
    }

    public void devolverItem(int codigo, Usuario usuario, int diasAtraso) {
        if(diasAtraso < 0){
            System.out.println("Erro: dias de Atraso não pode ser negativo!");
            return;
        }
        if(usuario == null) {
            System.out.println("Erro: Usuario inválido");
            return;
        }

        ItemBiblioteca itemEncontrado = buscarItemPorCodigo(codigo);
        if(itemEncontrado == null) {
            System.out.println("Erro: Item não encontrado.");
            return;
        }

        if(!itemEncontrado.isDisponivel()) {
            itemEncontrado.registrarDevolucao();
            usuario.decrementarEmprestimo();

            double multa = itemEncontrado.calcularMulta(diasAtraso);
            if(multa > 0) {
                System.out.printf("Devolução realizada com ATRASO! Multa aplicada: R$ %.2f\n", multa);
            } else {
                System.out.println("Devolução realizada dentro do prazo!");
            }
        } else {
            System.out.println("Erro: Este item já consta como disponível no sistema.");
        }
    }
}
