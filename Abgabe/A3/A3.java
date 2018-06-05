public class A3 {

        public static void main (String []args){

            // Erstellt das Spielfeld
            boolean[][][][] field = new boolean[10][10][10][10];

            // BefÃ¼llt das Feld
            field = add(field);

            // Gibt ein bestimmte Position aus
            print(7,5,3,1, field);
        }

        /**
         * Bekommt eine Position und das Spielfeld mit und gibt aus ob es eine Gewinn oder Verlust Position ist.
         * @param pos1
         * @param pos2
         * @param pos3
         * @param pos4
         * @param field
         */
        public static void print (int pos1, int pos2, int pos3, int pos4, boolean [][][][] field){
            if (field[pos1][pos2][pos3][pos4]){
                System.out.println("Es ist eine Gewinn Position");
            } else {
                System.out.println("Es ist keine Gewinn Position");
            }
        }

        /**
         * Geht das ganze Spielfeld durch und setzt bei jeder Position ob es eine Gewinn oder Verlust Position ist.
         * @param field
         * @return
         */
        public static boolean[][][][] add (boolean [][][][] field){

            for (int a = 0; a <= 9; a++){
                for (int b = 0; b <= 9; b++){
                    for (int c = 0; c <= 9; c++){
                        for (int d = 0; d <= 9; d++){
                            int [] position = new int[] {a,b,c,d};
                            field [a][b][c][d] = winposition(newGamefield(position));
                        }
                    }
                }
            }
            return field;
        }

        /**
         * Bekommt das 2D-Array mit BinÃ¤r Zahlen.
         * Gibt ein Boolean zurÃ¼ck ob es eine Gewinn Position ist.
         * @param gamefield
         * @return
         */
        public static boolean winposition (int[][] gamefield) {

            int [] won = new int[gamefield[1].length];

            for (int i = 0; i < gamefield[1].length; i++) {
                for (int j = 0; j < gamefield.length; j++) {
                    won[i] = won[i] + gamefield[j][i];
                }
            }

            boolean winposition = true;

            for (int x = 0; x < won.length; x++) {
                if (won[x] % 2 == 1) {
                    winposition = false;
                } else {
                    optSpielzug(gamefield, x);
                }
            }
            return winposition;
        }

        public static void optSpielzug(int [][] gamefield, int pos){
            for (int i = 0; i < gamefield.length; i++) {
                if(gamefield[i][pos] == 1){
                    gamefield[i][pos] = 0;
                }
            }

            String [] binNum = new String[gamefield.length];

            for (int j = 0; j < gamefield.length; j++) {
                binNum[pos] = binNum[pos] + gamefield[pos][j];
            }
            System.out.println(binNum);
        }

        /**
         * Bekommt Array mit Zahlen und wandelt diese in BinÃ¤r zahlen um.
         * Gibt 2 Dimensionales Array zurÃ¼ck. Jede Ziffer der Bin Zahl ist eine Stelle im Array
         * @param gamefield
         * @return
         */
        public static int[][] newGamefield(int[] gamefield) {
            int[][] newGamefield = new int[gamefield.length][10];

            for (int i = 0; i < gamefield.length; i++) {
                String binZahl = dezInBin(gamefield[i]);
                for (int j = 0; j < binZahl.length(); j++) {
                    newGamefield[i][j] = Integer.parseInt(String.valueOf((binZahl.charAt(j))));
                }
            }

            return newGamefield;
        }

        public static int binInDez(String x){
            int result = Integer.parseInt(x, 2);
            return result;
        }

        public static String dezInBin(int x) {
            String number = Integer.toBinaryString(x);
            return number;
        }
    }
