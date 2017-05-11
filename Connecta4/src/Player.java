/**
 * @author joan on 24/4/17.
 * @project Connecta4
 * @package src
 */
public class Player implements Jugador {
    private class Resultat {
        public boolean esCasellaGuanyadora;
        public int jugadorGuanyador;
        public int valor = 0;

        public Resultat(boolean esTaulerGuanyador, int jugadorGuanyador, int valorTauler) {
            this.esCasellaGuanyadora = esTaulerGuanyador;
            this.jugadorGuanyador = jugadorGuanyador;
            this.valor = valorTauler;
        }

        @Override
        public String toString() {
            return "Resultat{" +
                    "esCasellaGuanyadora=" + esCasellaGuanyadora +
                    ", jugadorGuanyador=" + jugadorGuanyador +
                    '}';
        }
    }

    /**
     * Propietats
     */
    private Integer InfinitPositiu = Integer.MAX_VALUE;
    private Integer InfinitNegatiu = -InfinitPositiu;
    private String nom = "El puto amo";
    private int profunditat = 6;
    private static int[][] evaluacions = {
            {3,4,5,7,7,5,4,3},
            {4,6,8,10,10,8,6,4},
            {5,8,11,13,13,11,8,5},
            {6,10,14,16,16,14,10,6},
            {6,10,14,16,16,14,10,6},
            {5,8,11,13,13,11,8,5},
            {4,6,8,10,10,8,6,4},
            {3,4,5,7,7,5,4,3},
    };
    private int[] Weights = new int[] { 1, 5, 100, 10000, 2, 6, 200, 15000 };

    /**
     * Constructor
     **/
    public Player() {
//        testTaulers();
    }

