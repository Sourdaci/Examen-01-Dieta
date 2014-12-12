
/**
 * Write a description of class Alimento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alimento
{
    //Nombre del alimento
    private String nombre;
    //Valores alimenticios del alimento
    private float proteinas, carbohidratos, grasas;

    /**
     * Nuevo alimento
     * Los valores numericos deben llevar una "F" al final
     */
    public Alimento(String nombre, float proteinas, float carbohidratos, float grasas)
    {
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
    }
    
    //Devuelve el nombre
    public String getNombre(){
        return nombre;
    }
    
    //Devuelve las proteinas
    public float getProteinas(){
        return proteinas;
    }
    
    //Devuelve los carbohidratos
    public float getCarbohidratos(){
        return carbohidratos;
    }
    
    //Devuelve las grasas
    public float getGrasas(){
        return grasas;
    }

    /**
     * Muestra los valores alimenticios del alimento
     */
    public void muestraDatos()
    {
        System.out.println("Nombre: " + nombre);
        System.out.println("Proteinas por cada 100 gramos: " + proteinas);
        System.out.println("Carbohidratos por cada 100 gramos: " + carbohidratos);
        System.out.println("Grasas por cada 100 gramos: " + grasas);
        System.out.println("Calorias: " + getCalorias());
        System.out.print("Componente/s mayoritario/s: ");
        if(proteinas > carbohidratos && proteinas > grasas){
            System.out.print("Proteinas\n");
        }else if(carbohidratos > proteinas && carbohidratos > grasas){
            System.out.print("Carbohidratos\n");
        }else if(grasas > proteinas && grasas > carbohidratos){
            System.out.print("Grasas\n");
        }else if(proteinas == carbohidratos && proteinas == grasas){
            System.out.print("Proteinas, Carbohidratos y Grasas\n");
        }else if(proteinas == carbohidratos && proteinas > grasas){
            System.out.print("Proteinas y Carbohidratos\n");
        }else if(proteinas == grasas && proteinas > carbohidratos){
            System.out.print("Proteinas y Grasas\n");
        }else{
            System.out.print("Carbohidratos y Grasas\n");
        }
    }
    
    /**
     * Calcula las calorias del alimento
     */
    public float getCalorias(){
        return ((proteinas * 4) + (carbohidratos * 4) + (grasas * 9));
    }
}