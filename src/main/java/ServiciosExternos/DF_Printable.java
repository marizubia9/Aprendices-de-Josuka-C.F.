/**
 * @package ServiciosExternos
 * @brief Clases para hacer posible la conexión con la raspberry y el parseo de la información
 */
package ServiciosExternos;
/**
 * Interfaz con método print que será implementado por Partidos_parameters y Sanciones_parameters para visualizar el contenido de las listas
 * @author Alumno
 *
 */
public interface DF_Printable
{
    // Force classes to have a print method
    void print();
}
