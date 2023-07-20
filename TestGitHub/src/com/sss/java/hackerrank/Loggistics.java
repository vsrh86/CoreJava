package com.sss.java.hackerrank;

interface ITransportUnit {
    int calculateSpace();
}

class Product {
    protected int factor;

    public Product(int factor) {
        this.factor = factor;
    }

    public int calculateSpace() {
        return factor;
    }
}

class SolidProduct extends Product {
    private int weight;
    private int volume;

    public SolidProduct(int weight, int volume, int factor) {
        super(factor);
        this.weight = weight;
        this.volume = volume;
    }

    public int calculateSpace() {
        return weight * volume * factor;
    }
}

class LiquidProduct extends Product {
    private int liter;

    public LiquidProduct(int liter, int factor) {
        super(factor);
        this.liter = liter;
    }

    public int calculateSpace() {
        return liter * factor;
    }
}

class JewelProduct extends Product {
    private int count;
    private int requiredBox;

    public JewelProduct(int count, int requiredBox, int factor) {
        super(factor);
        this.count = count;
        this.requiredBox = requiredBox;
    }

    public int calculateSpace() {
        return count * factor + requiredBox * factor;
    }
}

class TransportUnit implements ITransportUnit {
    private Product[] products;

    public TransportUnit(Product[] products) {
        this.products = products;
    }

    public int calculateSpace() {
        int totalSpace = 0;
        for (Product product : products) {
            totalSpace += product.calculateSpace();
        }
        return totalSpace;
    }
}

public class Loggistics {
    public static void main(String[] args) {
        SolidProduct solidProduct = new SolidProduct(100, 10, 3);
        LiquidProduct liquidProduct = new LiquidProduct(50, 2);
        TransportUnit transportUnit = new TransportUnit(new Product[]{solidProduct, liquidProduct});
        int totalSpace = transportUnit.calculateSpace();
        System.out.println("Total space required: " + totalSpace);
    }
}
