package br.com.senac.cenaflix.persistecia;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {

    private static final String PERSISTENCE_UNIT = "Cenaflix-PU";
    private static EntityManager en;
    private static EntityManagerFactory fabrica;

    /**
     * Método que faz a persistência dos dados se a conexão estiver fechada
     *
     * @return as entidades mapeadas e os dados do banco
     */
    public static EntityManager getEntityManager() {
        if (fabrica == null || !fabrica.isOpen()) {
            fabrica = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }

        if (en == null || !en.isOpen()) {
            en = fabrica.createEntityManager();
        }

        return en;
    }

    /**
     * Método que fecha a conexão com as entidades e o banco
     *
     */
    public static void closeEntityManager() {
        if (en.isOpen() && en != null) {
            en.close();
            fabrica.close();
        }
    }

}

/**
 * Classe de persistência dos dados
 *
 * @author Jhon
 * @version 1.0
 * @since Primeira versão
 */
