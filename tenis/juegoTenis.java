

public class juegoTenis {

    private jugador jugador1;
    private jugador jugador2;
    private int matchpoint;
    private String ganador = "partido en curso";

    public juegoTenis(String nombrejugador1, String nombrejugador2) {
        this.jugador1 = new jugador(nombrejugador1);
        this.jugador2 = new jugador(nombrejugador2);
    }

    public int obtenerPuntaje(String jugador) {
        if (jugador.equals(jugador1.obtenerNombre())) {
            return jugador1.obtenerPuntaje();
        }
        return jugador2.obtenerPuntaje();
    }

    public int obtenerSet(int jugador){
        return jugador == 1 ? jugador1.obtenerSets() : jugador2.obtenerSets();
    }
    
    public void pelotaExitosa(String jugador) {
        if (!"partido en curso".equals(this.ganador)) {
            System.out.println("El juego ya ha terminado. El ganador es " + this.ganador);
            return;
        }
        if (jugador.equals(jugador1.obtenerNombre())) {
            puntojugador1();
        } else {
            puntojugador2();
        }
    }

    private void puntojugador1() {
        if (jugador1.obtenerPuntaje() == 30) {
            jugador1.guardarPuntaje(40);
        } else if (jugador1.obtenerPuntaje() == 40 && hayDeuce() && this.matchpoint == 1) {
            ganarGame(jugador1);
        } else if (jugador1.obtenerPuntaje() == 40 && hayDeuce() && this.matchpoint <= 0) {
            this.matchpoint += 1;
        } else if (jugador1.obtenerPuntaje() == 40 && !hayDeuce()) {
            ganarGame(jugador1);
        } else {
            jugador1.incrementarPuntaje(15);
        }
    }

    private void puntojugador2() {
        if (jugador2.obtenerPuntaje() == 30) {
            jugador2.guardarPuntaje(40);
        } else if (jugador2.obtenerPuntaje() == 40 && hayDeuce() && this.matchpoint == -1) {
            ganarGame(jugador2);
        } else if (jugador2.obtenerPuntaje() == 40 && hayDeuce() && this.matchpoint >= 0) {
            this.matchpoint -= 1;
        } else if (jugador2.obtenerPuntaje() == 40 && !hayDeuce()) {
            ganarGame(jugador2);
        } else {
            jugador2.incrementarPuntaje(15);
        }
    }

    private void ganarGame(jugador jugador) {
        resetearPuntajes();
        jugador.incrementarGames();
        if (jugador.obtenerGames() >= 6 && Math.abs(jugador1.obtenerGames() - jugador2.obtenerGames()) >= 2) {
            ganarSet(jugador);
        }
    }

    private void ganarSet(jugador jugador) {
        jugador1.guardarGames(0);
        jugador2.guardarGames(0);
        jugador.incrementarSets();
        if (jugador.obtenerSets() == 3) {
            ganador = jugador.obtenerNombre();
        }
    }

    public String obtenerMarcador() {
        String marcador = "Jugador1: " + jugador1.obtenerPuntaje() + " - Jugador2: " + jugador2.obtenerPuntaje() +
                          " | Games: Jugador1: " + jugador1.obtenerGames() + " - Jugador2: " + jugador2.obtenerGames() +
                          " | Sets: Jugador1: " + jugador1.obtenerSets() + " - Jugador2: " + jugador2.obtenerSets();
        if (hayDeuce()) {
            marcador += " | Deuce";
        }

        if (hayTieBreak()) {
            marcador += " | Tie Break";
        }

        return marcador;
    }

    private void resetearPuntajes() {
        jugador1.resetearPuntaje();
        jugador2.resetearPuntaje();
        matchpoint = 0;
    }

    public boolean hayDeuce() {
        return (jugador1.obtenerPuntaje() == 40 && jugador2.obtenerPuntaje() == 40);
    }

    private boolean hayTieBreak() {
        return jugador1.obtenerGames() == 6 && jugador2.obtenerGames() == 6;
    }

    public String obtenerGanador() {
        return ganador;
    }
}
