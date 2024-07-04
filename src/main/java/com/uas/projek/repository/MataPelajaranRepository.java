package com.uas.projek.repository;

import com.uas.projek.entity.MataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MataPelajaranRepository extends JpaRepository<MataPelajaran, Long> {
}
