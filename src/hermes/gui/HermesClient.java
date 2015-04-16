/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.gui;

import com.hermes.client.HCUser;
import com.hermes.client.events.ChannelListClickedEvent;
import com.hermes.common.HChannel;
import com.hermes.common.HHash;
import com.hermes.common.constants.HBrowsable;
import com.hermes.common.constants.HGender;
import com.hermes.common.constants.HLineType;
import com.hermes.common.constants.HLocation;
import hermes.events.ChannelPaneEvents;
import hermes.util.ConfigReader;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.DataFormatException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;

/**
 *
 * @author joaquin
 */
public class HermesClient extends javax.swing.JFrame
{

    /**
     * Creates new form NewJFrame
     */
    private HCUser user;

    public HermesClient() throws UnknownHostException, IOException, NoSuchAlgorithmException
    {
        initComponents();

        ListPane lp = new ListPane(new ChannelListClickedEvent()
        {

            @Override
            public void channelListClick(HChannel channel)
            {
                try
                {
                    addChannel(channel);
                } catch (Exception ex)
                {
                    Logger.getLogger(HermesClient.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        
        
        user = ConfigReader.getInstance().getUser();//new HCUser("Ħεямεѕ", "QWERTYUIOPASDFGH", (short) 155, HLineType.HLNone, HBrowsable.Browsable, (byte) 30, HGender.Male, HLocation.Uruguay, "Montevideo", InetAddress.getByName("167.62.91.249"), (short) 14884, InetAddress.getByName("10.1.20.56"), InetAddress.getByName("8.8.8.8"), (short) 80, (byte) 12, (byte) 34, (byte) 5);
               
        user.setAvatar(new ImageIcon("./avatar.png"));

       
        user.setPersonalMessage("https://github.com/juacom99/hermes-client");
        
        
       

        TPChat.add(lp);
        int index = TPChat.indexOfComponent(lp);
        TPChat.setTabComponentAt(index, getTitlePanel(lp, "Channel List", new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/channel-list.png")), null, 3));

        JPanel newTab = new JPanel();
        JButton bNewTab = new JButton(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/newConnection.png")));
        bNewTab.setBorderPainted(false);
        bNewTab.setFocusPainted(false);
        bNewTab.setContentAreaFilled(false);
        bNewTab.setRolloverEnabled(true);
        bNewTab.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/newConnection-over.png")));
        bNewTab.setSize(24, 16);
        bNewTab.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                BNewTabActionPerformed();
            }
        });

        Action action = new AbstractAction("OpenHashDialog")
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                BNewTabActionPerformed();
            }

        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control N"));
        bNewTab.getActionMap().put("OpenHashDialog", action);
        bNewTab.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "OpenHashDialog");
        bNewTab.addActionListener(action);

        TPChat.add(newTab);
        index = TPChat.indexOfComponent(newTab);
        TPChat.setTabComponentAt(index, getTitlePanel(newTab, null, null, bNewTab, 0));

        TPChat.setEnabledAt(index, false);

        Container glassPane = (Container) this.getGlassPane();
        glassPane.setBackground(Color.red);

        glassPane.setVisible(true);

        FlowLayout fl = new FlowLayout(FlowLayout.RIGHT);
        fl.setVgap(2);
        glassPane.setLayout(fl);

        glassPane.add(BConfig);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        BConfig = new javax.swing.JButton();
        TPChat = new javax.swing.JTabbedPane();

        BConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/config.png"))); // NOI18N
        BConfig.setBorderPainted(false);
        BConfig.setContentAreaFilled(false);
        BConfig.setMaximumSize(new java.awt.Dimension(20, 20));
        BConfig.setMinimumSize(new java.awt.Dimension(20, 20));
        BConfig.setPreferredSize(new java.awt.Dimension(20, 20));
        BConfig.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BConfigActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hermes-Client");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/icon.png")).getImage());

        TPChat.addChangeListener(new javax.swing.event.ChangeListener()
        {
            public void stateChanged(javax.swing.event.ChangeEvent evt)
            {
                TPChatStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(TPChat, javax.swing.GroupLayout.DEFAULT_SIZE, 762, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TPChat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BNewTabActionPerformed()
    {
        String hash = JOptionPane.showInputDialog(this, "Input a hash", "arlnk://CHATROOM:127.0.0.1:14884|UYM");

        if (hash != null)
        {

            try
            {
                HChannel c = HHash.getInstance().decode(hash);
                addChannel(c);
            } catch (IOException ex)
            {

            } catch (DataFormatException ex)
            {

            } catch (Exception ex)
            {

            }
        }
    }

    private void TPChatStateChanged(javax.swing.event.ChangeEvent evt)//GEN-FIRST:event_TPChatStateChanged
    {//GEN-HEADEREND:event_TPChatStateChanged

        if ((TPChat.getSelectedIndex() != 0) && TPChat.getSelectedIndex() != (TPChat.getTabCount() - 1))
        {
            JPanel p = ((JPanel) TPChat.getTabComponentAt(TPChat.getSelectedIndex()));

            if (p != null)
            {
                ((JLabel) p.getComponent(0)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/chat.png")));
            }

            // System.out.println("Icon: " + p.getComponent(0));
            // System.out.println("Name: " + p.getComponent(1));
        }
    }//GEN-LAST:event_TPChatStateChanged

    private void BConfigActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BConfigActionPerformed
    {//GEN-HEADEREND:event_BConfigActionPerformed
        ConfigDialog cf=new ConfigDialog(user,this, false);
        cf.setModal(true);
         JRootPane rootPane = ((JDialog) cf).getRootPane();
        rootPane.setWindowDecorationStyle(JRootPane.NONE);
        
        cf.setLocation(BConfig.getX()-cf.getWidth()-30,BConfig.getY()+20);
        cf.setVisible(true);
        
        if(cf.getOption()==JOptionPane.YES_OPTION)
        {
            this.user=cf.getUser();
            
            for(int i=1;i<TPChat.getTabCount()-1;i++)
            {
                ((ChannelPane)TPChat.getComponentAt(i)).update(user);
            }
        }
        
        
    }//GEN-LAST:event_BConfigActionPerformed

    private JPanel getTitlePanel(final JPanel panel, String title, ImageIcon icon, JButton button, int margin)
    {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, margin, 0));
        titlePanel.setOpaque(false);
        Dimension d;
        if (icon != null)
        {
            JLabel LIcon = new JLabel(icon);
            /* d = new Dimension(16, 16);
             LIcon.setSize(d);
             LIcon.setPreferredSize(d);*/
            titlePanel.add(LIcon);
        }

        if (title != null)
        {
            JLabel titleLbl = new JLabel(title);
            titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            titlePanel.add(titleLbl);
        }

        if (button != null)
        {
            d = new Dimension(16, 16);
            button.setSize(d);
            button.setPreferredSize(d);
            titlePanel.add(button);
        }

        return titlePanel;
    }

    private void addChannel(HChannel channel) throws Exception
    {
        ChannelPaneEvents events = new ChannelPaneEvents()
        {

            @Override
            public void onTextRecived(ChannelPane source)
            {
                int index = TPChat.indexOfComponent(source);
                if (index != -1 && TPChat.getSelectedIndex() != index)
                {
                    JPanel p = ((JPanel) TPChat.getTabComponentAt(index));

                    ((JLabel) p.getComponent(0)).setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/chat-new.png")));

                    // System.out.println("Icon: " + p.getComponent(0));
                    // System.out.println("Name: " + p.getComponent(1));
                }
            }

            @Override
            public void onNameChange(ChannelPane source, String newName)
            {
                int index = TPChat.indexOfComponent(source);
                if (index != -1)
                {
                    JPanel p = ((JPanel) TPChat.getTabComponentAt(index));

                    ((JLabel) p.getComponent(1)).setText(newName);
                    p.repaint();
                    TPChat.repaint();
                    repaint();
                    // System.out.println("Icon: " + p.getComponent(0));
                    // System.out.println("Name: " + p.getComponent(1));
                }
            }
        };

        final ChannelPane cp = new ChannelPane(user, channel, events);
        JButton closeButton = new JButton(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/close.png")));
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setRolloverEnabled(true);
        closeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/close-over.png")));
        Dimension d = new Dimension(16, 16);
        closeButton.setSize(d);
        closeButton.setPreferredSize(d);
        closeButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int index = TPChat.getSelectedIndex() - 1;
                TPChat.remove(cp);
                ((ChannelPane) cp).close();
                TPChat.setSelectedIndex(index);

            }
        });

        Action action = new AbstractAction("closeTab")
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                int index = TPChat.getSelectedIndex() - 1;
                TPChat.remove(cp);
                ((ChannelPane) cp).close();
                TPChat.setSelectedIndex(index);
            }

        };
        action.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control W"));
        closeButton.getActionMap().put("closeTab", action);
        closeButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put((KeyStroke) action.getValue(Action.ACCELERATOR_KEY), "closeTab");
        closeButton.addActionListener(action);

        TPChat.add(cp, TPChat.getTabCount() - 1);
        int index = TPChat.indexOfComponent(cp);
        TPChat.setTabComponentAt(index, getTitlePanel(cp, channel.getName(), new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/chat.png")), closeButton, 3));
        TPChat.setSelectedIndex(TPChat.getTabCount() - 2);

        cp.connect();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConfig;
    private javax.swing.JTabbedPane TPChat;
    // End of variables declaration//GEN-END:variables
}
