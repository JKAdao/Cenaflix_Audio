package br.com.senac.cenaflix.usuario;

import br.com.senac.cenaflix.persistecia.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    /**
     * Método que recebe como parâmetro um objeto Usuario e registra ele no
     * banco
     *
     * @param u
     */
    public void registrarUsuario(Usuario u) {
        EntityManager en = JPAUtil.getEntityManager();
        try {
            en.getTransaction().begin();
            en.persist(u);
            en.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso");
        } catch (HeadlessException e) {
            en.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    /**
     * Método que válida o login e a senha do úsuario
     *
     *
     * @param usuario
     * @param senha
     * @return Um úsuario com os dados registrados no banco de dados
     */
    public Usuario validarUsuario(String usuario, String senha) {
        Usuario userEncontrado = null;
        EntityManager en = JPAUtil.getEntityManager();
        try {
            TypedQuery<Usuario> buscarUsuario = en.createQuery("SELECT u FROM Usuario u WHERE u.login = :loginPar AND u.senha = :senhaPar", Usuario.class);
            buscarUsuario.setParameter("loginPar", usuario);
            buscarUsuario.setParameter("senhaPar", senha);

            if (usuario.equals(buscarUsuario.getSingleResult().getLogin()) && senha.equals(buscarUsuario.getSingleResult().getSenha())) {
                userEncontrado = buscarUsuario.getSingleResult();
            }
        } catch (Exception e) {
            System.out.println("Erro na validação " + e.getMessage());
        }
        return userEncontrado;

    }

}

/**
 * Classe Data Access Object de úsuarios
 *
 * @author Jhon
 * @version 1.0
 * @since Primeira versão
 */