    private void testTaulers() {
        Tauler t = new Tauler(8);
        t.afegeix(0, -1);
        t.afegeix(0, -1);
        t.afegeix(0, -1);
        t.afegeix(0, -1);
        t.afegeix(1, 1);
        t.afegeix(1, 1);
        t.afegeix(2, 1);
        t.afegeix(2, -1);
        t.afegeix(3, -1);
        t.afegeix(3, 1);
        t.afegeix(3, 1);
        t.afegeix(3, 1);
        t.afegeix(3, -1);
        t.pintaTauler();
        System.out.println(evaluarTauler(t, -1));
        /*        Tauler t1 = new Tauler(8);
        t1.afegeix(0, 1);
        t1.afegeix(1, 1);
        t1.afegeix(2, 1);
        t1.afegeix(3, 1);
        t1.pintaTauler();
        System.out.println(tauler_guanyador(t1));

        Tauler t1a = new Tauler(8);
        t1a.afegeix(0, -1);
        t1a.afegeix(1, -1);
        t1a.afegeix(2, 1);
        t1a.afegeix(3, -1);
        t1a.afegeix(4, 1);
        t1a.afegeix(5, 1);
        t1a.afegeix(6, 1);
        t1a.afegeix(7, 1);
        t1a.pintaTauler();
        System.out.println(tauler_guanyador(t1a));

        Tauler t2 = new Tauler(8);
        t2.afegeix(0, 1);
        t2.afegeix(1, -1);
        t2.afegeix(1, 1);
        t2.afegeix(2, -1);
        t2.afegeix(2, 1);
        t2.afegeix(2, 1);
        t2.afegeix(3, -1);
        t2.afegeix(3, -1);
        t2.afegeix(3, -1);
        t2.afegeix(3, 1);
        t2.pintaTauler();
        System.out.println(tauler_guanyador(t2));

        Tauler t2a = new Tauler(8);
        t2a.afegeix(0, 1);
        t2a.afegeix(0, 1);
        t2a.afegeix(0, -1);
        t2a.afegeix(0, -1);
        t2a.afegeix(0, 1);

        t2a.afegeix(1, 1);
        t2a.afegeix(1, 1);
        t2a.afegeix(1, -1);
        t2a.afegeix(1, -1);
        t2a.afegeix(1, 1);
        t2a.afegeix(1, 1);

        t2a.afegeix(2, -1);
        t2a.afegeix(2, -1);
        t2a.afegeix(2, 1);
        t2a.afegeix(2, 1);
        t2a.afegeix(2, -1);
        t2a.afegeix(2, -1);
        t2a.afegeix(2, 1);

        t2a.afegeix(3, 1);
        t2a.afegeix(3, 1);
        t2a.afegeix(3, -1);
        t2a.afegeix(3, -1);
        t2a.afegeix(3, 1);
        t2a.afegeix(3, 1);
        t2a.afegeix(3, 1);
        t2a.afegeix(3, 1);
        t2a.pintaTauler();
        System.out.println(tauler_guanyador(t2a));

        Tauler t2b = new Tauler(8);
        t2b.afegeix(4, 1);
        t2b.afegeix(4, 1);
        t2b.afegeix(4, -1);
        t2b.afegeix(4, -1);
        t2b.afegeix(4, 1);

        t2b.afegeix(5, 1);
        t2b.afegeix(5, 1);
        t2b.afegeix(5, -1);
        t2b.afegeix(5, -1);
        t2b.afegeix(5, 1);
        t2b.afegeix(5, 1);

        t2b.afegeix(6, -1);
        t2b.afegeix(6, -1);
        t2b.afegeix(6, 1);
        t2b.afegeix(6, 1);
        t2b.afegeix(6, -1);
        t2b.afegeix(6, -1);
        t2b.afegeix(6, 1);

        t2b.afegeix(7, 1);
        t2b.afegeix(7, 1);
        t2b.afegeix(7, -1);
        t2b.afegeix(7, -1);
        t2b.afegeix(7, -1);
        t2b.afegeix(7, 1);
        t2b.afegeix(7, 1);
        t2b.afegeix(7, 1);
        t2b.pintaTauler();
        System.out.println(tauler_guanyador(t2b));

        Tauler tde = new Tauler(8);
        tde.afegeix(7, 1);
        tde.afegeix(7, 1);
        tde.afegeix(7, -1);
        tde.afegeix(7, -1);
        tde.afegeix(7, 1);

        tde.afegeix(6, 1);
        tde.afegeix(6, 1);
        tde.afegeix(6, -1);
        tde.afegeix(6, -1);
        tde.afegeix(6, 1);
        tde.afegeix(6, 1);

        tde.afegeix(5, -1);
        tde.afegeix(5, -1);
        tde.afegeix(5, 1);
        tde.afegeix(5, 1);
        tde.afegeix(5, -1);
        tde.afegeix(5, -1);
        tde.afegeix(5, 1);

        tde.afegeix(4, 1);
        tde.afegeix(4, 1);
        tde.afegeix(4, -1);
        tde.afegeix(4, -1);
        tde.afegeix(4, -1);
        tde.afegeix(4, 1);
        tde.afegeix(4, 1);
        tde.afegeix(4, 1);
        tde.pintaTauler();
        System.out.println(tauler_guanyador(tde));*/

/*        Tauler t3 = new Tauler(8);
        t3.afegeix(0, -1);
        t3.afegeix(0, -1);
        t3.afegeix(0, 1);
        t3.afegeix(0, -1);
        t3.afegeix(0, 1);
        t3.afegeix(0, 1);
        t3.afegeix(0, 1);
        t3.afegeix(0, 1);
        t3.pintaTauler();
        System.out.println(tauler_guanyador(t3));*/





    }

    /**
     * @return
     */
    @Override
    public String nom() {
        return this.nom;
    }

    /**
     * @param t     Tauler actual de joc
     * @param color Color de la peça que possarà
     * @return
     */
    @Override
    public int moviment(Tauler t, int color) {
        int eval_act, eval_ant = InfinitNegatiu, millor_mov = 0;
        for(int i=0; i < t.getMida(); ++i){
            if(t.movpossible(i)){
                Tauler aux = new Tauler(t);
                aux.afegeix(i, color);
                eval_act = min_value(aux, InfinitNegatiu, InfinitPositiu, profunditat, color);
                System.out.println("accio -> "+i+" valor accio = "+eval_act);
                if(eval_act > eval_ant){
                    millor_mov = i;
                    eval_ant = eval_act;
                }
            }
        }
        System.out.println();
        return millor_mov;
    }

