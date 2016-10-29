package modelo;

public class Hilera {

    private CH_SList lista;
    private char a = ')';
    private int longitud;

    public Hilera(String cadena) {

        lista = convertirLista(cadena);
        longitud = (int) lista.headNode().getData();
    }

    public CH_SList convertirLista(String cadena) {

        CH_SList h = new CH_SList();
        int i = 1;
        int j = 1;

        String puntuacion = "(,;.:¡!¿?)";
        while (cadena.charAt(i) != a) {
            boolean insertar = true;
            while (puntuacion.charAt(j) != a && insertar == true) {
                if (cadena.charAt(i) == puntuacion.charAt(j)) {
                    insertar = false;
                }
                j++;
            }
            if (insertar == true) {
                h.insert(cadena.charAt(i), h.lastNode());
            }
            j = 1;
            i++;
        }
        return h;
    }

    public void imprimir() {
        lista.printData();
    }

    public void agregar(String cadena, int pos) {
        int i = 1;
        int j = 1;
        String puntuacion = "(,;.:¡!¿?)";
        while (cadena.charAt(i) != a) {
            boolean insertar = true;
            while (puntuacion.charAt(j) != a && insertar == true) {
                if (cadena.charAt(i) == puntuacion.charAt(j)) {
                    insertar = false;
                }
                j++;
            }
            if (insertar == true) {
                if (pos == 1) {
                    lista.insert(cadena.charAt(i), lista.headNode());
                } else {
                    lista.insert(cadena.charAt(i), lista.nodeAt(pos - 1));
                }
            }
            j = 1;
            pos = pos + 1;
            i++;
        }
    }

    public void eliminar(int x, int y) {
        if (x > 0 && y <= (int) lista.headNode().getData() + 1) {
            for (int i = 0; i < y - x + 1; i++) {
                lista.delete(lista.nodeAt(x), lista.nodeAt(x - 1));
            }
        }
    }

    public int longitud(String cadena) {
        CH_SList h = convertirLista(cadena);
        return (int) h.headNode().getData();
    }

    public boolean palindrome() {
        SNode p, q;
        return true;
    }

    public void reemplazar(String cadena, int pos) {
        if (pos != 0) {
            if (longitud(cadena) > longitud - pos) {
                eliminar(pos, longitud);
                agregar(cadena, pos);
            } else {
                eliminar(pos, pos + longitud(cadena) - 1);
                agregar(cadena, pos);
            }
        }

    }

    public void reversar() {
        lista.reverse();
    }

    public void alfabetico() {

        lista = lista.alphabet();
    }

    public boolean anagramas(String cadena) {
        CH_SList h, w;
        h = convertirLista(cadena);
        w = lista.copiar();
        h = h.alphabet();
        w = w.alphabet();
        return w.equals(h);
    }


}
