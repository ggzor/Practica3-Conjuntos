public class App {
  public static void main(String[] args) {
    ConjuntoEntero A = new ConjuntoEntero(new int[] { 1, 3, 4 });
    ConjuntoEntero B = new ConjuntoEntero(new int[] { 3, 5, 6 });

    A.diferencia(B);
    A.mostrar();
  }
}
