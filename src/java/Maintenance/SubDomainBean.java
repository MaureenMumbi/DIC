/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

/**
 *
 * @author Maureen
 */
public class SubDomainBean {
    int ID;
    String SUBDOMAIN;
    String DOMAINID;

    public String getDOMAINID() {
        return DOMAINID;
    }

    public void setDOMAINID(String DOMAINID) {
        this.DOMAINID = DOMAINID;
    }

   
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSUBDOMAIN() {
        return SUBDOMAIN;
    }

    public void setSUBDOMAIN(String SUBDOMAIN) {
        this.SUBDOMAIN = SUBDOMAIN;
    }
}
