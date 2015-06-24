/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

/**
 *
 * @author Maureen
 */
public class MaritalBean implements java.io.Serializable {
  int ID;
  String MSTATUS;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getMSTATUS() {
        return MSTATUS;
    }

    public void setMSTATUS(String MSTATUS) {
        this.MSTATUS = MSTATUS;
    }
}
