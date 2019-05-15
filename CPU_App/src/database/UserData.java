package database;

import java.io.Serializable;


public class UserData implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = -2299677340114049754L;
	private boolean[] dpALU, dpSTORE, dpLOAD, dpBRANCH;
	public UserData(){
		dpALU =new boolean[18];  dpSTORE =new boolean[18];
		dpLOAD =new boolean[18]; dpBRANCH =new boolean[18];
		this.dpALU[0] = this.dpSTORE[0] = this.dpLOAD[0] = this.dpBRANCH[0] = true;
		for(int i = 1; i < 18; i++){
			this.dpALU[i] = this.dpSTORE[i] = this.dpLOAD[i] = this.dpBRANCH[i] = false;
		}
	}
	public boolean[] getDPALU(){return this.dpALU;}
	public boolean getDPALU(int i){return this.dpALU[i];}
	public boolean[] getDPLOAD(){return this.dpLOAD;}
	public boolean getDPLOAD(int i){return this.dpALU[i];}
	public boolean[] getDPSTORE(){return this.dpSTORE;}
	public boolean getDPSTORE(int i){return this.dpALU[i];}
	public boolean[] getDPBRANCH(){return this.dpBRANCH;}
	public boolean getDPBRANCH(int i){return this.dpALU[i];}
	
	public void setDPALU(int index){this.dpALU[index] =true;}
	public void setDPLOAD(int index){this.dpLOAD[index] =true;}
	public void setDPSTORE(int index){this.dpSTORE[index] =true;}
	public void setDPBRANCH(int index){this.dpBRANCH[index] =true;}
}
