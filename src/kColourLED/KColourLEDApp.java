package kColourLED;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Enumeration;
import java.util.Timer;
import java.util.TimerTask;

import javax.microedition.io.Connector;
import javax.wireless.messaging.MessageConnection;
import javax.wireless.messaging.MessageListener;
import javax.wireless.messaging.TextMessage;

import net.rim.blackberry.api.bbm.platform.BBMPlatformApplication;
import net.rim.blackberry.api.bbm.platform.BBMPlatformContext;
import net.rim.blackberry.api.bbm.platform.BBMPlatformContextListener;
import net.rim.blackberry.api.bbm.platform.BBMPlatformManager;
import net.rim.blackberry.api.bbm.platform.io.BBMPlatformChannelListener;
import net.rim.blackberry.api.bbm.platform.io.BBMPlatformConnection;
import net.rim.blackberry.api.bbm.platform.io.BBMPlatformData;
import net.rim.blackberry.api.bbm.platform.io.BBMPlatformIncomingJoinRequest;
import net.rim.blackberry.api.bbm.platform.profile.BBMPlatformContact;
import net.rim.blackberry.api.bbm.platform.profile.BBMPlatformContactList;
import net.rim.device.api.system.LED;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Dialog;

/**
 * This class extends the UiApplication class, providing a graphical user interface.
 */
public class KColourLEDApp extends UiApplication implements MessageListener {
    /**
     * Entry point for application
     * 
     * @param args
     *            Command line arguments (not used)
     */
	MessageConnection _mc;
	KColourLEDScreen ks; 
	String ad; 
	
    public static void main( String[] args ) throws IOException {
        // Create a new instance of the application and make the currently
        // running thread the application's event dispatch thread.
        KColourLEDApp theApp = new KColourLEDApp();
        theApp.enterEventDispatcher();
        theApp.setAcceptEvents(true); 
    }
    
    public void notifyIncomingMessage(MessageConnection conn)  
    { 
        javax.wireless.messaging.Message m = null;
		try {
			m = _mc.receive();
		} catch (InterruptedIOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        String address = m.getAddress(); 
        String msg = null; 
        if ( m instanceof TextMessage ) 
        { 
            TextMessage tm = (TextMessage)m; 
            msg = tm.getPayloadText(); 
            Timer t = new Timer();
            t.schedule(new TClass(), 2500);
            ad = address;
        } 
        else 
        {
             System.out.println("Invalid Message Format"); 
             System.out.println("Received SMS text from  " + address + " : " + msg); 
        }
    }
    
    class TClass extends TimerTask
    {
		public void run() {
			String color = "";
			for(Enumeration e = ks.ht.keys();e.hasMoreElements();)
			{
				Object key = e.nextElement();
				if(ad.indexOf(key.toString()) != -1)
				{
					color = ks.ht.get(key).toString();
					break;
				}
			}
			if(color != "") LED.setColorConfiguration(300, 1500, Integer.parseInt(color));
		}
    }
    
    /**
     * Creates a new KColourLEDApp object
     * @throws IOException 
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     */
    public KColourLEDApp() throws IOException {
    	//Session Request Listener
        _mc = (MessageConnection) Connector.open("sms://:0");  
        _mc.setMessageListener(this);
        
        BBMPlatformApplication bbmPlatformApplication=new BBMPlatformApplication("");
        BBMPlatformContext bbmPlatformContext=BBMPlatformManager.register(bbmPlatformApplication);
        bbmPlatformContext.setListener(_channelListener);
        
        // Push a screen onto the UI stack for rendering.
        pushScreen( ks = new KColourLEDScreen() {
        	public boolean onClose()
        	{
        		Dialog.inform("Bye :)");
        		try {
					_mc.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				System.exit(0);
        		return true;
        	}
        });
    }
    private final BBMPlatformChannelListener _channelListener = new BBMPlatformChannelListener() 
    {
            public void contactsInvited(BBMPlatformConnection connection, BBMPlatformContactList contactList) 
            {
            	//contactsInvited
            }
            
            public void contactsJoined(BBMPlatformConnection connection, BBMPlatformContactList contactList, final String cookie, int type) 
            {
                BBMPlatformContact contact = (BBMPlatformContact) contactList.getAll().nextElement();
                if (type == CONTACT_INVITING_ME) 
                {
                	
                } 
                else if (type == CONTACT_INVITED_BY_ME) 
                {
                	
                }
            }
            
            public void contactDeclined(BBMPlatformConnection connection, BBMPlatformContact contact) 
            {
            	//contactDeclined
            }
           
            public void contactLeft(BBMPlatformConnection connection, BBMPlatformContact contact) 
            {
                
            }
            // someone sent me some data in the channel
            public void dataReceived(BBMPlatformConnection connection, BBMPlatformContact sender, BBMPlatformData data) 
            {
                String msg = data.getDataAsString();
                String type = data.getContentType();
                ks.setTitle(msg+"WHOA");
                //onMessageReceived(sender, type, msg);//here you call the your own method;
            }
            
            public void joinRequestReceived(BBMPlatformConnection connection, BBMPlatformIncomingJoinRequest request, String param) 
            {
            	request.accept(null);  // automatically accept all public requests            
            }
            
            public void joinRequestCanceled(BBMPlatformConnection connection, BBMPlatformIncomingJoinRequest request, int code) 
            {
            	//joinRequestCanceled
            }
    };
}
