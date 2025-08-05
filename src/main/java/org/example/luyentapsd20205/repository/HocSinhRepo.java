package org.example.luyentapsd20205.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.luyentapsd20205.model.HocSinh;
import org.example.luyentapsd20205.model.TaiKhoan;

import java.util.List;

public class HocSinhRepo {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
    private EntityManager em = emf.createEntityManager();

    public List<HocSinh> getAll() {
        return em.createQuery("select h from HocSinh h", HocSinh.class).getResultList();
    }

    public HocSinh getHocSinh(int id) {
        return em.find(HocSinh.class, id);
    }

    public void them(HocSinh hocSinh) {
        try{
            em.getTransaction().begin();
            em.persist(hocSinh);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void sua(HocSinh hocSinh) {
        try{
            em.getTransaction().begin();
            em.merge(hocSinh);
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void xoa(int id) {
        try{
            em.getTransaction().begin();
            em.remove(getHocSinh(id));
            em.getTransaction().commit();
        }catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public List<HocSinh> phanTrang(int page, int pageSize){
        return em.createQuery("select h from HocSinh h", HocSinh.class)
                .setFirstResult((page - 1) * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
    }

    public List<HocSinh> searching(int tuoi){
        return em.createQuery("select h from HocSinh h where h.tuoi = :tuoi", HocSinh.class)
                .setParameter("tuoi", tuoi)
                .getResultList();
    }

    public Boolean xacThuc(String username, String password) {
        List<TaiKhoan> li = em.createQuery("select tk from TaiKhoan tk where tk.name = :username and tk.password = :password", TaiKhoan.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        if(li.size() != 0){
            return true;
        }else{
            return false;
        }
    }

    public Boolean isAdminn(String username, String password) {
        TaiKhoan li = em.createQuery("select tk from TaiKhoan tk where tk.name = :username and tk.password = :password", TaiKhoan.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .getSingleResult();
        return li.isAdmin();
    }
}
