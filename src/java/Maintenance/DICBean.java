/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

/**
 *
 * @author Maureen
 */
public class DICBean implements java.io.Serializable {
 int DICID;
 int DISTRICTID;
  String DICNAME;         

    public int getDICID() {
        return DICID;
    }

    public void setDICID(int DICID) {
        this.DICID = DICID;
    }

    public int getDISTRICTID() {
        return DISTRICTID;
    }

    public void setDISTRICTID(int DISTRICTID) {
        this.DISTRICTID = DISTRICTID;
    }

    public String getDICNAME() {
        return DICNAME;
    }

    public void setDICNAME(String DICNAME) {
        this.DICNAME = DICNAME;
    }
    
}
