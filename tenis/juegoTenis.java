public class juegoTenis {

    private jugador jugador1;
    private jugador jugador2;
    private marcador marcador;
    private String ganador = "partido en curso";

    public juegoTenis(String nombrejugador1, String nombrejugador2) {
        this.jugador1 = new jugador(nombrejugador1);
        this.jugador2 = new jugador(nombrejugador2);
        this.marcador = new marcador();
    }

    public void pelotaExitosa(String jugador) {
        if (!"partido en curso".equals(this.ganador)) {
            System.out.println("El juego ya ha terminado. El ganador es " + this.ganador);
            return;
        }
        if (jugador.equals(jugador1.obtenerNombre())) {
            marcador.incrementarPuntaje(1);
        } else {
            marcador.incrementarPuntaje(2);
        }

        verificarGanador();
    }

    private void verificarGanador() {
        if (marcador.obtenerSets(1) == 3) {
            ganador = jugador1.obtenerNombre();
        } else if (marcador.obtenerSets(2) == 3) {
            ganador = jugador2.obtenerNombre();
        }
    }

    public String obtenerMarcador() {
        return marcador.obtenerMarcador();
    }

    public String obtenerGanador() {
        return ganador;
    }
}
