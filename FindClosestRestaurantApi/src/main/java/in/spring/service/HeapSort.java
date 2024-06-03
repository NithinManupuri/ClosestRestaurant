package in.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import in.spring.entity.Restaurant;


@Service
public class HeapSort<T extends Comparable<T>> {
    
    private ArrayList<Restaurant> list;
  
    public HeapSort() {
        this.list = new ArrayList<>();
    }
    
    public List<Restaurant> getThreeClosest(List<Restaurant> byArea) {
        insert(byArea);
        List<Restaurant> result;
        if (list.size() < 3) {
            result = new ArrayList<>(list);
        } else {
            result = new ArrayList<>(list.subList(0, 3));
        }
        list.clear(); 
        return result;
    }
    
    private void insert(List<Restaurant> byArea) {
        for (Restaurant object : byArea) { 
            list.add(object);
            upHeap(list.size() - 1);
        }
    }

    public void upHeap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index).getDistanceFromArea().compareTo(list.get(p).getDistanceFromArea()) < 0) {
            swap(p, index);
            upHeap(p);
        }
    }

    private void swap(int p, int index) {
        Restaurant temp = list.get(p);
        list.set(p, list.get(index));
        list.set(index, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

}