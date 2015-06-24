/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Maintenance;

/**
 *
 * @author Maureen
 */
public class QuestionnaireBean implements java.io.Serializable {
    int ID;
   String SUBDOMAINID;
   String QUESTION;
   String TYPE;
   String ISCODED;
   String DEPENDANT;
   String DEPENDANTVALUE;
   String DEPENDANTQUESTION;

    public String getDOMAINID() {
        return DOMAINID;
    }

    public void setDOMAINID(String DOMAINID) {
        this.DOMAINID = DOMAINID;
    }
   String DOMAINID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSUBDOMAINID() {
        return SUBDOMAINID;
    }

    public void setSUBDOMAINID(String SUBDOMAINID) {
        this.SUBDOMAINID = SUBDOMAINID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public void setQUESTION(String QUESTION) {
        this.QUESTION = QUESTION;
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE;
    }

    public String getISCODED() {
        return ISCODED;
    }

    public void setISCODED(String ISCODED) {
        this.ISCODED = ISCODED;
    }

    public String getDEPENDANT() {
        return DEPENDANT;
    }

    public void setDEPENDANT(String DEPENDANT) {
        this.DEPENDANT = DEPENDANT;
    }

    public String getDEPENDANTVALUE() {
        return DEPENDANTVALUE;
    }

    public void setDEPENDANTVALUE(String DEPENDANTVALUE) {
        this.DEPENDANTVALUE = DEPENDANTVALUE;
    }

    public String getDEPENDANTQUESTION() {
        return DEPENDANTQUESTION;
    }

    public void setDEPENDANTQUESTION(String DEPENDANTQUESTION) {
        this.DEPENDANTQUESTION = DEPENDANTQUESTION;
    }
    
}
