package br.com.gulliver.beans;

import java.time.LocalDate;

public class Avaliacao {

    private Integer codigo;
    private String mensagem;
    private LocalDate data;
    private Integer rate;
    private Usuario usuario;

    public Avaliacao() {}

    public Avaliacao(Integer codigo, String mensagem, LocalDate data, Integer rate, Usuario usuario) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.data = data;
        this.rate = rate;
        this.usuario = usuario;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Avaliacao {" +
                "mensagem='" + mensagem + '\'' +
                ", data=" + data +
                ", rate=" + rate +
                ", usuario=" + usuario.getNome() +
                '}';
    }
}
