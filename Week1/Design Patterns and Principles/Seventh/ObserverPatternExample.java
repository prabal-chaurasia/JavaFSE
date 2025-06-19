package Seventh;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String stockName, double newPrice);
}

interface Stock {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(String stockName, double newPrice);
}

class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String stockName, double newPrice) {
        for (Observer o : observers) {
            o.update(stockName, newPrice);
        }
    }

    public void setStockPrice(String stockName, double newPrice) {
        System.out.println("\nStock updated: " + stockName + " -> " + newPrice);
        notifyObservers(stockName, newPrice);
    }
}

class MobileApp implements Observer {
    private String name;

    MobileApp(String name) {
        this.name = name;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("MobileApp [" + name + "]: " + stockName + " price changed to " + newPrice);
    }
}

class WebApp implements Observer {
    private String name;

    WebApp(String name) {
        this.name = name;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("WebApp [" + name + "]: " + stockName + " price changed to " + newPrice);
    }
}

public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobile1 = new MobileApp("MobileUser1");
        Observer web1 = new WebApp("WebUser1");

        market.registerObserver(mobile1);
        market.registerObserver(web1);

        market.setStockPrice("TCS", 3240.75);
        market.setStockPrice("INFY", 1480.25);

        market.removeObserver(web1);

        market.setStockPrice("WIPRO", 450.10);
    }
}
