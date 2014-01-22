package org.lego.element;

public enum BlockSize {

    OneAndOne("1*1"),
    OneAndTow("1*2"),
    OneAndThree("1*3"),
    OneAndFour("1*4"),
    OneAndSix("1*6"),
    TwoAndTwo("2*2"),
    TwoAndFour("2*4");
    
    private String desc;
    
    BlockSize(String desc){
        this.desc = desc;
    }
    
    public String getDesc(){
        return this.desc;
    }
}
