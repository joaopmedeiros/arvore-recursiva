import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ArvoreBinaria<E> implements BinaryTreeTAD<E>{
	private Nodo refRoot;
	private int totElem;	
	
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
			this.filhoe = n;
		}
		
		public Nodo getFilhod(){
			return this.filhod;
		}
		
		public void setFilhod(Nodo n) {
			this.filhod = n;
		}
		
		public Nodo getPai() {
			return pai;
		}
		
		public void setPai(Nodo n) {
			this.pai = n;
		}
		
		public void setElem(E e) {
			this.elem = e;
		}
		
		public E getElem() {
			return elem;
		}
	
		
	}
	
	private Nodo searchNodeRef(E element) {
		return searchNodeRef(element, refRoot);
	}
	
	private Nodo searchNodeRef(E element, Nodo target) {
		Nodo res = null;
		if(target!=null && element!=null) {
			if(target.equals(element)) {
				res = target;
			}
			else {
				res = searchNodeRef(element,target.getFilhoe());
				if(res==null) {
					res = searchNodeRef(element,target.getFilhod());
				}
				
			}
		}
		return res;
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
		Nodo aux = searchNodeRef(old);
		if(aux!=null) {
			E rem = aux.getElem();			
			aux.setElem(element);
			return rem;
		}
		return null;		
	}

	@Override
	public E getRoot() {
		if(refRoot==null) {
			throw new EmptyTreeException();			
		}
		else {
			return this.refRoot.getElem();
		}
	}

	@Override
	public void setRoot(E element)  throws EmptyTreeException{
		if(refRoot==null) {
			throw new EmptyTreeException();
		}
		else {
			this.refRoot.setElem(element);		
		}		
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
		return totElem;
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
		List<E> res = new ArrayList<E>();
		traversalPre(refRoot,res);
		return res;
	}
	
	private void traversalPre(Nodo n, List<E> res) {
		if(n!=null) {
			res.add(n.getElem());
			traversalPre(n.getFilhoe(),res);
			traversalPre(n.getFilhod(),res);
		}
	}

	@Override
	public List<E> traversalPos() {
		List<E> res = new ArrayList<E>();
		traversalPos(refRoot,res);
		return res;
	}

	private void traversalPos(Nodo n, List<E> res) {
		if(n!=null) {
			traversalPos(n.getFilhoe(),res);
			traversalPos(n.getFilhod(),res);
			res.add(n.getElem());
		}
	}
	
	@Override
	public List<E> traversalCentral() {
		List<E> res = new ArrayList<E>();
		traversalCentral(refRoot,res);
		return res;
	}
	
	private void traversalCentral(Nodo n, List<E> res) {
		if(n!=null) {
			traversalCentral(n.getFilhoe(),res);
			res.add(n.getElem());
			traversalCentral(n.getFilhod(),res);
		}
	}

	@Override
	public List<E> traversalWidth() {
		List<E> res = new ArrayList<E>();
		traversalWidth(refRoot,res);
		return res;
	}
	
	private void traversalWidth(Nodo n, List<E> res) throws EmptyTreeException {
		Queue<Nodo> fila = new LinkedList<Nodo>();
		if(n==null) {
			throw new EmptyTreeException();
		}
		else {
			fila.add(n);
			while(!fila.isEmpty()) {
				Nodo aux = fila.poll();
				res.add(aux.getElem());
				if(aux.getFilhoe()!=null) fila.add(aux.getFilhoe());
				if(aux.getFilhod()!=null) fila.add(aux.getFilhod());				
			}
		}
	}
	
	
	

}
