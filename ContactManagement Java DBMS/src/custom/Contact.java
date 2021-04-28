/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package custom;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author microsoftm
 */
public class Contact{
    
    private String name;
    private List phone;
    private int contactId;
    private int phoneId;
    
    public Contact() {
        phone = new ArrayList<String>();
    }
    
    public Contact(String name, String phone1) {
        this();
        this.name = name;
        this.phone.add(phone1);
    }
    
    public Contact(String name, String phone1, String phone2) {
        this(name, phone1);
        this.phone.add(phone2);
    }

    
    
    public boolean hasMoreThanOneNumbers(){
        return phone.size() > 1;
    }
    
    public String getName() {
        return this.name;
    }
    
    public List getPhone() {
        return this.phone;
    }
    
    public int getContactId() {
        return this.contactId;
    }
    
    public int getPhoneId() {
        return this.phoneId;
    }
    
    public void setContactId(int contactId) {
        this.contactId = contactId;
    }
    
    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String setPhone1(String phone) {
        return (String) this.getPhone().set(0, phone);
    }
    public String setPhone2(String phone) {
        if(this.getPhone().size()>1){
            return (String) this.getPhone().set(1, phone);
        }else if(this.addPhone(phone) == Constants.ADD_SUCCESS){
            
            return (String) this.getPhone().get(1);
        }
        return null;
    }
    
    
    public int addPhone(String phoneNo) {
        if(!"".equals(phoneNo)){
            if(!(this.phone.contains(phoneNo))) {
                return this.getPhone().add(phoneNo) ? Constants.ADD_SUCCESS : Constants.COULDNT_ADD;
            }else {
                return Constants.ALREADY_EXISTS;
            }
        }
        return Constants.NOT_A_PHONE_NUMBER;
    }
    
    public boolean updatePhone(String oldPhone, String newPhone) {
        int index = this.phone.indexOf(oldPhone);
        if(index != -1){
            return this.phone.set(index, newPhone) == oldPhone;
        }else{
            return false;
        }
    }
    
    @Override
    public String toString(){
        String str = "";
        str += this.getName() + "\n";
        for(int i = 0; i < phone.size(); i++) {
            str += phone.get(i) + "\t";
        }
        return str;
    }
    
}
