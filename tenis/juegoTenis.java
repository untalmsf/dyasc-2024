import static org.junit.jupiter.api.Assertions.assertEquals;

public class juegoTenis {

    private int puntaje1;
    private int puntaje2;
    private int games1;
    private int games2;
    private int sets1;
    private int sets2;
    private int matchpoint;
    private String ganador = "partido en curso";

    public juegoTenis(String jugador1, String jugador2) {
        this.puntaje1 = 0;
        this.puntaje2 = 0;
        this.games1 = 0;
        this.games2 = 0;
    }

    public int obtenerPuntaje(String jugador) {
        if (jugador.equals("Jugador1")) {
            return this.puntaje1;
        }

        return this.puntaje2;
    }

    public int obtenerSet(int jugador){
        return jugador == 1 ? this.sets1 : this.sets2;
    }
    
    public void pelotaExitosa(String jugador) {
        if (!"partido en curso".equals(this.ganador)) {
            System.out.println("El juego ya ha terminado. El ganador es " + this.ganador);
            return;
        }
        if (jugador.equals("Jugador1")) {
            puntoJugador1();
        } else {
            puntoJugador2();
        }
    }

    private void puntoJugador1() {
        if (this.puntaje1 == 30) {
            this.puntaje1 = 40;
        } else if (this.puntaje1 == 40 && hayDeuce() && this.matchpoint == 1) {
            ganarGame("Jugador1");
        } else if (this.puntaje1 == 40 && hayDeuce() && this.matchpoint <= 0) {
            this.matchpoint += 1;
        } else if (this.puntaje1 == 40 && !hayDeuce()) {
            ganarGame("Jugador1");
        } else {
            this.puntaje1 += 15;
        }
    }

    private void puntoJugador2() {
        if (this.puntaje2 == 30) {
            this.puntaje2 = 40;
        } else if (this.puntaje2 == 40 && hayDeuce() && this.matchpoint == -1) {
            ganarGame("Jugador2");
        } else if (this.puntaje2 == 40 && hayDeuce() && this.matchpoint >= 0) {
            this.matchpoint -= 1;
        } else if (this.puntaje2 == 40 && !hayDeuce()) {
            ganarGame("Jugador2");
        } else {
            this.puntaje2 += 15;
        }
    }

    private void ganarGame(String jugador) {
        resetearPuntajes();
        if (jugador.equals("Jugador1")) {
            this.games1 += 1;
            if (this.games1 >= 6 && this.games1 - this.games2 >= 2) {
                ganarSet("Jugador1");
            }
        } else {
            this.games2 += 1;
            if (this.games2 >= 6 && this.games2 - this.games1 >= 2) {
                ganarSet("Jugador2");
            }
        }
    }

    private void ganarSet(String jugador) {
        games1 = 0;
        games2 = 0;
        if (jugador.equals("Jugador1")) {
            sets1 += 1;
            if (sets1 == 3) {
                ganador = "Jugador1";
            }
        } else {
            sets2 += 1;
            if (sets2 == 3) {
                ganador = "Jugador2";
            }
        }
    }
    public String obtenerMarcador() {
        
        String marcador = "Jugador1: " + puntaje1 + " - Jugador2: " + puntaje2 +
                          " | Games: Jugador1: " + games1 + " - Jugador2: " + games2 +
                          " | Sets: Jugador1: " + sets1 + " - Jugador2: " + sets2;
        if (hayDeuce()) {
            marcador += " | Deuce";
        }

        if (hayTieBreak()) {
            marcador += " | Tie Break";
        }

        return marcador;
    }
    private void resetearPuntajes() {
        puntaje1 = 0;
        puntaje2 = 0;
        matchpoint = 0;
    }
    
    public int[] marcador(String jugador1, String jugador2) {
        int[] marcador = {this.obtenerPuntaje(jugador1), this.obtenerPuntaje(jugador2),this.matchpoint, this.games1, this.games2};
        return marcador;
    }

    public boolean hayDeuce(){
        return (puntaje1 == 40 && puntaje2 == 40);
    }
    
    private boolean hayTieBreak() {
        return games1 == 6 && games2 == 6;
    }

    public String obtenerGanador() {
        return ganador;
    }    

}