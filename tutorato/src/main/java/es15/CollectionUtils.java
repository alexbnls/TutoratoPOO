package es15;

public class CollectionUtils {
    public static void printCollection(CustomCollection<?> collection)
    {
        for(int i = 0; i < collection.size(); i++)
            System.out.println(collection.get(i));
    }
}
