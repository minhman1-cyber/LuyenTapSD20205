package org.example.luyentapsd20205.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HocSinh {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String ten_hoc_sinh;

    private int tuoi;

    private boolean dang_hoc;

    @ManyToOne
    private TruongHoc truong_hoc;

}
