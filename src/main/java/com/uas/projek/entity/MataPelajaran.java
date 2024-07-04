package com.uas.projek.entity;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
public class MataPelajaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kodeMapel;
    private String namaMapel;
    private String tingkat;
}