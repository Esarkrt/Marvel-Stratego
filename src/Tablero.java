
public class Tablero {
    Pieza Celdas[][];
    public Tablero(){
        Celdas=new Pieza[10][10];
        inicializarTablero();
    }
    private void inicializarTablero(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Celdas[i][j]=null;
            }
        }
    }
    private boolean zonasProhibidas(int fila, int columna){
        boolean lago1 =(fila==4||fila==5)&&(columna==3||columna==4);
        boolean lago2 =(fila==4||fila==5)&&(columna==6||columna==7);
        return lago1 || lago2;
    }

    public Pieza[][] getCeldas() {
        return Celdas;
    }

    public void setCeldas(int fila, int columna, Pieza pieza) {
        Celdas[fila][columna]=pieza;
    }
    public boolean esPosicionValida(int fila, int columna){
        if((fila>=0 && fila<10) && (columna>=0 && columna<10)){
            return true;
        }
        return false;
    }
    public boolean esMovimientoValido(int fila, int columna) {
    if (!esPosicionValida(fila, columna)) {
        return false;
    }
    if (zonasProhibidas(fila, columna)) {
        return false;
    }
    return true;
    }
    public boolean moverPieza(int filaOrigen, int colOrigen, int filaDestino, int colDestino)throws InvalidMoveException  {
        if (!esMovimientoValido(filaDestino, colDestino)) {
            throw new InvalidMoveException("Movimiento inválido hacia esa posición o zona prohibida.");
        }

        Pieza piezaMovida = Celdas[filaOrigen][colOrigen];
        Pieza piezaDestino = Celdas[filaDestino][colDestino];

        if (piezaDestino == null) {
            Celdas[filaDestino][colDestino] = piezaMovida;
            Celdas[filaOrigen][colOrigen] = null;
            return true;
        } 
        
        if (piezaDestino.getBando() != piezaMovida.getBando()) {
            ResultadoCombate resultado = Combate(piezaMovida, piezaDestino, filaOrigen, colOrigen, filaDestino, colDestino);
            return true; 
        } else {
            throw new InvalidMoveException("No puedes atacar una pieza de tu mismo bando.");
        }
        
    }
    public ResultadoCombate Combate(Pieza atacante, Pieza defensor, int fO, int cO, int fD, int cD){
        if(defensor.getRango()==0){
            Celdas[fD][cD] = atacante;
            Celdas[fO][cO] = null;
           return ResultadoCombate.GANA;
            
        }
        if (defensor.getRango() == 11) { 
        if (atacante.getRango() == 3) { 
            Celdas[fD][cD] = atacante;
            Celdas[fO][cO] = null;
            return ResultadoCombate.GANA;
        } else { 
            Celdas[fO][cO] = null; 
            return ResultadoCombate.PIERDE;
        }
    }
    
    
    if (atacante.getRango() == 1 && defensor.getRango() == 10) {
        Celdas[fD][cD] = atacante;
        Celdas[fO][cO] = null;
        return ResultadoCombate.GANA;
    }

    
    if (atacante.getRango() > defensor.getRango()) {
        Celdas[fD][cD] = atacante;
        Celdas[fO][cO] = null;
        return ResultadoCombate.GANA;
    } else if (atacante.getRango() < defensor.getRango()) {
        Celdas[fO][cO] = null; 
        return ResultadoCombate.PIERDE;
    } else {
        
        Celdas[fO][cO] = null;
        Celdas[fD][cD] = null; 
        return ResultadoCombate.EMPATE;
    }
}}


