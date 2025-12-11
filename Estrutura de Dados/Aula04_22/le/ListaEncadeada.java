
public class ListaEncadeada {
	
	private Elemento inicio;

	public ListaEncadeada() { }
	
	public ListaEncadeada(Elemento inicio) {	
		this.inicio = inicio;
	}

	public Elemento getInicio() {
		return inicio;
	}

	public void setInicio(Elemento inicio) {
		this.inicio = inicio;
	}
	
	public void adicionar(Pessoa p) {
		if(this.inicio == null) {
			this.inicio = new Elemento(p);
		}else {
			Elemento e = this.inicio;
			while(e.getProximo() != null) {
				e = e.getProximo();
			}
			e.setProximo(new Elemento(p));
		}
	}
	
	public void listar() {
		if(this.inicio == null) {
			System.out.println("Lista Vazia.");
		}else {
			Elemento e = this.inicio;
			System.out.println(e);
			while(e.getProximo() != null) {
				e = e.getProximo();
				System.out.println(e);
			}
		}
	}
	
	public Pessoa remover(String cpf) {
		if(this.inicio == null) {			
			return null;
		}else {
			Elemento e = this.inicio;
			if(e.getPessoa().getCpf().equals(cpf)) {
				this.inicio = e.getProximo();
				return e.getPessoa();
			}else {
				while(e.getProximo() != null) {
					if(e.getProximo().getPessoa().getCpf().equals(cpf)) {
						Pessoa removida = e.getProximo().getPessoa(); 
						e.setProximo(e.getProximo().getProximo());
						return removida;
					}else {
						e = e.getProximo();
					}
				}
			}
		}
		return null;
	}

}
