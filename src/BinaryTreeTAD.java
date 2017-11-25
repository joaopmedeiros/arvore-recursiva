import java.util.Iterator;
import java.util.List;

/**
 * Interface que descreve o TAD �rvore Bin�ria.
 * @author Michael Mora, J�lio Machado, Isabel Manssour
 */

public interface BinaryTreeTAD<E> {

	/**
	 * Adiciona um novo nodo na �rvore.
	 * @param element Novo nodo a ser inserido.	
	 * @param father  Nodo ap�s o qual ser� inserido o novo nodo, se null ent�o insere na raiz.
	 * @param position NodePosition.LEFT para filho da esquerda ou NodePosition.RIGHT para filho da direita.
	 * @return true se o elemento foi inserido
	 */
	boolean add(E element, E father, NodePosition position);

	/**
	 * Remove o nodo da �rvore, juntamente com todos os seus filhos.
	 * @param element Refer�ncia para o dado a ser removido.
	 * @return true se a �rvore cont�m o elemento especificado.
	 */
	boolean removeBranch(E element);

	/**
	 * Substitui a primeira ocorr�ncia do elemento indicado por um novo elemento
	 * @param old elemento a ser substitu�do
	 * @param element novo elemento
	 * @return elemento que foi substitu�do ou null se o elemento n�o est� na �rvore
	 */
	E set(E old, E element);

	/**
	 * Recupera o dado armazenado na raiz da �rvore.
	 * @return dado armazenado na raiz da �rvore. 
	 * @throws EmptyTreeException se a �rvore est� vazia.
	 */
	E getRoot();

	/**
	 * Altera o dado armazenado na raiz da �rvore
	 * @param element dado a ser armazenado na raiz da �rvore
	 * @throws EmptyTreeException se a �rvore est� vazia.
	 */
	void setRoot(E element);

	/**
	 * Recupera o dado armazenado no filho da esquerda do nodo da �rvore
	 * @param element Refer�ncia para o nodo a ser buscado.
	 * @return dado armazenado na esquerda do nodo informado. 
	 */
	E getLeft(E element);

	/**
	 * Recupera o dado armazenado no filho da direita do nodo da �rvore
	 * @param element Refer�ncia para o nodo a ser buscado.
	 * @return dado armazenado na direita do nodo informado. 
	 */
	E getRight(E element);

	/**
	 * Recupera o dado armazenado no pai do nodo da �rvore
	 * @param element Refer�ncia para o nodo a ser buscado.
	 * @return dado armazenado no pai do nodo informado. 
	 */
	E getFather(E element);

	/**
	 * Retorna true se a �rvore cont�m o elemento especificado
	 * @param element o elemento a ser buscado
	 * @return true se a �rvore cont�m o elemento especificado
	 */
	boolean contains(E element);

	/**
	 * Recupera a quantidade de nodos da �rvore.
	 * @return n�mero de nodos. 
	 */
	int size();

	/**
	 * Recupera a quantidade de nodos da �rvore atrav�s de c�lculo recursivo.
	 * @return n�mero de nodos. 
	 */	
	int count();
	
	/**
	 * Recupera a quantidade de nodos folha da �rvore, atrav�s de c�lculo recursivo.
	 * @return n�mero de nodos. 
	 */	
	int countLeaves();

	/**
	 * Retorna a altura da �rvore.
	 * @return altura. 
	 */	
	int height();
	
	/**
	 * Retorna o n�vel do do elemente "element".
	 * @param elemento para verificar.
	 * @return n�vel do elemento.
	 */	
	int level(E element);

	/**
	 * Verifica se �rvore est� vazia.
	 * @return true se a �rvore est� vazia, false caso contr�rio. 
	 */
	boolean isEmpty();
	
	/**
	 * Verifica se o elemento fornecido � o raiz.
	 * @param elemento para verificar.
	 * @return true se o elemento for raiz, false caso contr�rio. 
	 */
	boolean isRoot(E element);

	/**
	 * Verifica se o elemento fornecido � folha.
	 * @param elemento para verificar.
	 * @return true se o elemento for folha, false caso contr�rio. 
	 */
	boolean isLeave(E element);
	
	/**
	 * Percorre a �rvore em pr�-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da �rvore em pr�-ordem.
	 */
	List<E> traversalPre();
	
	/**
	 * Percorre a �rvore em p�s-ordem, retornando seus elementos. 	
	 * @return Lista com os nodos da �rvore em p�s-ordem.
	 */
	List<E> traversalPos();
	
	/**
	 * Percorre a �rvore em ordem central (ou in-fixa), retornando seus elementos. 	
	 * @return Lista com os nodos da �rvore em ordem central.
	 */
	List<E> traversalCentral();
	
	/**
	 * Percorre a �rvore em amplitude, retornando seus elementos. 	
	 * @return Lista com os nodos da �rvore, ordenados n�vel a n�vel, da esquerda para direita. 
	 */
	List<E> traversalWidth();
}