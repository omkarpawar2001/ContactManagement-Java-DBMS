/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import custom.Contact;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author microsoftm
 */
public class ContactDB {
    private Connection conn;
    private List contacts;
    private PreparedStatement ps;
    
    
    public ContactDB(){
        conn = MySQLConnect.getConnection();
        ps = null;
//        contacts = new ArrayList<Contact>();
    }
    
    public List<Contact> getContacts(String search) throws SQLException{
        contacts = new ArrayList<Contact>();
//        System.out.print("here1");
        String query = "SELECT * FROM `contacts` WHERE UPPER(`contacts`.name) LIKE UPPER(\'%" + search + "%\') ORDER BY `contacts`.`name` ASC" ;
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(query);
        
         while (rs.next()) {
             Contact contact = new Contact();
             contact.setContactId(rs.getInt("id"));
             contact.setName(rs.getString("name"));
             contact.setPhoneId(rs.getInt("phone_id"));
             
             String query1 = "SELECT * FROM `phone` WHERE id = " + rs.getString("phone_id");
             Statement s1 = conn.createStatement();
             ResultSet rs1 = s1.executeQuery(query1);
             while(rs1.next()) {
                 contact.addPhone(rs1.getString("phone"));
             }
             contacts.add(contact);
         }
         return contacts;
    }
    
    public void storeContact(Contact c) throws SQLException{
        
        Statement s =  conn.createStatement();
        ResultSet rs = s.executeQuery("SELECT MAX(id) AS \'last\' FROM `phone`");
        rs.next();
        int last = rs.getInt("last");
        
        String query1 = "INSERT INTO phone(id, phone) VALUES ";
        for (Object phone : c.getPhone()) {
            query1 += " (?, ?),";
        }
        query1 = query1.substring(0, query1.length()-1);
        ps = conn.prepareStatement(query1);
//        ps.setString(1, ""+(last+1));
//        ps.setString(2, c.getPhone().get(0).toString());
        int i = 0;
        for (Object phone : c.getPhone()) {
            ps.setString(++i, ""+(last+1));
            ps.setString(++i, phone.toString());
//            System.out.println(i);
        }
//        System.out.println(query1);
        ps.execute();
        
        last++;
        
       
        String query2 = "INSERT INTO contacts(name, phone_id) VALUES (?, ?)";
        ps = conn.prepareStatement(query2);
        ps.setString(1, c.getName());
        ps.setString(2, ""+last);
        ps.execute();
    }
    
    public void deleteContact(Contact c) throws SQLException{
//        System.out.println(c.getContactId());
//        System.out.println(c.getPhoneId());
        String query = "DELETE FROM `contacts` WHERE `contacts`.`id` = (?)";
        ps = conn.prepareStatement(query);
        ps.setInt(1, c.getContactId());
        ps.execute();
        
        query = "DELETE FROM `phone` WHERE `phone`.`id` = (?)";
        ps = conn.prepareStatement(query);
        ps.setInt(1, c.getPhoneId());
        ps.execute();
    }
    
    public void updateContact(Contact oldContact, Contact newContact) throws SQLException{
        String query = "UPDATE `contacts` SET name = (?) WHERE id = (?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, newContact.getName());
        ps.setInt(2, oldContact.getContactId());
        ps.execute();
        
        query = "UPDATE `phone` SET phone = (?) WHERE id = (?) AND phone = (?)";
        ps = conn.prepareStatement(query);
        ps.setString(1, newContact.getPhone().get(0).toString());
        ps.setInt(2, oldContact.getPhoneId());
        ps.setString(3, oldContact.getPhone().get(0).toString());
        ps.execute();
        
        if(newContact.getPhone().size() > 1 && oldContact.getPhone().size() > 1){
            query = "UPDATE `phone` SET phone = (?) WHERE id = (?) AND phone = (?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, newContact.getPhone().get(1).toString());
            ps.setInt(2, oldContact.getPhoneId());
            ps.setString(3, oldContact.getPhone().get(1).toString());
            ps.execute();
        }else if(newContact.getPhone().size() > 1){
            query = "INSERT INTO phone(id, phone) VALUES (?, ?)";
            ps = conn.prepareStatement(query);
            ps.setInt(1, oldContact.getPhoneId());
            ps.setString(2, newContact.getPhone().get(1).toString());
            ps.execute();
        }
        
        
    }
}
