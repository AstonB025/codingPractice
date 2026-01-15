package RWScenarios.CacheImplementation;

public class Driver {
    public static void main(String[] args) {
        SimpleCache<Integer, String> cache = new SimpleCache<>(3);

        cache.put(1, "Apple");
        cache.put(2, "Banana");
        cache.put(3, "Cherry");

        System.out.println(cache); // {1=Apple, 2=Banana, 3=Cherry}

        // This will remove the oldest entry (1=Apple)
        cache.put(4, "Dates");

        System.out.println(cache); // {2=Banana, 3=Cherry, 4=Dates}

        System.out.println("Get key 2: " + cache.get(2)); // Banana
        System.out.println("Cache size: " + cache.size()); // 3

        cache.clear();
        System.out.println("After clear: " + cache); // {}
    }
}
