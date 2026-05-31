package model;

public class Investigador {
    private String idInvestigador;
    private String nombre;
    private String especialidad;

    public Investigador(String idInvestigador, String nombre, String especialidad) {
        this.idInvestigador = idInvestigador;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }

    public String getIdInvestigador() { return idInvestigador; }
    public String getNombre() { return nombre; }
    public String getEspecialidad() { return especialidad; }

    public String toCSV() {
        return String.format("INVESTIGADOR,%s,%s,%s", idInvestigador, nombre, especialidad);
    }
}