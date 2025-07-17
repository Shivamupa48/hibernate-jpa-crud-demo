package com.learn.hibernate.dao;

import com.learn.hibernate.entities.Certificate;
import java.util.List;

public interface CertificateDao {
    void saveCertificate(Certificate certificate);
    Certificate getCertificate(int id);
    List<Certificate> getAllCertificates();
    void deleteCertificate(int id);
}
