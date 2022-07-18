package exercicio1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aluno");
        EntityManager em = emf.createEntityManager();

        Estado estadoParaAdicionar = new Estado("Parana", "PR");
        Aluno alunoParaAdicionar = new Aluno("Sergio", 40, estadoParaAdicionar);

        em.getTransaction().begin();

        em.persist(estadoParaAdicionar);
        em.persist(alunoParaAdicionar);

        em.getTransaction().commit();
        em.close();
    }
}
