package org.example;

import org.example.ExternalApi;

public class MyService {
    private ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void fetchData() {
        api.getData();  // the method we want to verify was called
    }
}
