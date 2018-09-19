public class ConjuntoEntero {
  private int elementos[];

  public ConjuntoEntero(int valores[]) {
    elementos = valores;
  }

  public void agregar(int valor) {
    if (!contiene(valor)) {
      int temp[] = elementos;
      elementos = new int[temp.length + 1];

      // Copiar elementos
      for (int i = 0; i < temp.length; i++) {
        elementos[i] = temp[i];
      }

      elementos[elementos.length - 1] = valor;
    }
  }

  public boolean eliminar(int valor) {
    if (contiene(valor)) {
      int temp[] = elementos;
      elementos = new int[temp.length - 1];

      for (int i = 0, j = 0; i < temp.length; i++) {
        if (temp[i] != valor) {
          elementos[j] = temp[i];
          j++;
        }
      }

      return true;
    }

    return false;
  }

  public void diferencia(ConjuntoEntero b) {
    int temp[] = new int[elementos.length];
    int j = 0;
    for (int i = 0; i < elementos.length; i++) {
      if(!b.contiene(elementos[i])) {
        temp[j] = elementos[i];
        j++;
      }      
    }

    elementos = new int[j];

    for (int i = 0; i < elementos.length; i++) {
      elementos[i] = temp[i];
    }
  }

  public boolean contiene(int valor) {
    for (int i = 0; i < elementos.length; i++) {
      if (valor == elementos[i]) {
        return true;
      }
    }

    return false;
  }

  public void mostrar() {
    System.out.print("{ ");
    for (int i = 0; i < elementos.length; i++) {
      if (i + 1 == elementos.length) {
        System.out.print(elementos[i]);
      } else {
        System.out.print(elementos[i] + ", ");
      }
    }
    System.out.println(" }");
  }
}
