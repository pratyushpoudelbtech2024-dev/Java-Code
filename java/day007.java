class GarbageCollectionExample {
    public static void main(String[] args) {
        GarbageCollectionExample obj = new GarbageCollectionExample();
        obj = null; 
        System.gc(); 
    }
}
