package com.uas.projek.entity;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
public class JadwalPelajaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hari;
    private int idGuru;
    private int idKelas;

    @ManyToOne
    @JoinColumn(name = "id_mapel")
    private MataPelajaran mataPelajaran;

    @ManyToOne
    @JoinColumn(name = "id_siswa")
    private Siswa siswa;

    private String jamMulai;
    private String jamSelesai;
}
