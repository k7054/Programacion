void decirHola(int n) {
    for (int i = 1; i <= n; i++) {
        IO.println("Hola");
    }
}

void main() {
    int n = Integer.parseInt(IO.readln());
    decirHola(n);
}