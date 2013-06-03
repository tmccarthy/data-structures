package au.id.tmm.datastructures.list;

import au.id.tmm.datastructures.*;

public class LinkedList<E> implements List<E>, au.id.tmm.datastructures.Iterable {

    private ElementNode<E> head;

    public LinkedList() {
    }

    @Override
    public void add(E toAdd) {

        if (this.head == null) {
            this.head = new ElementNode<E>(toAdd);
        } else {
            this.getLastNode().setNextNode(new ElementNode<E>(toAdd));
        }

    }

    @Override
    public void add(int index, E toAdd) {

        if (index == 0) {
            this.head = new ElementNode<E>(toAdd, this.head);
        } else {
            ElementNode<E> insertAfter = this.getNode(index - 1);
            insertAfter.setNextNode(new ElementNode<E>(toAdd, insertAfter.getNextNode()));
        }
    }

    @Override
    public void remove(int index) {
        ElementNode<E> removeAfter = this.getNode(index - 1);

        removeAfter.setNextNode(removeAfter.getNextNode().getNextNode());
    }

    @Override
    public E get(int index) {
        return this.getNode(index).getElement();
    }

    @Override
    public void set(int index, E toSet) {
        this.getNode(index).setElement(toSet);
    }

    @Override
    public void clear() {
        ElementNode<E> currentNode = this.head;

        while (currentNode != null) {
            ElementNode<E> nodeToClear = currentNode;
            currentNode = currentNode.getNextNode();

            nodeToClear.setElement(null);
            nodeToClear.setNextNode(null);
        }

        this.head = null;
    }

    @Override
    public int size() {
        if (this.head == null) {
            return 0;
        }

        int size = 1;
        ElementNode<E> currentNode = this.head;

        while (currentNode.hasNextNode()) {
            size++;
            currentNode = currentNode.getNextNode();
        }

        return size;
    }

    @Override
    public au.id.tmm.datastructures.Iterator<E> iterator() {
        return new ConcreteLinkedListIterator<E>(this.head);
    }

    private class ConcreteLinkedListIterator<E> implements Iterator<E> {

        private ElementNode<E> currentNode;

        protected ConcreteLinkedListIterator(ElementNode<E> firstNode) {
            // Start with a simple pointer, so that the first call to next()
            // returns the first element.
            this.currentNode = new ElementNode<E>(null, firstNode);
        }

        @Override
        public boolean hasNext() {
            return this.currentNode.hasNextNode();
        }

        @Override
        public E next() {
            this.currentNode = this.currentNode.getNextNode();
            return this.currentNode.getElement();
        }
    }

    private ElementNode<E> getLastNode() {

        ElementNode<E> currentNode = this.head;

        if (currentNode == null) {
            return null;
        }

        while (currentNode.hasNextNode()) {
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    private ElementNode<E> getNode(int index) {
        ElementNode<E> currentNode = this.head;

        if (currentNode == null) {
            throw new ArrayIndexOutOfBoundsException();
        }

        for (int i = 0; i < index; i++) {
            if (currentNode.hasNextNode()) {
                currentNode = currentNode.getNextNode();
            } else {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        return currentNode;
    }

    private class ElementNode<E> {
        private E element;
        private ElementNode<E> nextNode;

        public ElementNode(E element, ElementNode<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        public ElementNode(E element) {
            this(element, null);
        }

        private E getElement() {
            return element;
        }

        private void setElement(E element) {
            this.element = element;
        }

        private boolean hasNextNode() {
            return this.getNextNode() != null;
        }

        private ElementNode<E> getNextNode() {
            return nextNode;
        }

        private void setNextNode(ElementNode<E> nextNode) {
            this.nextNode = nextNode;
        }
    }

}
