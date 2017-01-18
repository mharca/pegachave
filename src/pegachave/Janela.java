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
	private JTextArea jta2,jta3;
	JScrollPane jsp2,jsp3;
	Thread t;
	JButton botao;
	
	public Janela(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Pegar chaves em lote");
		jta = new JTextArea();
		jta2 = new JTextArea();
		jta3 = new JTextArea();
		
		botao = new JButton("Pegar chaves");
		
		this.setSize(600,800);
		JPanel panel = new JPanel(new GridLayout());
		
		JScrollPane jsp = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//jsp.setViewportView(jta);
		jsp.setBorder(BorderFactory.createTitledBorder("Identificador"));
		
		jsp2 = new JScrollPane(jta2,JScrollPane.VERTICAL_SCROLLBAR_NEVER,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jsp2.setViewportView(jta2);
		jsp2.setBorder(BorderFactory.createTitledBorder("Chaves"));
		
		
		jsp3 = new JScrollPane(jta3,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//jsp3.setViewportView(jta3);
		jsp3.setBorder(BorderFactory.createTitledBorder("Nome"));
		
		jsp.getVerticalScrollBar().setModel(jsp3.getVerticalScrollBar().getModel());
		jsp2.getVerticalScrollBar().setModel(jsp3.getVerticalScrollBar().getModel());
		
		jsp.setEnabled(true);
		jta.setEditable(true);
		//jta2.setEditable(false);
		//jta3.setEditable(false);
		jta.setEnabled(true);
			
		
		botao.addActionListener(new botaoAction());
	
		panel.add(jsp);
		panel.add(jsp2);
		panel.add(jsp3);
		panel.add(botao);
		

		this.add(panel);
		
		this.setVisible(true);
	}
	
	private class botaoAction implements ActionListener{
					
		@Override
		public void actionPerformed(ActionEvent e) {
			botao.setEnabled(false);
			
			new pegaChave().execute();
	}
	
		
		
	private class pegaChave extends SwingWorker<String, Object>{

		@Override
		protected String doInBackground() throws Exception {
			// TODO Auto-generated method stub
			int linhas = jta.getLineCount();
			String[] lines = jta.getText().split("\n");
			int x=0;
				try{
					for(int i=0;i<linhas;i++){
						System.out.print(i+"-"+lines[i]+"\n");
						x = (i*100)/linhas;
						botao.setText("Andamento: "+x+"%");
						try{
							
							parser = new HtmlParser(lines[i]);
							jta2.append(parser.getChave()+"\n");
							jta3.append(parser.getNome()+"\n");
							
							//jsp2.repaint();								
						}catch(Exception ex1){
							jta2.append("Erro\n");
							jta3.append("Erro\n");
						}		
						
					} // for
					botao.setEnabled(true);
					botao.setText("Pegar chaves");
				}catch(Exception ex){
					System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=ERRRRRROOOOOO=-=-=-=-=-=-=-=-=-=-=--=-");
					jta2.append("Erro\n");
					jta3.append("Erro\n");
				}
			return null;
		}
		
	}
}
}
		
	
		
	
	

