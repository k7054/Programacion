void main() {
    IO.println("COMPARAR DOS ARRAYS");

    IO.println("Comparación ints");

    int[] arrayA = {7, 24, 8, 36, 95};
    int[] arrayB = {17, 23, 8, 21, 56};

    int limiteAB = Math.min(arrayA.length, arrayB.length);

    for (int i = 0; i < limiteAB; i++) {
        int numA = arrayA[i];
        int numB = arrayB[i];

        if (numA > numB) IO.println(String.format("Posición %d, el mayor es %d.", i, numA));
        if (numA < numB) IO.println(String.format("Posición %d, el mayor es %d.", i, numB));
        if (numA == numB) IO.println(String.format("Posición %d, son iguales.", i));
    }

    int[] arrayMayorInt;

    if (arrayA.length > arrayB.length) {
        arrayMayorInt = arrayA;
        for (int i = limiteAB; i < arrayMayorInt.length; i++) {
            IO.println(String.format("ArrayA, posición %d, valor %d.", i, arrayMayorInt[i]));
        }
    } else {
        arrayMayorInt = arrayB;
        for (int i = limiteAB; i < arrayMayorInt.length; i++) {
            IO.println(String.format("ArrayB, posición %d, valor %d.", i, arrayMayorInt[i]));
        }
    }

    IO.println("\nComparación doubles");

    double[] arrayC = {11.36, 0.0, 1.184, -3.98, 1495739.2};
    double[] arrayD = {17.56, 23.34, 8, 21.2, 56.43586};

    int limiteCD = Math.min(arrayC.length, arrayD.length);

    for (int i = 0; i < limiteCD; i++) {
        double numC = arrayC[i];
        double numD = arrayD[i];

        if (numC > numD) IO.println(String.format("Posición %d, el mayor es %.4f.", i, numC));
        if (numC < numD) IO.println(String.format("Posición %d, el mayor es %.4f.", i, numD));
        if (numC == numD) IO.println(String.format("Posición %d, son iguales.", i));
    }

    double[] arrayMayorDouble;

    if (arrayC.length > arrayD.length) {
        arrayMayorDouble = arrayC;
        for (int i = limiteCD; i < arrayMayorDouble.length; i++) {
            IO.println(String.format("ArrayC, posición %d, valor %.4f.", i, arrayMayorDouble[i]));
        }
    } else {
        arrayMayorDouble = arrayD;
        for (int i = limiteCD; i < arrayMayorDouble.length; i++) {
            IO.println(String.format("ArrayD, posición %d, valor %.4f.", i, arrayMayorDouble[i]));
        }
    }


    IO.println("\nComparación booleans");

    boolean[] arrayE = {false, false, true, false, true};
    boolean[] arrayF = {true, false, false, true, true};

    int limiteEF = Math.min(arrayE.length, arrayF.length);

    for (int i = 0; i < limiteEF; i++) {
        boolean indicadorE = arrayE[i];
        boolean indicadorF = arrayF[i];

        if (indicadorE == indicadorF) IO.println(String.format("Posición %d, son iguales", i));
        else                          IO.println(String.format("Posición %d, no son iguales", i));
    }

    boolean[] arrayMayorBoolean;

    if (arrayA.length > arrayB.length) {
        arrayMayorBoolean = arrayE;
        for (int i = limiteEF; i < arrayMayorBoolean.length; i++) {
            IO.println(String.format("ArrayE posición %d valor %b", i, arrayMayorBoolean[i]));
        }
    } else {
        arrayMayorBoolean = arrayF;
        for (int i = limiteEF; i < arrayMayorBoolean.length; i++) {
            IO.println(String.format("ArrayF posición %d valor %b", i, arrayMayorBoolean[i]));
        }
    }
}