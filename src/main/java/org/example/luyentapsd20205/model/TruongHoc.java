package org.example.luyentapsd20205.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TruongHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ten_truong;

    @OneToMany(mappedBy = "truong_hoc", cascade = CascadeType.ALL, orphanRemoval = true)
    List<HocSinh> hoc_sinh;
}
