public class marcador {
    private int puntajeJugador1;
    private int puntajeJugador2;
    private int gamesJugador1;
    private int gamesJugador2;
    private int setsJugador1;
    private int setsJugador2;
    private int tieBreakPuntosJugador1;
    private int tieBreakPuntosJugador2;
    private int matchpoint;

    public marcador() {
        this.puntajeJugador1 = 0;
        this.puntajeJugador2 = 0;
        this.gamesJugador1 = 0;
        this.gamesJugador2 = 0;
        this.setsJugador1 = 0;
        this.setsJugador2 = 0;
        this.tieBreakPuntosJugador1 = 0;
        this.tieBreakPuntosJugador2 = 0;
        this.matchpoint = 0;
    }

    public int obtenerSets(int jugador) {
        return jugador == 1 ? setsJugador1 : setsJugador2;
    }

    public void incrementarPuntaje(int jugador) {
        if (jugador == 1) {
            manejarPuntoJugador1();
        } else {
            manejarPuntoJugador2();
        }
    }

    private void manejarPuntoJugador1() {
        if (puntajeJugador1 == 40 && puntajeJugador2 == 40) {
            switch (matchpoint) {
                case 0 -> matchpoint = 1;
                case 1 -> ganarGame(1);
                default -> matchpoint = 0;
            }
        } else if (puntajeJugador1 == 30) {
            puntajeJugador1 = 40;
        } else if (puntajeJugador1 == 40 && puntajeJugador2 < 40) {
            ganarGame(1);
        } else {
            puntajeJugador1 += 15;
        }
    }

    private void manejarPuntoJugador2() {
        if (puntajeJugador1 == 40 && puntajeJugador2 == 40) {
            switch (matchpoint) {
                case 0 -> matchpoint = -1;
                case -1 -> ganarGame(2);
                default -> matchpoint = 0;
            }
        } else if (puntajeJugador2 == 30) {
            puntajeJugador2 = 40;
        } else if (puntajeJugador2 == 40 && puntajeJugador1 < 40) {
            ganarGame(2);
        } else {
            puntajeJugador2 += 15;
        }
    }

    private void ganarGame(int jugador) {
        if (jugador == 1) {
            gamesJugador1++;
        } else {
            gamesJugador2++;
        }
        resetearPuntajes();
        verificarSetGanado();
    }

    public void resetearPuntajes() {
        puntajeJugador1 = 0;
        puntajeJugador2 = 0;
        matchpoint = 0;
    }

    private void verificarSetGanado() {
        if (hayTieBreak()) {
            return; // Si estamos en tie-break, se verifica el ganador dentro de la lógica del tie-break.
        }

        if (gamesJugador1 >= 6 && (gamesJugador1 - gamesJugador2) >= 2) {
            ganarSet(1);
        } else if (gamesJugador2 >= 6 && (gamesJugador2 - gamesJugador1) >= 2) {
            ganarSet(2);
        }
    }

    private void ganarSet(int jugador) {
        if (jugador == 1) {
            setsJugador1++;
        } else {
            setsJugador2++;
        }
        resetearGames();
    }

    public void resetearGames() {
        gamesJugador1 = 0;
        gamesJugador2 = 0;
    }

    private void manejarTieBreak(int jugador) {
        if (jugador == 1) {
            tieBreakPuntosJugador1++;
            if (tieBreakPuntosJugador1 >= 7 && (tieBreakPuntosJugador1 - tieBreakPuntosJugador2) >= 2) {
                ganarSet(1);
            }
        } else {
            tieBreakPuntosJugador2++;
            if (tieBreakPuntosJugador2 >= 7 && (tieBreakPuntosJugador2 - tieBreakPuntosJugador1) >= 2) {
                ganarSet(2);
            }
        }
    }

    public boolean hayDeuce() {
        return puntajeJugador1 == 40 && puntajeJugador2 == 40 && matchpoint == 0;
    }

    public boolean hayTieBreak() {
        return gamesJugador1 == 6 && gamesJugador2 == 6;
    }

    public String obtenerMarcador() {
        String marcador = "Puntajes: Jugador1: " + puntajeJugador1 + " - Jugador2: " + puntajeJugador2 +
                          " | Games: Jugador1: " + gamesJugador1 + " - Jugador2: " + gamesJugador2 +
                          " | Sets: Jugador1: " + setsJugador1 + " - Jugador2: " + setsJugador2;

        if (hayTieBreak()) {
            marcador += " | Tie Break: Jugador1: " + tieBreakPuntosJugador1 + " - Jugador2: " + tieBreakPuntosJugador2;
        } else if (hayDeuce()) {
            marcador += " | Deuce";
        } else if (matchpoint == 1) {
            marcador += " | Ventaja Jugador1";
        } else if (matchpoint == -1) {
            marcador += " | Ventaja Jugador2";
        }

        return marcador;
    }
}
