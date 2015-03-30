/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hermes.gui;

import com.hermes.common.AresFormater;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 *
 * @author jomartinez
 */
public class ChatPane extends javax.swing.JPanel
{

    /**
     * Creates new form ChatPane
     */
    private HTMLDocument doc;
    private HTMLEditorKit kit;

    public ChatPane()
    {
        initComponents();
        this.doc = new HTMLDocument();
        this.kit = new HTMLEditorKit();
        
        EPChat.setComponentPopupMenu(PMMenu);

        EPChat.addHyperlinkListener(new HyperlinkListener()
        {

            @Override
            public void hyperlinkUpdate(HyperlinkEvent e)
            {

                if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
                {
                    try
                    {
                        DesktopApi.browse(new URI(e.getURL().toString()));
                    } catch (URISyntaxException ex)
                    {
                        Logger.getLogger(ChatPane.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
        EPChat.setEditorKit(kit);
        EPChat.setDocument(doc);
    }

    public void write(String s)
    {
        try
        {
            //Convert Color from ares to HTML
            //Add it to the Document
            String str = AresFormater.getInstance().toHTML(s);
            kit.insertHTML(doc, doc.getLength(), str, 0, 0, null);

            EPChat.select(doc.getLength(), doc.getLength());
        } catch (BadLocationException ex)
        {
            Logger.getLogger(ChatPane.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
            Logger.getLogger(ChatPane.class.getName()).log(Level.SEVERE, null, ex);
        }
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

        PMMenu = new javax.swing.JPopupMenu();
        MISave = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        EPChat = new javax.swing.JEditorPane();

        MISave.setFont(new java.awt.Font("Serif", 1, 12)); // NOI18N
        MISave.setText("Save to..");
        MISave.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                MISaveActionPerformed(evt);
            }
        });
        PMMenu.add(MISave);

        EPChat.setEditable(false);
        EPChat.setContentType("\"text/html\""); // NOI18N
        EPChat.getDocument().putProperty("char-set","UTF-8");
        EPChat.setFont(new java.awt.Font("Serif", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(EPChat);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void MISaveActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_MISaveActionPerformed
    {//GEN-HEADEREND:event_MISaveActionPerformed
        JFileChooser fc=new JFileChooser();
        
        int option=fc.showSaveDialog(this);
        
        if(option==JFileChooser.APPROVE_OPTION)
        {
            try
            {
                kit.write(new FileOutputStream(fc.getSelectedFile().getPath()), doc, 0, doc.getLength());
            } catch (IOException ex)
            {
                Logger.getLogger(ChatPane.class.getName()).log(Level.SEVERE, null, ex);
            } catch (BadLocationException ex)
            {
                Logger.getLogger(ChatPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_MISaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JEditorPane EPChat;
    private javax.swing.JMenuItem MISave;
    private javax.swing.JPopupMenu PMMenu;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
