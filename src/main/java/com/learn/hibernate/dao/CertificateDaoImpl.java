package com.learn.hibernate.dao;

import com.learn.hibernate.entities.Certificate;
import com.revisehiber.Util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CertificateDaoImpl implements CertificateDao {

    @Override
    public void saveCertificate(Certificate certificate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(certificate);
        tx.commit();
        session.close();
    }

    @Override
    public Certificate getCertificate(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Certificate cert = session.get(Certificate.class, id);
        session.close();
        return cert;
    }

    @Override
    public List<Certificate> getAllCertificates() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Certificate> list = session.createQuery("from Certificate", Certificate.class).list();
        session.close();
        return list;
    }

    @Override
    public void deleteCertificate(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Certificate cert = session.get(Certificate.class, id);
        if (cert != null) {
            session.delete(cert);
        }
        tx.commit();
        session.close();
    }
}
