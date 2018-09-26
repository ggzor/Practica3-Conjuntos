public class Conjunto {
  private Object elementos[];

  public Conjunto(Object valores[]) {
    elementos = valores;
  }

  public boolean contiene(Object valor) {
    for (int i = 0; i < elementos.length; i++) {
      if (valor.equals(elementos[i])) {
        return true;
      }
    }

    return false;
  }

  public Conjunto agregar(Object valor) {
    if (!contiene(valor)) {
      Object temp[] = elementos;
      Object temp2[] = new Object[temp.length + 1];

      // Copiar elementos
      for (int i = 0; i < temp.length; i++) {
        temp2[i] = temp[i];
      }

      // Agregar nuevo elemento
      temp2[temp2.length - 1] = valor;
      return new Conjunto(temp2);
    }

    return new Conjunto(elementos);
  }

  public Conjunto eliminar(Object valor) {
    if (contiene(valor)) {
      Object temp[] = elementos;
      Object temp2[] = new Object[temp.length - 1];

      // Copiar todos los elementos excepto el valor que queremos eliminar
      for (int i = 0, j = 0; i < temp.length; i++) {
        if (temp[i] != valor) {
          temp2[j] = temp[i];
          j++;
        }
      }

      return new Conjunto(temp2);
    }

    return new Conjunto(elementos);
  }

  public Conjunto diferencia(Conjunto b) {
    // Calcular diferencia
    Object temp[] = new Object[elementos.length];
    int j = 0;
    for (int i = 0; i < elementos.length; i++) {
      if (!b.contiene(elementos[i])) {
        temp[j] = elementos[i];
        j++;
      }
    }

    // Truncar arreglo
    Object temp2[] = new Object[j];
    for (int i = 0; i < elementos.length; i++) {
      temp2[i] = temp[i];
    }

    return new Conjunto(temp2);
  }

  private int menor(int a, int b) {
    return a < b ? a : b;
  }

  public Conjunto interseccion(Conjunto b) {
    int longitud = menor(elementos.length, b.elementos.length);

    // Calcular intersección
    Object temp[] = new Object[longitud];
    int k = 0;
    for (int i = 0; i < elementos.length; i++) {
      Object valor = elementos[i];
      if (b.contiene(valor)) {
        temp[k] = valor;
        k++;
      }
    }

    // Truncar arreglo
    Object temp2[] = new Object[k];
    for (int i = 0; i < k; i++) {
      temp2[i] = temp[i];
    }

    return new Conjunto(temp2);
  }

  public Conjunto union(Conjunto b) {
    int longitud = elementos.length + b.elementos.length;

    // Copiar elementos primer conjunto
    Object temp[] = new Object[longitud];
    for (int i = 0; i < elementos.length; i++) {
      temp[i] = elementos[i];
    }

    // Copiar elementos del segundo que no esten en el primero
    int desplazamiento = elementos.length;
    int j = 0;
    for (int i = 0; i < b.elementos.length; i++) {
      Object valor = b.elementos[i];
      if (!contiene(valor)) {
        temp[desplazamiento + j] = valor;
        j++;
      }
    }

    // Truncar arreglo
    Object temp2[] = new Object[desplazamiento + j];
    for (int i = 0; i < elementos.length; i++) {
      temp2[i] = temp[i];
    }

    return new Conjunto(temp2);
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
