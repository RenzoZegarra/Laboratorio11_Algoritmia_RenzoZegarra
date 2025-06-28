package hash;

public class HashC 
{
    private static class Element 
    {
        Register register; // Es el registro guardado
        boolean isAvailable; // Indica si la celda esta disponible

        public Element() {
            this.register = null;
            this.isAvailable = true;
        }
    }

    private Element[] table; // Arreglo de elementos de la tabla hash
    private int size; // Tamaño de la tabla

    public HashC(int size) 
    {
        this.size = size;
        this.table = new Element[size];
        for (int i = 0; i < size; i++) 
        {
            table[i] = new Element(); // Inicializar elementos vacíos
        }
    }

    // Metodo para calcular el indice a partir de la clave
    private int hash(int key) 
    {
        return key % size;
    }

    // Metodo para insertar un nuevo registro en la tabla
    public void insert(Register reg) 
    {
        int key = reg.getKey();
        int index = hash(key); //Posicion Base
        int originalIndex = index; //Evita el bucle infinito

        do 
        {
            Element element = table[index];

            // Inserta si está disponible o si es celda previamente eliminada
            if (element.isAvailable) 
            {
                element.register = reg;
                element.isAvailable = false; //Ahora se ocupo
                return;
            }

            index = (index + 1) % size; //Sondeo linea para la proxima celda
        } 
        while (index != originalIndex);

        System.out.println("Error: la tabla está llena. No se pudo insertar.");
    }

    // Metodo para buscar un registro en la tabla por su clave
    public Register search(int key) 
    {
        int index = hash(key);
        int originalIndex = index;

        do 
        {
            Element element = table[index];
            // Si encuentra la clave y la celda está ocupada
            if (!element.isAvailable && element.register.getKey() == key) 
            {
                return element.register;
            }

            // Si encuentra una celda vacía que nunca tuvo datos, la búsqueda termina
            if (element.register == null && element.isAvailable) 
            {
                // Si encontramos una celda vacía y disponible, no puede estar más adelante
                break;
            }

            index = (index + 1) % size;
        } 
        while (index != originalIndex); // Se detiene si da la vuelta completa

        return null; // No se encontró la clave
    }

    // Metodo para eliminar un registro de forma logica no fisica
    public void delete(int key) 
    {
        int index = hash(key);
        int originalIndex = index;

        do 
        {
            Element element = table[index];

            if (!element.isAvailable && element.register.getKey() == key) 
            {
                element.isAvailable = true;
                return;
            }

            if (element.register == null && element.isAvailable) 
            {
                break;
            }

            index = (index + 1) % size;
        } 
        while (index != originalIndex);
    }

    // Metodo para imprimir el estado actual de la tabla
    public void printTable() 
    {
        for (int i = 0; i < size; i++) 
        {
            Element element = table[i];
            System.out.print("Índice " + i + ": ");
            if (element.register != null && !element.isAvailable) 
            {
                System.out.println(element.register); //Muestra el dato
            } 
            else 
            {
                System.out.println("Vacío"); //Celda libre o eliminada
            }
        }
    }
}
