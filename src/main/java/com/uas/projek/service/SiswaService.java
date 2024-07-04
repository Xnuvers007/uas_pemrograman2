package com.uas.projek.service;

import com.uas.projek.entity.Siswa;
import com.uas.projek.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SiswaService {
    @Autowired
    private SiswaRepository siswaRepository;

    public List<Siswa> findAll() {
        return siswaRepository.findAll();
    }

    public Optional<Siswa> findById(Long id) {
        return siswaRepository.findById(id);
    }

    public Siswa save(Siswa siswa) {
        return siswaRepository.save(siswa);
    }

    public void deleteById(Long id) {
        siswaRepository.deleteById(id);
    }
}
