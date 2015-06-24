/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

/**
 *
 * @author Maureen
 */
public class ReligionBean implements java.io.Serializable{
    int ID;
   String RELIGION;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRELIGION() {
        return RELIGION;
    }

    public void setRELIGION(String RELIGION) {
        this.RELIGION = RELIGION;
    }
    
}