    /**
     * @param t
     * @param alfa
     * @param beta
     * @param nivell
     * @param color
     * @return
     */
    private int min_value(Tauler t, int alfa, int beta, int nivell, int color){
        if(nivell==0 || tauler_guanyador(t).esCasellaGuanyadora || !t.espotmoure()) return heuristica(t, color);
        for(int i=0;i<t.getMida();i++){
            if(t.movpossible(i)){
                Tauler aux = new Tauler (t);
                aux.afegeix(i, -color);
                beta = Math.min(beta, max_value(aux,alfa,beta,nivell-1, color));
                if(beta <= alfa) return beta;
            }
        }
        return beta;
    }

    /**
     * @param t
     * @param alfa
     * @param beta
     * @param nivell
     * @param color
     * @return
     */
    private int max_value(Tauler t, int alfa, int beta, int nivell, int color){
        if(nivell==0 || tauler_guanyador(t).esCasellaGuanyadora || !t.espotmoure()) return heuristica(t,color);
        for(int i=0;i<t.getMida();i++){
            if(t.movpossible(i)){
                Tauler aux = new Tauler (t);
                aux.afegeix(i, color);
                alfa = Math.max(alfa, min_value(aux, alfa, beta, nivell-1, color));
                if(alfa >= beta) return alfa;
            }
        }
        return alfa;
    }

    /**
     * @param jugador
     * @return
     */
    private int oponent(int jugador) {
        return -jugador;
    }

    /**
     * @param t
     * @return
     */
    private Resultat tauler_guanyador(Tauler t) {
        Resultat resultat = new Resultat(false, 0, 0);
        for (int i = 0; i < t.getMida(); i++) {
            for (int j = 0; j < t.getMida(); j++) {
                if (t.getColor(i, j) == 0) continue;
                resultat = evaluarCasella(t, i, j);
                if (resultat.esCasellaGuanyadora) return resultat;
            }
        }

        return resultat;
    }

    /**
     * @param t
     * @return
     */
    private Resultat tauler_guanyadorWIP(Tauler t) {
        Resultat resultat = new Resultat(false, 0, 0);

        int heurisitica = 0;

        for (int i = 0; i < t.getMida(); i++) {
            for (int j = 0; j < t.getMida(); j++) {
                if (t.getColor(i, j) == 0) continue;
                resultat = evaluarCasellaWIP(t, i, j);
                if (resultat.esCasellaGuanyadora) return resultat;

                heurisitica += resultat.valor;
            }
        }

        resultat.valor = heurisitica;
        return resultat;
    }

    private Resultat evaluarCasellaWIP(Tauler t, int fil, int col) {
        int maximMenor = -1;
        int maximMajor = t.getMida();
        int jugador = t.getColor(fil, col);
        int pecesPerGuanyar = 4;
        int j;
        int contador, contadorBlancs, contadorPonderat;
        int heuristicaCasella = 0;

        //Mirar adalt -> Tests OK
        contador = 1;
        contadorBlancs = 0;
        contadorPonderat = 0;
        for (int i = fil+1; i < maximMajor && i <= fil+3; i++) {
            if (t.getColor(i, col) == jugador) contador++;
            else if (t.getColor(i, col) == 0) contadorBlancs++;
            contadorPonderat += evaluacions[i][col];
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }
        heuristicaCasella += contadorPonderat * calcularPuntuacio(contador, contadorBlancs);

        //Mirar diagonal adalt dreta -> Tests OK
        contador = 1;
        contadorBlancs = 0;
        contadorPonderat = 0;
        j = col+1;
        for (int i = fil+1; i < maximMajor && j < maximMajor && i <= fil+3; i++) {
            if (t.getColor(i, j) == jugador) contador++;
            else if (t.getColor(i, j) == 0) contadorBlancs++;
            contadorPonderat += evaluacions[i][j];
            j++;
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }
        heuristicaCasella += contadorPonderat * calcularPuntuacio(contador, contadorBlancs);

        //Mirar dreta -> Tests OK
        contador = 1;
        contadorBlancs = 0;
        contadorPonderat = 0;
        for (int i = col+1; i < maximMajor && i <= col+3; i++) {
            if (t.getColor(fil, i) == jugador) contador++;
            else if (t.getColor(fil, i) == 0) contadorBlancs++;
            contadorPonderat += evaluacions[fil][i];
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }
        heuristicaCasella += contadorPonderat * calcularPuntuacio(contador, contadorBlancs);

        //Mirar diagonal adalt esquerra -> Tests OK
        contador = 1;
        contadorBlancs = 0;
        contadorPonderat = 0;
        j = col-1;
        for (int i = fil+1; i < maximMajor && j > maximMenor && i <= fil+3; i++) {
            if (t.getColor(i, j) == jugador) contador++;
            else if (t.getColor(i, j) == 0) contadorBlancs++;
            contadorPonderat += evaluacions[i][j];
            j--;
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }

        heuristicaCasella += contadorPonderat * calcularPuntuacio(contador, contadorBlancs);

        return new Resultat(false, 0, jugador * heuristicaCasella);
    }

