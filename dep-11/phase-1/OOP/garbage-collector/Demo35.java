class Demo35{
    public static void main(String[] args) {
        /* MyCrazyClass crazyClass1 = new MyCrazyClass();
        System.gc();
        System.out.println("--------------------");
        crazyClass1 = null;
        System.gc();
        System.out.println("--------------------");

        new MyCrazyClass();
        new MyCrazyClass();
        new MyCrazyClass();
        new MyCrazyClass();
        new MyCrazyClass();
        new MyCrazyClass();
        new MyCrazyClass();
        new MyCrazyClass();

        System.gc();*/
        MyCrazyClassWrapper myCrazyClassWrapper = new MyCrazyClassWrapper(new MyCrazyClass()); //crazyclass instance indirectly connect with stack
        System.gc();
        myCrazyClassWrapper = null;
        System.gc();

        while(true) Thread.onSpinWait();




    }
}

/* class MyCrazyClassWrapper{
    private MyCrazyClass crazyClass;
    public MyCrazyClassWrapper(MyCrazyClass crazyClass){
        this.crazyClass = crazyClass;
    }
}

class  MyCrazyClass{
    public MyCrazyClass(){
        System.out.println("MyCrazyClass is constructed");
    }

    @Override
    protected void finalize() throws Throwable{
        System.out.println("Garbage collector is going to collect..Save me!!!");
        System.out.println(Thread.currentThread().getName());

    }

} */