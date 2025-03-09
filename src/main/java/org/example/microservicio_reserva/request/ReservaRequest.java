package org.example.microservicio_reserva.request;

public class ReservaRequest {
    private Long vueloId;
    private Long hotelId;
    private String usuario;

    // Getters y Setters

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}