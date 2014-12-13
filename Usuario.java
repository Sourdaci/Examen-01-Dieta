import java.util.ArrayList;
/**
 * Programa sencillo para llevar el control de dietas de una persona
 */
public class Usuario
{
    // Nombre del usuario que utiliza esta aplicacion
    private String nombre;
    // Ingestas de macronutrientes realizadas por el usuario
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
     * Devuelve el nombre del usuario de la aplicacion
     */
    public String getNombre(){
        return nombre;
    }

    /**
     * El Usuario ingiere una cantidad determinada en gramos de un alimento
     */
    public void comer(Alimento manduca, float cantidad){
        //Los macronutrientes recibidos del alimento se contabilizan cada 100 gramos
        //Se deben calcular los macronutrientes consumidos dependiendo de los gramos ingeridos
        proteinas += aumentoMacronutriente(manduca.getProteinas(), cantidad);
        carbohidratos += aumentoMacronutriente(manduca.getCarbohidratos(), cantidad);
        grasas += aumentoMacronutriente(manduca.getGrasas(), cantidad);
        comparaCaloriasAlimento(manduca);
        consumo.add(manduca);
    }
    
    /**
     * Calcula las cantidades de macronutrientes ingeridos al tomar un alimento
     */
    private float aumentoMacronutriente(float nutriente, float cantidad){
        return (nutriente * (cantidad / 100.0F));
    }
    
    /**
     * Muestra el estado del Usuario
     */
    public void muestraEstado(){
        System.out.printf("%-35s%s", "Nombre: ", nombre + "\n");
        System.out.printf("%-35s%s", "Gramos de proteinas ingeridos: ", proteinas);
        if(proteinas != 0){
            System.out.print(" (" + nutriPor(proteinas) + "%)");
        }
        System.out.printf("%-36s%s", "\nGramos de carbohidratos ingeridos: ", carbohidratos);
        if(carbohidratos != 0){
            System.out.print(" (" + nutriPor(carbohidratos) + "%)");
        }
        System.out.printf("%-36s%s", "\nGramos de grasas ingeridos: ", grasas);
        if(grasas != 0){
            System.out.print(" (" + nutriPor(grasas) + "%)");
        }
        System.out.printf("%-36s%s", "\nCalorias ingeridas: ", caloriasIngeridas() + "\n");
    }
    
    /**
     * Calcula las calorias ingeridas en total por el usuario
     */
    public float caloriasIngeridas(){
        return ((proteinas * 4) + (carbohidratos * 4) + (grasas * 9));
    }
    
    /**
     * Calcula porcentajes de macronutrientes consumidos para muestraEstado()
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
