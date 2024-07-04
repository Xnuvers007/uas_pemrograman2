package com.uas.projek.controller;

import com.uas.projek.entity.JadwalPelajaran;
import com.uas.projek.service.JadwalPelajaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jadwalpelajaran")
public class JadwalPelajaranController {
    @Autowired
    private JadwalPelajaranService jadwalPelajaranService;

    @GetMapping
    public List<JadwalPelajaran> getAllJadwalPelajaran() {
        return jadwalPelajaranService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> getJadwalPelajaranById(@PathVariable Long id) {
        Optional<JadwalPelajaran> jadwalPelajaran = jadwalPelajaranService.findById(id);
        return jadwalPelajaran.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public JadwalPelajaran createJadwalPelajaran(@RequestBody JadwalPelajaran jadwalPelajaran) {
        return jadwalPelajaranService.save(jadwalPelajaran);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JadwalPelajaran> updateJadwalPelajaran(@PathVariable Long id, @RequestBody JadwalPelajaran jadwalPelajaran) {
        Optional<JadwalPelajaran> jadwalPelajaranOptional = jadwalPelajaranService.findById(id);
        if (!jadwalPelajaranOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        JadwalPelajaran jadwalPelajaranToUpdate = jadwalPelajaranOptional.get();
        jadwalPelajaranToUpdate.setHari(jadwalPelajaran.getHari());
        jadwalPelajaranToUpdate.setIdGuru(jadwalPelajaran.getIdGuru());
        jadwalPelajaranToUpdate.setIdKelas(jadwalPelajaran.getIdKelas());
        jadwalPelajaranToUpdate.setMataPelajaran(jadwalPelajaran.getMataPelajaran());
        jadwalPelajaranToUpdate.setSiswa(jadwalPelajaran.getSiswa());
        jadwalPelajaranToUpdate.setJamMulai(jadwalPelajaran.getJamMulai());
        jadwalPelajaranToUpdate.setJamSelesai(jadwalPelajaran.getJamSelesai());
        return ResponseEntity.ok(jadwalPelajaranService.save(jadwalPelajaranToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJadwalPelajaran(@PathVariable Long id) {
        jadwalPelajaranService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
