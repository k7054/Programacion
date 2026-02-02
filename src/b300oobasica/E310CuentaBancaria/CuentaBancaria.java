package b300oobasica.E310CuentaBancaria;

public class CuentaBancaria {
    private double saldo = 0;
    private double descubierto = 0;

    public CuentaBancaria() {
    }

    public CuentaBancaria(double saldo) {
        this.saldo = saldo;
    }

    public CuentaBancaria(double saldo, double descubierto) {
        this.saldo = saldo;
        this.descubierto = Math.abs(descubierto);
    }

    public String toString() {
        return "Saldo = " + saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof CuentaBancaria)) return false;

        CuentaBancaria otra = (CuentaBancaria) obj;
        return this.saldo == otra.saldo;
    }

    public CuentaBancaria clone() {
        return new CuentaBancaria(this.saldo, this.descubierto);
    }

    public void ingresarCajero(double ingresarSaldo) {
        if (ingresarSaldo > 0) {
            saldo = saldo + ingresarSaldo;
        }
    }

    public void extraerCajero(double extraerSaldo) {
        if (extraerSaldo > saldo) {
            throw new RuntimeException("Saldo insuficiente");
        }

        saldo = saldo - extraerSaldo;
    }

    public void cargarRecibo(double importeRecibo) {
        double saldoFinal = saldo - importeRecibo;

        if (saldoFinal < -descubierto) {
            throw new RuntimeException("Descubierto máximo superado");
        }

        saldo = saldoFinal;
    }
}
