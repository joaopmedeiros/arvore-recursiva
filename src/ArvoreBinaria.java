import java.util.List;

public class ArvoreBinaria<E> implements BinaryTreeTAD<E>{
	
	private class Nodo {
		private Nodo pai;
		private Nodo filhoe;
		private Nodo filhod;
		private E elem;

		public Nodo(E elem) {
			this.pai = null;
			this.filhoe = null;
			this.filhod = null;
			this.elem = elem;
		}
		
		public Nodo getFilhoe(){
			return filhoe;
		}
		
		public void setFilhoe(Nodo n) {
			filhoe = n;
		}
		
		public Nodo getFilhod(){
			return filhod;
		}
		
		public void setFilhod(Nodo n) {
			filhod = n;
		}
		
		public Nodo getPai() {
			return pai;
		}
		
		public void setPai(Nodo n) {
			pai = n;
		}
				
		
	}

	@Override
	public boolean add(E element, E father, NodePosition position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeBranch(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(E old, E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getRoot() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRoot(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E getLeft(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getRight(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getFather(E element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countLeaves() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int level(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isRoot(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLeave(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<E> traversalPre() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> traversalPos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> traversalCentral() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> traversalWidth() {
		// TODO Auto-generated method stub
		return null;
	}

}
