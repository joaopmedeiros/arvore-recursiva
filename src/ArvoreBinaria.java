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
			if(target.getElem().equals(element)) {
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
		Nodo n = new Nodo(element);
		Nodo aux = null;
		boolean res = false;
		if(father==null) {
			if(position==NodePosition.LEFT) {
				n.setFilhoe(refRoot);			
			}
			else {
				n.setFilhod(refRoot);				
			}
			if(refRoot!=null) {
				refRoot.setPai(n);
			}
			refRoot = n;
			res = true;
			this.totElem++;			
		}
		else {
			aux = searchNodeRef(father,refRoot);
			if(aux!=null) {
				n.setPai(aux);
				if(position==NodePosition.LEFT) {
					n.setFilhoe(aux.getFilhoe());
					if(aux.getFilhoe()!=null) {
						aux.getFilhoe().setPai(n);
					}
					aux.setFilhoe(n);
				}
				else {
					n.setFilhod(aux.getFilhod());
					if(aux.getFilhod()!=null) {
						aux.getFilhod().setPai(n);
					}
					aux.setFilhod(n);
				}
				res = true;
				this.totElem++;
			}
			
		}
		return res;
		
	}

	@Override
	public boolean removeBranch(E element) {
		Nodo aux = searchNodeRef(element);
		if(aux!=null) {
			List<E> removidos = new ArrayList<E>();		
			traversalPos(aux,removidos);
			int removidos_cont = removidos.size();
			totElem = totElem - removidos_cont;
			if(aux.equals(aux.getPai().getFilhoe())) {
				aux.getPai().setFilhoe(null);
			}
			else {
				aux.getPai().setFilhod(null);
			}
			
			return true;
		}
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
		Nodo aux = searchNodeRef(element);
		if(aux!=null) {
			if(aux.getFilhoe()!=null) {
				return aux.getFilhoe().getElem();
			}
		}
		return null;
	}

	@Override
	public E getRight(E element) {
		Nodo aux = searchNodeRef(element);
		if(aux!=null) {
			if(aux.getFilhod()!=null) {
				return aux.getFilhod().getElem();
			}
		}
		return null;
	}

	@Override
	public E getFather(E element) {
		Nodo aux = searchNodeRef(element);
		if(aux!=null) {
			if(aux.getPai()!=null) {
				return aux.getPai().getElem();
			}
		}
		return null;
		
	}

	@Override
	public boolean contains(E element) {
		Nodo aux = searchNodeRef(element);
		if(aux!=null) return true;
		return false;
	}

	@Override
	public int size() {
		return totElem;
	}

	@Override
	public int count() {
		return traversalPos().size();
	}

	@Override
	public int countLeaves() {
		List<E> res = new ArrayList<E>();
		countLeaves(refRoot,res);
		return res.size();
	}
	
	private void countLeaves(Nodo n, List<E> res) {
		if(n!=null) {
			countLeaves(n.getFilhoe(),res);
			countLeaves(n.getFilhod(),res);
			if(n.getFilhoe()==null && n.getFilhod()==null) {
				res.add(n.getElem());
			}
		}
		
	}

	@Override
	public int height() {
		if(isEmpty()) {
			return 0;
		}
		return findHeight(refRoot);
	}
	
	
	private int findHeight(Nodo n) {
		if(n==null) return -1;
		return 1 + Math.max(findHeight(n.getFilhoe()),findHeight(n.getFilhod()));
	}

	@Override
	public int level(E element) {
		Nodo aux = searchNodeRef(element);
		if(aux!=null) {
			int cont = 0;
			while(aux.getPai()!=null) {
				cont++;
				aux = aux.getPai();
			}
			return cont+1;
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		if(totElem==0) {
			return true;
		}
		return false;
			
	}

	@Override
	public boolean isRoot(E element) {
		if(refRoot.getElem().equals(element)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isLeave(E element) {
		Nodo aux = searchNodeRef(element);
		if(aux!=null) {
			if(aux.getFilhoe()==null && aux.getFilhod()==null) {
				return true;
			}			
		}
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
