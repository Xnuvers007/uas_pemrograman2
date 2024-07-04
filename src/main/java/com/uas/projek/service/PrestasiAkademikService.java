package com.uas.projek.service;

import com.uas.projek.entity.PrestasiAkademik;
import com.uas.projek.repository.PrestasiAkademikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrestasiAkademikService {
    @Autowired
    private PrestasiAkademikRepository prestasiAkademikRepository;

    public List<PrestasiAkademik> findAll() {
        return prestasiAkademikRepository.findAll();
    }

    public Optional<PrestasiAkademik> findById(Long id) {
        return prestasiAkademikRepository.findById(id);
    }

    public PrestasiAkademik save(PrestasiAkademik prestasiAkademik) {
        return prestasiAkademikRepository.save(prestasiAkademik);
    }

    public void deleteById(Long id) {
        prestasiAkademikRepository.deleteById(id);
    }
}
