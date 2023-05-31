package br.com.senac.cenaflix.persistecia;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Podcast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String produtor;
    private String nomeep;
    private int numeroep;
    private Date duracao;
    private String url;

    /**
     * Métodos gets and setters
     *
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdutor() {
        return produtor;
    }

    public void setProdutor(String produtor) {
        this.produtor = produtor;
    }

    public String getNomeep() {
        return nomeep;
    }

    public void setNomeep(String nomeep) {
        this.nomeep = nomeep;
    }

    public int getNumeroep() {
        return numeroep;
    }

    public void setNumeroep(int numeroep) {
        this.numeroep = numeroep;
    }

    public Date getDuracao() {
        return duracao;
    }

    public void setDuracao(Date duracao) {
        this.duracao = duracao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
