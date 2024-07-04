package com.uas.projek.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.sql.Date;

@Data
@Entity
public class PrestasiAkademik {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String deskripsiAtauNilai;
    
    @ManyToOne
    @JoinColumn(name = "id_mapel")
    private MataPelajaran mataPelajaran;

    @ManyToOne
    @JoinColumn(name = "id_siswa")
    private Siswa siswa;

    private String jenisPrestasi;
    private Date tanggal;
}
