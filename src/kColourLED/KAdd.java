package kColourLED;

import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.TextField;
import net.rim.device.api.ui.container.PopupScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;
import net.rim.device.api.util.Arrays;

public class KAdd extends PopupScreen {

	PopupScreen ps = this;
	
	public KAdd(final KColourLEDScreen ks) {
		super(new VerticalFieldManager(),Field.FOCUSABLE);
        final TextField tf = new TextField(TextField.NO_NEWLINE);
        ButtonField bf = new ButtonField("Ok",Field.FIELD_HCENTER);
        final ColourPicker cp = new ColourPicker("Pick a Colour!");
        tf.setLabel("Cell Number: ");
        bf.setChangeListener(new FieldChangeListener() {
			public void fieldChanged(Field field, int context) {
				if(ks.ht.containsKey(tf.getText()))
				{
					String key = tf.getText();
					String value = ks.ht.get(key).toString();
					ks.ht.remove(tf.getText());
					Arrays.remove(ks.items, key + "," + value);
				}
				ks.ht.put(tf.getText(), String.valueOf(cp.getColorValue()));
				ks.writeTextFile("file:///store/home/user/KLEDSave.txt", ks.ht.toString());
				Arrays.add(ks.items, tf.getText() + "," + cp.getColorValue());
				ks.lf.set(ks.items);
				ks.lf.invalidate();
				UiApplication.getUiApplication().popScreen(ps);
			}
        });
		add(tf);
        add(cp);
        add(bf);
	}

}
