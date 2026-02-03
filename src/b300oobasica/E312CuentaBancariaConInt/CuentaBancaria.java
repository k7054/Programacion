package b300oobasica.E312CuentaBancariaConInt;

public class CuentaBancaria {
    private int saldo = 0;
    private int descubierto = 0;

    public CuentaBancaria() {
    }

    public CuentaBancaria(int saldo) {
        this.saldo = conversionCents(saldo);
    }

    public CuentaBancaria(int saldo, int descubierto) {
        this.saldo = conversionCents(saldo);
        this.descubierto = conversionCents(descubierto);
    }

    public String toString() {
        return String.format("Saldo = %.2f", getSaldo());
    }

    public double getSaldo() {
        return saldo / 100.0;
    }

    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof CuentaBancaria)) return false;

        CuentaBancaria otra = (CuentaBancaria) obj;
        return this.saldo == otra.saldo;
    }

    public CuentaBancaria clone() {
        return new CuentaBancaria(this.saldo / 100, this.descubierto / 100);
    }

    private int conversionCents(double euros) {
        return (int) Math.round(euros * 100);
    }

    public void ingresarCajero(int ingresarSaldo) {
        if (ingresarSaldo > 0) {
            saldo = saldo + conversionCents(ingresarSaldo);
        }
    }

    public void extraerCajero(int extraerSaldo) {
        if (conversionCents(extraerSaldo) > saldo) {
            throw new RuntimeException("Saldo insuficiente");
        }

        saldo = saldo - conversionCents(extraerSaldo);
    }

    public void cargarRecibo(double importeRecibo) {
        int saldoFinal = saldo - conversionCents(importeRecibo);

        if (saldoFinal < -descubierto) {
            throw new RuntimeException("Descubierto máximo superado");
        }

        saldo = saldoFinal;
    }
}
