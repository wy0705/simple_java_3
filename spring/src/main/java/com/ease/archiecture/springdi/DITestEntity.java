package com.ease.archiecture.springdi;

public class DITestEntity {

    private DIEntity diEntity;

//    public DITestEntity(DIEntity diEntity) {
//        System.out.println("DITestEntity con");
//        this.diEntity = diEntity;
//    }
//
//    public DITestEntity(){
//
//    }

    public void setDiEntity(DIEntity diEntity) {
        System.out.println("set DIEntity." );
        this.diEntity = diEntity;
    }

    public DIEntity getDiEntity() {
        System.out.println("aaaaaaa");
        System.out.println("aaaaaaa");
        System.out.println("aaaaaaa");
        return diEntity;
    }

    public void justPrint() {
        diEntity.print();
    }

}
