public class Demo13 {
    public static void main(String[] args) {
        byte b1 = 78; //?
        short sh1 = b1;
        short myshort = 355; //?
        int num = b1;
        int num2 = num;


        char ch1 = 'A';
        char mychar = 65; //?
        //sh1 =ch1; (value bits 15 < valuebit 16)

        ch1 = sh1; //?
        ch1 = b1;  //?

        long mylng = b1;
        long mylng2 = sh1;
        long mylng3 = num;

        //float myfloat = 0.256;
        float myfloat = 0.256f;
        double mydouble = myfloat;

        float myfloat2 = mylng;
        float myfloat3 = sh1;
        float myfloat4 = ch1;
        float myfloat5 = b1;
        float myfloat6 = mylng; //?

        double mydouble2 = mylng;
        double mydouble3 = sh1;
        double mydouble4 = b1;
        double mydouble5 = ch1;
        double mydouble6 = num;

    }
}
