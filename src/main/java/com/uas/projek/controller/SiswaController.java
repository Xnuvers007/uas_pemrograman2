package com.uas.projek.controller;

import com.uas.projek.entity.Siswa;
import com.uas.projek.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.sql.Date;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/siswa")
public class SiswaController {

    @Autowired
    private SiswaService siswaService;

    @GetMapping
    public List<Siswa> getAllSiswa() {
        List<Siswa> siswaList = siswaService.findAll();
        for (Siswa siswa : siswaList) {
            siswa.setFotoBase64(convertFotoToBase64(siswa.getFoto()));
        }
        return siswaList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Siswa> getSiswaById(@PathVariable Long id) {
        Optional<Siswa> siswaOptional = siswaService.findById(id);
        if (siswaOptional.isPresent()) {
            Siswa siswa = siswaOptional.get();
            siswa.setFotoBase64(convertFotoToBase64(siswa.getFoto()));
            return ResponseEntity.ok(siswa);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Siswa createSiswa(
            @RequestParam("id_ta") int idTa,
            @RequestParam("nama_lengkap") String namaLengkap,
            @RequestParam("alamat") String alamat,
            @RequestParam("telp") String telp,
            @RequestParam("nama_ortu") String namaOrtu,
            @RequestParam("nisn") String nisn,
            @RequestParam("status") boolean status,
            @RequestParam("tanggal_lahir") Date tanggalLahir,
            @RequestParam("foto") MultipartFile foto) throws IOException, SQLException {
        Siswa siswa = new Siswa();
        siswa.setIdTa(idTa);
        siswa.setNamaLengkap(namaLengkap);
        siswa.setAlamat(alamat);
        siswa.setTelp(telp);
        siswa.setNamaOrtu(namaOrtu);
        siswa.setNisn(nisn);
        siswa.setStatus(status);
        siswa.setTanggalLahir(tanggalLahir);
        Blob fotoBlob = new javax.sql.rowset.serial.SerialBlob(foto.getBytes());
        siswa.setFoto(fotoBlob);
        return siswaService.save(siswa);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Siswa> updateSiswa(
            @PathVariable Long id,
            @RequestParam("id_ta") int idTa,
            @RequestParam("nama_lengkap") String namaLengkap,
            @RequestParam("alamat") String alamat,
            @RequestParam("telp") String telp,
            @RequestParam("nama_ortu") String namaOrtu,
            @RequestParam("nisn") String nisn,
            @RequestParam("status") boolean status,
            @RequestParam("tanggal_lahir") Date tanggalLahir,
            @RequestParam(value = "foto", required = false) MultipartFile foto) throws IOException, SQLException {
        Optional<Siswa> siswaOptional = siswaService.findById(id);
        if (!siswaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        Siswa siswa = siswaOptional.get();
        siswa.setIdTa(idTa);
        siswa.setNamaLengkap(namaLengkap);
        siswa.setAlamat(alamat);
        siswa.setTelp(telp);
        siswa.setNamaOrtu(namaOrtu);
        siswa.setNisn(nisn);
        siswa.setStatus(status);
        siswa.setTanggalLahir(tanggalLahir);
        if (foto != null && !foto.isEmpty()) {
            Blob fotoBlob = new javax.sql.rowset.serial.SerialBlob(foto.getBytes());
            siswa.setFoto(fotoBlob);
        }
        return ResponseEntity.ok(siswaService.save(siswa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSiswa(@PathVariable Long id) {
        siswaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // Metode untuk mengonversi Blob foto menjadi Base64
    private String convertFotoToBase64(Blob foto) {
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
}
