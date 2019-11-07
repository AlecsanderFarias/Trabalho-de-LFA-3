package model;

import java.util.Vector;

/**
 * Representação de um estado do autômato
 */
public class Estado {

    public Vector<Transicao> transicoes;
    public String nome;
    public boolean Inicial;
    public boolean Final;

    /**
     * Construtor da Classe
     *
     * @param nome Nome do estado
     */
    public Estado(String nome) {
        this.nome = nome;
        this.transicoes = null;
        this.Inicial = false;
        this.Final = false;
    }

    /**
     * Adiciona uma transição com o símbolo e o estado resultante
     *
     * @param simbolo          Símbolo da transição
     * @param estadoResultante Estado resultante
     */
    public void addTransicao(char simbolo, String estadoResultante) {
        transicoes.add(new Transicao(simbolo, estadoResultante));
    }

    /**
     * Marca o estado como inicial
     */
    public void setInicial() {
        this.Inicial = true;
    }

    /**
     * Marca o estado como final
     */
    public void setFinal() {
        this.Final = true;
    }

    /**
     * Retorna se o estado é um estado final ou não
     *
     * @return Verdadeiro ou Falso para Estado Final
     */
    public boolean getFinal() {
        return this.Final;
    }

    /**
     * Processa o símbolo para dizer se é válido ou não
     * Obs.: Essa função já trata a pilha (adiciona e retira quando necessário)
     *
     * @param simbolo Símbolo a ser processado pelo estado
     * @param pilha   Pilha do Autômato
     * @return Se for válido retorna o nome do estado para qual irá transitar, se for inválido retornará "null"
     */
    public String transitar(char simbolo, String pilha) {

        //Verificar o vetor de transições procurando por uma transição com o símbolo requisitado
        for (int index = 0; index < transicoes.size(); index++) {
            //Se a transição com o símbolo requisitado for válido, Pare.
            if (transicoes.elementAt(index).ehValida(simbolo, pilha.charAt(pilha.length()))) {
                //Verificar se há símbolo a ser retirado na pilha. Caso houver, remover o último símbolo da pilha
                if (transicoes.elementAt(index).simboloRemoverPilha != '@') {
                    pilha = pilha.substring(0, pilha.length() - 1);
                }

                //Verificar se há um símbolo a ser adicionado na pilha. Caso hover, adicionar símbolo na pilha
                if (transicoes.elementAt(index).simboloAddPilha != '@') {
                    pilha = pilha + transicoes.elementAt(index).simboloAddPilha;
                }
                return transicoes.elementAt(index).getEstado();
            }
        }
        return null;
    }
}





