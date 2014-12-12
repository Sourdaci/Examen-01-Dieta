
/**
 * Write a description of class Usuario here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Usuario
{
    // Nombre del usuario que utiliza esta aplicacion
    private String nombre;
    // Ingestas realizadas por el usuario
    private float proteinas, carbohidratos, grasas;

    /**
     * Nuevo Usuario de la aplicacion
     */
    public Usuario(String nombre)
    {
        this.nombre = nombre;
        proteinas = 0.0F;
        carbohidratos = 0.0F;
        grasas = 0.0F;
    }
    
    /**
     * Devuelve el nombre del usuario
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * El Usuario ingiere una cantidad determinada de un alimento
     * Primero toma el alimento, luego los gramos que desea
     */
    public void comer(Alimento manduca, float cantidad){
        proteinas += (manduca.getProteinas() * (cantidad / 100.0F));
        carbohidratos += (manduca.getCarbohidratos() * (cantidad / 100.0F));
        grasas += (manduca.getGrasas() * (cantidad / 100.0F));
    }
    
    /**
     * Muestra el estado del Usuario
     */
    public void muestraEstado(){
        if(proteinas != 0 || carbohidratos != 0 || grasas != 0){
            System.out.println("Nombre: " + nombre);
            System.out.println("Gramos de proteinas ingeridos: " + proteinas + " (" + nutriPor(proteinas) + "%)");
            System.out.println("Gramos de carbohidratos ingeridos: " + carbohidratos + " (" + nutriPor(carbohidratos) + "%)");
            System.out.println("Gramos de grasas ingeridos: " + grasas + " (" + nutriPor(grasas) + "%)");
            System.out.println("Calorias ingeridas: " + caloriasIngeridas());
        }else{
            System.out.println("Nombre: " + nombre);
            System.out.println("Gramos de proteinas ingeridos: " + proteinas);
            System.out.println("Gramos de carbohidratos ingeridos: " + carbohidratos);
            System.out.println("Gramos de grasas ingeridos: " + grasas);
            System.out.println("Calorias ingeridas: " + caloriasIngeridas());
        }
    }
    
    /**
     * Calcula las calorias ingeridas
     */
    public float caloriasIngeridas(){
        return ((proteinas * 4) + (carbohidratos * 4) + (grasas * 9));
    }
    
    /**
     * Calcula porcentajes para muestraEstado()
     */
    private float nutriPor(float nutriente){
        float total = proteinas + carbohidratos + grasas;
        return ((nutriente / total) * 100);
    }
    
    /**
     * Compara dos usuarios para saber quien ha ingerido mas calorias
     */
    public void comparaCalorias(Usuario comparar){
        float misCalorias = caloriasIngeridas();
        float otrasCalorias = comparar.caloriasIngeridas();
        if(misCalorias > otrasCalorias){
            System.out.println(nombre + " ha consumido mas calorias que " + comparar.getNombre());
        }else if(misCalorias < otrasCalorias){
            System.out.println(comparar.getNombre() + " ha consumido mas calorias que " + nombre);
        }else{
            System.out.println(nombre + " y " + comparar.getNombre() + " han consumido la misma cantidad de calorias");
        }
    }
}
