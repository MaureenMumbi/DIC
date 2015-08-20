/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Maintenance;

import DBCREDENTIALSFILE.IdGenerator;
import dbConnect.dbConnect;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;

/**
 *
 * @author Nyabuto Geofrey
 */
public class saveAccessTrail {
    int status=0;
 String id,compname;
 public int addAccess(String userid,String task) throws SQLException, UnknownHostException{
   compname=InetAddress.getLocalHost().getHostName();
    dbConnect conn = new dbConnect();
    IdGenerator IG = new IdGenerator();
     id=IG.current_id();
    String adder="INSERT INTO access_trail(id,username,task,hostcomp) VALUES(?,?,?,?)";
    conn.ps=conn.connect.prepareStatement(adder);
    conn.ps.setString(1, id);
    conn.ps.setString(2, userid);
    conn.ps.setString(3, task);
    conn.ps.setString(4, compname);
    
   status=conn.ps.executeUpdate();
     
     
     return status;
 }
    
}
