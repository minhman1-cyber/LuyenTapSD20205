package org.example.luyentapsd20205.service;

import org.example.luyentapsd20205.model.HocSinh;
import org.example.luyentapsd20205.model.TaiKhoan;
import org.example.luyentapsd20205.repository.HocSinhRepo;

import java.util.List;

public class HocSinhService {
    private HocSinhRepo hocSinhRepo = new HocSinhRepo();

    public List<HocSinh> getAllHocSinh() {
        return hocSinhRepo.getAll();
    }

    public HocSinh getHocSinhById(int id) {
        return hocSinhRepo.getHocSinh(id);
    }

    public void them(HocSinh hocSinh) {
        hocSinhRepo.them(hocSinh);
    }

    public void sua(HocSinh hocSinh) {
        hocSinhRepo.sua(hocSinh);
    }

    public void xoa(int id) {
        hocSinhRepo.xoa(id);
    }

    public List<HocSinh> phanTrang(int page, int pageSize){
        return hocSinhRepo.phanTrang(page, pageSize);
    }

    public List<HocSinh> searching(int tuoi){
        return hocSinhRepo.searching(tuoi);
    }

    public Boolean xacThuc(String username, String password) {
        return hocSinhRepo.xacThuc(username, password);
    }

    public Boolean isAdminn(String username, String password) {

        return hocSinhRepo.isAdminn(username, password);
    }
}
