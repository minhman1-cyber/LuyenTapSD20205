package org.example.luyentapsd20205.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.luyentapsd20205.model.TruongHoc;

import java.util.List;

public class TruongHocRepo {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<TruongHoc> getAllTruongHoc() {
        return em.createQuery("select t from TruongHoc t", TruongHoc.class).getResultList();
    }

    public TruongHoc getTruongHocById(int id) {
        return em.find(TruongHoc.class, id);
    }
}
