package controller;

import DataAccessObject.*;
import Model.*;
import View.Landing;
import java.util.List;

public class ControllerApp {
    List<Pegawai> listPegawai;
    List<Agensi> listAgen;
    List<Pembeli> listBuyer;
    Landing frame;
    iAgensiDao agenDao;
    iPegawaiDao pegawaiDao;
    iPembeliDao pembeliDao;
    
    public ControllerApp(Landing frame){
        this.frame = frame;
        this.agenDao = new AgensiDao();
        this.pegawaiDao = new PegawaiDao();
        this.pembeliDao = new PembeliDao();
        listPegawai = pegawaiDao.getAllPegawai();
        listAgen = agenDao.getAllAgensi();
        listBuyer = pembeliDao.getAllPembeli();     
    }
    
    public void PilihanBox(){
        this.frame.getKodeAgensi().setVisible(false);
        this.frame.getEmail().setVisible(false);
        this.frame.getNomorhp().setVisible(false);
        this.frame.getUsername().setVisible(true);
        this.frame.getPassword().setVisible(true);
        if(this.frame.getAgensi().isSelected()){
            this.frame.getKodeAgensi().setVisible(true);
            this.frame.getEmail().setVisible(false);
            this.frame.getNomorhp().setVisible(false);
        }else if(this.frame.getPegawai().isSelected()){
            this.frame.getKodeAgensi().setVisible(false);
            this.frame.getEmail().setVisible(false);
            this.frame.getNomorhp().setVisible(false);
        }else if(this.frame.getPembeli().isSelected()){
            this.frame.getKodeAgensi().setVisible(false);
            this.frame.getEmail().setVisible(true);
            this.frame.getNomorhp().setVisible(true);
        }else{
            this.frame.getKodeAgensi().setVisible(false);
            this.frame.getEmail().setVisible(false);
            this.frame.getNomorhp().setVisible(false);
            this.frame.getUsername().setVisible(false);
            this.frame.getPassword().setVisible(false);
        }
    }
    
}
