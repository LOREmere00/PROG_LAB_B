package citizen;



import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.Color;



public class checkRegis {
	
	private final panRegis pan2;
	private String nomeCentro;
	private String tipoVaccino;
	private String comuneCentro;
	private String [] infos;
	private boolean userexist = false;
	
	public checkRegis (final panRegis pan2) {
		this.pan2 = pan2;
	}
	
	public boolean checkIn() {
		boolean allFieldsValids = true;
		dataRegis data2 = new dataRegis(this);
		boolean correctCF = false;
		boolean logged = false;
		String userdata = "";
		String CFdata = "";
		resetLabels();
		
		allFieldsValids &= checkUsern(this.pan2.getUsernText(),this.pan2.getUsernErr());
		allFieldsValids &= checkPassw(this.pan2.getPasswText(),this.pan2.getPasswErr());
		allFieldsValids &= checkNome(this.pan2.getNomeText(),this.pan2.getNomeErr());
		allFieldsValids &= checkCogno(this.pan2.getCognomeText(),this.pan2.getCognomeErr());
		allFieldsValids &= checkCF(this.pan2.getCFText(),this.pan2.getCFErr());
		allFieldsValids &= checkEmail(this.pan2.getEmailText(),this.pan2.getEmailErr());
		
		pan2.setCheckCF(allFieldsValids);
		
		if (allFieldsValids) {
			CFdata = this.pan2.getCFText().getText();
			CFdata = CFdata.trim();
			CFdata = CFdata.toUpperCase();
			correctCF = data2.checkID(CFdata);
			if(correctCF) {
				pan2.setCheckCF(true);
			}else {
				pan2.setCheckCF(false);
				updateErrorLabel(this.pan2.getCFErr(), "Codice fiscale non trovato", true);
			}
			
		}
		
		allFieldsValids &= correctCF;
		
		if (allFieldsValids) {
			userdata = this.pan2.getUsernText().getText();
			userdata = userdata.trim();
			logged = data2.checkLogged(userdata, CFdata);
			pan2.setLogged(logged);
			if(!((logged)||(this.userexist))) {
				data2.getInfos(CFdata);
	        	infos = new String [9];
	        	infos[0] = this.pan2.getNomeText().getText();
	        	infos[1] = this.pan2.getCognomeText().getText();
	        	String CFinsert = this.pan2.getCFText().getText();
	        	CFinsert = CFinsert.toUpperCase();
	        	infos[2] = CFinsert;
	        	String emailinsert = this.pan2.getEmailText().getText();
	        	emailinsert = emailinsert.toLowerCase();
	        	infos[3] = emailinsert;
	        	infos[4] = this.comuneCentro;
	        	infos[5] = this.nomeCentro;
	        	infos[6] = this.pan2.getUsernText().getText();
	        	infos[7] = String.valueOf(this.pan2.getPasswText().getPassword());
	        	infos[8] = this.tipoVaccino;
	        	data2.setAll(infos);
	        	pan2.setProceed(true);
			}else {
				if(this.userexist) {
					pan2.setCheckUsern(false);
	        		updateErrorLabel(this.pan2.getUsernErr(), "Nome utente non disponibile", true);
				}else {
					pan2.setCheckCF(false);
				}
			}
		}
		
		return allFieldsValids;
	}
	
	protected void resetLabels(){
        updateErrorLabel(this.pan2.getUsernErr(), "", false);
        updateErrorLabel(this.pan2.getPasswErr(), "", false);
        updateErrorLabel(this.pan2.getNomeErr(), "", false);
        updateErrorLabel(this.pan2.getCognomeErr(), "", false);
        updateErrorLabel(this.pan2.getCFErr(), "", false);
        updateErrorLabel(this.pan2.getEmailErr(), "", false);
        updateErrorLabel(this.pan2.getIDErr(), "", false);
    }
	
	protected static void updateErrorLabel(final JLabel ErrorLabel, final String labelTExt, final boolean vis) {
        ErrorLabel.setText(labelTExt);
        ErrorLabel.setVisible(vis);
    }
	
	private boolean checkUsern(final JTextField input, final JLabel ErrorLabel) {
        boolean rest = true;
        Color col = input.getForeground();
        String newuser = input.getText();
        newuser = newuser.trim();
        if(!((col.equals(Color.GRAY))|| (newuser.length()==0))){
            if (newuser.length()<4) {
            	rest = false;
            	updateErrorLabel(ErrorLabel, "Nome utente troppo breve", true);
            }else {
            	if (newuser.length()>20) {
            		updateErrorLabel(ErrorLabel, "Nome utente troppo lungo", true);
            	}else {
            		for (int i = 0; i< newuser.length(); i++) {
            			if(!(Character.isLetterOrDigit(newuser.charAt(i)))){
            				rest = false;
            				updateErrorLabel(ErrorLabel, "Non usare caratteri speciali", true);
            			}
            		}
            	}
            }
        }else {
        	updateErrorLabel(ErrorLabel, "Questo campo è vuoto", true);
            rest = false;
        }
        if (rest) {
        	pan2.setCheckUsern(true);
        }
        return rest;
    }
	
