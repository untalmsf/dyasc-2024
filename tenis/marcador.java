public class marcador {
    private jugador jugador1;
    private jugador jugador2;
    private int matchpoint;

    public marcador(jugador jugador1, jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.matchpoint = 0;
    }

    public int obtenerSets(jugador jugador) {
        return this.jugador1.obtenerNombre().equals(jugador.obtenerNombre()) ? this.jugador1.obtenerSets() : this.jugador2.obtenerSets();
    }   

    public void incrementarPuntaje(jugador jugadorActual) {
        if (jugadorActual.obtenerPuntaje() == 40 && jugadorOponente(jugadorActual).obtenerPuntaje() == 40) {
            manejarDeuce(jugadorActual);
        } else if (jugadorActual.obtenerPuntaje() == 30) {
            jugadorActual.guardarPuntaje(40);
        } else if (jugadorActual.obtenerPuntaje() == 40 && jugadorOponente(jugadorActual).obtenerPuntaje() < 40) {
            ganarGame(jugadorActual);
        } else {
            jugadorActual.incrementarPuntaje(15);
        }
    }

    private jugador jugadorOponente(jugador jugadorActual) {
        return jugadorActual == jugador1 ? jugador2 : jugador1;
    }

    private void manejarDeuce(jugador jugadorActual) {
        if (matchpoint == 0) {
            matchpoint = jugadorActual == jugador1 ? 1 : -1;
        } else if ((jugadorActual == jugador1 && matchpoint == 1) || (jugadorActual == jugador2 && matchpoint == -1)) {
            ganarGame(jugadorActual);
        } else {
            matchpoint = 0; // Volver a deuce
        }
    }

    private void ganarGame(jugador jugador) {
        jugador.incrementarGames();
        resetearPuntajes();
        verificarSetGanado();
    }

    public void resetearPuntajes() {
        jugador1.resetearPuntaje();
        jugador2.resetearPuntaje();
        matchpoint = 0;
    }

    private void verificarSetGanado() {
        if (hayTieBreak()) {
            return; // La lógica del tie-break se maneja aparte.
        }

        if (jugador1.obtenerGames() >= 6 && (jugador1.obtenerGames() - jugador2.obtenerGames()) >= 2) {
            ganarSet(jugador1);
        } else if (jugador2.obtenerGames() >= 6 && (jugador2.obtenerGames() - jugador1.obtenerGames()) >= 2) {
            ganarSet(jugador2);
        }
    }

    private void ganarSet(jugador jugador) {
        jugador.incrementarSets();
        resetearGames();
    }

    public void resetearGames() {
        jugador1.guardarGames(0);
        jugador2.guardarGames(0);
    }

    public boolean hayTieBreak() {
        return jugador1.obtenerGames() == 6 && jugador2.obtenerGames() == 6;
    }

    public String obtenerMarcador() {
        String marcador = "Puntajes: " + jugador1.obtenerNombre() + ": " + jugador1.obtenerPuntaje() + " - " +
                          jugador2.obtenerNombre() + ": " + jugador2.obtenerPuntaje() +
                          " | Games: " + jugador1.obtenerNombre() + ": " + jugador1.obtenerGames() + " - " +
                          jugador2.obtenerNombre() + ": " + jugador2.obtenerGames() +
                          " | Sets: " + jugador1.obtenerNombre() + ": " + jugador1.obtenerSets() + " - " +
                          jugador2.obtenerNombre() + ": " + jugador2.obtenerSets();

        if (hayTieBreak()) {
            marcador += " | Tie Break: " + jugador1.obtenerNombre() + ": " + jugador1.obtenerTieBreakPuntos() + " - " +
                        jugador2.obtenerNombre() + ": " + jugador2.obtenerTieBreakPuntos();
        } else if (hayDeuce()) {
            marcador += " | Deuce";
        } else if (matchpoint == 1) {
            marcador += " | Ventaja " + jugador1.obtenerNombre();
        } else if (matchpoint == -1) {
            marcador += " | Ventaja " + jugador2.obtenerNombre();
        }

        return marcador;
    }

    public boolean hayDeuce() {
        return jugador1.obtenerPuntaje() == 40 && jugador2.obtenerPuntaje() == 40 && matchpoint == 0;
    }
}