    /**
     * @param t
     * @param fil
     * @param col
     * @return
     */
    private Resultat evaluarCasella(Tauler t, int fil, int col) {
        int pecesPerGuanyar = 4;
        int maximMenor = -1;
        int maximMajor = t.getMida();

        int jugador = t.getColor(fil, col);
        int j;
        int contador;


        //Mirar adalt -> Tests OK
        contador = 1;
        for (int i = fil+1; i < maximMajor && i <= fil+3; i++) {
            if (t.getColor(i, col) == jugador) contador++;
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }

        //Mirar diagonal adalt dreta -> Tests OK
        contador = 1;
        j = col+1;
        for (int i = fil+1; i < maximMajor && j < maximMajor && i <= fil+3; i++) {
            if (t.getColor(i, j++) == jugador) contador++;
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }

        //Mirar dreta -> Tests OK
        contador = 1;
        for (int i = col+1; i < maximMajor && i <= col+3; i++) {
            if (t.getColor(fil, i) == jugador) contador++;
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }

        //Mirar diagonal adalt esquerra -> Tests OK
        contador = 1;
        j = col-1;
        for (int i = fil+1; i < maximMajor && j > maximMenor && i <= fil+3; i++) {
            if (t.getColor(i, j--) == jugador) contador++;
        }

        if (contador == pecesPerGuanyar) {
            return new Resultat(true, jugador, jugador * InfinitPositiu);
        }
        return new Resultat(false, 0, 0);
    }

