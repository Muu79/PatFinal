/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bhyatmua
 */
public class PatientManager {

    //Fields
    private String username;
    private Hasher h = new Hasher();

    //Constructor
    public PatientManager(String user) {
        username = user;
    }
    DBConnect db = new DBConnect();

    public String getPatientTbl(String sql) {
        String temp = "";

        try {
            ResultSet rs = db.queryTbl(sql);

            while (rs.next()) {
                //Used to return all fields from patient table
                temp += rs.getString(2) + "\t";
                temp += rs.getString(3) + "\t";
                temp += rs.getString(4) + "\t";
                temp += rs.getString(5) + "\t";
                temp += rs.getInt(6) + "\t";
                temp += rs.getString(7) + "\t";
                temp += rs.getString(10) + "\t";
                temp += "\n";
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
        }

        return temp;
    }

    public int login(String usr, String pass) {
        int auth = 0;
        pass = h.toHexString(h.getSHA(pass));

        try {
            ResultSet rs = db.queryTbl(String.format("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientsPersonalInfo.CellNo, tblPatientHealth.Allergens, tblPatientHealth.BloodType, tblHospitals.HospitalName, tblHospitals.TelNo, tblJobs.JobDesc, tblDoctors.DoctorUsername, tblPatientsPersonalInfo.Passwordhash\n"
                    + "FROM tblPatientsPersonalInfo INNER JOIN ((tblPatientHealth INNER JOIN (tblAdmissions INNER JOIN tblHospitals ON tblAdmissions.HosID = tblHospitals.HosID) ON tblPatientHealth.PatUsername = tblAdmissions.PatientUsername) INNER JOIN (tblJobs INNER JOIN (tblDoctors INNER JOIN tblDocAndPatients ON tblDoctors.DoctorUsername = tblDocAndPatients.DocUsername) ON tblJobs.JobID = tblDoctors.JobID) ON tblPatientHealth.PatUsername = tblDocAndPatients.PatientUsername) ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername\n"
                    + "WHERE  tblPatientHealth.PatUsername = '"+ usr.trim() + "';", usr.trim()));
            System.out.println(usr.trim());
            if (rs.next()) {
                System.out.println("hmm");
                if (rs.getString("Passwordhash").equals(pass)) {
                    System.out.println("ahah");
                    return 4;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err lvl 4" + ex);
        }
        try {  // tests if Username and password are correct and if the patient has any admissions
            ResultSet rs = db.queryTbl("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientsPersonalInfo.CellNo, tblPatientsPersonalInfo.Passwordhash\n"
                    + "FROM tblPatientsPersonalInfo INNER JOIN (tblPatientHealth INNER JOIN tblAdmissions ON tblPatientHealth.PatUsername = tblAdmissions.PatientUsername) ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername "
                    + "WHERE tblPatientsPersonalInfo.PatUsername ='" + usr + "'  ;");
            {
                if (rs.next()) {
                    System.out.println("I see");
                    if (rs.getString("Passwordhash").equals(pass)) {
                        auth = 4;
                        return auth;
                    }
                } else {
                    ResultSet nrs = db.queryTbl(String.format("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.CellNo "
                            + "FROM tblPatientsPersonalInfo INNER JOIN tblPatientHealth ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername "
                            + "WHERE tblPatientHealth.PatUsername = '%s' ", username));
                    if (nrs.next()) {
                        auth = 3;
                        return auth;
                    }

                }
            }

        } catch (SQLException ex) {
            System.out.println("err lvl 3" + ex);
            return auth;
        }
        try {// Tests
            ResultSet rs = db.queryTbl("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.Passwordhash\n"
                    + "FROM tblPatientsPersonalInfo INNER JOIN tblPatientHealth ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername "
                    + "Where tblPatientHealth.PatUsername = '" + usr + "';");
            if (rs.next()) {
                if (rs.getString("Passwordhash").equalsIgnoreCase(pass)) {
                    auth = 2;
                    return auth;
                }
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Err lvl 2-1" + ex);
            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(2);
        }

        try {
            ResultSet rs = db.queryTbl("SELECT tblDoctors.PasswordHash\n"
                    + "FROM tblPatientsPersonalInfo INNER JOIN (tblPatientHealth INNER JOIN (tblDoctors INNER JOIN tblDocAndPatients ON tblDoctors.DoctorUsername = tblDocAndPatients.DocUsername) ON tblPatientHealth.PatUsername = tblDocAndPatients.PatientUsername) ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername\n"
                    + " WHERE tblPatientHealth.PatUsername = '" + usr + "';");
            if (rs.next()) {
                if (rs.getString("PasswordHash").equalsIgnoreCase(pass)) {
                    auth = 2;
                    return auth;
                }

            }
        } catch (Exception e) {
            System.out.println("EE");
            auth = 0;
            System.out.println("PROMBLEM");
            System.out.println(e);
        }

        return auth;
    }

    public int login(String usr) {
        int auth = 0;
        try {
            ResultSet rs = db.queryTbl("SELECT * FROM tblPatientsPersonalInfo WHERE PatUsername = '" + usr + "' OR IDNo = '" + usr + "'");
            while (rs.next()) {
                auth = 1;
            }
        } catch (SQLException ex) {
            auth = 0;
        }

        return auth;
    }

    public boolean logExixts(String usr) {
        try {
            ResultSet rs = db.queryTbl("SELECT * FROM Patients WHERE Username = '" + usr + "'");
            while (rs.next()) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }

    public void updateTbl(String sql) throws SQLException {
        db.updateTbl(sql);
    }

    public String getInfo(String username, int auth) {
        String temp = "";
        ResultSet rs;
        switch (auth) {
            case 1:
                try {
                    System.out.println("Found it");
                    rs = db.queryTbl("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens\n"
                            + "FROM tblPatientsPersonalInfo INNER JOIN tblPatientHealth ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername\n"
                            + "Where tblPatientHealth.PatUsername = '" + username + "' ; ");
                    if (rs.next()) {
                        temp += rs.getString("tblPatientHealth.PatUsername") + ";" + rs.getString("Fname") + " " + rs.getString("Sname") + ";"
                                + rs.getString("BloodType") + ";" + rs.getString("Allergens");
                    } else {
                        temp += " ; ; ; ;";
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return temp;

            case 2:
                try { //Very convoluted SQL statement, done in Design View
                    rs = db.queryTbl("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.CellNo\n"
                            + "FROM tblPatientsPersonalInfo INNER JOIN tblPatientHealth ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername "
                            + " WHERE PatUsername = '" + username + "'");
                    if (rs.next()) {
                        System.out.println("Peekaboo");
                        temp += rs.getString("PatUsername") + ";"
                                + rs.getString("Fname") + " " + rs.getString("Sname") + ";"
                                + rs.getString("BloodType") + ";"
                                + rs.getString("Allergens") + ";"
                                + rs.getString("CellNo");
                    } else {
                        temp += " ; ; ; ; ";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println(temp);
                return temp;

            case 3:
                try {
                    rs = db.queryTbl("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.CellNo\n"
                            + "FROM tblPatientsPersonalInfo INNER JOIN (tblPatientHealth INNER JOIN tblAdmissions ON tblPatientHealth.PatUsername = tblAdmissions.PatientUsername) ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername\n"
                            + "WHERE tblPatientsPersonalInfo.PatUsername='" + username.trim() + "';");

                    if (rs.next()) {
                        temp += rs.getString("PatUsername") + ";" + rs.getString("Fname") + " " + rs.getString("Sname") + ";"
                                + rs.getString("BloodType") + ";" + rs.getString("Allergens") + ";" + rs.getString("CellNo");
                    } else {

                        rs = db.queryTbl(String.format("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.CellNo "
                                + "FROM tblPatientsPersonalInfo INNER JOIN tblPatientHealth ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername "
                                + "WHERE PatUsername = '%s' ", username.trim()));
                        if (rs.next()) {
                            temp += rs.getString("PatUsername") + ";" + rs.getString("Fname") + " " + rs.getString("Sname") + ";"
                                    + rs.getString("BloodType") + ";" + rs.getString("Allergens") + ";" + rs.getString("CellNo");

                        }
                        rs.close();

                    }

                } catch (SQLException ex) {
                    System.out.println(ex);
                    Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
                }

                return temp;
            case 4:
                try {

                    rs = db.queryTbl("SELECT tblPatientHealth.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.CellNo, tblHospitals.HospitalName, tblHospitals.TelNo, tblJobs.JobDesc, tblDoctors.DoctorUsername\n" +
"FROM tblPatientsPersonalInfo INNER JOIN ((tblJobs INNER JOIN (tblHospitals INNER JOIN (tblDoctors INNER JOIN tblDocAndPatients ON tblDoctors.DoctorUsername = tblDocAndPatients.DocUsername) ON tblHospitals.HosID = tblDoctors.RegHosID) ON tblJobs.JobID = tblDoctors.JobID) INNER JOIN tblPatientHealth ON (tblPatientHealth.PatUsername = tblDocAndPatients.PatientUsername) AND (tblDoctors.DoctorUsername = tblPatientHealth.TrustedDoc)) ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername"
                            + " WHERE PatUsername = 'Muu79'");
                    if (rs.next()) {
                        temp += rs.getString("PatUsername") + ";" + rs.getString("Fname") + " " + rs.getString("Sname") + ";"
                                + rs.getString("BloodType") + ";" + rs.getString("Allergens") + ";" + rs.getString("CellNo") + ";" + rs.getString("HospitalName") + ";"
                                + rs.getString("TelNo") + ";" + rs.getString("JobDesc") + ";" + rs.getString("DoctorUsername") + " ";
                        System.out.println("Yes?");
                    } else {
                        ResultSet nrs = db.queryTbl(String.format("SELECT tblPatientsPersonalInfo.PatUsername, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.Sname, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.CellNo\n"
                                + "FROM tblPatientsPersonalInfo INNER JOIN tblPatientHealth ON tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername"
                                + " WHERE tblPatientsPersonalInfo.PatUsername = '%s';", username.trim()));
                        if (nrs.next()) {
                            temp += String.format(" %s;%s %s; %s; %s; %s;", nrs.getString("PatUsername"), nrs.getString("Fname"), nrs.getString("Sname"),
                                    nrs.getString("BloodType"), nrs.getString("Allergens"), nrs.getString("CellNo"));
                            temp += " ; ; ; ; ";
                        } else {
                            temp += " ; ; ; ; ; ; ; ; ";
                            System.out.println("WTF");
                        }
                    }
                    rs.close();

                } catch (SQLException ex) {
                    System.out.println(ex);
                    System.exit(-3);
                    Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
                }
                return temp;
            default:
                break;
        }
        return temp;
    }

    private boolean doesDoctorExist(String username) {
        try {
            ResultSet rs = db.queryTbl(String.format("SELECT DoctorUsername FROM tblDoctors "
                    + "WHERE DoctorUsername = '%s' ", username));
            if (rs.next()) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public String getAdmissions(String username) {
        String temp = "";
        try {
            ResultSet rs = db.queryTbl("SELECT tblAdmissions.*, tblHospitals.HospitalName\n"
                    + "FROM tblAdmissions INNER JOIN tblHospitals ON tblAdmissions.HosID = tblHospitals.HosID"
                    + " WHERE PatientUsername = '" + username + "'");
            while (rs.next()) {
                temp += rs.getString("PatientUsername") + ";" + rs.getString("Ward") + ";"
                        + rs.getString("DateIn") + ";" + rs.getString("DateOut") + ";" + rs.getString("HospitalName") + "\n";
            }
        } catch (SQLException ex) {

            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Err with admissions " + ex);
            return "No Admissions";
        }
        return temp;
    }

    public boolean changePassword(String rec, String pass) {
        boolean temp = false;
        try {
            ResultSet rs = db.queryTbl("SELECT * FROM tblPatientsPersonalInfo WHERE PatUsername = '" + username + "'");
            while (rs.next()) {
                if (h.toHexString(h.getSHA(rec)).equals(rs.getString("RecoveryCodehash"))) {
                    db.updateTbl("UPDATE tblPatientsPersonalInfo SET Passwordhash = '" + pass + "' WHERE PatUsername = '" + username + "'");
                    System.out.println("Success");
                    temp = true;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Issue with SQL :(" + ex);
        }
        return temp;

    }

    public void SaveChanges(String s) {
        try {
            Scanner sc = new Scanner(s).useDelimiter(";");
            if (sc.hasNext()) {
                db.updateTbl(String.format("UPDATE tblPatientsPersonalInfo SET IDNo = '%s', FName = '%s',SName = '%s',"
                        + "CellNo = '%s', HomeNo = '%s'"
                        + " WHERE PatUsername = '%s'", sc.next(), sc.next(), sc.next(), sc.next(), sc.next(), username));
                String a = sc.next();
                String b = sc.next();
                String d;
                try {
                    d = sc.next() + " ";
                } catch (NoSuchElementException ex) {
                    d = " ";
                }
                if (this.doesDoctorExist(d)) {

                    db.updateTbl(String.format("UPDATE tblPatientHealth SET Allergens = '%s' , BloodType = '%s' ,TrustedDoc = '%s'"
                            + " WHERE PatUsername = '%s' ", a, b, d, username));
                    try {
                        db.updateTbl(String.format("INSERT INTO tblDocAndPatients (DocUsername,PatientUsername)"
                                + "VALUES(  '%s', '%s' )"
                                + "",
                                d, username));
                    } catch (SQLException ex) { //done if the record of doc an patient already exists, 
                        //thus updating it rather than creating a new record
                        db.updateTbl(String.format("UPDATE tblDocAndPatients SET DocUsername = '%s' "
                                + "WHERE PatientUsername = '%s' ", d, username));
                        db.updateTbl(String.format("UPDATE tblPatientHealth SET TrustedDoc = '%s' "
                                + "WHERE PatUsername = '%s' ", d, username));
                    }
                } else {

                    db.updateTbl(String.format("UPDATE tblPatientHealth SET Allergens = '%s' , BloodType = '%s' "
                            + " WHERE PatUsername = '%s' ", a, b, username));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getKnown(String usr) {
        MasterValidator vm = new MasterValidator();
        String temp = "; ; ; ; ; ; ;";
        try {
            ResultSet rs = db.queryTbl("SELECT tblPatientsPersonalInfo.IDNo, tblPatientsPersonalInfo.FName, tblPatientsPersonalInfo.SName, tblPatientHealth.BloodType, tblPatientHealth.Allergens, tblPatientsPersonalInfo.CellNo, tblPatientsPersonalInfo.HomeNo, tblPatientHealth.TrustedDoc\n"
                    + "FROM tblPatientsPersonalInfo INNER JOIN tblPatientHealth ON "
                    + "tblPatientsPersonalInfo.PatUsername = tblPatientHealth.PatUsername "
                    + "WHERE PatUsername = + '" + usr + "';");
            if (rs.next()) {
                String id = rs.getString("IDNo");
                if (!vm.isStringEmpty(id)) {
                    temp = id + ";"
                            + rs.getString("FName") + " " + rs.getString("SName") + ";"
                            + rs.getString("BloodType") + ";"
                            + rs.getString("Allergens") + ";"
                            + rs.getString("CellNo") + ";"
                            + rs.getString("HomeNo") + ";"
                            + rs.getString("TrustedDoc");

                } else {
                    return temp;
                }
            }

            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error with edit getKnown: " + ex);
        }
        return temp;
    }

    public String queryTbl(String sql) {
        try {
            String temp = "";
            ResultSet rs = db.queryTbl(sql);
            while (rs.next()) {

            }
            return temp;
        } catch (SQLException ex) {
            Logger.getLogger(PatientManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ERR with SQL";
    }
}
