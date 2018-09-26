public class App {
  public static void main(String[] args) {
    Conjunto A = new Conjunto(new Object[] {true, "Axel", "Axol", 7});
    Conjunto B = new Conjunto(new Object[] {false, true, "Sol", "Axol", 4});

    System.out.print("El conjunto A es: ");
    A.mostrar();

    System.out.print("El conjunto B es: ");
    B.mostrar();

    System.out.println("¿'3' pertenece a A?: " + A.contiene(3));
    System.out.println("¿'true' pertenece a A?: " + A.contiene(7));

    Conjunto interseccion = A.interseccion(B);
    System.out.print("A ∩ B: ");
    interseccion.mostrar();

    Conjunto union = A.union(B);
    System.out.print("A ∪ B: ");
    union.mostrar();

    Conjunto diferencia = A.diferencia(B);
    System.out.print("A - B: ");
    diferencia.mostrar();

    Conjunto C = A.agregar(false);
    System.out.print("'false' agregado a A: ");
    C.mostrar();

    Conjunto D = A.agregar("Axol");
    System.out.print("'Axol' agregado a A: ");
    D.mostrar();

    Conjunto E = B.eliminar(4);
    System.out.print("'4' eliminado de B: ");
    E.mostrar();

    Conjunto F = B.eliminar("Vacio");
    System.out.print("'Vacio' eliminado de B: ");
    F.mostrar();
  }
}
