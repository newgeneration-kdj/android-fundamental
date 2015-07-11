package com.example.ladmusician.newgeneration_fundamental_1.DTO;

/**
 * Created by ladmusician on 15. 7. 11..
 */
public class TelephoneDTO {
    private int id;
    private String name;
    private String phoneNm;

    /* setter */
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPhoneNm(String phoneNm) {
        this.phoneNm = phoneNm;
    }

    /* getter */
    public int getId() {
        return this.id;
    }
    public String getName() {
        return this.name;
    }
    public String getPhoneNm() {
        return this.phoneNm;
    }
}
