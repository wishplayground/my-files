public class Demo1 {
    public static void main(String[] args) {

    }
}

interface ServeletConfig{
    String getServiceContext();
}
interface Servlet{
    ServeletConfig getServiceConfig();
    void init(ServeletConfig serveletConfig);

}

class GenericServelet implements ServeletConfig,Servlet {

    public ServeletConfig getServletConfig(){
        return null;
    }
    @Override
    public String getServiceContext() {
        return null;
    }

    @Override
    public void init(ServeletConfig serveletConfig) {

    }
}

class TomCat{

}
