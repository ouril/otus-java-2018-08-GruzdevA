package ru.otus.gruzdev3;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

    public class Itr<E> implements Iterator<E> {
        private int cursor = -1;

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            if (hasNext()) {
                cursor++;
                return (E) array[cursor];
            }
            throw new NoSuchElementException();
        }
    }

    public Iterator<E> iterator() {
        return new Itr<E>();
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
        try {
            c.forEach(obj -> remove(obj));
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean removeIf(Predicate<? super E> filter) {
        try {
            for (E obj : array) {
                if (filter.test(obj)) {
                    remove(obj);
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean retainAll(Collection<?> c) {

        MyArrayList<E> newMyArrayList = new MyArrayList<>();
        c.forEach(obj -> {
           if (contains(obj)){
               newMyArrayList.add((E) obj);
           }
        });
        if (newMyArrayList.size() > 0 ){
            array = newMyArrayList.array;
            size = newMyArrayList.size;
            return true;
        }
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
    }

}
