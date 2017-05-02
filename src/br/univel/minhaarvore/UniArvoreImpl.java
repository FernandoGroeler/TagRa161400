package br.univel.minhaarvore;

public class UniArvoreImpl<T> implements UniArvore<T> {
	private UniNode<T> raiz;
	
	public UniArvoreImpl(UniNode<T> noRaiz) {
		this.raiz = noRaiz;
	}

	@Override
	public void mostrarTodosConsole() {
		imprimir(this.raiz);
	}

	@Override
	public UniNode<T> getNoRaiz() {
		return this.raiz;
	}
	
	private String getTab(UniNode<T> node) {
		UniNode<T> n = node;
		String s = "";
		while (n.getPai() != null) {
			s += "\t";
			n = n.getPai();
		}
		
		return s;
	}
	
	private void imprimir(UniNode<T> node) {
		if (node != null) {
			System.out.println(getTab(node) + node.getConteudo().toString());
		
			if (node.getFilhos() != null) {
				for (UniNode<T> n : node.getFilhos())
					imprimir(n);
			}
		}
	}
}