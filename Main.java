// -----------------------------------------
// Interfaz Comando
// -----------------------------------------

interface Command {
    void ejecutar();
}


// -----------------------------------------
// Receptor: Televisor
// -----------------------------------------

class Televisor {

    private boolean encendido = false;
    private int volumen = 10;
    private int canal = 1;

    public void encender() {
        encendido = true;
        System.out.println("El televisor está encendido.");
    }

    public void apagar() {
        encendido = false;
        System.out.println("El televisor está apagado.");
    }

    public void subirVolumen() {
        if (encendido) {
            volumen++;
            System.out.println("Volumen: " + volumen);
        } else {
            System.out.println("El televisor está apagado.");
        }
    }

    public void cambiarCanal(int nuevoCanal) {
        if (encendido) {
            canal = nuevoCanal;
            System.out.println("Canal cambiado a: " + canal);
        } else {
            System.out.println("El televisor está apagado.");
        }
    }
}


// -----------------------------------------
// Comando Concreto: Encender
// -----------------------------------------

class EncenderTV implements Command {

    private Televisor tv;

    public EncenderTV(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.encender();
    }
}


// -----------------------------------------
// Comando Concreto: Apagar
// -----------------------------------------

class ApagarTV implements Command {

    private Televisor tv;

    public ApagarTV(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.apagar();
    }
}


// -----------------------------------------
// Comando Concreto: Subir Volumen
// -----------------------------------------

class SubirVolumen implements Command {

    private Televisor tv;

    public SubirVolumen(Televisor tv) {
        this.tv = tv;
    }

    @Override
    public void ejecutar() {
        tv.subirVolumen();
    }
}


// -----------------------------------------
// Comando Concreto: Cambiar Canal
// -----------------------------------------

class CambiarCanal implements Command {

    private Televisor tv;
    private int canal;

    public CambiarCanal(Televisor tv, int canal) {
        this.tv = tv;
        this.canal = canal;
    }

    @Override
    public void ejecutar() {
        tv.cambiarCanal(canal);
    }
}


// -----------------------------------------
// Invocador: Boton
// -----------------------------------------

class Boton {

    private Command comando;

    public void establecerComando(Command comando) {
        this.comando = comando;
    }

    public void presionar() {
        comando.ejecutar();
    }
}


// ------------------------------------------
// Programa principal
// ------------------------------------------

public class Main {

    public static void main(String[] args) {

        // Crea el televisor
        Televisor tv = new Televisor();


        // Crea los comandos
        Command encender = new EncenderTV(tv);
        Command apagar = new ApagarTV(tv);
        Command volumen = new SubirVolumen(tv);
        Command canal = new CambiarCanal(tv, 5);


        // Crea los botones
        Boton boton1 = new Boton();
        Boton boton2 = new Boton();
        Boton boton3 = new Boton();
        Boton boton4 = new Boton();


        // Asigna un comando a cada botón
        boton1.establecerComando(encender);
        boton2.establecerComando(apagar);
        boton3.establecerComando(volumen);
        boton4.establecerComando(canal);


        // Presiona los botones
        boton1.presionar();

        boton3.presionar();
        boton3.presionar();

        boton4.presionar();

        boton2.presionar();
    }
}