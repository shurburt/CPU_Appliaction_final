package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import database.UserDatabase;
public class UserDatabase implements Serializable {
	/**
	 *
	 */
	private static final long serialVersionUID = 8328465362640182110L;
	private static Hashtable<String,UserData> database;

	public static void loadDatbase() throws FileNotFoundException, IOException, ClassNotFoundException{
		File file = new File("src/Files/database.dat");
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		database = (Hashtable<String,UserData>)in.readObject();
		in.close();
	}
	public static void saveDatabase() throws FileNotFoundException, IOException, ClassNotFoundException{
		File file = new File("src/Files/database.dat");
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(database);
		out.close();
	}
	public static UserData getUserData(String str){return database.get(str);}
	public static void setUserData(String str,UserData data) throws FileNotFoundException, ClassNotFoundException, IOException{
		if(database.containsKey(str)){
			database.replace(str, data);
		}
		else{
			database.put(str, data);
		}
		saveDatabase();
	}
	public static void newUserData(String str){database.put(str,new UserData());}
	public static Hashtable<String,UserData> getDatabase(){return database;}
	public static void clearDatabase(){
		database.clear();
	}
	public static int getCount(boolean arr[]){
		int returnInt =0;
		for(int i = 0; i <arr.length;i++){
			if(arr[i] == true){
				returnInt++;
			}
		}
		return returnInt;
	}
}
