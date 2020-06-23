package com.wangp.myaop.s_jvm.ch6.builder01;

public class FoodBuilder {

    //required
    private final String foodName;
    private final int reilang;

    //optional
    private int danbz;
    private int dianfen;
    private int zf;
    private int tang;
    private int wss;

    public static class Builder {
        //required
        private final String foodName;
        private final int reilang;

        //optional
        private int danbz;
        private int dianfen;
        private int zf;
        private int tang;
        private int wss;

        public Builder(String foodName, int reilang) {
            super();
            this.foodName = foodName;
            this.reilang = reilang;
        }

        public Builder danbz(int val) {
            this.danbz = val;
            return this;
        }

        public Builder dianfen(int val) {
            this.dianfen = val;
            return this;
        }

        public Builder zf(int val) {
            this.zf = val;
            return this;
        }

        public Builder tang(int val) {
            this.tang = val;
            return this;
        }

        public Builder wss(int val) {
            this.wss = val;
            return this;
        }

        public FoodBuilder build(){
            return new FoodBuilder(this);
        }
    }

    @Override
    public String toString() {
        return "FoodBuilder{" +
                "foodName='" + foodName + '\'' +
                ", reilang=" + reilang +
                ", danbz=" + danbz +
                ", dianfen=" + dianfen +
                ", zf=" + zf +
                ", tang=" + tang +
                ", wss=" + wss +
                '}';
    }

    private FoodBuilder(Builder builder){
        foodName = builder.foodName;
        reilang = builder.reilang;
        danbz = builder.danbz;
        zf = builder.zf;
        wss = builder.wss;
        tang = builder.tang;
        dianfen = builder.dianfen;
    }

    public static void main(String[] args) {
        FoodBuilder foodBuilder = new Builder("food2",100).danbz(10).zf(20).wss(40).build();
        System.out.println(foodBuilder);
    }
    
}
