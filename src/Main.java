class Nodo { //Clase Nodo, me representa un nodo en la lista enlazada
    int dato; //Me va almacenar el valor del nodo
    Nodo siguiente; //Me apuntara al siguiente nodo de la lista

    public Nodo(int dato) { //Constructor para inicializar un nodo con un dato ya establecido
        this.dato = dato;
        this.siguiente = null; //En un principio el siguiente nodo sera nulo
    }
}

class ListaEnlazada { //Clase ListaEnlazada me representa la lista enlazada
    Nodo cabeza; //Apunta al primer nodo de mi lista

    public ListaEnlazada() { //Constructor para inicializar una lista enlazada vaci
        this.cabeza = null; //Al principio mi lista siempre estara vacia
    }

    // Método para imprimir la lista enlazada
    public void imprimirLista() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.dato + " "); //Imprime mi valor de nodo
            actual = actual.siguiente; //Mueve a mi siguiente nodo
        }
        System.out.println();
    }

    // Método para invertir la lista enlazada en el lugar
    public void invertirLista() {
        Nodo prev = null;
        Nodo actual = cabeza;
        Nodo siguiente = null;
        while (actual != null) {
            siguiente = actual.siguiente;
            actual.siguiente = prev;
            prev = actual;
            actual = siguiente;
        }
        cabeza = prev; //La cabeza de lista ahora apunta a mi ultimo nodo, es el nuevo
    }

    // Método para encontrar y devolver el elemento del medio de la lista enlazada
    public Nodo encontrarElementoMedio() {
        Nodo rapido = cabeza;
        Nodo lento = cabeza;
        while (rapido != null && rapido.siguiente != null) {
            rapido = rapido.siguiente.siguiente;
            lento = lento.siguiente;
        }
        return lento; //Mi nodo lento es el elemento de en medio
    }

    // Método para eliminar nodos duplicados de la lista enlazada
    public void eliminarDuplicados() {
        Nodo actual = cabeza;
        while (actual != null) {
            Nodo comparador = actual;
            while (comparador.siguiente != null) {
                if (comparador.siguiente.dato == actual.dato) {
                    comparador.siguiente = comparador.siguiente.siguiente; //Elimina nodo duplicado
                } else {
                    comparador = comparador.siguiente;
                }
            }
            actual = actual.siguiente; //Mueve a mi siguiente nodo
        }
    }
}

public class Main {

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();

        lista.cabeza = new Nodo(1); //Creo mi lista enlazada
        lista.cabeza.siguiente = new Nodo(2);
        lista.cabeza.siguiente.siguiente = new Nodo(3);
        lista.cabeza.siguiente.siguiente.siguiente = new Nodo(2);
        lista.cabeza.siguiente.siguiente.siguiente.siguiente = new Nodo(4);
        lista.cabeza.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo(4);
        lista.cabeza.siguiente.siguiente.siguiente.siguiente.siguiente.siguiente = new Nodo(5);

        System.out.println("Lista original:");
        lista.imprimirLista();

        System.out.println("Lista invertida:");
        lista.invertirLista();
        lista.imprimirLista();

        Nodo elementoMedio = lista.encontrarElementoMedio();
        System.out.println("Elemento del medio: " + elementoMedio.dato);

        System.out.println("Lista sin duplicados:");
        lista.eliminarDuplicados();
        lista.imprimirLista();
    }
}
