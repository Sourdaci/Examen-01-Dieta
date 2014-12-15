
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
        System.out.printf("%-35s%s", "Componente/s mayoritario/s:", mayoritario());
    }
    
    /**
     * Devuelve el macronutriente mayoritario del Alimento
     */
    private String mayoritario(){
        String mayoritario = "Proteinas, Carbohidratos y Grasas";
        if (proteinas > carbohidratos && proteinas > grasas){
            mayoritario = "Proteinas";
        }else if (carbohidratos > proteinas && carbohidratos > grasas){
             mayoritario = "Carbohidratos";  
        }else if (grasas > proteinas && grasas > carbohidratos){
             mayoritario = "Grasas";  
        }else if (grasas == proteinas && grasas > carbohidratos){
             mayoritario = "Proteinas y Grasas";  
        }else if (carbohidratos == proteinas && grasas < carbohidratos){
             mayoritario = "Proteinas y Carbohidratos";  
        }else if (carbohidratos == grasas && grasas > proteinas){
             mayoritario = "Carbohidratos y Grasas";  
        }
        return mayoritario;
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