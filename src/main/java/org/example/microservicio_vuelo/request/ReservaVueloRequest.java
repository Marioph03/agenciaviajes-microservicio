package org.example.microservicio_vuelo.request;

public class ReservaVueloRequest {
    private Long vueloId;
    private int plazasSolicitadas;

    // Getters y Setters

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }

    public int getPlazasSolicitadas() {
        return plazasSolicitadas;
    }

    public void setPlazasSolicitadas(int plazasSolicitadas) {
        this.plazasSolicitadas = plazasSolicitadas;
    }
}