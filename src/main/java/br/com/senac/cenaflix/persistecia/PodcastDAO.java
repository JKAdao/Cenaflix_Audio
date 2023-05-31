package br.com.senac.cenaflix.persistecia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.List;

public class PodcastDAO {

    /**
     * Método que recebe como parâmetro um objeto Podcast e salva ele no banco
     *
     * @param p
     */
    public void cadastrarPodcast(Podcast p) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    /**
     * Método que recebe como parâmetro um produtor e filtra na Jtable
     *
     * @param filtroProdutor
     * @return uma lista de filmes populada com dados resgatados do banco de
     * dados
     */
    public List<Podcast> listarPodcast(String filtroProdutor) {
        EntityManager em = JPAUtil.getEntityManager();
        List podcasts = null;
        try {
            String textoQuery = "SELECT p FROM Podcast p WHERE p.produtor LIKE :produtor";

            Query consulta = em.createQuery(textoQuery);

            consulta.setParameter("produtor", "%" + filtroProdutor + "%");

            podcasts = consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
        return podcasts;
    }

    /**
     * Método que recebe como parâmetro um id e exclui os dados relacionados e
     * atualiza a Jtable
     *
     * @param id
     */
    public void excluirPodcast(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            Podcast d = em.find(Podcast.class, id);
            if (d != null) {
                em.getTransaction().begin();
                em.remove(d);
                em.getTransaction().commit();
            }
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

}

/**
 * Classe Data Access Object de Podcasts
 *
 * @author Jhon
 * @version 1.0
 * @since Primeira versão
 */
