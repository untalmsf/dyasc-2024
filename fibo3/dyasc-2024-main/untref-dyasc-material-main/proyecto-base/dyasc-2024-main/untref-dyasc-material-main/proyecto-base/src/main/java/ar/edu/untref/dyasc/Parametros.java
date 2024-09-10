package ar.edu.untref.dyasc;

public class Parametros {
    private String orientacion;
    private String direccion;
    private String nombreArchivo;
    private String modo;
    private int n;

    public Parametros(String orientacion, String direccion, String nombreArchivo, String modo, int n) {
        this.orientacion = orientacion;
        this.direccion = direccion;
        this.nombreArchivo = nombreArchivo;
        this.modo = modo;
        this.n = n;
    }

    public static Parametros procesarArgumentos(String[] args) {
        String orientacion = "h";
        String direccion = "d";
        String nombreArchivo = null;
        String modo = "l";
        int n = 0;

        for (String arg : args) {
            if (arg.startsWith("-o=")) {
                String opcion = arg.substring(3);
                if (opcion.length() == 2) {
                    orientacion = opcion.substring(0, 1);
                    direccion = opcion.substring(1, 2);

                    if ((!orientacion.equals("h") && !orientacion.equals("v")) ||
                        (!direccion.equals("d") && !direccion.equals("i"))) {
                        throw new IllegalArgumentException("Opciones inválidas.");
                    }
                } else {
                    throw new IllegalArgumentException("Opciones inválidas.");
                }
            } else if (arg.startsWith("-f=")) {
                nombreArchivo = arg.substring(3);
            } else if (arg.startsWith("-m=")) {
                modo = arg.substring(3);
                if (!modo.equals("l") && !modo.equals("s")) {
                    throw new IllegalArgumentException("Modo inválido.");
                }
            } else {
                try {
                    n = Integer.parseInt(arg);
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Número inválido: " + arg);
                }
            }
        }

        return new Parametros(orientacion, direccion, nombreArchivo, modo, n);
    }

    public String getOrientacion() {
        return orientacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public String getModo() {
        return modo;
    }

    public int getN() {
        return n;
    }
}
