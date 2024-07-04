package com.uas.projek.controller;

import com.uas.projek.entity.PrestasiAkademik;
import com.uas.projek.service.PrestasiAkademikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/prestasiakademik")
public class PrestasiAkademikController {
    @Autowired
    private PrestasiAkademikService prestasiAkademikService;

    @GetMapping
    public List<PrestasiAkademik> getAllPrestasiAkademik() {
        return prestasiAkademikService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PrestasiAkademik> getPrestasiAkademikById(@PathVariable Long id) {
        Optional<PrestasiAkademik> prestasiAkademik = prestasiAkademikService.findById(id);
        return prestasiAkademik.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public PrestasiAkademik createPrestasiAkademik(@RequestBody PrestasiAkademik prestasiAkademik) {
        return prestasiAkademikService.save(prestasiAkademik);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PrestasiAkademik> updatePrestasiAkademik(@PathVariable Long id, @RequestBody PrestasiAkademik prestasiAkademik) {
        Optional<PrestasiAkademik> prestasiAkademikOptional = prestasiAkademikService.findById(id);
        if (!prestasiAkademikOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        PrestasiAkademik prestasiAkademikToUpdate = prestasiAkademikOptional.get();
        prestasiAkademikToUpdate.setDeskripsiAtauNilai(prestasiAkademik.getDeskripsiAtauNilai());
        prestasiAkademikToUpdate.setMataPelajaran(prestasiAkademik.getMataPelajaran());
        prestasiAkademikToUpdate.setSiswa(prestasiAkademik.getSiswa());
        prestasiAkademikToUpdate.setJenisPrestasi(prestasiAkademik.getJenisPrestasi());
        prestasiAkademikToUpdate.setTanggal(prestasiAkademik.getTanggal());
        return ResponseEntity.ok(prestasiAkademikService.save(prestasiAkademikToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrestasiAkademik(@PathVariable Long id) {
        prestasiAkademikService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