    /**
     * @param t
     * @param jugador
     * @return
     */
    private int evaluarTauler(Tauler t, int jugador) {
        Resultat r = tauler_guanyador(t);
        boolean guanyador = r.esCasellaGuanyadora;

        if (guanyador) return r.valor;

        int puntuacioOponent = 1;
        int score = 0;
        int blanks = 0;
        int k;
        int moreMoves = 0;
        for (int i = t.getMida()-1; i >= 0; i--) {
            for (int j = 0; j < t.getMida(); j++) {

                if (t.getColor(i, j) == 0 || t.getColor(i, j) == jugador) continue;

                if (j <= 3) {
                    for (k = 1; k < 4; ++k) {
                        if (t.getColor(i, j+k) == oponent(jugador)) puntuacioOponent++;
                        else if(t.getColor(i, j+k) == jugador) {
                            puntuacioOponent = 0;
                            blanks = 0;
                            break;
                        } else blanks++;
                    }

                    moreMoves = 0;
                    if (blanks > 0) {
                        for (int c = 1; c < 4; ++c) {
                            int column = j+c;
                            for (int m = i; m <= 5; m++) {
                                if (t.getColor(m, column) == 0) moreMoves++;
                                else break;
                            }
                        }
                    }

                    if (moreMoves != 0) score += calcularPuntuacio(puntuacioOponent, moreMoves);
                    puntuacioOponent = 1;
                    blanks = 0;
                }

                if (i >= 3) {
                    for (k = 1; k < 4; ++k) {
                        if (t.getColor(i - k, j) == oponent(jugador)) puntuacioOponent++;
                        else if (t.getColor(i - k, j) == jugador) {
                            puntuacioOponent = 0;
                            break;
                        }
                    }
                    moreMoves = 0;

                    if (puntuacioOponent > 0) {
                        int column = j;
                        for (int m = i-k+1; m <= i-1 ; m++) {
                            if (t.getColor(m, column) == 0) moreMoves++;
                            else break;
                        }
                    }
                }
                if (moreMoves != 0) score += calcularPuntuacio(puntuacioOponent, moreMoves);
                puntuacioOponent = 1;
                blanks = 0;
                if (j >= 3) {
                    for (k = 1; k < 4; ++k) {
                        if (t.getColor(i, j-k) == oponent(jugador)) puntuacioOponent++;
                        else if (t.getColor(i, j - k) == jugador) {
                            puntuacioOponent = 0;
                            blanks = 0;
                            break;
                        } else blanks++;
                    }
                    moreMoves = 0;
                    if (blanks > 0) {
                        for (int c = 1; c < 4; c++) {
                            int column = j - c;
                            for (int m = i; m <= 5; m++) {
                                if (t.getColor(m, column) == 0) moreMoves++;
                                else break;
                            }
                        }
                    }
                    if (moreMoves != 0) score += calcularPuntuacio(puntuacioOponent, moreMoves);
                    puntuacioOponent = 1;
                    blanks = 0;
                }

                if (j <= 3 && i >= 3) {
                    for (k = 1; k < 4; ++k) {
                        if (t.getColor(i-k, j+k) == oponent(jugador)) puntuacioOponent++;
                        else if (t.getColor(i-k, j+k) == jugador) {
                            puntuacioOponent = 0;
                            blanks = 0;
                            break;
                        } else blanks++;
                    }
                    moreMoves = 0;
                    if (blanks > 0) {
                        for (int c = 1; c < 4; ++c) {
                            int column = j+c, row = i-c;
                            for (int m = row; m <= 5; ++m) {
                                if (t.getColor(m, column) == 0) moreMoves++;
                                else if(t.getColor(m, column) == -1);
                                else break;
                            }
                        }
                        if (moreMoves != 0) score += calcularPuntuacio(puntuacioOponent, moreMoves);
                        puntuacioOponent = 1;
                        blanks = 0;
                    }
                }

                if (i >= 3 && j >= 3) {
                    for (k = 1; k < 4; ++k) {
                        if (t.getColor(i-k, j-k) == oponent(jugador)) puntuacioOponent++;
                        else if (t.getColor(i-k, j-k) == jugador) {
                            puntuacioOponent = 0;
                            blanks = 0;
                            break;
                        } else blanks++;
                    }

                    moreMoves = 0;
                    if (blanks > 0) {
                        for (int c = 1; c < 4; ++c) {
                            int column = j-c, row = i-c;
                            for (int m = row; m <= 5 ; ++m) {
                                if (t.getColor(m, column) == 0) moreMoves++;
                                else if(t.getColor(m, column) == oponent(jugador));
                                else  break;
                            }
                        }
                        if (moreMoves != 0) score += calcularPuntuacio(puntuacioOponent, moreMoves);
                        puntuacioOponent = 1;
                        blanks = 0;
                    }
                }
            }
        }
        return score;
    }

    private int evaluarTaulerWIP(Tauler t, int jugador) {
        Resultat r = tauler_guanyadorWIP(t);
        boolean guanyador = r.esCasellaGuanyadora;
        if (guanyador) return r.jugadorGuanyador * InfinitPositiu;

        return r.valor;
    }
    /**
     * @param puntuacio
     * @param moviments
     * @return
     */
    int calcularPuntuacio(int puntuacio, int moviments){
        int puntuacioMoviments = 4 - moviments;
        if(puntuacio==0) return 0;
        else if(puntuacio==1) return 1*puntuacioMoviments;
        else if(puntuacio==2) return 10*puntuacioMoviments;
        else if(puntuacio==3) return 100*puntuacioMoviments;
        else return 1000;
    }

