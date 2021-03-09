public class LinkedListDeque<Type>{

    public static class IntNode {
        public IntNode prev;
        public Type item;
        public IntNode next;

        public IntNode(Type x, IntNode p, IntNode n) {
            prev = p;
            item = x;
            next = n;
        }

        public IntNode(){
            next = null;
            next = null;
        }
    }
    private int size;
    private IntNode sentinel;

    public LinkedListDeque(){
        size = 0;
        IntNode<Type> sentinel = new IntNode<>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public LinkedListDeque(LinkedListDeque other)

    public void addFirst(Type item){
        IntNode<Type> first = new IntNode<>(item, sentinel, sentinel.next);
        sentinel.next = first;
        first.next.prev = first;
        size ++;
    }

    public void addLast(Type item){
       sentinel.prev.next = new IntNode<>(item, sentinel.prev, sentinel);
       sentinel.prev = sentinel.prev.next;
       size ++;
    }

    public boolean isEmpty(){
        if (size == 0) return true;
        return false;
    }

    public int size() return size;

    public void printDeque(){
        if (size == 0){
            System.out.println("empty deque");
            return;
        }
        IntNode<Type> x = sentinel.next;
        System.out.print(x.item);
        while (x.next != sentinel) {
            p = p.next;
            System.out.print(" " + x.item);
        }
        System.out.print("\n")
    }

    public Type removeFirst(){
        if (size == 0) return null;
        Type x = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return x;
    }

    public Type removeLast(){
        if (size == 0) return null;
        Type x = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return x;
    }

    public Type get(int index){
        if(size <= index || index < 0) return null;
        IntNode<Type> p = sentinel.next;
        while(index != 0){
            p = p.next;
            index--;
        }
        return p.item;
    }
    public Type getRecursive(int index){
        if(size <= index || index < 0) return null;
        return getRecursiveHelper(index, sentinel.next);
    }

    private Type getRecursiveHelper(int index, IntNode<Type> p){
        if (index == 0) return p.item;
        return getRecursiveHelper(index -1, p.next);
    }
}