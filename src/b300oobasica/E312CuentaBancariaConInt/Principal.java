package b300oobasica.E312CuentaBancariaConInt;

public class Principal {
    public static void main(String[] args) {
        CuentaBancaria cuenta1 = new CuentaBancaria(100);
        CuentaBancaria cuenta2 = new CuentaBancaria(50, 70);

        System.out.println("Cuenta 1: " + cuenta1);
        System.out.println("Cuenta 2: " + cuenta2);

        cuenta1.ingresarCajero(50);
        System.out.println("Cuenta 1 tras ingresar 50: " + cuenta1);

        cuenta1.extraerCajero(150);
        System.out.println("Cuenta 1 tras extraer 150: " + cuenta1);

        try {
            cuenta1.extraerCajero(10);
        } catch (RuntimeException e) {
            System.out.println("Error extracción cuenta1: " + e.getMessage());
        }

        cuenta2.cargarRecibo(80);
        System.out.println("Cuenta 2 tras recibo 80: " + cuenta2);

        cuenta2.cargarRecibo(40);
        System.out.println("Cuenta 2 tras recibo 40: " + cuenta2);

        try {
            cuenta2.cargarRecibo(10);
        } catch (RuntimeException e) {
            System.out.println("Error recibo cuenta2: " + e.getMessage());
        }

        CuentaBancaria cuenta3 = cuenta2.clone();
        System.out.println("Cuenta 2: " + cuenta2);
        System.out.println("Cuenta 3: " + cuenta3);

        if (cuenta2.equals(cuenta3)) {
            System.out.println("Cuenta 2 y Cuenta 3 son iguales");
        } else {
            System.out.println("Cuenta 2 y Cuenta 3 son distintas");
        }
    }
}
