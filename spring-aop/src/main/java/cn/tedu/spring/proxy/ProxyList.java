package cn.tedu.spring.proxy;

import java.util.*;

/**
 * List 类型的代理类，解决List类型的线程安全问题
 * @param <E>
 */
public class ProxyList<E> implements List<E> {
    //完成最终功能的目标（target）对象
    private ArrayList<E> target;
    public ProxyList(ArrayList<E> list){
        target = list;
    }

    @Override
    public boolean add(E e) {
        synchronized (this) {
            return target.add(e);
        }
    }

    @Override
    public E get(int index) {
        synchronized (this) {
            return target.get(index);
        }
    }


    @Override
    public int size() {
        synchronized (this) {
            return target.size();
        }
    }

    @Override
    public String toString() {
        synchronized (this) {
            return target.toString();
        }
    }

    @Override
    public boolean isEmpty() {
        synchronized (this) {
            return target.isEmpty();
        }
    }

    @Override
    public boolean contains(Object o) {
        synchronized (this) {
            return target.contains(o);
        }
    }

    @Override
    public Iterator<E> iterator() {
        synchronized (this) {
            return target.iterator();
        }
    }

    @Override
    public Object[] toArray() {
        synchronized (this) {
            return target.toArray();
        }
    }

    @Override
    public <T> T[] toArray(T[] a) {
        synchronized (this) {
            return target.toArray(a);
        }
    }



    @Override
    public boolean remove(Object o) {
        synchronized (this){
            return target.remove(o);
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        synchronized (this) {
            return target.containsAll(c);
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        synchronized (this) {
            return target.addAll(c);
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        synchronized (this) {
            return target.addAll(index,c);
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        synchronized (this) {
            return target.removeAll(c);
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        synchronized (this) {
            return target.retainAll(c);
        }
    }

    @Override
    public void clear() {
        synchronized (this){
            target.clear();
        }
    }

    @Override
    public E set(int index, E element) {
        synchronized (this) {
            return target.set(index, element);
        }
    }

    @Override
    public void add(int index, E element) {
        synchronized (this){
            target.add(index, element);
        }
    }

    @Override
    public E remove(int index) {
        synchronized (this) {
            return target.remove(index);
        }
    }

    @Override
    public int indexOf(Object o) {
        synchronized (this) {
            return target.indexOf(o);
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        synchronized (this) {
            return target.lastIndexOf(o);
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        synchronized (this) {
            return target.listIterator();
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        synchronized (this) {
            return target.listIterator(index);
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        synchronized (this) {
            return target.subList(fromIndex, toIndex);
        }
    }
}
