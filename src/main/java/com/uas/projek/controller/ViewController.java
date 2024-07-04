package com.uas.projek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/siswa")
    public String getSiswaPage() {
        return "siswa";
    }

    @GetMapping("/matapelajaran")
    public String getMataPelajaranPage() {
        return "matapelajaran";
    }

    @GetMapping("/prestasiakademik")
    public String getPrestasiAkademikPage() {
        return "prestasiakademik";
    }

    @GetMapping("/jadwalpelajaran")
    public String getJadwalPelajaranPage() {
        return "jadwalpelajaran";
    }
}
