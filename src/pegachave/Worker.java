package pegachave;

public  class Worker {
	String nome;
	String chave;
	String genero;
	String email;
	String ramal;
	String empresa;
	String pais;
	String matricula;
	String cargo;
	String imovel;
	String endereco;
	String lotacao;
	

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
		
	public String getChave() {
		return chave;
	}
	public void setChave(String chave) {
		this.chave = chave;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getRamal() {
		return ramal;
	}
	public void setRamal(String ramal) {
		this.ramal = ramal;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getImovel() {
		return imovel;
	}
	public void setImovel(String imovel) {
		this.imovel = imovel;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getLotacao() {
		return lotacao;
	}
	public void setLotacao(String lotacao) {
		this.lotacao = lotacao;
	}
	////////////////////////////////////////////////
	public String getFoto(){
	//	return "http://farm3.staticflickr.com/2227/2527718435_0333a14594_z.jpg";
		//String stringAux = new String();
		String fotoUrl = new String();
		//fotoUrl = "http://apl.ti.petrobras.com.br/fotos/0"+stringAux+".jpg";
							//fotoUrl = "http://apl.ti.petrobras.com.br/fotos/0"+new Control().getMatriculaByChave(matriculaTexto.getText())+".jpg";
			fotoUrl = "http://apl.ti.petrobras.com.br/fotos/0"+this.getMatricula()+".jpg";
					
					
		
		return fotoUrl;
	}
	
	
}
