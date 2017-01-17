package pegachave;
import java.io.*;
import java.net.MalformedURLException;
import java.util.List;
/*
import org.jsoup.*;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
*/
import com.gargoylesoftware.htmlunit.BrowserVersion;
//import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
//import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.WebResponse;
import com.gargoylesoftware.htmlunit.html.*;

public class HtmlParser {
		//String site = "http://portalpetrobras.petrobras.com.br/PetrobrasPortal/appmanager/portal/desktop?_nfpb=true&_pageLabel=home_a_petrobras";
		
	String site;
	Worker empregado = new Empregado();
	DomElement element;

		public HtmlParser(String matricula){
			WebClient webclient = new WebClient(BrowserVersion.FIREFOX_45);
		//	webclient.getOptions().setJavaScriptEnabled(true);
		//	webclient.setAjaxController(new NicelyResynchronizingAjaxController());
		    webclient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		
			try {
				site="http://portalpetrobras.petrobras.com.br/PetrobrasPortal/appmanager/portal/desktop?_nfpb=true&_pageLabel=dctm_landing_page_localizador_de_pessoas_a_petrobras&origem=buscalope&unico="+matricula+"&locale=pt";
				
				
				final HtmlPage startPage = webclient.getPage(site);
						

				final List<FrameWindow> lfw = startPage.getFrames();
				final HtmlPage p2 = (HtmlPage) lfw.get(1).getEnclosedPage();
				
				
				
			//	DomElement element = (DomElement) p2.getByXPath("//div[@class='span9']").get(0);
			//	empregado.setNome(element.asText());
				
				Thread tdChave = new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub

						try{
							element = (DomElement) p2.getByXPath("//div[@class='span9']").get(1);
							empregado.setChave(element.asText());
						}catch(Exception e){
							empregado.setChave("Sem chave.");
						}
					}
				});
				
				tdChave.run();
/*				Thread tdNome = new Thread(new Runnable(){
				
					@Override 
					public void run(){
						element = (DomElement) p2.getByXPath("//div[@class='row-fluid']").get(4);
						empregado.setNome(element.asText());
					}
				});
				
				tdNome.run();
				
				Thread tdEmail = new Thread(new Runnable() {
					
					@Override
					public void run() {
						element = (DomElement) p2.getByXPath("//div[@class='span9']").get(3); // Email
						empregado.setEmail(element.asText());
						System.out.println("email"+empregado.getEmail());
								
						
					}
				});
				
				tdEmail.run();
				
	*/			
			//	element = (DomElement) p2.getByXPath("//div[@class='row-fluid']").get(9);
				
				
			//	System.out.println("999999999999"+empregado.getNome());
				
				
				
				element = (DomElement) p2.getByXPath("//div[@class='span9']").get(2); // Genero
				empregado.setGenero(element.asText());
				
				Thread tdEmp = new Thread( new Runnable() {
					
					@Override
					public void run() {
						try{
							element = (DomElement) p2.getElementById("empresaContratada");
							element = (DomElement) element.getLastElementChild();
							empregado.setEmpresa(element.asText());
							System.out.println(element.asText());
							
						}catch(Exception e){
							element = (DomElement) p2.getElementById("empresa");
							element = (DomElement) element.getLastElementChild();
							empregado.setEmpresa(element.asText());
							System.out.println(element.asText());

						}

						
					}
				});
				
				tdEmp.run();
				
							
			//	element = (DomElement) p2.getByXPath("//div[@class='span9']").get(4); // Empresa
			//	empregado.setEmpresa(element.asText());
				
				
				/*************** OK apenas tentando otimizar ****************************
				 
				element = (DomElement) p2.getByXPath("//div[@class='span9']").get(5); // Pais
				empregado.setPais(element.asText());
				
				element = (DomElement) p2.getByXPath("//div[@class='span9']").get(6); // Matricula
				empregado.setMatricula(element.asText());
				
				element = (DomElement) p2.getByXPath("//div[@class='span9']").get(7); // Cargo
				empregado.setCargo(element.asText());
				
				element = (DomElement) p2.getByXPath("//div[@class='span9']").get(8); // Imovel
				empregado.setImovel(element.asText());
				
				element = (DomElement) p2.getByXPath("//div[@class='span4']").get(1); // Ramal
				empregado.setRamal(element.asText());
				
				
				
				*************** OK apenas tentando otimizar ****************************/
				
				
		//		element = (DomElement) p2.getByXPath("//div[@class='span9']").get(10); // Endereco
		//		empregado.setEndereco(element.asText());
				
		//		element = (DomElement) p2.getByXPath("//div[@class='span9']").get(11); // Lotacao
		//		empregado.setLotacao(element.asText());
				
				/*
				for(int i=0;i< 9;i++){
					//element = (DomElement) p2.getByXPath("//div[@class='span9']").get(i);
					element = (DomElement) p2.getByXPath("//div[@class='row-fluid']").get(i);
					System.out.println(i+" - "+element.asText());
				}
				*/
			
				/*
				element = (DomElement) p2.getByXPath("//div[@class='row-fluid']").get(8);
				System.out.println("**********"+element.asText());
					*/			
				
			} catch (FailingHttpStatusCodeException e) {
				System.out.println("Problemas no http status");
				e.printStackTrace();
			} catch (MalformedURLException e) {
				System.out.println("Url errada.");
			} catch (IOException e) {
				System.out.println("Erro de entrada e saida");
			}
			//System.out.println("FIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIMFIM ");
			webclient.close();
		}
		
		public String getNome(){
			return empregado.getNome();
		}
		public String getRamal(){
			return empregado.getRamal();
		}
		public String getMatricula(){
			return empregado.getMatricula();
		}
		public String getEmpresa(){
			return empregado.getEmpresa();
		}
		public String getChave(){
			return empregado.getChave();
		}
		
		public String getEmail(){
			return empregado.getEmail();
		}
		
}
	

