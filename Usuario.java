import java.util.*;
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
    // Nombre del alimento mas calorico consumido
    private String masCalorico;
    // Calorias del alimento consumido mas calorico
    private float masCalorias;
    // Registro de alimentos consumidos por el usuario
    private ArrayList<Alimento> consumo;

    /**
     * Nuevo Usuario de la aplicacion
     */
    public Usuario(String nombre)
    {
        this.nombre = nombre;
        proteinas = 0.0F;
        carbohidratos = 0.0F;
        grasas = 0.0F;
        consumo = new ArrayList<Alimento>();
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
        comparaCaloriasAlimento(manduca);
        consumo.add(manduca);
    }
    
    /**
     * Muestra el estado del Usuario
     */
    public void muestraEstado(){
        System.out.println("Nombre: " + nombre);
            System.out.print("Gramos de proteinas ingeridos: " + proteinas);
            if(proteinas != 0){
                System.out.print(" (" + nutriPor(proteinas) + "%)");
            }
            System.out.print("\nGramos de carbohidratos ingeridos: " + carbohidratos);
            if(carbohidratos != 0){
                System.out.print(" (" + nutriPor(carbohidratos) + "%)");
            }
            System.out.print("\nGramos de grasas ingeridos: " + grasas);
            if(grasas != 0){
                System.out.print(" (" + nutriPor(grasas) + "%)");
            }
            System.out.println("\nCalorias ingeridas: " + caloriasIngeridas());
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
    
    /**
     * Muestra el alimento mas calorico consumido... si existe
     */
    public void conMasCalorias(){
        if(masCalorico != null){
            System.out.println("Alimento mas calorico ingerido por el usuario hasta el momento: " + masCalorico);
        }else{
            System.out.println("El usuario todavia no ha comido nada");
        }
    }
    
    /**
     * Compara el alimento comido con el almacenado para ver si tiene mas contenido calorico
     * Si lo tiene, lo almacena
     */
    private void comparaCaloriasAlimento(Alimento manduca){
        if(manduca.getCalorias() > masCalorias){
            masCalorias = manduca.getCalorias();
            masCalorico = manduca.getNombre();
        }
    }
    
    /**
     * Permite al usuario consultar el alimento que ha consumido segun su orden
     * Si introduce 1, vera el primer alimento consumido
     * Si introduce 2, vera el segundo alimento consumido
     * Y asi sucesivamente
     */
    public void consultaConsumo(int index){
        if(consumo.size() != 0){
            if(index >= 1 && index <= consumo.size()){
                consumo.get(index - 1).muestraDatos();
            }else{
                System.out.println("Registro invalido, registros validos de 1 a " + consumo.size());
            }
        }else{
            System.out.println("No ha ingerido ningun alimento todavia");
        }
    }
}
