package com.uas.projek.repository;

import com.uas.projek.entity.PrestasiAkademik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrestasiAkademikRepository extends JpaRepository<PrestasiAkademik, Long> {
}
