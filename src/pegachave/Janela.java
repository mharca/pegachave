package pegachave;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Janela extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HtmlParser parser;
	private JTextArea jta;
	private JTextArea jta2;
	Thread t;
	
	public Janela(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jta = new JTextArea();
		jta2 = new JTextArea();
		JButton botao;
		botao = new JButton("Pegar chaves");
		
		this.setSize(600,800);
		JPanel panel = new JPanel(new GridLayout());
		
		JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//jsp.setViewportView(jta);
		
		
		JScrollPane jsp2= new JScrollPane(jta2,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp2.setViewportView(jta2);
		
		jsp.getVerticalScrollBar().setModel(jsp2.getVerticalScrollBar().getModel());
		jsp.setEnabled(true);
		jta.setEditable(true);
		jta.setEnabled(true);
	
		botao.addActionListener(new botaoAction());
	
		panel.add(jsp);
		panel.add(jsp2);
		panel.add(botao);
		

		this.add(panel);
		
		this.setVisible(true);
	}
	
	private class botaoAction implements ActionListener{
					
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			t = new Thread(new Runnable() {
				
				@Override
				public void run() {
					int linhas = jta.getLineCount();
					String[] lines = jta.getText().split("\n");
					
						try{
							for(int i=0;i<linhas;i++){
								System.out.print(i+"-"+lines[i]+"\n");
								try{
									parser = new HtmlParser(lines[i]);
									SwingUtilities.invokeLater(new Runnable() {
										
										@Override
										public void run() {
											// TODO Auto-generated method stub
											jta2.append(parser.getChave()+"\n");
										}
									});
									
									//jta2.repaint();
									
								}catch(Exception ex1){
									jta2.append("Erro\n");
								}
							} // for
						}catch(Exception ex){
							System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=ERRRRRROOOOOO=-=-=-=-=-=-=-=-=-=-=--=-");
							jta2.append("Erro\n");
						}					
					}
	
					
				});
			t.run();
			};
			
	}
}
		
	
		
	
	

