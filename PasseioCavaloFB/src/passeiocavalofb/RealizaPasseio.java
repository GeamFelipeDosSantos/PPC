package passeiocavalofb;

import model.Tabuleiro;

/**
 *
 * @author Geam
 */
public class RealizaPasseio {

    static int teste = 0;
    static boolean sucesso = false;
    int horizontal[] = {2, 1, -1, -2, -2, -1, 1, 2};//int horizontal[Size + 1] = {0,2,1,-1,-2,-2,-1,1,2};
    int vertical[] = {- 1, -2, -2, -1, 1, 2, 2, 1};//int vertical[Size+ 1] = {0,1,2,2,1,-1,-2,-2,-1};
    int tabuleiro[][] = {
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0}
    };//int h[Size + 1][Size + 1];
    //int n;
    int[][] matrizAcessibilidade = {
        {2, 3, 4, 4, 4, 4, 3, 2},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {4, 6, 8, 8, 8, 8, 6, 4},
        {3, 4, 6, 6, 6, 6, 4, 3},
        {2, 3, 4, 4, 4, 4, 3, 2}
    };
    int linhaAtual, colunaAtual, jogada, /*maxTab, minTab,*/ linhaAcessibilidade, colunaAcessibilidade;

//----------------------------------------
    public void imprimirTabuleiro() {

        for (int i = 0; i < Tabuleiro.DIMENSAO_TABULEIRO; i++) {
            for (int j = 0; j < Tabuleiro.DIMENSAO_TABULEIRO; j++) {
                // System.out.println(tabuleiro[i][j]);
                if (tabuleiro[i][j] < 10) {
                    System.out.print(" ");
                }
                System.out.print(" ");
                System.out.print(tabuleiro[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
//----------------------------------------

    public void tentarProximoMovimento(int i, int horizontalP, int verticalP) {
        int u, v, k;
        //System.out.println(teste++);
        k = 0;
        sucesso = false;
        do {

            System.out.println("===========================================");
            imprimirTabuleiro();

            u = horizontalP + horizontal[k];
            v = verticalP + vertical[k];

            if (0 < horizontalP && horizontalP < Tabuleiro.DIMENSAO_TABULEIRO
                    && 0 < verticalP && verticalP < Tabuleiro.DIMENSAO_TABULEIRO
                    && tabuleiro[horizontalP][verticalP] == 0
                    //&& analisarPreenchimentoBordas(horizontalP,verticalP)
                    ) {

                tabuleiro[horizontalP][verticalP] = i;

                if (i < Tabuleiro.DIMENSAO_TABULEIRO * Tabuleiro.DIMENSAO_TABULEIRO) {
                    tentarProximoMovimento(i + 1, u, v);
                    if (!sucesso) {
                        tabuleiro[horizontalP][verticalP] = 0;
                    }
                } else {
                    sucesso = true;
                }
            }
            k++;
           
        } while (!sucesso && k < Tabuleiro.DIMENSAO_TABULEIRO);

    }

    void executar() {
        int i, j;

        System.out.println("Tamanho do tabuleiro (1-8): ");
        //n = 8;//cin >> n;
        /*for (i = 0; i < Tabuleiro.DIMENSAO_TABULEIRO; i++) {
            for (j = 0; j < Tabuleiro.DIMENSAO_TABULEIRO; j++) {
                tabuleiro[i][j] = 0;
            }
        }*/
        System.out.println("Posicao inicial do cavalo (x,y): ");
        //i = 5;
        //j = 5;

        //tabuleiro[7][7] = 1;
        tentarProximoMovimento(1, 5, 1);
        if (sucesso) {
            imprimirTabuleiro();
        } else {
            System.out.println("Caminho nao encontrado");
        }

    }

    public final static boolean analisarColuna(int colunaAtual, int movimentoVertical) {
        if ((colunaAtual + movimentoVertical < 0) || (colunaAtual + movimentoVertical > (Tabuleiro.DIMENSAO_TABULEIRO - 1))) {
            return false;
        }
        return true;
    }

    public final static boolean analisarLinha(int linhaAtual, int movimentoHorizontal) {
        if ((linhaAtual + movimentoHorizontal < 0) || (linhaAtual + movimentoHorizontal > (Tabuleiro.DIMENSAO_TABULEIRO - 1))) {
            return false;
        }
        return true;
    }

    public boolean analisarPreenchimentoBordas(int linha,int coluna) {

        System.out.println("Verificar se bordas foram preenchidas.");
        imprimirTabuleiro();

        for (int i = 0; i < Tabuleiro.DIMENSAO_TABULEIRO; i++) {
            for (int j = 0; j < Tabuleiro.DIMENSAO_TABULEIRO; j++) {

                //Se linha for 0,1,6 ou 7
                //e coluna for 0,1,6 ou 7
                if ((i <= 1 || i >= 6) || (j <= 1 || j >= 6)) {
                    if (tabuleiro[i][j] == 0) {
                        System.out.println(false);
                        return false;
                    }
                }
            }
        }

        System.out.println(true);

        return true;
    }
}
