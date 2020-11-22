package Aprendices_de_Josuka.ServiciosExternos;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Sanciones_parameters implements DF_Printable
{
    private String codigo;
    private String tipo;
    private String dni;
    private String cod_partido;

    public Sanciones_parameters() {
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCodPartido() {
        return cod_partido;
    }

    public void setCodPartido(String cod_partido) {
        this.cod_partido = cod_partido;
    }


    @Override
    public void print()
    {
        System.out.println(
                "Printing Sancion_parameters" + "\n" +
                 "cod: " + getCodigo() + "\n" +
                 "Tipo: " + getTipo() + "\n" +
                 "Dni: " + getDni()+ "\n" +
                 "Cod partido: " + getCodPartido() + "\n"
        );
    }
}
