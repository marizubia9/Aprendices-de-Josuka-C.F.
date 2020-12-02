package ServiciosExternos;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Partidos_parameters implements DF_Printable
{
    private String equipo1_name;
    private String equipo2_name;
    private int res_e1;
    private int res_e2;
    private String date;

    public Partidos_parameters() {
    }


    public String getEquipo1_name() {
        return equipo1_name;
    }

    public void setEquipo1_name(String equipo1_name) {
        this.equipo1_name = equipo1_name;
    }

    public String getEquipo2_name() {
        return equipo2_name;
    }

    public void setEquipo2_name(String equipo2_name) {
        this.equipo2_name = equipo2_name;
    }

    public int getRes_e1() {
        return res_e1;
    }

    public void setRes_e1(int res_e1) {
        this.res_e1 = res_e1;
    }

    public int getRes_e2() {
        return res_e2;
    }

    public void setRes_e2(int res_e2) {
        this.res_e2 = res_e2;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public void print()
    {
        System.out.println(
                "Printing Partido_parameters" + "\n" +
                 "Equipo1_name: " + getEquipo1_name() + "\n" +
                 "Equipo2_name: " + getEquipo2_name() + "\n" +
                 "res_e1: " + getRes_e1()+ "\n" +
                 "res_e2: " + getRes_e2() + "\n" +
                 "Date: " + getDate() + "\n"
        );
    }
}
