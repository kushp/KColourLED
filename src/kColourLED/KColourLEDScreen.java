package kColourLED;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Hashtable;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

import net.rim.device.api.io.IOUtilities;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.ObjectListField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.util.Arrays;

public class KColourLEDScreen extends MainScreen {
    //private ObjectChoiceField ocf;
   
	KColourLEDScreen ks = this;
	Hashtable ht = new Hashtable();
	Object[] items = new Object[]{};
	final ObjectListField lf = new ObjectListField();
	
    public KColourLEDScreen() {
        super( MainScreen.VERTICAL_SCROLL | MainScreen.VERTICAL_SCROLLBAR );
        setTitle( "Welcome to K Colour LED!" );
        String data = readTextFile("file:///store/home/user/KLEDSave.txt");
        if(data != null)
        {
        	data = data.replace('{', ' ').replace('}',' ').trim();
        	String[] toPut = split(data,",");
        	String[] keyValue;
        	for(int i=0;i<toPut.length;i++)
        	{
        		toPut[i] = toPut[i].trim();
        		keyValue = split(toPut[i],"=");
        		ht.put(keyValue[0], keyValue[1]);
        		Arrays.add(items, keyValue[0] + "," + keyValue[1]);
        	}
        	lf.set(items);
        	lf.invalidate();
        }
        ButtonField bf = new ButtonField("Add New!");
        bf.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				UiApplication.getUiApplication().pushScreen(new KAdd(ks));
			}	
        });
        ButtonField bff = new ButtonField("About Us");
        bff.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				UiApplication.getUiApplication().invokeLater(new Runnable() {
					public void run() {
						Dialog.inform("EMILIEE IS A LOSER ;)");	
					}
				});
			}	
        });
        add(lf);
        add(bf);
        add(bff);
        //String choiceSTRS[] = {"Opt 1", "Opt 2", "Opt 3"};
        //ocf = new ObjectChoiceField("Text Messages: ",choiceSTRS,0,ObjectChoiceField.FIELD_LEFT);
        //add(ocf); 
    }
    
    public String[] split(String strString, String strDelimiter)
	{
		int iOccurrences = 0;
		int iIndexOfInnerString = 0;
		int iIndexOfDelimiter = 0;
		int iCounter = 0;

		// Check for null input strings.
		if (strString == null)
		{
			throw new NullPointerException("Input string cannot be null.");
		}
		// Check for null or empty delimiter
		// strings.
		if (strDelimiter.length() <= 0 || strDelimiter == null)
		{
			throw new NullPointerException("Delimeter cannot be null or empty.");
		}

		// If strString begins with delimiter
		// then remove it in
		// order
		// to comply with the desired format.

		if (strString.startsWith(strDelimiter))
		{
			strString = strString.substring(strDelimiter.length());
		}

		// If strString does not end with the
		// delimiter then add it
		// to the string in order to comply with
		// the desired format.
		if (!strString.endsWith(strDelimiter))
		{
			strString += strDelimiter;
		}

		// Count occurrences of the delimiter in
		// the string.
		// Occurrences should be the same amount
		// of inner strings.
		while((iIndexOfDelimiter= strString.indexOf(strDelimiter,iIndexOfInnerString))!=-1)
		{
			iOccurrences += 1;
			iIndexOfInnerString = iIndexOfDelimiter + strDelimiter.length();
		}

		// Declare the array with the correct
		// size.
		String[] strArray = new String[iOccurrences];

		// Reset the indices.
		iIndexOfInnerString = 0;
		iIndexOfDelimiter = 0;

		// Walk across the string again and this
		// time add the
		// strings to the array.
		while((iIndexOfDelimiter= strString.indexOf(strDelimiter,iIndexOfInnerString))!=-1)
		{

			// Add string to
			// array.
			strArray[iCounter] = strString.substring(iIndexOfInnerString, iIndexOfDelimiter);

			// Increment the
			// index to the next
			// character after
			// the next
			// delimiter.
			iIndexOfInnerString = iIndexOfDelimiter + strDelimiter.length();

			// Inc the counter.
			iCounter += 1;
		}
            return strArray;
	}
    
    private String readTextFile(String fName) {
    	  String result = null;
    	  FileConnection fconn = null;
    	  DataInputStream is = null;
    	  try {
    	   fconn = (FileConnection) Connector.open(fName, Connector.READ_WRITE);
    	   is = fconn.openDataInputStream();
    	   byte[] data = IOUtilities.streamToBytes(is);
    	   result = new String(data);
    	  } catch (IOException e) {
    	   System.out.println(e.getMessage());
    	  } finally {
    	   try {
    	    if (null != is)

    	     is.close();
    	    if (null != fconn)
    	     fconn.close();
    	   } catch (IOException e) {
    	    System.out.println(e.getMessage());
    	   }
    	  }
    	  return result;
    	 }
    
    public void writeTextFile(String fName, String text) {
    	  DataOutputStream os = null;
    	  FileConnection fconn = null;
    	  try {
    	   fconn = (FileConnection) Connector.open(fName, Connector.READ_WRITE);
    	   if (!fconn.exists())
    	    fconn.create();

    	   os = fconn.openDataOutputStream();
    	   os.write(text.getBytes());
    	  } catch (IOException e) {
    	   System.out.println(e.getMessage());
    	  } finally {
    	   try {
    	    if (null != os)
    	     os.close();
    	    if (null != fconn)
    	     fconn.close();
    	   } catch (IOException e) {
    	    System.out.println(e.getMessage());
    	   }
    	  }
    }
}
