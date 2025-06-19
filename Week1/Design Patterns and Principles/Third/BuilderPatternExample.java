package Third;

class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String graphics;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphics = builder.graphics;
    }

    public void displayConfiguration() {
        System.out.println("CPU: " + cpu);
        System.out.println("RAM: " + ram);
        System.out.println("Storage: " + storage);
        System.out.println("Graphics: " + graphics);
        System.out.println();
    }

    static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphics;

        public Builder setCpu(String cpu) {
            this.cpu = cpu;
            return this;
        }

        public Builder setRam(String ram) {
            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphics(String graphics) {
            this.graphics = graphics;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer basicComputer = new Computer.Builder()
            .setCpu("Intel i3")
            .setRam("8GB")
            .setStorage("256GB SSD")
            .build();

        Computer gamingComputer = new Computer.Builder()
            .setCpu("Intel i9")
            .setRam("32GB")
            .setStorage("1TB SSD")
            .setGraphics("NVIDIA RTX 4080")
            .build();

        basicComputer.displayConfiguration();
        gamingComputer.displayConfiguration();
    }
}
