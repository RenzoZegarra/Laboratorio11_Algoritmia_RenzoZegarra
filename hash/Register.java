package hash;

public class Register
{
    private int key; //Clave que será el indice de la tabla
    private String name; //Nombre del registro

    //Constructor
    public Register(int key, String name)
    {
        this.key = key;
        this.name = name;
    }

    public int getKey() 
    {
        return key;
    }

    public String getName()
    {
        return name;
    }

    //Representación en texto del objeto
    public String toString()
    {
        return "()"+key+", "+name + ")";
    }
}
