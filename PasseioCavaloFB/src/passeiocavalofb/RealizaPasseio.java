package passeiocavalofb;

import model.Tabuleiro;

/**
 *
 * @author Geam
 */
public class RealizaPasseio {

    static boolean sucesso = false;
    static boolean primeiraTentativa = true;
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
    };

   


    public void imprimirTabuleiro() {

        System.out.println("===========================================");
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


    public void tentarProximoMovimento(int i, int horizontalP, int verticalP) {
        int u, v, k;
        //System.out.println(teste++);
        k = 0;
        sucesso = false;
        do {

            
            imprimirTabuleiro();
            if (!primeiraTentativa) {
                u = (horizontalP) + horizontal[k];
                v = (verticalP) + vertical[k];
                primeiraTentativa = false;
            }else{
                u = (horizontalP);
                v = (verticalP);
                primeiraTentativa = false;
            }
            if (-1 < horizontalP && horizontalP < Tabuleiro.DIMENSAO_TABULEIRO
                    && -1 < verticalP && verticalP < Tabuleiro.DIMENSAO_TABULEIRO
                    && tabuleiro[horizontalP][verticalP] == 0 //&& analisarPreenchimentoBordas(horizontalP,verticalP)
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
        
        System.out.println("Tamanho do tabuleiro (1-8): ");

        System.out.println("Posicao inicial do cavalo (x,y): ");

        tentarProximoMovimento(1, 0, 0);
        if (sucesso) {
            imprimirTabuleiro();
        } else {
            System.out.println("Caminho nao encontrado");
        }

    }

}
