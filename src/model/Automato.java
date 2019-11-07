package model;

import java.util.Vector;

/**
 * Representação computacional de um autômato determinístico com pilha
 */
public class Automato {
    public Vector<Estado> estados;
    public Estado estadoAtual = null;
    public String pilha;
    public String alfabeto;

    /**
     * Construtor da Classe
     */
    public Automato() {
        this.estados = null;
        this.pilha = null;
        this.alfabeto = null;
    }

    /**
     * Cria um novo estado com o nome do parâmetro e adiciona no autômato
     * Obs.: Esta função não irá verificar se o estado já existe
     *
     * @param nome Nome do novo estado.
     */
    public void addEstado(String nome) {
        estados.add(new Estado(nome));
    }

    /**
     * Cria uma nova transição no estado em questão.
     * Obs.: Esta função não irá verificar se a transição já existe
     *
     * @param estado           Nome do estado
     * @param simbolo          Símbolo da transição
     * @param estadoResultante Nome do estado resultante
     */
    public void addTransicao(String estado, char simbolo, String estadoResultante) {
        for (int index = 0; index < estados.size(); index++) {
            if (estados.elementAt(index).nome == estado) {
                estados.elementAt(index).addTransicao(simbolo, estadoResultante);
            }
        }
    }

    /**
     * Muda o estado atual do autômato para o estado em questão
     *
     * @param nome Nome do estado para o qual ele deve mudar
     */
    public void mudarEstadoAtual(String nome) {
        for (int index = 0; index < estados.size(); index++) {
            if (estados.elementAt(index).nome.equals(nome)) {
                estadoAtual = estados.elementAt(index);
            }
        }

    }

    /**
     * Processa a palavra em questão e mostra se foi aceita ou rejeitada
     *
     * @param palavra Palavra que o autômato irá processar e validar
     */
    public void processarPalavra(String palavra) {
        this.mudarEstadoAtual("q0");
        String estado = null;

        for (int index = 0; index < palavra.length(); index++) {
            estado = estadoAtual.transitar(palavra.charAt(index), pilha);

            if (estado == null) {
                break;
            } else {
                mudarEstadoAtual(estado);
            }

        }

        if (estado == null || !estadoAtual.getFinal()) {
            System.out.println("Palavra rejeitada");
        } else {
            System.out.println("Palavra aceita");
        }


    }

}
