package study;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("playground");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

            Movie movie = new Movie();
            movie.setMovieId(1L);
            movie.setMovieName("타이타닉");

            em.persist(movie);
            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
