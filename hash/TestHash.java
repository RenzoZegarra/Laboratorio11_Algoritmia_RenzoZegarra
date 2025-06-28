package hash;

public class TestHash 
{
    public static void main(String[] args) 
    {
        HashC hashTable = new HashC(11);
        
        hashTable.insert(new Register(34, "34"));
        hashTable.insert(new Register(3, "3"));
        hashTable.insert(new Register(7, "7")); 
        hashTable.insert(new Register(30, "30"));
        hashTable.insert(new Register(11, "11"));
        hashTable.insert(new Register(8, "8"));
        hashTable.insert(new Register(7, "7"));
        hashTable.insert(new Register(23, "23"));
        hashTable.insert(new Register(41, "41"));
        hashTable.insert(new Register(16, "16"));
        hashTable.insert(new Register(34, "34"));

        hashTable.printTable();

        System.out.println("\nBuscando clave 23:");
        System.out.println(hashTable.search(23));

        System.out.println("\nEliminando clave 30");
        hashTable.delete(30);
        hashTable.printTable();

        System.out.println("\nBuscando clave 23:");
        System.out.println(hashTable.search(23));

        System.out.println("--------------------------");
        
        HashC hashTable2 = new HashC(5);

        // Insertar registros con colisiones
        hashTable2.insert(new Register(0, "A"));   // Índice 0
        hashTable2.insert(new Register(5, "B"));   // Colisión, debe ir a índice 1
        hashTable2.insert(new Register(10, "C"));  // Otra colisión, debe ir a índice 2

        // Mostrar tabla
        System.out.println("Estado de la tabla hash con colisiones:");
        hashTable2.printTable();

        // Buscar claves
        System.out.println("\nBuscando clave 5: " + hashTable2.search(5));
        System.out.println("Buscando clave 10: " + hashTable2.search(10));
    }
}
