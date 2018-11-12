package ru.otus.gruzdev3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class MyArrayList<E> implements Collection<E> {

    private int size;
    private E[] array;

    public MyArrayList() {
        size = 0;
        array = (E[]) new Object[10];

    }

    static public void main(String... args){
        MyArrayList<String> test = new MyArrayList<>();
        for (int i = 0; i < 200; i++){
            String str = "Element " +  String.valueOf(i);
            test.add(str);
        }
        System.out.println(test);

        for (int i = 0; i < 200; i++) {
            System.out.println(test.get(i));
        }
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(Object o) {
        int i;
        for(i = 0; i < this.size; ++i) {
            if (o.equals(this.array[i])) {
                return true;
            }
        }
        return false;
    }

    private int containsWithIndex(Object o) {
        int i;
        for(i = 0; i < this.size; ++i) {
            if (o.equals(this.array[i])) {
                return i;
            }
        }
        return -1;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public void forEach(Consumer<? super E> action) {
        int i;
        for (i = 0; i < size; i++){
            action.accept(array[i]);
        }
    }

    public Object[] toArray() {
        return array;
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(E t) {
        try {
            array[size] = t;
        } catch (java.lang.ArrayIndexOutOfBoundsException e) {
            int newLength = array.length * 2;
            E[] newArray = (E[]) new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
            array[size] = t;
        }
        ++size;
        return true;

    }

    public boolean remove(Object o) {

        int i = containsWithIndex(o);
        if (i == -1){
            return false;

        } else {
            int newSize;

            if ((newSize = this.size - 1) > i) {
                System.arraycopy(array, i + 1, array, i, newSize - i);
            }
            size--;
            return true;
        }
    }

    public boolean containsAll(Collection<?> c) {
        int i;
        for (i = 0; i < c.size(); i++){
            if (!contains(c.toArray()[i])) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) {
       try {

           for(E o: c) {
               add(o);
           }
           return true;
       } catch (Exception e) {
           e.fillInStackTrace();
           return false;
       }
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }



    public void clear() {
        size = 0;

    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    public E remove(int index) {

            int newSize;
            E obj = array[index];
            if ((newSize = this.size - 1) > index) {
                System.arraycopy(array, index + 1, array, index, newSize - index);
            }
            return obj;
            //array = newarray;
    }

}
