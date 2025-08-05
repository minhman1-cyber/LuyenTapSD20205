package org.example.luyentapsd20205.service;

import org.example.luyentapsd20205.model.TruongHoc;
import org.example.luyentapsd20205.repository.TruongHocRepo;

import java.util.List;

public class TruongHocService {
    private TruongHocRepo repo = new TruongHocRepo();

    public List<TruongHoc> getAllTruongHoc() {
        return repo.getAllTruongHoc();
    }

    public TruongHoc getTruongHocById(int id) {
        return repo.getTruongHocById(id);
    }
}
