package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() 
	{
		size = 0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		if(element != null)
		{
			LLNode<E> temp = new LLNode<E>(element);
			if(size == 0)
			{
				head.next = temp;
				temp.prev = head;
				temp.next = tail;
				tail.prev = temp;
			}
			else
			{
				temp.prev = tail.prev;
				tail.prev.next = temp;
				temp.next = tail;
				tail.prev = temp;
			}
			size += 1;
			return true;
		}
		else
		{
			throw new NullPointerException();
		}
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		if(index < size && index >= 0)
		{
			LLNode<E> temp = head;
			for(int i = 0; i <= index; i += 1)
			{
				temp = temp.next;
			}
			return temp.data;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		if(element != null)
		{
			if(index >= 0 && index <= size)
			{
				LLNode<E> temp = head;
				for(int i = 0; i <= index; i += 1)
				{
					temp = temp.next;
				}
				
				LLNode<E> notun = new LLNode<E>(element);
				temp.prev.next = notun;
				notun.prev = temp.prev;
				notun.next = temp;
				temp.prev = notun;
				
				size += 1;
			}
			else
			{
				throw new IndexOutOfBoundsException();
			}
		}
		else
		{
			throw new NullPointerException();
		}
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		if(index >= 0 && index < size)
		{
			LLNode<E> temp = head;
			for(int i = 0; i <= index; i += 1)
			{
				temp = temp.next;
			}
			
			temp.prev.next = temp.next;
			temp.next.prev = temp.prev;
			size -= 1;
			return temp.data;
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		if(index >= 0 && index < size)
		{
			if(element != null)
			{
				LLNode<E> temp = head;
				for(int i = 0; i <= index; i += 1)
				{
					temp = temp.next;
				}
				temp.data = element;
				return temp.data;
			}
			else
			{
				throw new NullPointerException();
			}
		}
		else
		{
			throw new IndexOutOfBoundsException();
		}
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
