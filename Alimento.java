
/**
 * Representa un alimento que cualquier ser humano puede consumir
 * Sera registrado mediante un programa de control de dieta
 */
public class Alimento
{
    //Nombre del alimento
    private String nombre;
    //Valores alimenticios del alimento
    private float proteinas, carbohidratos, grasas;

    /**
     * Nuevo alimento
     * Los valores numericos deben llevar una "F" al final si llevan decimales
     */
    public Alimento(String nombre, float proteinas, float carbohidratos, float grasas)
    {
        this.nombre = nombre;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
    }
    
    /**
     * Devuelve el nombre del alimento
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Devuelve las proteinas del alimento
     */
    public float getProteinas(){
        return proteinas;
    }
    
    /**
     * Devuelve los carbohidratos del alimento
     */
    public float getCarbohidratos(){
        return carbohidratos;
    }
    
    /**
     * Devuelve las grasas del alimento
     */
    public float getGrasas(){
        return grasas;
    }

    /**
     * Muestra los valores alimenticios del alimento
     */
    public void muestraDatos()
    {
        System.out.printf("%-35s%s", "Nombre:", nombre + "\n");
        System.out.printf("%-35s%s", "Proteinas por cada 100 gramos:", proteinas + "\n");
        System.out.printf("%-35s%s", "Carbohidratos por cada 100 gramos:", carbohidratos + "\n");
        System.out.printf("%-35s%s", "Grasas por cada 100 gramos:", grasas + "\n");
        System.out.printf("%-35s%s", "Calorias:", getCalorias() + "\n");
        System.out.printf("%-35s", "Componente/s mayoritario/s:");
        //Compara los macronutrientes para mostrar el mayoritario
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
        //Las proteinas y carbohidratos aportan 4 calorias por unidad
        //Las grasas aportan 9 calorias por unidad
        return ((proteinas * 4) + (carbohidratos * 4) + (grasas * 9));
    }
}