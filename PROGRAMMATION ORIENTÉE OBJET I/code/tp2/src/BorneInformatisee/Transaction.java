package BorneInformatisee;

public class Transaction {
    private static final String MODE_PAIMENTCOMPT= "Paiment comptant";
    private static final String MODE_PAIMENTCC= "Paiment par carte de credit";


    String modeDePaiment;
    boolean mPaiment;


    public  Transaction(){
        this.modeDePaiment = modePaiment();
    }

    public String modePaiment(){
        if(!mPaiment){
            modeDePaiment = MODE_PAIMENTCOMPT;
        }else{
            modeDePaiment = MODE_PAIMENTCC;
        }
        return modeDePaiment;
    }

    public String getModeDePaiment() {
        return modeDePaiment;
    }

    public void setModeDePaiment(String modeDePaiment) {
        this.modeDePaiment = modeDePaiment;
    }

    public boolean ismPaiment() {
        return mPaiment;
    }

    public boolean setmPaiment(boolean mPaiment) {
        this.mPaiment = mPaiment;
        return mPaiment;
    }


}
