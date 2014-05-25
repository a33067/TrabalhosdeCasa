package pt.isel.mpd14.alerter;

import java.io.FileInputStream;
import java.io.InputStream;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Hello world!
 *
 */
public class App 
{
 
    public static void main( String[] args )
    {
        final Alarm a = new Alarm();
        long now = System.currentTimeMillis();
        a.addEvent(now + 2000);
        a.addEvent(now + 5000);
        a.addEvent(now + 6000);
      	a.addAlarm(new IAlarm() {@Override
			public void alarm() {
				System.out.println("Ole Ole!!!!!");
			}
		});
        a.addAlarm(new IAlarm() {@Override
			public void alarm() {
				 JFrame frm = new JFrame();
                                 frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                 frm.add(new JScrollPane(new JTextArea()));
                                 frm.pack();
                                 frm.setVisible(true);
			}
		});
         a.addAlarm(new IAlarm() {@Override
			public void alarm() {
				 JFrame frm = new JFrame();
                                 frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                                 frm.add(new JScrollPane(new JList<String>(new String[]{"ola", "isel", "mundo", "xpto"})));
                                frm.pack();
        frm.setVisible(true);
			}
		});
        a.start();
    }
}