	private boolean checkPassw(final JPasswordField input, final JLabel ErrorLabel) {
        boolean rest = true;
        Color col = input.getForeground();
        String newpass = String.valueOf(input.getPassword());
    	newpass = newpass.trim();
        if(!((col.equals(Color.GRAY))|| (newpass.length()==0))){
        	if (newpass.length()<7) {
        		rest = false;
        		updateErrorLabel(ErrorLabel, "Password troppo breve", true);
        	}else if (newpass.length()>14) {
        		rest = false;
        		updateErrorLabel(ErrorLabel, "Password troppo lunga", true);
        	}else if (newpass.contains(" ")) {
        		rest = false;
        		updateErrorLabel(ErrorLabel, "Password non valida", true);
        	}
		}else {
			updateErrorLabel(ErrorLabel, "Questo campo è vuoto", true);
            rest = false;
		}
        if (rest) {
        	pan2.setCheckPassw(true);
        }
        return rest;
    }
	
	private boolean checkNome(final JTextField input, final JLabel ErrorLabel) {
        boolean rest = true;
        Color col = input.getForeground();
        String newnome = input.getText();
        newnome = newnome.trim();
        newnome = newnome.replaceAll("\\s+", " ");
        if(!((col.equals(Color.GRAY))|| (newnome.length()==0))){
        	int spaceCount = (int) newnome.chars().filter(c -> c == ' ').count();
            if ((spaceCount>2) || (newnome.length()<2) || (newnome.length()>30)) {
            	rest = false;
            	updateErrorLabel(ErrorLabel, "Nome non valido", true);
            }else {
            	for (int i = 0; i< newnome.length(); i++) {
                    if(!((Character.isLetter(newnome.charAt(i))) || (Character.isWhitespace(newnome.charAt(i))))){
                        rest = false;
                        updateErrorLabel(ErrorLabel, "Nome non valido", true);
                    }
                }
            }
        }else {
        	updateErrorLabel(ErrorLabel, "Questo campo è vuoto", true);
            rest = false;
        }
        if (rest) {
        	pan2.setCheckNome(true);
        }
        return rest;
    }
	
	private boolean checkCogno(final JTextField input, final JLabel ErrorLabel) {
        boolean rest = true;
        Color col = input.getForeground();
        String newcogno = input.getText();
        newcogno = newcogno.trim();
        newcogno = newcogno.replaceAll("\\s+", " ");
        if(!((col.equals(Color.GRAY))|| (newcogno.length()==0))){
        	int spaceCount = (int) newcogno.chars().filter(c -> c == ' ').count();
            if ((spaceCount>2) || (newcogno.length()<2) || (newcogno.length()>30)) {
            	rest = false;
            	updateErrorLabel(ErrorLabel, "Cognome non valido", true);
            }else {
            	for (int i = 0; i< newcogno.length(); i++) {
                    if(!((Character.isLetter(newcogno.charAt(i))) || (Character.isWhitespace(newcogno.charAt(i))))){
                        rest = false;
                        updateErrorLabel(ErrorLabel, "Cognome non valido", true);
                    }
                }
            }
        }else {
        	updateErrorLabel(ErrorLabel, "Questo campo è vuoto", true);
            rest = false;
        }
        if (rest) {
        	pan2.setCheckCognome(true);
        }
        return rest;
    }
	
	private boolean checkEmail(final JTextField input, final JLabel ErrorLabel) {
        boolean rest = true;
        Color col = input.getForeground();
        String newemail = input.getText();
        newemail = newemail.trim();
        newemail = newemail.replaceAll("\\s+", " ");
        if(!((col.equals(Color.GRAY))|| (newemail.length()==0))){
        	String regexmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        	if (!(newemail.matches(regexmail))) {
            	rest = false;
            	updateErrorLabel(ErrorLabel, "E-mail non valida", true);
        	}
        }else {
        	updateErrorLabel(ErrorLabel, "Questo campo è vuoto", true);
            rest = false;
        }
        if (rest) {
        	pan2.setCheckEmail(true);
        }
        return rest;
    }
	
	private boolean checkCF(final JTextField input, final JLabel ErrorLabel) {
        boolean rest = true;
        Color col = input.getForeground();
        String newCF = input.getText();
    	newCF = newCF.trim();
        if(!((col.equals(Color.GRAY))|| (newCF.length()==0))){
        	if (newCF.length()!=16) {
        		updateErrorLabel(ErrorLabel, "Codice fiscale non valido", true);
        		rest = false;
        	}else {
        		for (int i = 0; i< newCF.length(); i++) {
                    if(!(Character.isLetterOrDigit(newCF.charAt(i)))){
                        rest = false;
                        updateErrorLabel(ErrorLabel, "Codice fiscale non valido", true);
                    }
                }
        	}
		}else {
			updateErrorLabel(ErrorLabel, "Questo campo è vuoto", true);
            rest = false;
		}
        if (rest) {
        	pan2.setCheckCF(true);
        }
        return rest;
    }
	
	public void setNomeCentro(String nomecentro) {
		this.nomeCentro= nomecentro;
	}
	
	public void setComuneCentro(String comunecentro) {
		this.comuneCentro= comunecentro;
	}
	
	public void setTipoVaccino(String tipovaccino) {
		this.tipoVaccino= tipovaccino;
	}
	
	public void setUserExist(boolean userexist) {
		this.userexist=userexist;
	}
     
}
