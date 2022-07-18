package exercicio2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Aluno");
        EntityManager em = emf.createEntityManager();
        Estado estadoParaAdicionar = new Estado("Sao Paulo", "SP");

        // JPQL
        String jpqlList = "SELECT a FROM Aluno where a.estado = :estado";
        List<Aluno> alunoJPQLList = em.createQuery(jpqlList, Aluno.class)
                .setParameter("estado", estadoParaAdicionar).
                getResultList();

        alunoJPQLList.forEach(Aluno -> System.out.println("Resultado da consulta: " + Aluno));

        // JPACriteriaAPI
        CriteriaQuery<Aluno> cql = em.getCriteriaBuilder().createQuery(Aluno.class);
        Root<Aluno> arl = cql.from(Aluno.class);
        List<Aluno> aACL = em.createQuery(cql).getResultList();

        aACL.forEach(Aluno -> System.out.println("Resultado da consulta: " + Aluno));

        em.close();
    }
}
