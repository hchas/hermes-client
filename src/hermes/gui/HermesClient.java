/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.gui;

import com.hermes.client.HCUser;
import com.hermes.common.HChannel;
import com.hermes.common.HHash;
import com.hermes.common.constants.HBrowsable;
import com.hermes.common.constants.HGender;
import com.hermes.common.constants.HLineType;
import com.hermes.common.constants.HLocation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.zip.DataFormatException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

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
    
    public HermesClient() throws UnknownHostException
    {
        initComponents();
        
        ListPane lp = new ListPane();

        user = new HCUser("Ħεямεѕ", "ABCDEFGHIJKLMNOP", (short) 155, HLineType.HLNone, HBrowsable.Browsable, (byte) 30, HGender.Male, HLocation.Uruguay, "Montevideo", InetAddress.getByName("167.62.91.249"), (short) 14884, InetAddress.getByName("10.1.20.56"), InetAddress.getByName("8.8.8.8"), (short) 80, (byte) 12, (byte) 34, (byte) 5);

        user.setAvatar(new ImageIcon("./avatar.png"));
        user.setPersonalMessage("https://github.com/juacom99/hermes-project");
        
        TPChat.addTab("Channel List     ", new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/channel-list.png")), lp, "Channel List");
        
      
 
      Container glassPane = (Container) this.getGlassPane();
      glassPane.setVisible(true);
      glassPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
      
      glassPane.add(BHash);
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
        BHash = new javax.swing.JButton();
        TPChat = new javax.swing.JTabbedPane();

        BConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/config.png"))); // NOI18N
        BConfig.setBorderPainted(false);
        BConfig.setContentAreaFilled(false);
        BConfig.setMaximumSize(new java.awt.Dimension(20, 20));
        BConfig.setMinimumSize(new java.awt.Dimension(20, 20));
        BConfig.setPreferredSize(new java.awt.Dimension(20, 20));

        BHash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/connect.png"))); // NOI18N
        BHash.setBorderPainted(false);
        BHash.setContentAreaFilled(false);
        BHash.setMaximumSize(new java.awt.Dimension(20, 20));
        BHash.setMinimumSize(new java.awt.Dimension(20, 20));
        BHash.setPreferredSize(new java.awt.Dimension(20, 20));
        BHash.setMnemonic(KeyEvent.VK_H);
        BHash.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BHashActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hermes-Client");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/icon.png")).getImage());

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

    private void BHashActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_BHashActionPerformed
    {//GEN-HEADEREND:event_BHashActionPerformed
        
        
        String hash=JOptionPane.showInputDialog(this,"Input a hash","arlnk://CHATROOM:127.0.0.1:14884|UYM");
        System.out.println(hash);
        if(hash!=null)
        {

            try
            {
                HChannel c= HHash.getInstance().decode(hash);
                addChannel(c);
            }
            catch(IOException ex)
            {
                System.err.println(ex.getMessage());
            }
            catch(DataFormatException ex)
            {
                System.err.println(ex.getMessage());
            }
            catch(Exception ex)
            {
                System.err.println(ex.getMessage());
            }
        }
    }//GEN-LAST:event_BHashActionPerformed

    
     private JPanel getTitlePanel(final JTabbedPane tabbedPane, final JPanel panel, String title)
    {
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 0));
        titlePanel.setOpaque(false);

        
        
        JLabel icon = new JLabel(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/chat.png")));
        Dimension d = new Dimension(21, 21);
        icon.setSize(d);
        icon.setPreferredSize(d);
        titlePanel.add(icon);

        JLabel titleLbl = new JLabel(title);
        titleLbl.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        titlePanel.add(titleLbl);
        
        
        JButton closeButton = new JButton(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/close.png")));
        closeButton.setBorderPainted(false);
        closeButton.setFocusPainted(false);
        closeButton.setContentAreaFilled(false);
        closeButton.setRolloverEnabled(true);
        closeButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/hermes/resources/images/close-over.png")));
        d = new Dimension(16, 16);
        closeButton.setSize(d);
        closeButton.setPreferredSize(d);
        closeButton.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                tabbedPane.remove(panel);
                ((ChannelPane)panel).close();
            }
        });
        titlePanel.add(closeButton);

        return titlePanel;
    }

      private void addChannel(HChannel channel) throws Exception
    {
       ChannelPane cp = new ChannelPane(user,channel);
        TPChat.add(cp);
        int index = TPChat.indexOfComponent(cp);
        TPChat.setTabComponentAt(index, getTitlePanel(TPChat, cp, channel.getName()));
        
        TPChat.setSelectedIndex(TPChat.getTabCount()-1);
    }
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BConfig;
    private javax.swing.JButton BHash;
    private javax.swing.JTabbedPane TPChat;
    // End of variables declaration//GEN-END:variables
}
