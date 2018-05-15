package m_package;

public class Admin {
    private String addr;
    private String mdp;
    
    public Admin(String addr, String mdp) {
    	super();
    	this.addr = addr;
    	this.mdp = mdp;
    }
    
    public Admin(){
    	super();
    }
    
    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
}