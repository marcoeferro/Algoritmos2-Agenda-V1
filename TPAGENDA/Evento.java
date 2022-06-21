package TPAGENDA;
import java.time.LocalDate;
public class Evento extends Agenda {

    protected String horaInicioEvento, horaFinEvento;
    protected String lugarDelEvento;


    ///Constructor
    Evento (String nombre, String descripcion, LocalDate fecha){
        super(nombre,descripcion,fecha);
    }    
    public void setHoraInicio(String horaInicioEvento){
        this.horaInicioEvento=horaInicioEvento;
    }
    public void setHoraFin(String horaFinEvento){
        this.horaFinEvento=horaFinEvento;
    }
    public void setLugarDelEvento(String lugarDelEvento){
        this.lugarDelEvento=lugarDelEvento;
    }
}

