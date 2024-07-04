package com.uas.projek.repository;

import com.uas.projek.entity.JadwalPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JadwalPelajaranRepository extends JpaRepository<JadwalPelajaran, Long> {
}
