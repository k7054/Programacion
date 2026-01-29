package b300oobasica.E310CuentaBancaria;

public class CuentaBancaria {
    private double saldo = 0;
    private double saldoNegativo = 0;
    private boolean descubierto = false;

    public CuentaBancaria() {

    }

    public double  getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
