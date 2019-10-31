package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

public class CachingProxyRetriever implements Retriever{
    Storage storage;
    LRUCache lruc = new LRUCache(3);
    OriginalRetriever originalRetriever;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        if (lruc.find(id)==null){
            lruc.set(id, originalRetriever.retrieve(id));
            //return originalRetriever.storage.get(id);
        }
        return lruc.find(id);


        //return null;
    }
}