    private int CheckLine(int[] vals, int jugador)
    {
        int score = 0;
        for (int i = 0; i < vals.length - 3; i++)
        {
            //Examine each opportunity
            int c = 0;
            int p = 0;
            for (int j = 0; j < 4; j++)
                if (vals[i + j] == jugador) c++; //TODO Make sure that it looks at it's own identity
                else if (vals[i + j] !=0 ) p++;
            if ((c > 0) && (p == 0))
            {
                //Computer opportunity
                if (c == 4) return Weights[3]; //Win
                score += ((c/3)*Weights[2]) + ((c/2)*Weights[1]) + Weights[0];
            }
            else if ((c == 0) && (p > 0))
            {
                //Player opportunity
                if (p == 4) return -1*Weights[7]; //Win
                score -= ((p / 3) * Weights[6]) + ((p / 2) * Weights[5]) + Weights[4];
            }
        }
        return score;
    }

    private int heuristica(Tauler t, int jugador)
    {
        Resultat guanyador = tauler_guanyador(t);
        if (guanyador.esCasellaGuanyadora){
            return guanyador.jugadorGuanyador * InfinitPositiu;
        }
        int score = 0;
        //Eval Horizontal
        for (int i = 0; i < 6; i++)
        {
            int[] aux = new int[] {t.getColor(0,i), t.getColor(1,i), t.getColor(2,i), t.getColor(3,i), t.getColor(4,i),t.getColor(5,i), t.getColor(6,i)};
            score += CheckLine(aux, jugador);
        }

        //Eval Vertical
        for (int i = 0; i < 7; i++)
        {
            int[] aux = new int[] {t.getColor(i,0), t.getColor(i,1), t.getColor(i,2), t.getColor(i,3), t.getColor(i,4),t.getColor(i,5), t.getColor(i,6)};
            score += CheckLine(aux,jugador);
        }

        //Eval Diagonal
        int[] aux = new int[] {t.getColor(0,2),t.getColor(1,3),t.getColor(2,4), t.getColor(3,5)};
        score += CheckLine(aux,jugador);
        int[] aux1 = new int [] {t.getColor(0,1),t.getColor(1,2),t.getColor(2,3), t.getColor(3,4), t.getColor(4,5)};
        score += CheckLine(aux1,jugador);
        int [] aux2 = new int[] {t.getColor(0,0), t.getColor(1,1), t.getColor(2,2), t.getColor(3,3), t.getColor(4,4), t.getColor(5,5)};
        score += CheckLine(aux2,jugador);
        int [] aux3 = new int[] {t.getColor(1,0), t.getColor(2,1), t.getColor(3,2), t.getColor(4,3), t.getColor(5,4),t.getColor(6,5)};
        score += CheckLine(aux3,jugador);
        int [] aux4 = new int[] {t.getColor(2,0), t.getColor(3,1), t.getColor(4,2), t.getColor(5,3), t.getColor(6,4)};
        score += CheckLine(aux4,jugador);
        int [] aux5 = new int[] {t.getColor(3,0),t.getColor(4,1),t.getColor(5,2),t.getColor(6,3)};
        score += CheckLine(aux5,jugador);

        //Eval Diagonal 2
        int[] aux6 = new int[] {t.getColor(3,0), t.getColor(2,1), t.getColor(1,2), t.getColor(0,3)};
        score += CheckLine(aux6,jugador);
        int[] aux7 = new int[] {t.getColor(4,0), t.getColor(3,1), t.getColor(2,2), t.getColor(1,3), t.getColor(0,4)};
        score += CheckLine(aux7,jugador);
        int[] aux8 = new int[] {t.getColor(5,0), t.getColor(4,1), t.getColor(3,2), t.getColor(2,3), t.getColor(1,4), t.getColor(0,5)};
        score += CheckLine(aux8,jugador);
        int [] aux9 = new int[] {t.getColor(6,0), t.getColor(5,1), t.getColor(4,2), t.getColor(3,3), t.getColor(2,4), t.getColor(1,5)};
        score += CheckLine(aux9,jugador);
        int [] aux10 = new int[] {t.getColor(6,1), t.getColor(5,2), t.getColor(4,3),t.getColor(3,4),t.getColor(2,5)};
        score += CheckLine(aux10,jugador);
        int [] aux11 = new int[] {t.getColor(6,2), t.getColor(5,3),t.getColor(4,4),t.getColor(3,5)};
        score += CheckLine(aux11,jugador);
        return score;
    }
}