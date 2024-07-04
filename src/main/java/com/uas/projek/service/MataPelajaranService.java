package com.uas.projek.service;

import com.uas.projek.entity.MataPelajaran;
import com.uas.projek.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MataPelajaranService {
    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;

    public List<MataPelajaran> findAll() {
        return mataPelajaranRepository.findAll();
    }

    public Optional<MataPelajaran> findById(Long id) {
        return mataPelajaranRepository.findById(id);
    }

    public MataPelajaran save(MataPelajaran mataPelajaran) {
        return mataPelajaranRepository.save(mataPelajaran);
    }

    public void deleteById(Long id) {
        mataPelajaranRepository.deleteById(id);
    }
}
