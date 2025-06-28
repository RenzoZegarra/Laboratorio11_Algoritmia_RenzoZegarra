package hash;
import java.util.LinkedList;

public class HashO 
{
    private LinkedList<Register>[] table;
    private int size;

    @SuppressWarnings("unchecked")
    public HashO(int size) 
    {
        this.size = size;
        this.table = new LinkedList[size];
        // Inicializar cada posición con una nueva lista enlazada vacía
        for (int i = 0; i < size; i++) 
        {
            table[i] = new LinkedList<>();
        }
    }

    private int hash(int key) 
    {
        // Calcular el índice hash usando key % size
        return key % size;
    }

    public void insert(Register reg) 
    {
        int index = hash(reg.getKey());
        table[index].add(reg); //Agrega al final de la lista
    }

    public Register search(int key) 
    {
        int index = hash(key);
        for (Register reg : table[index]) 
        {
            if (reg.getKey() == key) 
            {
                return reg; // Retorna si encuentra el registro
            }
        }
        return null; // No encontrado
    }

    public void delete(int key) 
    {
        int index = hash(key);
        LinkedList<Register> bucket = table[index];
        for (Register reg : bucket) 
        {
            if (reg.getKey() == key) 
            {
                bucket.remove(reg); // Eliminar el registro
                return;
            }
        }
    }

    // Método printTable que muestra el contenido de la tabla hash
    public void printTable() 
    {
        for (int i = 0; i < size; i++) 
        {
            System.out.print("Índice " + i + ": ");
            if (table[i].isEmpty()) 
            {
                System.out.println("Vacío");
            } 
            else 
            {
                for (Register reg : table[i]) 
                {
                    System.out.print(reg + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) 
    {
        HashO tabla = new HashO(5);

        tabla.insert(new Register(1, "A"));
        tabla.insert(new Register(6, "B"));  // colisión con 1
        tabla.insert(new Register(11, "C")); // colisión con 1 y 6

        tabla.printTable();

        System.out.println("\nBuscando clave 6: " + tabla.search(6));
        System.out.println("Eliminando clave 6.");
        tabla.delete(6);
        tabla.printTable();
    }
}
