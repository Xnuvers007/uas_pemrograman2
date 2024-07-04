package com.uas.projek.controller;

import com.uas.projek.entity.MataPelajaran;
import com.uas.projek.service.MataPelajaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/matapelajaran")
public class MataPelajaranController {
    @Autowired
    private MataPelajaranService mataPelajaranService;

    @GetMapping
    public List<MataPelajaran> getAllMataPelajaran() {
        return mataPelajaranService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MataPelajaran> getMataPelajaranById(@PathVariable Long id) {
        Optional<MataPelajaran> mataPelajaran = mataPelajaranService.findById(id);
        return mataPelajaran.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MataPelajaran createMataPelajaran(@RequestBody MataPelajaran mataPelajaran) {
        return mataPelajaranService.save(mataPelajaran);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MataPelajaran> updateMataPelajaran(@PathVariable Long id, @RequestBody MataPelajaran mataPelajaran) {
        Optional<MataPelajaran> mataPelajaranOptional = mataPelajaranService.findById(id);
        if (!mataPelajaranOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        MataPelajaran mataPelajaranToUpdate = mataPelajaranOptional.get();
        mataPelajaranToUpdate.setKodeMapel(mataPelajaran.getKodeMapel());
        mataPelajaranToUpdate.setNamaMapel(mataPelajaran.getNamaMapel());
        mataPelajaranToUpdate.setTingkat(mataPelajaran.getTingkat());
        return ResponseEntity.ok(mataPelajaranService.save(mataPelajaranToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMataPelajaran(@PathVariable Long id) {
        mataPelajaranService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
