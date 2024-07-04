package com.uas.projek.entity;

import lombok.Data;

import jakarta.persistence.*;
import java.sql.Blob;
import java.sql.Date;
import java.util.Base64; // import Base64
import java.sql.SQLException;

@Data
@Entity
public class Siswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int idTa;
    private String namaLengkap;
    private String alamat;
    private String telp;
    private String namaOrtu;
    private String nisn;
    private boolean status;
    private Date tanggalLahir;

    @Lob
    private Blob foto;

    @Transient // transient agar tidak disimpan dalam database
    private String fotoBase64; // tambahkan field untuk foto dalam format Base64

    // getter dan setter untuk fotoBase64
    public String getFotoBase64() {
        if (foto != null) {
            try {
                byte[] bytes = foto.getBytes(1, (int) foto.length());
                return Base64.getEncoder().encodeToString(bytes);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void setFotoBase64(String fotoBase64) {
        this.fotoBase64 = fotoBase64;
    }
}
