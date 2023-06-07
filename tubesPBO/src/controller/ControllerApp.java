package controller;

import DataAccessObject.*;
import Model.*;
import View.Landing;
import java.util.List;

public class ControllerApp {
    //List<Pegawai> listPegawai;
    List<Agensi> listAgen;
    //List<Pembeli> listBuyer;
    Landing frame;
    iAgensiDao agenDao;
//    iPegawaiDao pegawaiDao;
//    iPembeliDao pembeliDao;
    
    public ControllerApp(Landing frame){
        this.frame = frame;
        this.agenDao = new AgensiDao();
//        this.pegawaiDao = new PegawaiDao();
//        this.pembeliDao = new PembeliDao();
        //listPegawai = pegawaiDao.getAllPegawai();
        listAgen = agenDao.getAllAgensi();
        //listBuyer = pembeliDao.getAllPembeli();     
    }
    
    public void PilihanBox(){
        this.frame.getKodeAgensi().setVisible(false);
        if(this.frame.getAgensi().isSelected()){
            this.frame.getKodeAgensi().setVisible(true);
        }
    }
    
}
