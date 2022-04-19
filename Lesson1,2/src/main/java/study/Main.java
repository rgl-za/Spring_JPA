package study;

import javax.persistence.*;

public class Main {
    public static void main(String[] args){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("playground");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try{
            tx.begin();

//            Movie movie = new Movie();
//            movie.setMovieId(2L);
//            movie.setMovieName("오징어게임");

//            em.persist(movie);


            Movie findMovie = em.find(Movie.class, 1L);
            System.out.println("findMovie = " + findMovie);

//            findMovie.setMovieName("로미오와줄리엣");

            em.remove(findMovie);

            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();
        }
    }
}
