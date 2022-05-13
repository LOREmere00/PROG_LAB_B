package citizen;



import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;



public class checkLogin {
	
	private final panLogin pan1;
	private boolean wrongpass = false;
	
	private ArrayList <String> infopack = new ArrayList<String>();
	
	/*
	 * Qui viene innanzitutto inizializzata l'istanza pan1 della classe panLogin. Questo consentirà di utilizzare i suoi metodi.
	 */
	
	public checkLogin (final panLogin pan1) {
		this.pan1 = pan1;
	}
	
	/*
	 * Il metodo checkInputs crea a sua volta un istanza data1 della classe dataLogin, permettendo così di utilizzare i suoi metodi
	 * di inserimento dati sul database
	 */
	
	public boolean checkInputs() {
        boolean allFieldsValids = true;
        boolean foundall = false;
        dataLogin data1 = new dataLogin(this);
        String testodata = "";
        String passdata ="";
        resetLabels();
        
        allFieldsValids &= checkInput(this.pan1.getUserText(),this.pan1.getUserErr());
        
        pan1.setCheckUser(allFieldsValids);
        
        allFieldsValids &= checkInput(this.pan1.getPassText(),this.pan1.getPassErr());
        
        if (allFieldsValids) {
        	testodata = this.pan1.getUserText().getText();
        	testodata = testodata.trim();
        	passdata = String.valueOf(pan1.getPassText().getPassword());
        	passdata = passdata.trim();
        	infopack = data1.getAllDatas(testodata, passdata);
        	if (!(infopack.isEmpty())) {
        		pan1.setCheckUser(true);
        		pan1.setCheckPass(true);
        		pan1.setInfoPack(infopack);
        		foundall = true;
        	}else  {
        		if (this.wrongpass) {
        			pan1.setCheckUser(true);
                	foundall = false;
                	updateErrorLabel(this.pan1.getPassErr(), "Password errata", true);
        		}else {
        			pan1.setCheckUser(false);
            		updateErrorLabel(this.pan1.getUserErr(), "Nome utente inesistente", true);
        		}
        	}
        }
        
        allFieldsValids &= foundall;

        return allFieldsValids;
    }
	
	protected void resetLabels(){
        updateErrorLabel(this.pan1.getUserErr(), "", false);
        updateErrorLabel(this.pan1.getPassErr(), "", false);
    }
	
	protected static void updateErrorLabel(final JLabel ErrorLabel, final String labelTExt, final boolean vis) {
        ErrorLabel.setText(labelTExt);
        ErrorLabel.setVisible(vis);
    }
	
	private static boolean checkInput(final JComponent input, final JLabel ErrorLabel){
        boolean rest = true;

        if(input instanceof JTextField){
            final JTextField tmp = (JTextField)input;
            Color col = tmp.getForeground();
            String testocheck = tmp.getText();
            testocheck = testocheck.trim();
            if(testocheck.equals("") || (col.equals(Color.GRAY))){
                updateErrorLabel(ErrorLabel, "Questo campo è vuoto", true);
                rest = false;
            }
        }
        return rest;
    }
	
	public void setWrongPass(boolean wrongpass) {
		this.wrongpass=wrongpass;
	}
}
